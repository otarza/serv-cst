package edu.cst.webserver.env;

import edu.cst.webserver.http.HttpHeader;
import edu.cst.webserver.http.HttpMime;
import edu.cst.webserver.http.HttpRequestException;
import edu.cst.webserver.http.HttpStatus;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Demur
 */
public class MimeTypeDetector {
    public static int getContentLength(File file) throws IOException {
        URL url = new URL("file", "", file.getPath());
        URLConnection conn = url.openConnection();
        return conn.getContentLength();
    }

    public static String getMimeType(File file) throws IOException {
        URL url = new URL("file", "", file.getPath());
        URLConnection conn = url.openConnection();
        String mimeType = conn.getContentType();
        String fileName = file.getCanonicalPath();

        if(mimeType.equals(HttpMime.CONTENT_UNKNOWN.getMime())) {
            if(fileName.endsWith(".js")) {
                mimeType = HttpMime.TEXT_JAVASCRIPT.getMime();
            }else if(fileName.endsWith(".css")) {
                mimeType = HttpMime.TEXT_CSS.getMime();
            }else if(fileName.endsWith(".ssjs")) {
                mimeType = ".ssjs";
            } else {
                mimeType = HttpMime.APPLICATION_OCTET_STREAM.getMime();
            }
        }
        return mimeType;
    }
}
