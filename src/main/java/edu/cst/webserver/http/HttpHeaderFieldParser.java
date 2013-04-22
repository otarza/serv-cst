package edu.cst.webserver.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Otar
 */
public class HttpHeaderFieldParser {
    //static US ASCII character lookup array
    private static char allowedHeaderFieldKeyChars[] = {
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, '!', '"', '#', '$', '%', '&', '\'',
            0, 0, '*', '+', 0, '-', '.', 0,
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 0, 0, 0, 0, 0, 0,
            0, 'A', 'B', 'C', 'D', 'E', 'F', 'G',
            'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z', 0, 0, 0, 0, '_',
            '`', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z', 0, '|', 0, '~'
    };

    /**
     * HTTP headerField parser
     * Parses headerField string and if its valid returns key value map, If not throws  HttpRequestException
     */
    public static Map<String, String> parse(String headerField) throws HttpRequestException {
        Map<String, String> headers = new HashMap<String, String>();
        boolean isValid;
        if (headerField != null && !headerField.isEmpty()) {
            String tokens[] = headerField.trim().split(":\\s*", 2);
            if (tokens.length == 2 && tokens[0].length() > 0 && tokens[1].length() > 0 && hasValidCharacters(tokens[0])) {
                String key = tokens[0];
                String value = tokens[1];
                headers.put(key, value);
                isValid = true;
            } else {
                isValid = false;
            }
        } else {
            isValid = false;
        }
        if (!isValid) {
            throw new HttpRequestException(HttpStatus.Code.BAD_REQUEST);
        }
        return headers;
    }

    public static Map<String, String> parse_list(List<String> headers) throws HttpRequestException {
        Map<String, String> result = new HashMap<String, String>();
        for (int i = 0; i < headers.size(); i++) {
            String header = headers.get(i);
            Map<String, String> parsed = parse(header);
            result.putAll(parsed);
        }
        return result;
    }

    private static boolean hasValidCharacters(String headerField) {
        boolean allowed = true;
        for (int i = 0; i < headerField.length(); i++) {
            int code = headerField.charAt(i);
            if (code < 0 || code > 128) {
                allowed = false;
                break;
            }
            if ((allowedHeaderFieldKeyChars[code] == 0)) {
                allowed = false;
                break;
            }
        }
        return allowed;
    }
}
