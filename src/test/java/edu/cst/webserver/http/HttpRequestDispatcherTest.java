package edu.cst.webserver.http;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Demur
 */
public class HttpRequestDispatcherTest {

    @Test
    public void testDispatcher() throws HttpRequestException {

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(HttpHeader.HOST,"www.example.com");
        headers.put(HttpHeader.ACCEPT,"text/html");
        headers.put(HttpHeader.CONTENT_TYPE,"text/html");

        String body = "";

        String requestLineString = "POST filetypes/app.xml?param1=value1&param2=value2 HTTP/1.1";
        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        HttpRequest request = null;

        try {
            HttpRequestLine requestLine = parser.parse(requestLineString);
            request = new HttpRequestWrapper(requestLine,headers,body);
        } catch (HttpRequestException e) {
            e.printStackTrace();
        }


        HttpRequestDispatcher dispatcher = new HttpRequestDispatcher(request);
        try {
            HttpResponse response = dispatcher.dispatch();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
