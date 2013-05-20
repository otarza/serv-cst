package edu.cst.webserver.http;

/**
 * User: vaxop
 */
import java.util.Map;

public interface HttpRequest {
    /**
     * Returns HTTP request method name POST, GET etc...
     */
    public HttpMethod.Type getRequestMethod();

    /**
     * Returns parsed HTTP Request Line object
     */
    public String getHttpRequestLine();

    /**
     * Returns request URI in a full form,
     * /path/to/resource?param=value
     * MUST use requestLine object
     */
    public String getRequestURI();

    /**
     * Returns HTTP version string: HTTP/1.1
     * MUST use requestLine object
     */
    public String getHttpVersion();

    /**
     * Returns key/value pairs of parsed HTTP request header fields
     */
    public Map<String, String> getAllHeaders();

    /**
     * Returns value of a HTTP header field
     * @param headerName
     */
    public String getHeader(String headerName);

    /**
     * Returns request content type specified as a value of
     * Content-Type: header field. e.g. application/x-form-www-urlencoded
     */
    public String getContentType();

    /**
     * Returns key/value pairs of query string or submitted form
     * MUST use requestLine
     * retrieve query string from requestLine object
     * perform lazy parsing of query string
     */
    public Map<String, String> getParams();

    /**
     * Returns path portion of request URI. If request URI was
     * /path/to/resource?param1=value1&param2=value2
     * method returns /path/to/resource
     * MUST use requestLine object
     */
    public String getPath();
}
