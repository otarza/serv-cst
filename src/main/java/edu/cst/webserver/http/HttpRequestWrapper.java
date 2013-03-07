package edu.cst.webserver.http;

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

    private String request;
    private String requestbody;
    Map<String, String> headers;


    public HttpRequestWrapper(String requestLine, Map<String, String> headers, String requestbody){
        this.request = requestLine;
        this.headers = headers;
        this.requestbody = requestbody;

    }


    @Override
    public HttpMethod.Type getRequestMethod(){
        HttpRequestLine parsedLine =   getHttpRequestLine();
        return parsedLine.getMethod();
    }

    @Override
    public HttpRequestLine getHttpRequestLine() {
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        try {
            HttpRequestLine requestLine = parser.parse(request);
            return requestLine;
        } catch (HttpRequestException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getRequestURI() {
        HttpRequestLine parsedLine =   getHttpRequestLine();
        return parsedLine.getRequestUri();
    }

    @Override
    public String getHttpVersion() {
        HttpRequestLine parsedLine =   getHttpRequestLine();
        return parsedLine.getHttpVersion();
    }

    @Override
    public Map<String, String> getAllHeaders() {
        return null;
    }

    @Override
    public String getHeader(String headerName) {
        return null;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public Map<String, String> getParams() {
        return null;
    }

    @Override
    public String getPath() {
        return null;
    }
}
