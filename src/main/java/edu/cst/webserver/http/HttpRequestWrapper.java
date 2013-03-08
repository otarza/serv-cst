package edu.cst.webserver.http;

import edu.cst.webserver.uri.QueryString;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vaxop
 * Date: 3/7/13
 * Time: 7:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class HttpRequestWrapper implements HttpRequest{

    private HttpRequestLine requestLine;
    private String requestBody;
    Map<String, String> headers;


    public HttpRequestWrapper(HttpRequestLine requestLine, Map<String, String> headers, String requestBody){
        this.requestLine = requestLine;
        this.headers = headers;
        this.requestBody = requestBody;

    }



    @Override
    public HttpMethod.Type getRequestMethod(){
        return requestLine.getMethod();
    }

    @Override
    public HttpRequestLine getHttpRequestLine() {
        return requestLine;
    }

    @Override
    public String getRequestURI() {
        return requestLine.getRequestUri();
    }

    @Override
    public String getHttpVersion() {
        return requestLine.getHttpVersion();
    }

    @Override
    public Map<String, String> getAllHeaders() {
        return headers;
    }

    @Override
    public String getHeader(String headerName) {
        return headers.get(headerName);
    }

    @Override
    public String getContentType() {
        return  headers.get(HttpHeader.CONTENT_TYPE);
    }

    @Override
    public Map<String, String> getParams() {

       return QueryString.parse(requestLine.getQueryString()) ;
    }

    @Override
    public String getPath() {
        return requestLine.getPath();
    }
}
