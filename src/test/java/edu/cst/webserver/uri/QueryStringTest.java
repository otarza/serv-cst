package edu.cst.webserver.uri;

/**
 * Created with IntelliJ IDEA.
 * User: Otar
 * Date: 2/28/13
 * Time: 1:40 AM
 * To change this template use File | Settings | File Templates.
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class QueryStringTest {

    @Test
    public void parse() {
        Map<String, String> m = new HashMap<String, String>();

        m.put("param1", "value1");
        m.put("param2", "val ue");
        m.put("pa ram3", "value3");

        Assert.assertEquals(m, QueryString.getUrlParams("param1=value1&param2=val%20ue&pa%20ram3=value3"));
    }

}
