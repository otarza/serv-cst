package edu.cst.webserver.http;

import edu.cst.webserver.env.MimeTypeDetector;
import edu.cst.webserver.env.ServerConfig;
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
    }

    public HttpResponse dispatch() throws IOException {

        if (file.exists()) {
            ServerConfig config = ServerConfig.getInstance();
            if (file.isDirectory() && config.isDirListingAllowed()) {
                response.setStatus(HttpStatus.Code.OK);
                response.setHeader(HttpHeader.CONTENT_TYPE,HttpMime.TEXT_HTML.getMime());

                HttpRequestHandler<File> handler = new HttpRequestDirectoryHandler(file,request,response);


            } else if (file.isFile() && file.canRead()) {
                boolean isRegularExecutableFile = Files.isRegularFile(path) && Files.isReadable(path) && Files.isExecutable(path);
                if (isRegularExecutableFile) {


                    // aq server side javascript
//           return new HttpRequestJavaScriptHandler(file, request, response);
                    //java executable

//           return new HttpRequestJavaHandler(file, request, response);
                } else {

                    String mime = null;
                    try {
                        mime = MimeTypeDetector.detectMimeType(path.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (HttpRequestException e) {

                        e.printStackTrace();
                    }
                    response.setStatus(HttpStatus.Code.OK);
                    response.setHeader(HttpHeader.CONTENT_TYPE,mime);
                    HttpRequestHandler<File> handler = new HttpRequestFileHandler(file,request,response);
               }
            }
        } else {
            response.setStatus(HttpStatus.Code.NOT_FOUND);
        }



        return response;
    }


}
