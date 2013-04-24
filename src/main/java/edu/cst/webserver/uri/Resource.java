package edu.cst.webserver.uri;

import edu.cst.webserver.env.ServerConfig;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Resource {
    private Resource() { }

    public File resolvePath(String resourcePath) {
        Path path = null;
        ServerConfig serverConfig = ServerConfig.getInstance();
        String docRoot = serverConfig.getDocumentRoot();

        if (resourcePath.equals("/")) {
            resourcePath = docRoot + resourcePath;
            for (String defaultFile : serverConfig.getDefaultFiles()){
                path = Paths.get(resourcePath + defaultFile);
                File file = path.toFile();
                if (file.exists()) {
                    return file;
                }
            }
        } else {
            resourcePath = docRoot + resourcePath;
            path = Paths.get(resourcePath);
        }
        return path == null ? null : path.toFile();
    }

    public static Resource newInstance() {
        return new Resource();
    }
}
