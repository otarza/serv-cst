package edu.cst.webserver.http;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Demur
 */


public class HttpResponseWrapper implements HttpResponse {

    private HttpStatus.Code statusCode;
    private Map<String,String> headers;
    private StringBuilder messageBody;
    private HttpResponseErrorHandler errorHandler;


    public HttpResponseWrapper() {
        headers = new HashMap<String, String>();
        messageBody = new StringBuilder();
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
    public void flush() throws IOException {
        //todo [DN]
    }
}