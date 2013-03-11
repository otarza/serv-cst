package edu.cst.webserver.http;

import edu.cst.webserver.env.ServerConfig;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author revazi
 */
public class HttpRequestLineParser {

    public static HttpRequestLineParser newInstance() {
        return new HttpRequestLineParser();
    }
    private HttpRequestLineParser() {

    }

    public HttpRequestLine parse(String requestLineString) throws HttpRequestException {

        String tokens[];

        ServerConfig config = ServerConfig.getInstance();
        tokens = requestLineString.trim().split("\\s+");

        if (tokens.length != 3) {
            throw new HttpRequestException(HttpStatus.Code.BAD_REQUEST);
        }

        String methodName = tokens[0].toUpperCase();
        if(!config.isSupportedMethod(methodName)) {
            throw new HttpRequestException(HttpStatus.Code.METHOD_NOT_ALLOWED);
        }

        String httpVersion = tokens[2];
        if(!config.isSupportedHttpVersion(tokens[2])) {
            throw new HttpRequestException(HttpStatus.Code.HTPP_VERSION_NOT_SUPPORTED);
        }

        String requestUriString = tokens[1];
        if(requestUriString == null ||  requestUriString.isEmpty()) {
            throw new HttpRequestException(HttpStatus.Code.BAD_REQUEST);
        }

        try{

            URI requestUri = new URI(tokens[1]);

            HttpRequestLine requestLine = new HttpRequestLine();
            requestLine.setMethod(HttpMethod.getMethodByName(methodName));
            requestLine.setHttpVersion(httpVersion);
            requestLine.setRequestUri(tokens[1]);
            requestLine.setPath(requestUri.getPath());
            requestLine.setQueryString(requestUri.getQuery());
            requestLine.setFragment(requestUri.getFragment());

            return requestLine;

        } catch(URISyntaxException e) {

            throw new HttpRequestException(HttpStatus.Code.BAD_REQUEST);

        }
    }
}
