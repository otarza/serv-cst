package edu.cst.webserver.http;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Demur
 */
public class HttpMethodNameTest {

    /**
     *   The GET method requests transfer of a current selected representation
     *   for the target resource.  GET is the primary mechanism of information
     *   retrieval and the focus of almost all performance optimizations.
     *
     */

    @Test
    public void testHttpMethodGET() {
        HttpMethod.Type methodGet = HttpMethod.TYPE_GET;

        Assert.assertEquals("GET", methodGet.getMethodName());
        Assert.assertFalse(methodGet.isRequestBodyAllowed());
        Assert.assertTrue(methodGet.isResponseBodyAllowed());
    }
    /**
     *    The HEAD method is identical to GET except that the server MUST NOT
     *    send a message body in the response
     *
     *    This method can be used for obtaining metadata about the
     *    selected representation without transferring the representation data.
     *    This method is often used for testing hypertext links for validity,
     *    accessibility, and recent modification.
     */
    @Test
    public void testHttpMethodHEAD() {
        HttpMethod.Type methodHead = HttpMethod.TYPE_HEAD;

        Assert.assertEquals("HEAD", methodHead.getMethodName());
        Assert.assertFalse(methodHead.isRequestBodyAllowed());
        Assert.assertFalse(methodHead.isResponseBodyAllowed());
    }

    /**
     *    The POST method requests that the target resource process the
     *    representation enclosed in the request according to the resource's
     *    own specific semantics.
     */
    @Test
    public void testHttpMethodPOST() {
        HttpMethod.Type methodPost = HttpMethod.TYPE_POST;

        Assert.assertEquals("POST", methodPost.getMethodName());
        Assert.assertTrue(methodPost.isRequestBodyAllowed());
        Assert.assertFalse(methodPost.isResponseBodyAllowed());
    }

    /**
     *    The PUT method requests that the state of the target resource be
     *    created or replaced with the state defined by the representation
     *    enclosed in the request message payload.
     */
    @Test
    public void testHttpMethodPUT(){
        HttpMethod.Type methodPut = HttpMethod.TYPE_PUT;

        Assert.assertEquals("PUT", methodPut.getMethodName());
        Assert.assertTrue(methodPut.isRequestBodyAllowed());
        Assert.assertFalse(methodPut.isResponseBodyAllowed());
    }

    /**
     *    The DELETE method requests that the origin server remove the
     *    association between the target resource and its current
     *    functionality.
     *
     */
    @Test
    public void testHttpMethodDELETE(){
        HttpMethod.Type methodDelete = HttpMethod.TYPE_DELETE;

        Assert.assertEquals("DELETE",methodDelete.getMethodName());
        Assert.assertFalse(methodDelete.isRequestBodyAllowed());
        Assert.assertFalse(methodDelete.isResponseBodyAllowed());

    }

    /**
     *    The CONNECT method requests that the recipient establish a tunnel to
     *    the destination origin server identified by the request-target and,
     *    if successful, thereafter restrict its behavior to blind forwarding
     *    of packets, in both directions, until the connection is closed.
     */
    @Test
    public void testHttpMethodCONNECT(){
        HttpMethod.Type methodConnect = HttpMethod.TYPE_CONNECT;

        Assert.assertEquals("CONNECT", methodConnect.getMethodName());
        Assert.assertFalse(methodConnect.isRequestBodyAllowed());
        Assert.assertFalse(methodConnect.isResponseBodyAllowed());
    }
    /**
     *    The OPTIONS method requests information about the communication
     *    options available on the request/response chain identified by the
     *    effective request URI.
     *
     *
     *    A client that generates an OPTIONS request containing a payload body
     *    MUST send a valid Content-Type header field describing the
     *    representation media type.
     */
    @Test
    public void testHttpMethodOPTIONS(){
        HttpMethod.Type methodOptions = HttpMethod.TYPE_OPTIONS;

        Assert.assertEquals("OPTIONS", methodOptions.getMethodName());
        Assert.assertTrue(methodOptions.isRequestBodyAllowed());
        Assert.assertFalse(methodOptions.isResponseBodyAllowed());
    }
    /**
     *    The TRACE method requests a remote, application-level loop-back of
     *    the request message.  The final recipient of the request SHOULD
     *    reflect the message received, excluding some fields described below,
     *    back to the client as the message body of a 200 (OK) response with a
     *    Content-Type of "message/http"
     *
     *    A client MUST NOT send a message body in a TRACE request.
     */
    @Test
    public void testHttpMethodTRACE(){
        HttpMethod.Type methodTrace = HttpMethod.TYPE_TRACE;

        Assert.assertEquals("TRACE", methodTrace.getMethodName());
        Assert.assertFalse(methodTrace.isRequestBodyAllowed());
        Assert.assertTrue(methodTrace.isResponseBodyAllowed());
    }
}
