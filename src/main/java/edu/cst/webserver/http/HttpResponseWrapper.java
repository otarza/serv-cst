package edu.cst.webserver.http;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Demur
 */


public class HttpResponseWrapper implements HttpResponse {

    private static final String STATUS_LINE = "HTTP/1.1 %d %s\r\n";
    private static final String HEADER_LINE = "%s: %s\r\n";
    private static final String SEPARATOR = "\r\n";

    private HttpStatus.Code statusCode;
    private Map<String,String> headers;
    private StringBuilder messageBody;
    private HttpResponseErrorHandler errorHandler;
    private OutputStream outputStream;
    private InputStream inputStream;

    private boolean flushed;
    private boolean separatorWritten;


    public HttpResponseWrapper(OutputStream outputStream) {
        this.outputStream = outputStream;
        this.headers = new HashMap<String, String>();
        this.messageBody = new StringBuilder();
    }

    public String getMessageBody(){
        return messageBody.toString();
    }

    public Map<String, String> getHeaders(){
        return this.headers;
    }

    public HttpStatus.Code getStatusCode(){
        return statusCode;
    }

    public void setErrorHandler(HttpResponseErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    @Override
    public void setHeader(String name, String value) {
        this.headers.put(name, value);
    }

    @Override
    public void setHeaders(Map<String, String> headers) {
        this.headers.putAll(headers);
    }

    @Override
    public void setStatus(HttpStatus.Code status) {
        this.statusCode = status;
    }

    @Override
    public void redirect(String location) {
        this.headers.put(HttpHeader.LOCATION, location);
    }

    @Override
    public void redirect(String location, HttpStatus.Code redirectStatus) {
        this.headers.put(HttpHeader.LOCATION, location);
        this.statusCode = redirectStatus;
    }

    @Override
    public void error(HttpStatus.Code errorStatus) throws HttpRequestException {
        this.statusCode = errorStatus;
        errorHandler.handle(this);
    }

    @Override
    public void error(HttpStatus.Code errorStatus, String body) throws HttpRequestException {
        this.messageBody.append(body);
        this.statusCode = errorStatus;
        errorHandler.handle(this);
    }

    @Override
    public void write(String content){
        messageBody.append(content);
    }

    @Override
    public void write(InputStream inputStream) throws IOException {
        this.inputStream = inputStream;
        flush();
    }

    @Override
    public void flush() throws IOException {
        if (!flushed) {
            writeStatusLine();
            writeHeaders();
            if(this.inputStream != null){
                writeBody(this.inputStream);
            } else {
                writeBody(new ByteArrayInputStream(messageBody.toString().getBytes()));
            }
            outputStream.flush();
            flushed = true;
        }
    }

    private void writeBody(InputStream inputStream) {
        try {
            if (!separatorWritten) {
                if (headers.get(HttpHeader.CONTENT_LENGTH) == null) {
                    headers.put(HttpHeader.CONTENT_TYPE, HttpMime.TEXT_HTML.getMime());
                }
                writeSeparator();
                separatorWritten = true;
            }
            byte[] buffer = new byte[1024];
            int bytesRead;
            while((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
			outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void writeHeaders() {
        for (Map.Entry<String, String> header : headers.entrySet()) {
            writeHeader(header.getKey(), header.getValue());
        }
    }

    private void writeHeader(String name, String value){
        String headerLine = String.format(HEADER_LINE, name, value);
        try {
            outputStream.write(headerLine.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeStatusLine() {
        if (statusCode == null) {
            statusCode = HttpStatus.Code.OK;
        }
        String statusLine = String.format(STATUS_LINE, statusCode.getCode(), statusCode.getMessage());
        try {
            outputStream.write(statusLine.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeSeparator(){
        try {
            outputStream.write(SEPARATOR.getBytes());
            separatorWritten = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}