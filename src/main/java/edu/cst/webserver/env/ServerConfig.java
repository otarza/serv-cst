package edu.cst.webserver.env;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * @author Demur
 */
public class ServerConfig{

    private static final ServerConfig CONFIG_INSTANCE;
    private Properties properties;
    private String SupportedMethods;
    private String SupportedMimeTypes;
    private String SupportedHttpFilters;
    private String[] methodTokens;
    private String[] mimeTokens;
    private Set<String> methods;
    private Set<String> mimes;

    private ServerConfig(){
        properties = new Properties();
        loadConfigFile();
    }

    static {
        CONFIG_INSTANCE = new ServerConfig();
        CONFIG_INSTANCE.init();
    }

    public static ServerConfig getInstance(){
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

    private void init() {
        this.SupportedMethods = properties.getProperty("http.methods");
        this.SupportedMimeTypes = properties.getProperty("mime.types");
        this.SupportedHttpFilters = properties.getProperty("http.filters");
    }

    public boolean isSupportedMethod(String method){
        methodTokens = SupportedMethods.split(",");
        methods = new HashSet<String>();
        Collections.addAll(methods, methodTokens);
        return methods.contains(method);
    }

    public boolean isSupportedMimeType(String mime){
        mimeTokens = SupportedMimeTypes.split(",");
        mimes = new HashSet<String>();
        Collections.addAll(mimes, mimeTokens);
        return mimes.contains(mime);
    }

}
