package edu.cst.webserver.http;

import junit.framework.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Otar
 * Date: 2/28/13
 * Time: 12:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class HeaderFieldTest {

    @Test
    public void parseTest() throws HttpRequestException {
        Map<String, String> fieldsMap = new HashMap<String, String>();

        fieldsMap.put("Accept-Language", "en-us,en;q=0.5");

        Assert.assertEquals(fieldsMap, HeaderField.parse("Accept-Language:    en-us,en;q=0.5 "));

    }
}
