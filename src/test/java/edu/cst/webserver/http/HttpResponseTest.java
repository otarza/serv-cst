package edu.cst.webserver.http;

import junit.framework.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Demur
 */
public class HttpResponseTest {

    @Test
    public void testHttpResponsePositive(){
        HttpRequestDispatcher response = new HttpRequestDispatcher();

        HttpResponseWrapper res = response.dispatch();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(HttpHeader.ACCEPT,"text/html");
        headers.put(HttpHeader.CONTENT_LENGTH,"343");


        Assert.assertEquals(headers,res.getHeaders());
        Assert.assertEquals(HttpStatus.Code.OK,res.getStatusCode());
        Assert.assertEquals(null,res.getMessageBody());
    }

}
