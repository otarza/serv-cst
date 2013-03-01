package edu.cst.webserver.http;

import edu.cst.webserver.env.ServerConfig;

import static java.lang.Character.toUpperCase;

/**
 * Created with IntelliJ IDEA.
 * User: Rezo
 * Date: 3/1/13
 * Time: 12:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class HttpRequestLineParser {
    private HttpRequestLineParser()
    {

    }

    public HttpRequestLine parse(String requestLineString){
        String parts[];
        requestLineString.replaceAll("^(\\s+)", "").replaceAll("\\s+$", "");
        try
        {
            parts = requestLineString.split("\\s+",3);
        }catch(HttpRequestException e)
        {
            throw new HttpRequestException(HttpStatus.Code.BAD_REQUEST);
        }
        //HTTP Method Check and Uppercase
        ServerConfig config = ServerConfig.getInstance();
        String p = parts[0].toString();
        p.toUpperCase();
        try
        {
            boolean configSupportedMethod = config.isSupportedMethod(p);
        }
        catch ()
        {
            //waiting for the HttpRequestException logic
            throw new HttpRequestException(HttpStatus.Code.METHOD_NOT_ALLOWED);
        }
            parts[0] = p;
        //Here Goes URI parse



        //--------------------
        //Http Request Version Check
        try
        {
            String part = parts[2];

        }catch()
        {
             //waiting for the HttpRequestException logic
             throw new HttpRequestException(HttpStatus.Code.HTPP_VERSION_NOT_SUPPORTED);
        }
        return parts;
    }



    public static HttpRequestLineParser newInstance() {
        return new HttpRequestLineParser();
    }

}
