package edu.cst.webserver.http;


import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author revazi
 */
@RunWith(Parameterized.class)
public class HttpRequestLineParserNegativeTest {
    private static final String HTTP_VERSION = "HTTP/1.1";

    private String requestLineString;
    private String expectedMethod;
    private String expectedPath;
    private String expectedQueryString;
    private String expectedFragment;
    private String expectedHttpVersion;

    public HttpRequestLineParserNegativeTest(
            String requestLineString,
            String expectedMethod,
            String expectedPath,
            String expectedQueryString,
            String expectedFragment,
            String expectedHttpVersion){
        this.requestLineString = requestLineString;
        this.expectedMethod = expectedMethod;
        this.expectedPath = expectedPath;
        this.expectedQueryString = expectedQueryString;
        this.expectedFragment = expectedFragment;
        this.expectedHttpVersion = expectedHttpVersion;
    }
    @Parameterized.Parameters
    public static Collection getRequestLineData() {
        return Arrays.asList(new Object[][]{
                {
                        "GET /path?></.?/to/resource HTTP/1.1", // Request line to parse
                        HttpMethod.METHOD_GET,            // Expected HTTP method
                        "/path?></.?/to/resource",        // Expected Path
                        null,                             // Expected Query String
                        null,                             // Expected Fragment
                        HTTP_VERSION                      // Expected HTTP version
                },
                {
                        "GET /with_\"stupid\"_quotes?foo=\"bar\" HTTP/1.1\r\n\r\n",
                        HttpMethod.METHOD_GET,
                        "with_\"stupid\"_quotes",
                        "foo=\"bar\"",
                        null,
                        HTTP_VERSION
                }

        });
    }

    @Test(expected = HttpRequestException.class)
    public void uriSyntaxTest() throws HttpRequestException {
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        HttpRequestLine requestLine = parser.parse(requestLineString);
        Assert.fail();
    }
}
