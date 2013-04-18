package edu.cst.webserver.http;

import edu.cst.webserver.http.handlers.HttpRequestDirectoryHandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Demur
 */
public class HttpRequestDispatcher implements HttpResponseErrorHandler{
    Path path;
    File file;
    HttpResponse response;
    HttpRequest request;
    public HttpRequestDispatcher(HttpRequest request){
        this.path = FileSystems.getDefault().getPath("C:/path/to/folder/resource/");
        this.file = new File(path.toString());
        this.request = request ;
        response = new HttpResponseWrapper();
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

    public HttpResponse dispatch() throws IOException {

        if (file.exists() && file.canRead()) {
            if (file.isDirectory()) {
                HttpRequestHandler<File> handler = new HttpRequestDirectoryHandler(file,request,response);
                try {
                    handler.process(file, request, response);
                } catch (HttpRequestException e) {
                    // do something here
                }
//          return      new HttpRequestDirectoryHandler(file, request, response);

                HttpDirFilesList v = new HttpDirFilesList(file);

                String list = v.getDirList();

                // vaxos klasi
            } else if (file.isFile()) {
                boolean isRegularExecutableFile = Files.isRegularFile(path) && Files.isReadable(path) && Files.isExecutable(path);
                if (file.canExecute()) {


                    // aq server side javascript
//           return new HttpRequestJavaScriptHandler(file, request, response);
                    //java executable

//           return new HttpRequestJavaHandler(file, request, response);
                } else {

 /*                   HttpRequestHandler<File> handler = new HttpRequestFileHandler<File>();
                    try {
                        handler.process(file, request, response);
                    } catch (HttpRequestException e) {
                        // do something here
                    }*/

//             return       new HttpRequestFileHandler(file, request, response);
//                    String mimeType = // demuris klasi romelic gveubneba mime tips
                }
            }
        }




    /*
        response.setErrorHandler(this);

        response.setHeader(HttpHeader.ACCEPT,"text/html");
        response.setHeader(HttpHeader.CONTENT_LENGTH,"343");
        response.write("test");



        response.setStatus(HttpStatus.Code.OK);*/

        return response;
    }


}
