package edu.cst.webserver.http;

import edu.cst.webserver.uri.QueryString;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vaxop
 * Date: 3/7/13
 * Time: 7:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class HttpRequestWrapper implements HttpRequest{

    private HttpRequestLine request;
    private String requestbody;
    Map<String, String> headers;


    public HttpRequestWrapper(HttpRequestLine requestLine, Map<String, String> headers, String requestbody){
        this.request = requestLine;
        this.headers = headers;
        this.requestbody = requestbody;

    }



    @Override
    public HttpMethod.Type getRequestMethod(){
        return request.getMethod();
    }

    @Override
    public HttpRequestLine getHttpRequestLine() {
        return request;
    }

    @Override
    public String getRequestURI() {
        return request.getRequestUri();
    }

    @Override
    public String getHttpVersion() {
        return request.getHttpVersion();
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

       return QueryString.parse(request.getQueryString()) ;
    }

    @Override
    public String getPath() {
        return request.getPath();
    }
}
