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
        Assert.assertEquals(true,config.isSupportedMethod("GET"));
        Assert.assertEquals(true,config.isSupportedMethod("HEAD"));
        Assert.assertEquals(false,config.isSupportedMethod("POST"));
    }
    @Test
    public void testSupportedMimeTypes(){
        Assert.assertEquals(true,config.isSupportedMimeType("image/jpeg"));
        Assert.assertEquals(true,config.isSupportedMimeType("text/html"));
        Assert.assertEquals(true,config.isSupportedMimeType("text/plain"));
        Assert.assertEquals(false,config.isSupportedMimeType("image/jpg"));
    }
}
