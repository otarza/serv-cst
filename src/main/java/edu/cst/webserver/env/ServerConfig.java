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
    private Set<String> methods;
    private Set<String> mimes;
    private Set<String> https;
    private Set<String> defaultFiles;
    private boolean allowListing;
    private String documentRoot;

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
        methods = commaSeparatedStringToSet(properties.getProperty("http.methods"));
        mimes = commaSeparatedStringToSet(properties.getProperty("mime.types"));
        https = commaSeparatedStringToSet(properties.getProperty("http.version"));
        defaultFiles = commaSeparatedStringToSet(properties.getProperty("directory.defaultFiles"));
        allowListing = Boolean.valueOf(properties.getProperty("directory.allowListing"));
        documentRoot = properties.getProperty("document.root");
    }

    private HashSet<String> commaSeparatedStringToSet(String input){
        String[] tokens = input.split("\\s*,\\s*");
        HashSet<String> result = new HashSet<String>();
        Collections.addAll(result,tokens);
        return result;
    }

    public boolean isSupportedMethod(String method){
        return methods.contains(method);
    }

    public boolean isSupportedMimeType(String mime){
        return mimes.contains(mime);
    }

    public boolean isDirListingAllowed(){
        return allowListing;
    }

    public boolean isWelcomeFile(String file){
        return defaultFiles.contains(file);
    }

    /**
     * @author Rezo
     * @param httpVersion
     */
    public boolean isSupportedHttpVersion(String httpVersion){
        return https.contains(httpVersion);
    }

    /**
     * @author vaxop
     */
    public String getDocumentRoot(){
        return this.documentRoot;
    }
}
