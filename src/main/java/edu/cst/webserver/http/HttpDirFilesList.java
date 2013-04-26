package edu.cst.webserver.http;

import edu.cst.webserver.uri.Resource;

import java.io.File;

/**
 * User: vaxop
 */
public class HttpDirFilesList {
    File file;

    public HttpDirFilesList(File file) {
        this.file = file;
    }

    public String getDirList() {
        File[] fileItems = file.listFiles();
        String basePath = file.getName();
        StringBuilder builder = new StringBuilder();
        builder.append("<ul>");
        for (File file : fileItems) {
            builder.append("<li><a href=\"");
            builder.append(basePath);
            builder.append("\\");
            builder.append(file.getName());
            builder.append("\" >");
            if (file.isDirectory()) {
                builder.append("/");
            }
            builder.append(file.getName());
            builder.append("</a></li>");
        }
        builder.append("</ul>");

        return builder.toString();
    }
}