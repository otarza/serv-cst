package edu.cst.webserver.http;

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
        File[] item = file.listFiles();
        String absolutePath = file.getAbsolutePath();
        StringBuilder builder = new StringBuilder();
        builder.append("<ul>");
        for (File f : item) {
            builder.append("<li><a href=\"");
            builder.append(absolutePath);
            builder.append("\\");
            builder.append(f.getName());
            builder.append("\" >");
            if (f.isDirectory()) {
                builder.append("/");
            }
            builder.append(f.getName());
            builder.append("</a></li>");
        }
        builder.append("</ul>");

        return builder.toString();
    }
}