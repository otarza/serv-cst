package edu.cst.webserver.uri;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Otar
 * Date: 2/28/13
 * Time: 1:15 AM
 */
public class QueryString {

    /**
     * getUrlParams returns key, value queryStringMap built from queryString
     * String queryString is http query string
     *
     */
    public static Map<String, String> getUrlParams(String queryString) {


        Map<String, String> queryStringMap = new HashMap<String, String>();

        //splitting sting with "#". only first part of string, before "#" is interesting.
        queryString = queryString.split("#")[0];

        for (String pairString : queryString.split("&")) {
            String pairSplitted[] = pairString.split("=");
            String key = "";
            String value = "";
            try {
                key = URLDecoder.decode(pairSplitted[0], "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                // TODO replace with logger [OZ]
            }
            try {
                value = URLDecoder.decode(pairSplitted[1], "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                // TODO replace with logger [OZ]
            }
            if (!key.isEmpty()) {
                queryStringMap.put(key, value);
            }
        }
        return queryStringMap;
    }
}
