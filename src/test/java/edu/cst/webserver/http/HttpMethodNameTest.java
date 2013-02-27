package edu.cst.webserver.http;

import org.junit.*;

/**
 * @author Demur
 */
public class HttpMethodNameTest {
    @org.junit.Test
    public void testGetMethodName() {
        Assert.assertEquals("GET", HttpMethod.GET);
    }
}
