package edu.cst.webserver.http;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Demur
 */


public class HttpResponseWrapper implements HttpResponse {

    private HttpStatus.Code statusCode;
    private Map<String,String> headers;
    private String  messageBody;
    private StringBuilder writeLine;
    private HttpResponseErrorHandler errorHandler;


    public HttpResponseWrapper() {
        headers = new HashMap<String, String>();
        writeLine = new StringBuilder();
    }

    public String getWriteLine() {
        return writeLine.toString();
    }

    public String getMessageBody(){
        return this.messageBody;
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
        this.messageBody = body;
        this.statusCode = errorStatus;
        errorHandler.handle(this);
    }

    @Override
    public void write(String content) throws IOException {
        writeLine.append(content);
    }

    @Override
    public void flush() throws IOException {
        //todo [DN]
    }
}