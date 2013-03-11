package edu.cst.webserver.http;

import junit.framework.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *@author Otar
 */
public class HttpHeaderFieldParserTest {

    @Test(expected = HttpRequestException.class)
    public void parseInvalidHeaderFieldTest() throws HttpRequestException {
        HttpHeaderFieldParser.parse(" Accept-Language :    en-us,en;q=0.5 ");
    }

    @Test
    public void parseTest() throws HttpRequestException {
        Map<String, String> fieldsMap = new HashMap<String, String>();
        fieldsMap.put("Accept-Language", "en-us,en;q=0.5");
        Assert.assertEquals(fieldsMap, HttpHeaderFieldParser.parse("Accept-Language:en-us,en;q=0.5"));

    }
}
