package edu.cst.webserver.http;

import java.io.IOException;

/**
 * @author Demur
 */
public class HttpRequestDispatcher implements HttpResponseErrorHandler{

    @Override
    public void handle(HttpResponse response) throws HttpRequestException {

        throw new HttpRequestException(response.getStatusCode(),"Message");
        //Generate Http response
       /* HTTP/1.1 400 Bad Request
        Content-Type: text/plain
        Content-Length: ...

        Something wrong happened!*/
    }

    public HttpResponseWrapper dispatch() throws IOException {
        HttpResponseWrapper response = new HttpResponseWrapper();
        response.setErrorHandler(new HttpRequestDispatcher());

        response.setHeader(HttpHeader.ACCEPT,"text/html");
        response.setHeader(HttpHeader.CONTENT_LENGTH,"343");
        response.write("test");



        response.setStatus(HttpStatus.Code.OK);

         return response;
    }


}
