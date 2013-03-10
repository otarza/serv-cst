package edu.cst.webserver.uri;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Otar
 * Date: 2/28/13
 * Time: 1:15 AM
 */
public class QueryString {
    private static final String UTF_8 = "UTF-8";

    /**
     * getUrlParams returns key, value queryStringMap built from queryString
     * String queryString is http query string
     *
     */
    public static Map<String, String> parse(String queryString) {

        Map<String, String> queryStringMap = new HashMap<String, String>();
        if(queryString == null || queryString.isEmpty()){
            return queryStringMap;
        }



        //splitting sting with "#". only first part of string, before "#" is interesting.
        queryString = queryString.split("#")[0];

        for (String pairString : queryString.split("&")) {
            String pairSplitted[] = pairString.split("=");
            String key = "";
            String value = "";
            try {
                key = URLDecoder.decode(pairSplitted[0], UTF_8);
                value = URLDecoder.decode(pairSplitted[1], UTF_8);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                // TODO replace with logger [OZ]
            }
            if (!key.isEmpty() && !value.isEmpty()) {
                queryStringMap.put(key, value);
            }
        }
        return queryStringMap;
    }
}
