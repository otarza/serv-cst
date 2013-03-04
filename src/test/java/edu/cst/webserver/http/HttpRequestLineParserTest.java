package edu.cst.webserver.http;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Rezo
 * Date: 3/1/13
 * Time: 2:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class HttpRequestLineParserTest{
    private static final String HTTP_VERSION = "HTTP/1.1";
    @Test
    public void requestLine0() throws HttpRequestException {
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        String requestLineString;
        requestLineString = "GET /test HTTP/1.1\r\n";
        HttpRequestLine requestLine = parser.parse(requestLineString);

        Assert Assert = null;
        Assert.assertEquals(HttpMethod.TYPE_GET, requestLine.getMethodByName());
        Assert.assertEquals("/test", requestLine.getPath());
        Assert.assertEquals(HTTP_VERSION, requestLine.getHttpVersion());
}
    @Test
    public void requestLine2() throws HttpRequestException{
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        String requestLineString;
        requestLineString = "GET /favicon.ico HTTP/1.1\r\n";
        HttpRequestLine requestLine = parser.parse(requestLineString);

        Assert Assert = null;
        Assert.assertEquals(HttpMethod.TYPE_GET, requestLine.getMethodByName());
        Assert.assertEquals("/favicon.ico", requestLine.getPath());
        Assert.assertEquals(HTTP_VERSION, requestLine.getHttpVersion());
    }
    @Test
    public void requestLine3() throws HttpRequestException{
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        String requestLineString;
        requestLineString = "GET /dumbfuck HTTP/1.1\r\n";
        HttpRequestLine requestLine = parser.parse(requestLineString);

        Assert Assert = null;
        Assert.assertEquals(HttpMethod.TYPE_GET, requestLine.getMethodByName());
        Assert.assertEquals("/dumbfuck", requestLine.getPath());
        Assert.assertEquals(HTTP_VERSION, requestLine.getHttpVersion());
    }
    @Test
    public void requestLine4() throws HttpRequestException{
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        String requestLineString;
        requestLineString = "GET /forums/1/topics/2375?page=1#posts-17408 HTTP/1.1\r\n";
        HttpRequestLine requestLine = parser.parse(requestLineString);

        Assert Assert = null;
        Assert.assertEquals(HttpMethod.TYPE_GET, requestLine.getMethodByName());
        Assert.assertEquals("/forums/1/topics/2375", requestLine.getPath());
        Assert.assertEquals("?page=1", requestLine.getQueryString());
        Assert.assertEquals("#posts-17408",requestLine.getFragment());
        Assert.assertEquals(HTTP_VERSION, requestLine.getHttpVersion());
    }
    @Test
    public void requestLine5() throws HttpRequestException{
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        String requestLineString;
        requestLineString = "GET /get_no_headers_no_body/world HTTP/1.1\r\n";
        HttpRequestLine requestLine = parser.parse(requestLineString);

        Assert Assert = null;
        Assert.assertEquals(HttpMethod.TYPE_GET, requestLine.getMethodByName());
        Assert.assertEquals("/get_no_headers_no_body/world", requestLine.getPath());
        Assert.assertEquals(HTTP_VERSION, requestLine.getHttpVersion());
    }
    @Test
    public void requestLine6() throws HttpRequestException{
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        String requestLineString;
        requestLineString = "GET /get_one_header_no_body HTTP/1.1\r\n";
        HttpRequestLine requestLine = parser.parse(requestLineString);

        Assert Assert = null;
        Assert.assertEquals(HttpMethod.TYPE_GET, requestLine.getMethodByName());
        Assert.assertEquals("/get_one_header_no_body", requestLine.getPath());
        Assert.assertEquals(HTTP_VERSION, requestLine.getHttpVersion());
    }
    @Test
    public void requestLine7() throws HttpRequestException{
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        String requestLineString;
        requestLineString = "GET /get_funky_content_length_body_hello HTTP/1.1\r\n";
        HttpRequestLine requestLine = parser.parse(requestLineString);

        Assert Assert = null;
        Assert.assertEquals(HttpMethod.TYPE_GET, requestLine.getMethodByName());
        Assert.assertEquals("/get_funky_content_length_body_hello", requestLine.getPath());
        Assert.assertEquals(HTTP_VERSION, requestLine.getHttpVersion());
    }
    @Test
    public void requestLine8() throws HttpRequestException{
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        String requestLineString;
        requestLineString = "POST /post_identity_body_world?q=search#hey HTTP/1.1\r\n";
        HttpRequestLine requestLine = parser.parse(requestLineString);

        Assert Assert = null;
        Assert.assertEquals(HttpMethod.TYPE_POST, requestLine.getMethodByName());
        Assert.assertEquals("/post_identity_body_world", requestLine.getPath());
        Assert.assertEquals("?q=search", requestLine.getQueryString());
        Assert.assertEquals("#hey",requestLine.getFragment());
        Assert.assertEquals(HTTP_VERSION, requestLine.getHttpVersion());
    }
    @Test
    public void requestLine9() throws HttpRequestException{
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        String requestLineString;
        requestLineString = "POST /post_chunked_all_your_base HTTP/1.1\r\n";
        HttpRequestLine requestLine = parser.parse(requestLineString);

        Assert Assert = null;
        Assert.assertEquals(HttpMethod.TYPE_POST, requestLine.getMethodByName());
        Assert.assertEquals("/post_chunked_all_your_base", requestLine.getPath());
        Assert.assertEquals(HTTP_VERSION, requestLine.getHttpVersion());
    }
    @Test
    public void requestLine10() throws HttpRequestException{
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        String requestLineString;
        requestLineString = "POST /two_chunks_mult_zero_end HTTP/1.1\r\n";
        HttpRequestLine requestLine = parser.parse(requestLineString);

        Assert Assert = null;
        Assert.assertEquals(HttpMethod.TYPE_POST, requestLine.getMethodByName());
        Assert.assertEquals("/two_chunks_mult_zero_end", requestLine.getPath());
        Assert.assertEquals(HTTP_VERSION, requestLine.getHttpVersion());
    }
    @Test
    public void requestLine11() throws HttpRequestException{
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        String requestLineString;
        requestLineString = "POST /chunked_w_trailing_headers HTTP/1.1\r\n";
        HttpRequestLine requestLine = parser.parse(requestLineString);

        Assert Assert = null;
        Assert.assertEquals(HttpMethod.TYPE_POST, requestLine.getMethodByName());
        Assert.assertEquals("/chunked_w_trailing_headers", requestLine.getPath());
        Assert.assertEquals(HTTP_VERSION, requestLine.getHttpVersion());
    }
    @Test
    public void requestLine12() throws HttpRequestException{
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        String requestLineString;
        requestLineString = "POST /chunked_w_bullshit_after_length HTTP/1.1\r\n";
        HttpRequestLine requestLine = parser.parse(requestLineString);

        Assert Assert = null;
        Assert.assertEquals(HttpMethod.TYPE_POST, requestLine.getMethodByName());
        Assert.assertEquals("/chunked_w_bullshit_after_length", requestLine.getPath());
        Assert.assertEquals(HTTP_VERSION, requestLine.getHttpVersion());
    }
    @Test
    public void requestLine13() throws HttpRequestException{
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        String requestLineString;
        requestLineString = "GET /with_\\\"stupid\\\"_quotes?foo=\\\"bar\\\" HTTP/1.1\r\n\r\n";
        HttpRequestLine requestLine = parser.parse(requestLineString);

        Assert Assert = null;
        Assert.assertEquals(HttpMethod.TYPE_GET, requestLine.getMethodByName());
        Assert.assertEquals("/with_\\\"stupid\\\"_quotes", requestLine.getPath());
        Assert.assertEquals("?foo=\\\"bar\\\"",requestLine.getQueryString());
        Assert.assertEquals(HTTP_VERSION, requestLine.getHttpVersion());
    }
    @Test
    public void requestLine14() throws HttpRequestException{
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        String requestLineString;
        requestLineString = "GET /test.cgi?foo=bar?baz HTTP/1.1\r\n\r\n";
        HttpRequestLine requestLine = parser.parse(requestLineString);

        Assert Assert = null;
        Assert.assertEquals(HttpMethod.TYPE_GET, requestLine.getMethodByName());
        Assert.assertEquals("/test.cgi", requestLine.getPath());
        Assert.assertEquals("?foo=bar?baz",requestLine.getQueryString());
        Assert.assertEquals(HTTP_VERSION, requestLine.getHttpVersion());
    }
    @Test
    public void requestLine15() throws HttpRequestException{
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        String requestLineString;
        requestLineString = "\r\nGET /test HTTP/1.1\r\n\r\n";
        HttpRequestLine requestLine = parser.parse(requestLineString);

        Assert Assert = null;
        Assert.assertEquals(HttpMethod.TYPE_GET, requestLine.getMethodByName());
        Assert.assertEquals("/test", requestLine.getPath());
        Assert.assertEquals(HTTP_VERSION, requestLine.getHttpVersion());
    }
    @Test
    public void requestLine16() throws HttpRequestException{
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        String requestLineString;
        requestLineString = "CONNECT 0-home0.netscape.com:443 HTTP/1.1\r\n";
        HttpRequestLine requestLine = parser.parse(requestLineString);

        Assert Assert = null;
        Assert.assertEquals(HttpMethod.TYPE_CONNECT, requestLine.getMethodByName());
        //System.out.println(requestLine.getMethodByName());
        Assert.assertEquals("0-home0.netscape.com:443", requestLine.getPath());
        Assert.assertEquals(HTTP_VERSION, requestLine.getHttpVersion());
    }
    @Test
    public void requestLine17() throws HttpRequestException{
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        String requestLineString;
        requestLineString = "POST /test HTTP/1.1\r\n";
        HttpRequestLine requestLine = parser.parse(requestLineString);

        Assert Assert = null;
        Assert.assertEquals(HttpMethod.TYPE_POST, requestLine.getMethodByName());
        Assert.assertEquals("/test", requestLine.getPath());
        Assert.assertEquals(HTTP_VERSION, requestLine.getHttpVersion());
    }
    @Test
    public void requestLine18() throws HttpRequestException{
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        String requestLineString;
        requestLineString = "POST * HTTP/1.1\r\n";
        HttpRequestLine requestLine = parser.parse(requestLineString);

        Assert Assert = null;
        Assert.assertEquals(HttpMethod.TYPE_POST, requestLine.getMethodByName());
        Assert.assertEquals("*", requestLine.getPath());
        Assert.assertEquals(HTTP_VERSION, requestLine.getHttpVersion());
    }
    @Test
    public void requestLine19() throws HttpRequestException{
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        String requestLineString;
        requestLineString = "GET / HTTP/1.1\r\n";
        HttpRequestLine requestLine = parser.parse(requestLineString);

        Assert Assert = null;
        Assert.assertEquals(HttpMethod.TYPE_GET, requestLine.getMethodByName());
        Assert.assertEquals("/", requestLine.getPath());
        Assert.assertEquals(HTTP_VERSION, requestLine.getHttpVersion());
    }
    @Test
    public void requestLine20() throws HttpRequestException{
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        String requestLineString;
        requestLineString = "GET /file.txt HTTP/1.1\r\n";
        HttpRequestLine requestLine = parser.parse(requestLineString);

        Assert Assert = null;
        Assert.assertEquals(HttpMethod.TYPE_GET, requestLine.getMethodByName());
        Assert.assertEquals("/file.txt", requestLine.getPath());
        Assert.assertEquals(HTTP_VERSION, requestLine.getHttpVersion());
    }
    @Test
    public void requestLine21() throws HttpRequestException{
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        String requestLineString;
        requestLineString = "CONNECT HOME0.NETSCAPE.COM:443 HTTP/1.1\r\n";
        HttpRequestLine requestLine = parser.parse(requestLineString);

        Assert Assert = null;
        Assert.assertEquals(HttpMethod.TYPE_CONNECT, requestLine.getMethodByName());
        Assert.assertEquals("HOME0.NETSCAPE.COM:443", requestLine.getPath());
        Assert.assertEquals(HTTP_VERSION, requestLine.getHttpVersion());
    }
    @Test
    public void requestLine22() throws HttpRequestException{
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        String requestLineString;
        requestLineString = "GET /δ¶/δt/pope?q=1#narf HTTP/1.1\r\n";
        HttpRequestLine requestLine = parser.parse(requestLineString);

        Assert Assert = null;
        Assert.assertEquals(HttpMethod.TYPE_GET, requestLine.getMethodByName());
        Assert.assertEquals("/δ¶/δt/pope", requestLine.getPath());
        Assert.assertEquals("?q=1", requestLine.getQueryString());
        Assert.assertEquals("#narf", requestLine.getFragment());
        Assert.assertEquals(HTTP_VERSION, requestLine.getHttpVersion());
    }
}


//        "GET /δ¶/δt/pope?q=1#narf HTTP/1.1\r\n"
//        "CONNECT home_0.netscape.com:443 HTTP/1.0\r\n"