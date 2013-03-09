package edu.cst.webserver.http;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;


/**
 * @author revazi
 */
@RunWith(Parameterized.class)
public class HttpRequestLineParserTest{
    private static final String HTTP_VERSION = "HTTP/1.1";

    private String requestLineString;
    private String expectedMethod;
    private String expectedPath;
    private String expectedQueryString;
    private String expectedFragment;
    private String expectedHttpVersion;

    public HttpRequestLineParserTest(
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

    @Parameters
    public static Collection getRequestLineData(){
        return Arrays.asList(new Object[][]{
                //0
                {
                        "GET /path/to/resource HTTP/1.1", // Request line to parse
                        HttpMethod.METHOD_GET,            // Expected HTTP method
                        "/path/to/resource",              // Expected Path
                        null,                               // Expected Query String
                        null,                               // Expected Fragment
                        HTTP_VERSION                      // Expected HTTP version

                },
                //1
                {
                        "GET /path/to/resource?param=value HTTP/1.1",
                        HttpMethod.METHOD_GET,
                        "/path/to/resource",
                        "param=value",
                        null,
                        HTTP_VERSION
                },
                //2
                {
                        "GET /favicon.ico HTTP/1.1\r\n",
                        HttpMethod.METHOD_GET,
                        "/favicon.ico",
                        null,
                        null,
                        HTTP_VERSION
                },
                //3
                {
                        "GET /dumbfuck HTTP/1.1\r\n",
                        HttpMethod.METHOD_GET,
                        "/dumbfuck",
                        null,
                        null,
                        HTTP_VERSION
                },
                //4
                {
                        "GET /forums/1/topics/2375?page=1#posts-17408 HTTP/1.1\r\n",
                        HttpMethod.METHOD_GET,
                        "/forums/1/topics/2375",
                        "page=1",
                        "posts-17408",
                        HTTP_VERSION
                },
                //5
                {
                        "GET /get_no_headers_no_body/world HTTP/1.1\r\n",
                        HttpMethod.METHOD_GET,
                        "/get_no_headers_no_body/world",
                        null,
                        null,
                        HTTP_VERSION
                },
                //6
                {
                        "GET /get_one_header_no_body HTTP/1.1\r\n",
                        HttpMethod.METHOD_GET,
                        "/get_one_header_no_body",
                        null,
                        null,
                        HTTP_VERSION
                },
                //7
                {
                        "GET /get_funky_content_length_body_hello HTTP/1.1\r\n",
                        HttpMethod.METHOD_GET,
                        "/get_funky_content_length_body_hello",
                        null,
                        null,
                        HTTP_VERSION
                },
                //8
                {
                        "POST /post_identity_body_world?q=search#hey HTTP/1.1\r\n",
                        HttpMethod.METHOD_POST,
                        "/post_identity_body_world",
                        "q=search",
                        "hey",
                        HTTP_VERSION
                },
                //9
                {
                        "GET /get_one_header_no_body HTTP/1.1\r\n",
                        HttpMethod.METHOD_GET,
                        "/get_one_header_no_body",
                        null,
                        null,
                        HTTP_VERSION
                },
                //10
                {
                        "POST /post_chunked_all_your_base HTTP/1.1\r\n",
                        HttpMethod.METHOD_POST,
                        "/post_chunked_all_your_base",
                        null,
                        null,
                        HTTP_VERSION
                },
                //11
                {
                        "POST /two_chunks_mult_zero_end HTTP/1.1\r\n",
                        HttpMethod.METHOD_POST,
                        "/two_chunks_mult_zero_end",
                        null,
                        null,
                        HTTP_VERSION
                },
                //12
                {
                        "POST /chunked_w_trailing_headers HTTP/1.1\r\n",
                        HttpMethod.METHOD_POST,
                        "/chunked_w_trailing_headers",
                        null,
                        null,
                        HTTP_VERSION
                },
                //13
                {
                        "POST /chunked_w_bullshit_after_length HTTP/1.1\r\n",
                        HttpMethod.METHOD_POST,
                        "/chunked_w_bullshit_after_length",
                        null,
                        null,
                        HTTP_VERSION
                },
                //14
                {
                        "GET /with_stupid_quotes?foo=bar HTTP/1.1\r\n\r\n",
                        HttpMethod.METHOD_GET,
                        "/with_stupid_quotes",
                        "foo=bar",
                        null,
                        HTTP_VERSION
                },
                //15
                {
                        "GET /test.cgi?foo=bar?baz HTTP/1.1\r\n\r\n",
                        HttpMethod.METHOD_GET,
                        "/test.cgi",
                        "foo=bar?baz",
                        null,
                        HTTP_VERSION
                },
                //16
                {
                        "\r\nGET /test HTTP/1.1\r\n\r\n",
                        HttpMethod.METHOD_GET,
                        "/test",
                        null,
                        null,
                        HTTP_VERSION
                },
                //17
                {
                        "CONNECT 0-home0.netscape.com:443 HTTP/1.1\r\n",
                        HttpMethod.METHOD_CONNECT,
                        "0-home0.netscape.com:443",
                        null,
                        null,
                        HTTP_VERSION
                },
                //18
                {
                        "GET / HTTP/1.1\r\n",
                        HttpMethod.METHOD_GET,
                        "/",
                        null,
                        null,
                        HTTP_VERSION
                },
                //19
                {
                        "CONNECT HOME0.NETSCAPE.COM:443 HTTP/1.1\r\n",
                        HttpMethod.METHOD_CONNECT,
                        "HOME0.NETSCAPE.COM:443",
                        null,
                        null,
                        HTTP_VERSION
                },
                //20
                {
                        "GET /δ¶/δt/pope?q=1#narf HTTP/1.1\r\n",
                        HttpMethod.METHOD_GET,
                        "/δ¶/δt/pope",
                        "q=1",
                        "narf",
                        HTTP_VERSION
                }
        });
    }

    @Test
    public void testHttpRequestLine() throws HttpRequestException, URISyntaxException {
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        HttpRequestLine requestLine = parser.parse(requestLineString);

        Assert.assertEquals(this.requestLineString, requestLine.getRequestUri());
        Assert.assertEquals(this.expectedMethod, requestLine.getMethod().getMethodName());
        Assert.assertEquals(this.expectedPath, requestLine.getPath());
        Assert.assertEquals(this.expectedQueryString,requestLine.getQueryString());
        Assert.assertEquals(this.expectedFragment,requestLine.getFragment());
        Assert.assertEquals(this.expectedHttpVersion, requestLine.getHttpVersion());
    }
}