package edu.cst.webserver.http;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Otar
 * Date: 2/28/13
 * Time: 12:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class HeaderField {
    public static Map<String, String> parse(String headerField) throws HttpRequestException {
        Map<String, String> splittedField = new HashMap<String, String>();

        //boolean match = headerField.matches("\\w+:\\s*\\w+\\s*");
        if (true) {    //aq true mxolod droebit weria sanam regexps movifiqreb
            String splittedAr[] = headerField.split(":");
            String key = splittedAr[0];
            String value = splittedAr[1];
            value = value.replaceAll("^\\s+", "");
            value = value.replaceAll("\\s+$", "");
            System.out.println(key);
            System.out.println(value);
            splittedField.put(key, value);
        } else {
            throw new HttpRequestException(HttpStatus.Code.BAD_REQUEST);
        }
        return splittedField;
    }
}
