package edu.cst.webserver.http;

import java.io.File;
import java.io.IOException;

/**
 * @author Demur
 */
public class HttpRequestDispatcher implements HttpResponseErrorHandler{
    String path;
    File file;

    public void HttpRequestDispatcher(){
        this.path = "C:/path/to/folder/resource/1";
        this.file = new File(path);

        if (file.exists() && file.canRead()) {
            if (file.isDirectory()) {
                HttpDirFilesList v = new HttpDirFilesList(file);

                String list = v.getDirFileList();

                // vaxos klasi
            } else if (file.isFile()) {
                if (file.canExecute()) {
                    // aq server side javascript
                } else {
//                    String mimeType = // demuris klasi romelic gveubneba mime tips
                }
            }
        }
    }

    @Override
    public void handle(HttpResponse response) throws HttpRequestException {

        throw new HttpRequestException(response.getStatusCode(),"Message");
        //Generate Http response
       /* HTTP/1.1 400 Bad Request
        Content-Type: text/plain
        Content-Length: ...

        Something wrong happened!*/
    }

    public HttpResponseWrapper dispatch() throws IOException {
        HttpResponseWrapper response = new HttpResponseWrapper();
        response.setErrorHandler(this);

        response.setHeader(HttpHeader.ACCEPT,"text/html");
        response.setHeader(HttpHeader.CONTENT_LENGTH,"343");
        response.write("test");



        response.setStatus(HttpStatus.Code.OK);

        return response;
    }


}
