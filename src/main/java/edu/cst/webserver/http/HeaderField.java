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
    //static US ASCII character lookup array
    static Character assci[] = new Character[]{
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', ':', ';', '<', '=', '>', '?', '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '[', '\\', ']', '^', '_', '`', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '{', '|', '}', '~'
    };

    /**
     * HTTP headerField parser
     * Parses headerField string and if its valid returns key value map, If not throws  HttpRequestException
     */
    public static Map<String, String> parse(String headerField) throws HttpRequestException {
        Map<String, String> splittedField = new HashMap<String, String>();
        boolean isValid = hasValidCharacters(headerField);
        if (isValid) {    //aq true mxolod droebit weria sanam regexps movifiqreb
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

    public static Boolean hasValidCharacters(String headerField) {
        for (int i = 0; i < headerField.length(); i++) {
            int code = (int) headerField.charAt(i);
            if ((assci[code] <= 0 || assci[code] > 128)) {
                return false;
            }
        }
        return true;
    }
}
