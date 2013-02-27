package edu.cst.webserver.http;

import edu.cst.webserver.env.ServerConfig;

/**
 * @author Demur
 */
public class Test {
    public static void main(String[] args) {
        //Issue 2
        testIssue2();
        //Issue 4
        ServerConfig con = ServerConfig.getInstance();
        if(con.isSupportedMimeType("text/html")){
            System.out.println("True");
        }else System.out.println("False");

        if(con.isSupportedMethod("GET")){
            System.out.println("True");
        }else System.out.println("False");
    }

    private static void testIssue2() {
        System.out.println("Method: " + HttpMethod.GET);
        System.out.println("Method: " + HttpMethod.DELETE);
        System.out.println("Method: " + HttpMethod.CONNECT);
        System.out.println("Method: " + HttpMethod.HEAD);
        System.out.println("Method: " + HttpMethod.OPTIONS);
        System.out.println("Method: " + HttpMethod.POST);
        System.out.println("Method: " + HttpMethod.PUT);
        System.out.println("Method: " + HttpMethod.TRACE);
    }
}
