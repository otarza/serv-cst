package edu.cst.webserver.http;

import edu.cst.webserver.env.ServerConfig;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author revazi
 */
public class HttpRequestLineParser{

    public static HttpRequestLineParser newInstance(){
        return new HttpRequestLineParser();
    }

    private HttpRequestLineParser(){
    }

    public HttpRequestLine parse(String requestLineString) throws HttpRequestException, URISyntaxException {
        String queryString = null;
        String fragmentString = null;
        String pathString = null;
        String parts[];
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
        URI requestUri = new URI(parts[1]);

        requestUri = requestUri.create(parts[1]);
        if(requestUri.getScheme() != null){
            pathString = requestUri.getScheme();
            if(requestUri.getPath() != null){
                pathString += requestUri.getPath();
            }
        }else{
            pathString = requestUri.getPath();
        };

        queryString = requestUri.getQuery();
        fragmentString = requestUri.getFragment();

        HttpRequestLine requestLine = new HttpRequestLine();
        requestLine.setMethod(HttpMethod.getMethodByName(methodName));
        requestLine.setHttpVersion(httpVersion);
        requestLine.setPath(pathString);
        requestLine.setRequestUri(requestLineString);
        requestLine.setQueryString(queryString);
        requestLine.setFragment(fragmentString);


        return requestLine;
    }
}
