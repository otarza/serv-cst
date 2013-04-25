package edu.cst.webserver.http.handlers;

import edu.cst.webserver.http.HttpRequest;
import edu.cst.webserver.http.HttpRequestException;
import edu.cst.webserver.http.HttpRequestHandler;
import edu.cst.webserver.http.HttpResponse;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author OtarZ
 */
public class HttpRequestJavaScriptHandler implements HttpRequestHandler {

    @Override
    public InputStream getInputStream() throws IOException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getContentType() throws IOException, HttpRequestException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getContentLength() throws IOException {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getLastModified() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void process(Object handle, HttpRequest request, HttpResponse response) throws HttpRequestException, IOException {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        try {
            double output = (Double) engine.eval("var date = new Date(); date.getHours();");
            System.out.println(output);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
