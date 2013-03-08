package edu.cst.webserver.http;

/**
 * @author Demur
 */
public class HttpRequestDispatcher implements HttpResponseErrorHandler{

    @Override
    public void handle(HttpStatus.Code statusCode, HttpResponse response) throws HttpRequestException {

        throw new HttpRequestException(statusCode,"Message");
        //Generate Http response
       /* HTTP/1.1 400 Bad Request
        Content-Type: text/plain
        Content-Length: ...

        Something wrong happened!*/
    }

    @Override
    public void handle(HttpStatus.Code statusCode, HttpResponse response, String body) throws HttpRequestException {

        //Generate Http response
        throw new HttpRequestException(statusCode,"error with message body: " + body);
    }

    public HttpResponseWrapper dispatch() {
        HttpResponseWrapper response = new HttpResponseWrapper();
        response.setErrorHandler(new HttpRequestDispatcher());

        response.setHeader(HttpHeader.ACCEPT,"text/html");
        response.setHeader(HttpHeader.CONTENT_LENGTH,"343");

        response.setStatus(HttpStatus.Code.OK);

         return response;
    }


}
