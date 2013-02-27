package edu.cst.webserver.env;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Demur
 */
public class ServerConfig{

    private static ServerConfig CONFIG_INSTANCE;
    private Properties properties;
    private String SUPPORTED_METHODS;
    private String SUPPORTED_MIME_TYPES;
    private String SUPPORTED_HTTP_FILTERS;

    private ServerConfig(){
        properties = new Properties();
        loadConfigFile();
        initialize();
    }

    public static ServerConfig getInstance(){
        if(CONFIG_INSTANCE == null){
            CONFIG_INSTANCE = new ServerConfig();
        }
        return CONFIG_INSTANCE;
    }

    private void loadConfigFile() {
        try {
            properties.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            System.err.println("Failed to load server configuration file");
            e.printStackTrace();
        }
    }

    private void initialize() {
        this.SUPPORTED_METHODS = properties.getProperty("http.methods");
        this.SUPPORTED_MIME_TYPES = properties.getProperty("mime.types");
        this.SUPPORTED_HTTP_FILTERS = properties.getProperty("http.filters");
    }

    public boolean isSupportedMethod(String method){
        String[] methods = SUPPORTED_METHODS.split(",");
        for(String iterator : methods){
            if(iterator.equals(method))
                return true;
        }
        return false;
    }

    public boolean isSupportedMimeType(String mime){
        String[] mimes = SUPPORTED_MIME_TYPES.split(",");
        for(String iterator : mimes){
            if(iterator.equals(mime))
                return true;
        }
        return false;
    }

}
