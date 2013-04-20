package edu.cst.webserver.http;

import edu.cst.webserver.http.handlers.HttpRequestDirectoryHandler;
import edu.cst.webserver.http.handlers.HttpRequestFileHandler;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Demur
 */
public class HttpRequestDispatcher implements HttpResponseErrorHandler{
    Path path;
    File file;
    HttpResponse response;
    HttpRequest request;
    public HttpRequestDispatcher(HttpRequest request){


        this.path = Paths.get(request.getPath());//FileSystems.getDefault().getPath("C:/path/to/folder/resource/");
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
               // handler.process();

            } else if (file.isFile()) {
                boolean isRegularExecutableFile = Files.isRegularFile(path) && Files.isReadable(path) && Files.isExecutable(path);
                if (isRegularExecutableFile) {


                    // aq server side javascript
//           return new HttpRequestJavaScriptHandler(file, request, response);
                    //java executable

//           return new HttpRequestJavaHandler(file, request, response);
                } else {

                   HttpRequestHandler<File> handler = new HttpRequestFileHandler(file,request,response);

                    try {
                        handler.getContentType();
                    } catch (HttpRequestException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }


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
