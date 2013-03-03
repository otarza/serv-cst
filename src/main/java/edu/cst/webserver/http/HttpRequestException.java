package edu.cst.webserver.http;

public class HttpRequestException extends Exception {
    private HttpStatus.Code statusCode;

    public HttpRequestException(HttpStatus.Code statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public HttpRequestException(HttpStatus.Code statusCode) {
        this.statusCode = statusCode;
    }

    public HttpStatus.Code getStatusCode() {
        return this.statusCode;
    }

}