package edu.cst.webserver.http;

import edu.cst.webserver.uri.QueryString;

import java.util.Map;

/**
 * User: vaxop
 */
public class HttpRequestWrapper implements HttpRequest{

    private HttpRequestLine requestLine;
    private String requestBody;
    private Map<String, String> headers;
    private Map<String,String> queryParams;

    public HttpRequestWrapper(HttpRequestLine requestLine, Map<String, String> headers, String requestBody){
        this.requestLine = requestLine;
        this.headers = headers;
        this.requestBody = requestBody;
        this.queryParams = QueryString.parse(requestLine.getQueryString());

    }

    @Override
    public HttpMethod.Type getRequestMethod(){
        return requestLine.getMethod();
    }

    @Override
    public String getHttpRequestLine() {
        return requestLine.toString();
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
        String header = headers.get(HttpHeader.CONTENT_TYPE);
        if(header == null){
           return "NULL";
        }else return   header ;
    }

    @Override
    public Map<String, String> getParams() {
       return queryParams;
    }

    @Override
    public String getPath() {
        return requestLine.getPath();
    }
}
