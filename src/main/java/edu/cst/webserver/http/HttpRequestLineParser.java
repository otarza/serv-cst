package edu.cst.webserver.http;

import edu.cst.webserver.env.ServerConfig;

//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Rezo
 * Date: 3/1/13
 * Time: 12:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class HttpRequestLineParser{
    private String requestUri;
    private String parts[];
    private String queryString="";
    private String pathString ="";
    private String fragmentString = "";

    public static HttpRequestLineParser newInstance(){
        return new HttpRequestLineParser();
    }

    private HttpRequestLineParser(){
    }

    public HttpRequestLine parse(String requestLineString) throws HttpRequestException {

        parts = requestLineString.trim().split("\\s+");

        //Check for the correct number of request parts
        if (parts.length != 3){
            throw new HttpRequestException(HttpStatus.Code.BAD_REQUEST);
        }
        //HTTP Method Check and Uppercase
        ServerConfig config = ServerConfig.getInstance();
        String methodName = parts[0].toUpperCase();

        if(!config.isSupportedMethod(methodName)){
            throw new HttpRequestException(HttpStatus.Code.METHOD_NOT_ALLOWED);
        }
        //Http Request Version Check
        String httpVersion = parts[2];
        requestUri = parts[1];

        if (!config.isSupportedHttpVersion(httpVersion)) {
            throw new HttpRequestException(HttpStatus.Code.HTPP_VERSION_NOT_SUPPORTED);
        }else if(requestUri.contains("?") && requestUri.contains("#")){
   /*URI parse*/    pathString = requestUri.substring(0,requestUri.indexOf("?"));
            queryString  = requestUri.substring(requestUri.indexOf("?"),
                    requestUri.indexOf("#"));
            fragmentString = requestUri.substring(requestUri.indexOf("#"));
        }else if(requestUri.contains("?")){
            pathString = requestUri.substring(0,requestUri.indexOf("?"));
            queryString  = requestUri.substring(requestUri.indexOf("?"));
        }else{
            pathString  = requestUri.substring(0);
        }

        HttpRequestLine requestLine = new HttpRequestLine();

        requestLine.setMethod(HttpMethod.getMethodByName(methodName));
        requestLine.setHttpVersion(httpVersion);
        requestLine.setPath(pathString);
        requestLine.setQueryString(queryString);
        requestLine.setFragment(fragmentString);
        requestLine.setRequestUri(requestLineString);

        return requestLine;
    }
}
