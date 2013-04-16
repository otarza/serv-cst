package edu.cst.webserver.http;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Demur
 *         Date: 4/16/13
 *         Time: 6:47 PM
 *         To change this template use File | Settings | File Templates.
 */
import com.google.inject.internal.util.$ImmutableList;

import java.io.File;

/**
 * User: vaxop
 */
public class HttpDirFilesList {

    File f;
    StringBuilder builder = null;
    public HttpDirFilesList(File f){
          this.f = f;
    }

    public String getDirFileList(){

        if (f.isDirectory()) {
            File[] item = f.listFiles();
            String absolutePath = f.getAbsolutePath();
            builder = new StringBuilder();
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

        } else {
            System.out.println("file");
            System.out.println(f.getAbsolutePath());
        }
         return null;
    }


}