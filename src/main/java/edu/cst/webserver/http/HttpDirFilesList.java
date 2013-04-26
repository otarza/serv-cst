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
        File[] item = file.listFiles();
        String absolutePath = file.getAbsolutePath();
        StringBuilder builder = new StringBuilder();
        File f1 = Resource.newInstance().resolvePath(file.getPath());
        String pp = f1.getPath();
        builder.append("<ul>");
        for (File f : item) {
            builder.append("<li><a href=\"");
            builder.append(f1.getPath());
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