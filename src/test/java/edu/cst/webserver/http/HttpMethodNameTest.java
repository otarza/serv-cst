package edu.cst.webserver.http;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Demur
 */
public class HttpMethodNameTest {
    @Test
    public void testGetMethodName() {
        Assert.assertEquals("GET", HttpMethod.GET);
    }
}
