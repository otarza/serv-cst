package edu.cst.webserver.uri;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Otar
 */
public class QueryString {
    private static final String UTF_8 = "UTF-8";

    public static Map<String, String> parse(String queryString) {
        Map<String, String> queryStringMap = new HashMap<String, String>();
        if (queryString == null || queryString.isEmpty()) {
            return queryStringMap;
        }
        queryString = queryString.split("#")[0];
        for (String pairString : queryString.split("&")) {
            String pairSplitted[] = pairString.split("=");
            String key, value;
            try {
                key = URLDecoder.decode(pairSplitted[0], UTF_8);
                value = URLDecoder.decode(pairSplitted[1], UTF_8);
                if (!key.isEmpty() && !value.isEmpty()) {
                    queryStringMap.put(key, value);
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                // TODO replace with logger [OZ]
            }
        }
        return queryStringMap;
    }
}