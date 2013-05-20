package edu.cst.webserver.http;

/**
 * Created with IntelliJ IDEA.
 * User: Rezo
 * Date: 3/1/13
 * Time: 12:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class HttpRequestLine {
    private HttpMethod.Type method;
    private String requestLineString;
    private String requestUri;
    private String path;
    private String queryString;
    private String fragment;
    private String httpVersion;

    public String getRequestLineString(){
        return requestLineString;
    }
    public void setRequestLineString(String requestLineString){
        this.requestLineString = requestLineString;

    }

    public HttpMethod.Type getMethod() {
        return method;
    }

    public void setMethod(HttpMethod.Type method) {
        this.method = method;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }
    public String getFragment() {
        return fragment;
    }

    public void setFragment(String fragment) {
        this.fragment = fragment;
    }

    public String getHttpVersion() {
        return httpVersion;
    }

    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    @Override
    public String toString() {
        return getMethod() + " " + getPath() + " " +getHttpVersion();
    }
}