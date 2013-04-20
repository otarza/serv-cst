package edu.cst.webserver.http;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Demur
 * @param <T>
 */
public interface HttpRequestHandler<T> {
    /**
     * @return resource InputStream
     * @throws IOException
     */
    public InputStream getInputStream() throws IOException;

    /**
     * @return MIME type
     */
    public String getContentType() throws IOException, HttpRequestException;

    /**
     * @return length of the file content or string
     */
    public int getContentLength() throws IOException;

    /**
     * @return formatted date format as defined by RFC 1123:
     * "EEE, dd MMM yyyy HH:mm:ss 'GMT'"
     */
    public String getLastModified();

    /**
     * Handler Implementation
     *
     * @param handle
     * @param request
     * @param response
     */
    public void process(T handle, HttpRequest request, HttpResponse response)
            throws HttpRequestException, IOException;
}