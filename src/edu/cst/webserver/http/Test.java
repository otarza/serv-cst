package edu.cst.webserver.http;

/**
 * @author Demur
 */
public class Test {
    public static void main(String[] args) {
        //Issue 2
        testIssue2();
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
