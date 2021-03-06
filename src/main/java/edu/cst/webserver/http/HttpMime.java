package edu.cst.webserver.http;

/**
 * @author Demur
 */
public enum HttpMime {

    TEXT_HTML("text/html"),
    IMAGE_PNG("image/png"),
    IMAGE_JPEG("image/jpeg"),
    IMAGE_GIF("image/gif"),
    TEXT_PLAIN("text/plain"),
    TEXT_JAVASCRIPT("text/javascript"),
    TEXT_CSS("text/css"),
    APPLICATION_XML("application/xml"),
    CONTENT_UNKNOWN("content/unknown"),
    APPLICATION_OCTET_STREAM("application/octet-stream");


    private String mime;

    private HttpMime(String name) {
        this.mime = name;
    }

    public String getMime() {
        return mime;
    }
}