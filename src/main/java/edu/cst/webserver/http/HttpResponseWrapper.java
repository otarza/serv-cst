package edu.cst.webserver.http;

import java.io.IOException;

/**
 * @author Demur
 */
public class HttpResponseWrapper implements HttpResponse {

    @Override
    public void setHeader(String name, String value) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setStatus(HttpStatus.Code status) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void redirect(String location) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void redirect(String location, HttpStatus.Code redirectStatus) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void error(HttpStatus.Code errorStatus) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void error(HttpStatus.Code errorStatus, String body) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void write(String content) throws IOException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void flush() throws IOException {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
