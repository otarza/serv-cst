package edu.cst.webserver.env;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Demur
 */
public class MimeTypeDetector {

    public static String detectedMimeType;

    private  MimeTypeDetector(String type){
               this.detectedMimeType = type;
    }
    public static MimeTypeDetector detectMimeType(String filePath) throws IOException {
        File file = new File(filePath);
        String mime = "";
        if(file.exists()){
            if(file.isFile()){
                URL url = new URL("file", "", file.getPath());
                URLConnection conn = url.openConnection();
                mime = conn.getContentType();



                if(mime.equals("unknown")){
                    //TODO return application/octet-stream  [DN]
                }
                // response.setHeader("Content-Type", [დადგენილი MIME ტიპი]
                // response.setHeader("Content-Length", file.length());
                // response.write(urlConnection.getInputStream());
            } else if( file.isDirectory()){
                // წავკითხოთ ყველა ფაილის სახელი დირექტორიაში, დავაგენერიროთ HTML
                // და დავაბრუნოთ response ობიექტის მეშვეობით
            }
        } else {
        // ფაილი ვერ მოიძებნა
        // დავადგინოთ გვაქვს თუ არა ამ path - ისთვის რეგისტრირებული სკრიპტი
        // თუ გვაქვს მაშინ შევასრულოთ სკრიპტი და რეზულტატი დავაბრუნოთ როგორც text/html
        // თუ არ გვაქვს არც სკრიპტი მაშინ:
        // response.error(HttpStatus.Code.NOT_FOUND);
    }
        return new MimeTypeDetector(mime);
    }


    public static String getDetectedMimeType() {
        return detectedMimeType;
    }
}
