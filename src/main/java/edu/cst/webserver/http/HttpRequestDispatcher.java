package edu.cst.webserver.http;

import edu.cst.webserver.env.MimeTypeDetector;
import edu.cst.webserver.env.ServerConfig;
import edu.cst.webserver.http.handlers.HttpRequestDirectoryHandler;
import edu.cst.webserver.http.handlers.HttpRequestFileHandler;
import edu.cst.webserver.uri.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Demur
 */
public class HttpRequestDispatcher implements HttpResponseErrorHandler{
    HttpResponse response;
    HttpRequest request;

    public HttpRequestDispatcher(HttpRequest request, HttpResponse response){
        this.request = request;
        this.response = response;
    }

    @Override
    public void handle(HttpResponse response) throws HttpRequestException {
        throw new HttpRequestException(response.getStatusCode(),"Message");
    }

    public void dispatch() throws IOException {
        File file = Resource.newInstance().resolvePath(request.getPath());
        if (file.exists() && file.canRead()) {
            if (file.isFile()) {
                HttpRequestFileHandler fileHandler = new HttpRequestFileHandler(file);
                try {
                    fileHandler.process(file, request, response);
                } catch (HttpRequestException e) {
                    e.printStackTrace();
                }
            } else if (file.isDirectory()) {
                HttpRequestDirectoryHandler directoryHandler = new HttpRequestDirectoryHandler(file);
                try {
                    directoryHandler.process(file, request, response);
                } catch (HttpRequestException e) {
                    e.printStackTrace();
                }
            }
            response.write(new FileInputStream(file));
            System.out.println();
        } else {
            response.setStatus(HttpStatus.Code.NOT_FOUND);
        }

    }



}
