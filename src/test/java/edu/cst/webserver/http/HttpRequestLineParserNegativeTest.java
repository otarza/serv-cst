package edu.cst.webserver.http;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 3/9/13
 * Time: 4:26 PM
 * To change this template use File | Settings | File Templates.
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
    public static Collection getRequestLineData(){
            return Arrays.asList(new Object[][]{
                    {
                            "GET /path/to/resource HTTP/1.1", // Request line to parse
                            HttpMethod.METHOD_GET,            // Expected HTTP method
                            "/path/to/resource",              // Expected Path
                            null,                               // Expected Query String
                            null,                               // Expected Fragment
                            HTTP_VERSION                      // Expected HTTP version
                    }

            });
    }


}
