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
    private String supportedMethods;
    private String supportedMimeTypes;
    private String supportedHttpVersion;
    private Set<String> methods;
    private Set<String> mimes;
    private Set<String> https;

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
        this.supportedMethods = properties.getProperty("http.methods");
        this.supportedMimeTypes = properties.getProperty("mime.types");
        this.supportedHttpVersion = properties.getProperty("http.version");

        String[] methodTokens = supportedMethods.split("\\s*,\\s*");
        methods = new HashSet<String>();
        Collections.addAll(methods, methodTokens);

        String[] mimeTokens = supportedMimeTypes.split("\\s*,\\s*");
        mimes = new HashSet<String>();
        Collections.addAll(mimes, mimeTokens);

        String[] httpTokens = supportedHttpVersion.split("\\s*,\\s*");
        https = new HashSet<String>();
        Collections.addAll(https, httpTokens);
    }

    public boolean isSupportedMethod(String method){
        return methods.contains(method);
    }

    public boolean isSupportedMimeType(String mime){
        return mimes.contains(mime);
    }

    /**
     * @author Rezo
     * @param httpVersion
     */
    public boolean isSupportedHttpVersion(String httpVersion){
        return https.contains(httpVersion);
    }
}
