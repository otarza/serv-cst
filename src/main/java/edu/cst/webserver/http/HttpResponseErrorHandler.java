package edu.cst.webserver.http;

/**
 * @author Demur
 */
public interface HttpResponseErrorHandler {
    public void handle(HttpResponse response) throws HttpRequestException;
}
