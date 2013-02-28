package edu.cst.webserver.http;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 3/1/13
 * Time: 2:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class HttpRequestLineParserTest{
    private static final String HTTP_VERSION = "HTTP/1.1";
    @Test
    public void testRequestLine0() {
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        String requestLineString;
        requestLineString = "GET /test HTTP/1.1\\r\\n";
        HttpRequestLine requestLine = parser.parse(requestLineString);

        Assert Assert = null;
        Assert.assertEquals(HttpMethod.METHOD_GET, requestLine.getMethodName());
        Assert.assertEquals("/test", requestLine.getPath());
        Assert.assertEquals(HTTP_VERSION, requestLine.getHttpVersion());
}
}
