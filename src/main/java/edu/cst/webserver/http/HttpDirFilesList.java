package edu.cst.webserver.http;

import edu.cst.webserver.env.MimeTypeDetector;
import edu.cst.webserver.env.ServerConfig;
import edu.cst.webserver.uri.Resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;

/**
 * User: vaxop
 */
public class HttpDirFilesList {


    private File file;
    private BasicFileAttributes attributes;
    ServerConfig serverConfig;


    public HttpDirFilesList(File file) throws IOException {
        this.serverConfig = ServerConfig.getInstance();
        this.file = file;
        this.attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
    }

    public String getDirList() throws IOException {
        File[] fileItems = file.listFiles();

        Comparator comp = new Comparator() {
            public int compare(Object o1, Object o2) {
                File f1 = (File) o1;
                File f2 = (File) o2;
                if (f1.isDirectory() && !f2.isDirectory()) {
                    // Directory before non-directory
                    return -1;
                } else if (!f1.isDirectory() && f2.isDirectory()) {
                    // Non-directory after directory
                    return 1;
                } else {
                    // Alphabetic order otherwise
                    return ((File) o1).compareTo((File) o2);
                }
            }
        };
        Arrays.sort(fileItems, comp);


        StringBuilder builder = new StringBuilder();

        builder.append("<html>");
        builder.append("<head>");
        builder.append("<style TYPE=\"text/css\">");
        builder.append("<!-- *{margin: 5px; padding: 5px;}");
        builder.append("header,section,left_side, middle_side,right_side{ display: block;}");
        builder.append("body{text-align: left;}");
        builder.append("h1{font: 25 px bold;}");
        builder.append("#head{border-bottom: 1px solid grey; height: 40px;}");
        builder.append("#titles{font :20 px bold;}");
        builder.append("#link{font :15 px bold;}");
        builder.append(".folder-row{background: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAgY0hSTQAAeiYAAICEAAD6AAAAgOgAAHUwAADqYAAAOpgAABdwnLpRPAAAAAlwSFlzAAAK7wAACu8BfXaKSAAAABx0RVh0U29mdHdhcmUAQWRvYmUgRmlyZXdvcmtzIENTNAay06AAAAD8SURBVEhLY2AYBaMhQLUQ8PLyMvDw8PgOxP/x4O/e3t7GZFkKNHQtAcNhFh8EqqvHhd3c3AKwOgCoYT+RFuDz4X93d/cFeC0AKvjr6ekZDqQdyMVA/daurq5iKBYh+eAF0OB9FPrmM9CMDKwWACUuAfFTCi34BNSfhs2CX0CJM0ALXlFowV2gfhsMC4AGPwfiw0D8kxILgPov+vr6qmCz4AFQEpQM8aYUIuQPhYaGsmELor1AzfeJMICQA7owkiooFQFdPw9I/6aCBagRDLINaPg6oMErqWD4fx8fH0tsPsgEWvKOChZ8w5qTQYUd0IIGKuA8sgrDUU00CwEAO6DLsJ7UqLkAAAAASUVORK5CYII=) no-repeat; padding-left: 18px; }");
        builder.append(".folder-up{background: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAABGdBTUEAALGPC/xhBQAAAAlwSFlzAAAK7gAACu4BrzForAAAABx0RVh0U29mdHdhcmUAQWRvYmUgRmlyZXdvcmtzIENTNAay06AAAAEcSURBVEhL5VTbDcIwDAwbMEJHgAkoP339dATYgE4AbMIosAEjMAITkHIOSWWFBoJbfqDSKVWa3Nlnu0r9xVMUxTzP8/VXkiVyoCVkWdaMKlJV1RLEFydg19UoIjZyn7yFVVd8GybCbfGiN1YNtWuCKE8g0RYdKdvTOKPFVsH7GQhSAkjPNmpdluWG7S/EAuyiy4ayoIw+J0VECbAPgXURCRxene35lihrg4vQ+c7X3hrwegTeqeNSIwDcQulj/+hqEGuRDZoa4a2AqAZSAUqZOooy4ngaOrFAYOh2frtKBPqKb/bwA9wOEVB86NyQeWsSJYBL3ZQGiMxkxwCZNZRd10WsDYNWRPS9f/cxB3VdT2Oikpwh7jH+Vz/OcQdW6nVK0oTOCAAAAABJRU5ErkJggg==) no-repeat; padding-left: 18px; }");
        builder.append(".file-row{background: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAgY0hSTQAAeiYAAICEAAD6AAAAgOgAAHUwAADqYAAAOpgAABdwnLpRPAAAAAlwSFlzAAALEQAACxEBf2RfkQAAABx0RVh0U29mdHdhcmUAQWRvYmUgRmlyZXdvcmtzIENTNAay06AAAACZSURBVEhLY2QAAg8Pj3og1QBiUwkc2LFjhyPcLJAFQPzf3d29gVIMNOc+EO9HcSjMAmq4HmT4qAV4Q5KoIHJ1dTUARrYDKRhmK1EWAA1OIDU1kWQBJamJKB94enr2wxQSSw8uHwDDf4j7ABju8dDiA1RGEYVJigMvLy/a5oPRjDZaXFNeXNOssCM2UxFQh7vSB7UsqIThrQoALPNrK6a7C7AAAAAASUVORK5CYII=) no-repeat; padding-left: 18px; }-->");
        builder.append("</style>");
        builder.append("</head>");
        builder.append("<body>");
        builder.append("<header id=\"head\">");
        builder.append("<h1>Index of " + file.getPath() + "</h1>");
        builder.append("</header>");

        builder.append("<table width=\"500\">");
        builder.append("<tr id=\"titles\">");
        builder.append("<td>Name</td>");
        builder.append("<td>Size</td>");
        builder.append("<td>Date Modified</td>");
        builder.append("</tr>");
        builder.append("<tr>");
        builder.append("<td class='folder-up'>");
        builder.append("<a href=\""+ file.getPath().substring(this.serverConfig.getDocumentRoot().length(), (file.getPath().length() - file.getName().length())) + "\">[parentDirectory]</a>");
        builder.append("</td>");
        builder.append("</tr>");
        for (File file : fileItems) {
            builder.append("<tr id=\"link\">");
            if(file.isDirectory()){
                builder.append("<td  class='folder-row'>");
                builder.append("<a href=\"");

                String src = file.getPath();
                builder.append(src.substring(ServerConfig.getInstance().getDocumentRoot().length()));
                if (file.isDirectory()) {
                    builder.append("/");
                }
                builder.append("\">");
                builder.append("/");
            } else {
                builder.append("<td  class='file-row'>");
                builder.append("<a href=\"");

                String src = file.getPath();
                builder.append(src.substring(9));
                builder.append("\">");
                builder.append("/");
            }
            builder.append(file.getName());
            builder.append("</a></td>");
            builder.append("<td>" + getSize() + " KB </td>");
            builder.append("<td>" + attributes.lastModifiedTime() + "</td>");
            builder.append("</tr>");
        }

        builder.append("</table>");
        builder.append("</section>");
        builder.append("</body>");
        builder.append("</html>");

        return builder.toString();
    }

    public double getSize() throws IOException {
        DecimalFormat doubleFormat = new DecimalFormat("#.##");
        return Double.valueOf(doubleFormat.format(MimeTypeDetector.getContentLength(file) / Double.valueOf("1024")));
      //  double size = MimeTypeDetector.getContentLength(this.file);
      //  return size;
    }
}