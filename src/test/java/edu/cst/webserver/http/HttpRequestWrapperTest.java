package edu.cst.webserver.http;

import edu.cst.webserver.env.ServerConfig;
import junit.framework.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vaxop
 * Date: 3/7/13
 * Time: 7:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class HttpRequestWrapperTest {

    @Test
    public void testHttpRequest(){

        Map<String, String> headers = new HashMap<String, String>();

        headers.put(HttpHeader.HOST,"www.example.com");
        headers.put(HttpHeader.ACCEPT,"text/html");
        headers.put(HttpHeader.CONTENT_TYPE,"text/html");

        String body = "";

        String requestLineString = "POST /path/to/resource?param1=value1&param2=value2 HTTP/1.1";
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        HttpRequest response = null;
        try {
            HttpRequestLine requestLine = parser.parse(requestLineString);
            response = new HttpRequestWrapper(requestLine,headers,body);
        } catch (HttpRequestException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(HttpMethod.Type.POST, response.getRequestMethod());
        Assert.assertTrue(ServerConfig.getInstance().isSupportedHttpVersion(response.getHttpVersion()));
        Assert.assertEquals("/path/to/resource",response.getPath());
        Assert.assertEquals("text/html",response.getContentType());
        Assert.assertEquals(headers,response.getAllHeaders());
        Map<String, String> m = new HashMap<String, String>();
        m.put("?param1", "value1");
        m.put("param2", "value2");
        Assert.assertEquals(m,response.getParams());
    }





}
