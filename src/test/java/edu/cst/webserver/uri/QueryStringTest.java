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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class QueryStringTest {

    @Test
    //Testing whitespace
    public void testWhiteSpaceParse() {
        Map<String, String> m = new HashMap<String, String>();
        m.put("param1", "value1");
        m.put("param2", "val ue");
        m.put("pa ram3", "value3");
        Assert.assertEquals(m, QueryString.parse("param1=value1&param2=val%20ue&pa%20ram3=value3"));
    }

    @Test
    //Testing percentage sign
    public void testPercentageSignParse() {
        Map<String, String> m = new HashMap<String, String>();
        m.put("param1", "10%");
        m.put("param2", "5%");
        m.put("param3", "17%");
        Assert.assertEquals(m, QueryString.parse("param1=10%25&param2=5%25&param3=17%25"));
    }

    @Test
    //Testing  UTF-8
    public void testUTF8Parse() {
        Map<String, String> m = new HashMap<String, String>();

        m.put("მისალმება", "გამარჯობა");
        m.put("param2", "ორი");
        m.put("param3", "თხუტმეტი");


        Assert.assertEquals(m, QueryString.parse("%E1%83%9B%E1%83%98%E1%83%A1%E1%83%90%E1%83%9A%E1%83%9B%E1%83%94%E1%83%91%E1%83%90=%E1%83%92%E1%83%90%E1%83%9B%E1%83%90%E1%83%A0%E1%83%AF%E1%83%9D%E1%83%91%E1%83%90&param2=%E1%83%9D%E1%83%A0%E1%83%98&param3=%E1%83%97%E1%83%AE%E1%83%A3%E1%83%A2%E1%83%9B%E1%83%94%E1%83%A2%E1%83%98"));
    }

    @Test
    //Testing  "#" sign. everything after "#" sign is not interesting at all.
    public void testHashParse() {
        Map<String, String> m = new HashMap<String, String>();
        m.put("param1", "value1");
        m.put("param2", "val ue");
        m.put("pa ram3", "value3");
        Assert.assertEquals(m, QueryString.parse("param1=value1&param2=val%20ue&pa%20ram3=value3#hello"));
    }

    @Test
    public void testEmptyQueryString() {
        Assert.assertEquals(Collections.emptyMap(), QueryString.parse(""));
    }

    @Test
    public void testNullQueryString() {
        Assert.assertEquals(Collections.emptyMap(), QueryString.parse(null));
    }

    @Test
    public void testQueryParamWithNoKey() {
        String queryString = "param1=value1&=value";
        Map<String, String> result = QueryString.parse(queryString);

        Map<String, String> m = new HashMap<String, String>();
        m.put("param1", "value1");
        Assert.assertEquals(m, result);
    }
}
