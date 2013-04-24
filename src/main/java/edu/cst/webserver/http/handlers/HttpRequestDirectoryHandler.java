package edu.cst.webserver.http.handlers;

import edu.cst.webserver.env.MimeTypeDetector;
import edu.cst.webserver.http.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;

/**
 * @author Demur
 */
public class HttpRequestDirectoryHandler implements HttpRequestHandler{

    HttpRequest request;
    HttpResponse response;
    File file;
    BasicFileAttributes attributes;
    public HttpRequestDirectoryHandler(File file, HttpRequest request,HttpResponse response) throws IOException {
        this.request = request;
        this.response = response;
        this.file = file;
        attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(file.getPath());
    }

    @Override
    public String getContentType() throws IOException, HttpRequestException {
      return MimeTypeDetector.getMimeType(file);
    }

    @Override
    public int getContentLength() throws IOException {
        return MimeTypeDetector.getContentLength(file);
    }

    @Override
    public String getLastModified() {
        FileTime fileModifyTime = attributes.lastModifiedTime();
        return new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(fileModifyTime);
    }

    @Override
    public void process(Object handle, HttpRequest request, HttpResponse response) throws HttpRequestException, IOException {
        HttpDirFilesList v = new HttpDirFilesList(file);
        String list = v.getDirList();
        response.write(list);
    }
}
