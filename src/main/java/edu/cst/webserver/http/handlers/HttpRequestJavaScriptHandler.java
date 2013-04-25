package edu.cst.webserver.http.handlers;

import edu.cst.webserver.http.HttpRequest;
import edu.cst.webserver.http.HttpRequestException;
import edu.cst.webserver.http.HttpRequestHandler;
import edu.cst.webserver.http.HttpResponse;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author OtarZ
 */
public class HttpRequestJavaScriptHandler implements HttpRequestHandler<File> {

    @Override
    public InputStream getInputStream() throws IOException {
        return null;
    }

    @Override
    public String getContentType() throws IOException, HttpRequestException {
        return null;
    }

    @Override
    public int getContentLength() throws IOException {
        return 0;
    }

    @Override
    public String getLastModified() {
        return null;
    }

    @Override
    public void process(File handle, HttpRequest request, HttpResponse response) throws HttpRequestException, IOException {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        try {
			engine.put("request", request);
			engine.put("response", response);
            engine.eval(new FileReader(handle));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
