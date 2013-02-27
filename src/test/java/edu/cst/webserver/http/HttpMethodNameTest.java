package edu.cst.webserver.http;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Demur
 */
public class HttpMethodNameTest {
    @Test
    public void testGetMethodName() {
        HttpMethod.Type methodGet = HttpMethod.TYPE_GET;
        HttpMethod.Type methodHead = HttpMethod.TYPE_HEAD;
        HttpMethod.Type methodPost = HttpMethod.TYPE_POST;
        HttpMethod.Type methodPut = HttpMethod.TYPE_PUT;
        HttpMethod.Type methodDelete = HttpMethod.TYPE_DELETE;
        HttpMethod.Type methodConnect = HttpMethod.TYPE_CONNECT;
        HttpMethod.Type methodOptions = HttpMethod.TYPE_OPTIONS;
        HttpMethod.Type methodTrace = HttpMethod.TYPE_TRACE;

        Assert.assertEquals("GET", methodGet.getMethodName());
        Assert.assertEquals("HEAD", methodHead.getMethodName());
        Assert.assertEquals("POST", methodPost.getMethodName());
        Assert.assertEquals("PUT", methodPut.getMethodName());
        Assert.assertEquals("DELETE", methodDelete.getMethodName());
        Assert.assertEquals("CONNECT", methodConnect.getMethodName());
        Assert.assertEquals("OPTIONS", methodOptions.getMethodName());
        Assert.assertEquals("TRACE", methodTrace.getMethodName());

        Assert.assertTrue(methodGet.isRequestBodyAllowed());
        Assert.assertFalse(methodGet.isResponseBodyAllowed());

    }
    @Test
    public void testRequestBodyAllow(){

    }
}
