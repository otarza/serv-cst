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

    public static String detectMimeType(String filePath) throws IOException, HttpRequestException {
        File file = new File(filePath);
        String mime = "";
        if(file.exists()){
            if(file.isFile()){
                URL url = new URL("file", "", file.getPath());
                URLConnection conn = url.openConnection();
                mime = conn.getContentType();
                if(mime.equals(HttpMime.CONTENT_UNKNOWN)){
                    mime = HttpMime.APPLICATION_OCTET_STREAM;
                }
            } else if( file.isDirectory()){
                throw new HttpRequestException(HttpStatus.Code.NOT_FOUND,"File not Found, Directory Located!");
            }
        } else {
            throw new HttpRequestException(HttpStatus.Code.NOT_FOUND,"File Not Found!");
    }
        return mime;
    }

}
