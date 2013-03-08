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

        headers.put("Host:","www.example.com");
        headers.put("Accept:","text/html");

        String line = "GET http://en.kioskea.net/ HTTP/1.1";
        String body = "";
        HttpRequest response = new HttpRequestWrapper(line,headers,body);


        Assert.assertEquals(HttpMethod.Type.GET, response.getRequestMethod());

        Assert.assertTrue(ServerConfig.getInstance().isSupportedHttpVersion(response.getHttpVersion()));
    }





}
