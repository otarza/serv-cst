package edu.cst.webserver.http;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Demur
 */
public class HttpMethod {

    public static final Type TYPE_GET = Type.GET;
    public static final Type TYPE_HEAD = Type.HEAD;
    public static final Type TYPE_POST = Type.POST;
    public static final Type TYPE_PUT = Type.PUT;
    public static final Type TYPE_DELETE = Type.DELETE;
    public static final Type TYPE_CONNECT = Type.CONNECT;
    public static final Type TYPE_OPTIONS = Type.OPTIONS;
    public static final Type TYPE_TRACE = Type.TRACE;

    public static final String METHOD_GET = "GET";
    public static final String METHOD_HEAD = "HEAD";
    public static final String METHOD_POST = "POST";
    public static final String METHOD_PUT = "PUT";
    public static final String METHOD_DELETE = "DELETE";
    public static final String METHOD_CONNECT = "CONNECT";
    public static final String METHOD_OPTIONS = "OPTIONS";
    public static final String METHOD_TRACE = "TRACE";

    private static final Map<String, Type> methods;

    static {
        methods = new HashMap<String, Type>();
        methods.put(METHOD_GET, TYPE_GET);
        methods.put(METHOD_HEAD, TYPE_HEAD);
        methods.put(METHOD_POST, TYPE_POST);
        methods.put(METHOD_PUT, TYPE_PUT);
        methods.put(METHOD_DELETE, TYPE_DELETE);
        methods.put(METHOD_CONNECT, TYPE_CONNECT);
        methods.put(METHOD_OPTIONS, TYPE_OPTIONS);
        methods.put(METHOD_TRACE, TYPE_TRACE);
    }

    public static Type getMethodByName(String methodName) {
        return methods.get(methodName);
    }

    public static enum Type {
        GET(METHOD_GET, false, true),
        HEAD(METHOD_HEAD, false, false),
        POST(METHOD_POST, true, false),
        PUT(METHOD_PUT, true, false),
        DELETE(METHOD_DELETE, false, false),
        CONNECT(METHOD_CONNECT, false, false),
        OPTIONS(METHOD_OPTIONS, true, false),
        TRACE(METHOD_TRACE, false, true);

        private String methodName;
        private boolean requestBodyAllowed;
        private boolean responseBodyAllowed;

        private Type(String methodName, boolean requestBodyAllowed, boolean responseBodyAllowed) {
            this.methodName = methodName;
            this.requestBodyAllowed = requestBodyAllowed;
            this.responseBodyAllowed = responseBodyAllowed;
        }

        public String getMethodName() {
            return methodName;
        }

        public void setMethodName(String methodName) {
            this.methodName = methodName;
        }

        public boolean isRequestBodyAllowed() {
            return requestBodyAllowed;
        }

        public void setRequestBodyAllowed(boolean requestBodyAllowed) {
            this.requestBodyAllowed = requestBodyAllowed;
        }

        public boolean isResponseBodyAllowed() {
            return responseBodyAllowed;
        }

        public void setResponseBodyAllowed(boolean responseBodyAllowed) {
            this.responseBodyAllowed = responseBodyAllowed;
        }
    }

}
