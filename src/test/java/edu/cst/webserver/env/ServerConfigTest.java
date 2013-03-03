package edu.cst.webserver.env;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @author Demur
 */
public class ServerConfigTest {

    ServerConfig config = ServerConfig.getInstance();

    @Test
    public void testSupportedMethod(){
        Assert.assertTrue(config.isSupportedMethod("GET"));
        Assert.assertTrue(config.isSupportedMethod("HEAD"));
        Assert.assertFalse(config.isSupportedMethod("POST"));
    }
    @Test
    public void testSupportedMimeTypes(){
        Assert.assertTrue(config.isSupportedMimeType("image/jpeg"));
        Assert.assertTrue(config.isSupportedMimeType("text/html"));
        Assert.assertTrue(config.isSupportedMimeType("text/plain"));
        Assert.assertFalse(config.isSupportedMimeType("image/jpg"));
    }
    @Test
    public void testSupportedHttpVersionAllowed(){
        Assert.assertEquals(true, config.isSupportedHttpVersion("HTTP/1.1"));
    }
    @Test
    public void testisSupportedHttpVersionNotAllowed(){
        Assert.assertEquals(false, config.isSupportedHttpVersion("HTTP/1.1"));
    }

}
