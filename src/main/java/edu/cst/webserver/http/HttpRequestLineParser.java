package edu.cst.webserver.http;

import edu.cst.webserver.env.ServerConfig;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 3/1/13
 * Time: 12:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class HttpRequestLineParser {
    private HttpRequestLineParser()
    {

    }
    public HttpRequestLine parse(String requestLineString)
    {

        ServerConfig config = ServerConfig.getInstance();
        config.isSupportedMethod(HttpRequestLine.getMethod());
        return null;
    }

    public static HttpRequestLineParser newInstance() {
        return new HttpRequestLineParser();
    }
}
