package edu.cst.webserver.http;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Demur
 */

interface HttpResponseErrorHandler {
    public void handle(HttpStatus.Code statusCode, HttpResponse response) throws HttpRequestException;
    public void handle(HttpStatus.Code statusCode, HttpResponse response, String body) throws HttpRequestException;
}

public class HttpResponseWrapper implements HttpResponse {

    HttpStatus.Code statusCode;
    HttpStatus statusName;
    private Map<String,String> headers;
    private String  messageBody;

    private HttpResponseErrorHandler errorHandler;

    public HttpResponseWrapper() {
        headers = new HashMap<String, String>();
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
        if(this.statusCode == null){
            this.statusCode = status;
        }
    }

    @Override
    public void redirect(String location) {
        this.headers.put(HttpHeader.LOCATION, location);
    }

    @Override
    public void redirect(String location, HttpStatus.Code redirectStatus) {
        this.headers.put(HttpHeader.LOCATION, location);
        if(this.statusCode == null){
            this.statusCode = redirectStatus;
        }
    }

    @Override
    public void error(HttpStatus.Code errorStatus) throws HttpRequestException {
        errorHandler.handle(errorStatus, this);
    }

    @Override
    public void error(HttpStatus.Code errorStatus, String body) throws HttpRequestException {
        this.messageBody = body;
        errorHandler.handle(errorStatus, this, messageBody);
    }

    @Override
    public void write(String content) throws IOException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void flush() throws IOException {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}