package edu.cst.webserver.http;

public class HttpRequestException extends Exception {
    private HttpStatus.Code httpStatusCode;

    public HttpRequestException(HttpStatus.Code statusCode, String message) {
        super(message);
        this.httpStatusCode = statusCode;
    }

    public HttpRequestException(HttpStatus.Code statusCode) {
        this.httpStatusCode = statusCode;
    }

    public HttpStatus.Code getStatusCode() {
        return this.httpStatusCode;

    }

}