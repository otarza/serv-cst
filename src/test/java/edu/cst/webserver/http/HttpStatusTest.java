package edu.cst.webserver.http;
//User:vaxop

import junit.framework.Assert;
import org.junit.Test;

public class HttpStatusTest {
    @Test
    public void testStatus100_CONTINUE() {
        HttpStatus.Code code = HttpStatus.Code.CONTINUE;

        Assert.assertEquals(100, code.getCode());
        Assert.assertEquals("Continue", code.getMessage());
    }

    @Test
    public void testStatus101_SWITCHING_PROTOCOLS() {
        HttpStatus.Code code = HttpStatus.Code.SWITCHING_PROTOCOLS;

        Assert.assertEquals(101, code.getCode());
        Assert.assertEquals("Switching Protocols", code.getMessage());
    }

    @Test
    public void testStatus102_PROCESSING() {
        HttpStatus.Code code = HttpStatus.Code.PROCESSING;

        Assert.assertEquals(102, code.getCode());
        Assert.assertEquals("Processing", code.getMessage());
    }

    @Test
    public void testStatus200_OK() {
        HttpStatus.Code code = HttpStatus.Code.OK;

        Assert.assertEquals(200, code.getCode());
        Assert.assertEquals("OK", code.getMessage());
    }

    @Test
    public void testStatus201_CREATED() {
        HttpStatus.Code code = HttpStatus.Code.CREATED;

        Assert.assertEquals(201, code.getCode());
        Assert.assertEquals("Created", code.getMessage());
    }

    @Test
    public void testStatus202_ACCEPTED() {
        HttpStatus.Code code = HttpStatus.Code.ACCEPTED;

        Assert.assertEquals(202, code.getCode());
        Assert.assertEquals("Accepted", code.getMessage());
    }

    @Test
    public void testStatus203_NON_AUTHORITATIVE_INFORMATION() {
        HttpStatus.Code code = HttpStatus.Code.NON_AUTHORITATIVE_INFORMATION;

        Assert.assertEquals(203, code.getCode());
        Assert.assertEquals("Non-Authoritative Information", code.getMessage());
    }

    @Test
    public void testStatus204_NO_CONTENT() {
        HttpStatus.Code code = HttpStatus.Code.NO_CONTENT;

        Assert.assertEquals(204, code.getCode());
        Assert.assertEquals("No Content", code.getMessage());
    }

    @Test
    public void testStatus206_PATRIAL_CONTENT() {
        HttpStatus.Code code = HttpStatus.Code.PARTIAL_CONTENT;

        Assert.assertEquals(206, code.getCode());
        Assert.assertEquals("Partial Content", code.getMessage());
    }

    @Test
    public void testStatus207_MULTI_STATUS() {
        HttpStatus.Code code = HttpStatus.Code.MULTI_STATUS;

        Assert.assertEquals(207, code.getCode());
        Assert.assertEquals("Multi-Status", code.getMessage());
    }

    @Test
    public void testStatus208_ALREADY_REPORTED() {
        HttpStatus.Code code = HttpStatus.Code.ALREADY_REPORTED;

        Assert.assertEquals(208, code.getCode());
        Assert.assertEquals("Already Reported", code.getMessage());
    }

    @Test
    public void testStatus226_IM_USED() {
        HttpStatus.Code code = HttpStatus.Code.IM_USED;

        Assert.assertEquals(226, code.getCode());
        Assert.assertEquals("IM Used", code.getMessage());
    }

    @Test
    public void testStatus300_MULTIPLE_CHOICES() {
        HttpStatus.Code code = HttpStatus.Code.MULTIPLE_CHOICES;

        Assert.assertEquals(300, code.getCode());
        Assert.assertEquals("Multiple Choices", code.getMessage());
    }

    @Test
    public void testStatus301_MOVED_PERMANENTLY() {
        HttpStatus.Code code = HttpStatus.Code.MOVED_PERMANENTLY;

        Assert.assertEquals(301, code.getCode());
        Assert.assertEquals("Moved Permanently", code.getMessage());
    }

    @Test
    public void testStatus302_FOUND() {
        HttpStatus.Code code = HttpStatus.Code.FOUND;

        Assert.assertEquals(302, code.getCode());
        Assert.assertEquals("Found", code.getMessage());
    }

    @Test
    public void testStatus303_SEE_OTHER() {
        HttpStatus.Code code = HttpStatus.Code.SEE_OTHER;

        Assert.assertEquals(303, code.getCode());
        Assert.assertEquals("See Other", code.getMessage());
    }

    @Test
    public void testStatus304_NOT_MODIFIED() {
        HttpStatus.Code code = HttpStatus.Code.NOT_MODIFIED;

        Assert.assertEquals(304, code.getCode());
        Assert.assertEquals("Not Modified", code.getMessage());
    }

    @Test
    public void testStatus305_USE_PROXY() {
        HttpStatus.Code code = HttpStatus.Code.USE_PROXY;

        Assert.assertEquals(305, code.getCode());
        Assert.assertEquals("Use Proxy", code.getMessage());
    }

    @Test
    public void testStatus306_RESERVED() {
        HttpStatus.Code code = HttpStatus.Code.RESERVED;

        Assert.assertEquals(306, code.getCode());
        Assert.assertEquals("Reserved", code.getMessage());
    }

    @Test
    public void testStatus307_TEMPORARY_REDIRECT() {
        HttpStatus.Code code = HttpStatus.Code.TEMPORARY_REDIRECT;

        Assert.assertEquals(307, code.getCode());
        Assert.assertEquals("Temporary Redirect", code.getMessage());
    }

    @Test
    public void testStatus308_PERMANENTLY_REDIRECT() {
        HttpStatus.Code code = HttpStatus.Code.PERMANENTLY_REDIRECT;

        Assert.assertEquals(308, code.getCode());
        Assert.assertEquals("Permanently Redirect", code.getMessage());
    }

    @Test
    public void testStatus400_BAD_REQUEST() {
        HttpStatus.Code code = HttpStatus.Code.BAD_REQUEST;

        Assert.assertEquals(400, code.getCode());
        Assert.assertEquals("Bad Request", code.getMessage());
    }

    @Test
    public void testStatus401_UNAUTHORIZED() {
        HttpStatus.Code code = HttpStatus.Code.UNAUTHORIZED;

        Assert.assertEquals(401, code.getCode());
        Assert.assertEquals("Unauthorized", code.getMessage());
    }

    @Test
    public void testStatus402_PAYMENT_REQUIRED() {
        HttpStatus.Code code = HttpStatus.Code.PAYMENT_REQUIRED;

        Assert.assertEquals(402, code.getCode());
        Assert.assertEquals("Payment Required", code.getMessage());
    }

    @Test
    public void testStatus403_FORBIDDEN() {
        HttpStatus.Code code = HttpStatus.Code.FORBIDDEN;

        Assert.assertEquals(403, code.getCode());
        Assert.assertEquals("Forbidden", code.getMessage());
    }

    @Test
    public void testStatus404_NOT_FOUND() {
        HttpStatus.Code code = HttpStatus.Code.NOT_FOUND;

        Assert.assertEquals(404, code.getCode());
        Assert.assertEquals("Not Found", code.getMessage());
    }

    @Test
    public void testStatus405_METHOD_NOT_ALLOWED() {
        HttpStatus.Code code = HttpStatus.Code.METHOD_NOT_ALLOWED;

        Assert.assertEquals(405, code.getCode());
        Assert.assertEquals("Method Not Allowed", code.getMessage());
    }

    @Test
    public void testStatus406_NOT_ACCEPTABLE() {
        HttpStatus.Code code = HttpStatus.Code.NOT_ACCEPTABLE;

        Assert.assertEquals(406, code.getCode());
        Assert.assertEquals("Not Acceptable", code.getMessage());
    }

    @Test
    public void testStatus407_PROXY_AUTHENTICATION_REQUIRED() {
        HttpStatus.Code code = HttpStatus.Code.PROXY_AUTHENTICATION_REQUIRED;

        Assert.assertEquals(407, code.getCode());
        Assert.assertEquals("Proxy Authentication Required", code.getMessage());
    }

    @Test
    public void testStatus408_REQUEST_TIMEOUT() {
        HttpStatus.Code code = HttpStatus.Code.REQUEST_TIMEOUT;

        Assert.assertEquals(408, code.getCode());
        Assert.assertEquals("Request Timeout", code.getMessage());
    }

    @Test
    public void testStatus409_CONFLICT() {
        HttpStatus.Code code = HttpStatus.Code.CONFLICT;

        Assert.assertEquals(409, code.getCode());
        Assert.assertEquals("Conflict", code.getMessage());
    }

    @Test
    public void testStatus410_GONE() {
        HttpStatus.Code code = HttpStatus.Code.GONE;

        Assert.assertEquals(410, code.getCode());
        Assert.assertEquals("Gone", code.getMessage());
    }

    public void testStatus411_LENGTH_REQUIRED() {
        HttpStatus.Code code = HttpStatus.Code.LENGTH_REQUIRED;

        Assert.assertEquals(411, code.getCode());
        Assert.assertEquals("Length Required", code.getMessage());
    }

    @Test
    public void testStatus412_PRECONDITION_FAILED() {
        HttpStatus.Code code = HttpStatus.Code.PRECONDITION_FAILED;

        Assert.assertEquals(412, code.getCode());
        Assert.assertEquals("Precondition Failed", code.getMessage());
    }

    @Test
    public void testStatus413_REQUEST_ENTITY_TOO_LARGE() {
        HttpStatus.Code code = HttpStatus.Code.REQUEST_ENTITY_TOO_LARGE;

        Assert.assertEquals(413, code.getCode());
        Assert.assertEquals("Request Entity Too Large", code.getMessage());
    }

    @Test
    public void testStatus414_REQUEST_URI_TOO_LONG() {
        HttpStatus.Code code = HttpStatus.Code.REQUEST_URI_TOO_LONG;

        Assert.assertEquals(414, code.getCode());
        Assert.assertEquals("Request-URI Too Long", code.getMessage());
    }

    @Test
    public void testStatus415() {
        HttpStatus.Code code = HttpStatus.Code.UNSUPPORTED_MEDIA_TYPE;

        Assert.assertEquals(415, code.getCode());
        Assert.assertEquals("Unsupported Media Type", code.getMessage());
    }

    @Test
    public void testStatus416_REQUESTED_RANGE_NOT_SATISFIABLE() {
        HttpStatus.Code code = HttpStatus.Code.REQUESTED_RANGE_NOT_SATISFIABLE;

        Assert.assertEquals(416, code.getCode());
        Assert.assertEquals("Requested Range Not Satisfiable", code.getMessage());
    }

    @Test
    public void testStatus417_EXPECTATION_FAILED() {
        HttpStatus.Code code = HttpStatus.Code.EXPECTATION_FAILED;

        Assert.assertEquals(417, code.getCode());
        Assert.assertEquals("Expectation Failed", code.getMessage());
    }

    @Test
    public void testStatus422_UNPROCESSABLE_ENTITY() {
        HttpStatus.Code code = HttpStatus.Code.UNPROCESSABLE_ENTITY;

        Assert.assertEquals(422, code.getCode());
        Assert.assertEquals("Unprocessable Entity", code.getMessage());
    }

    @Test
    public void testStatus423_LOCKED() {
        HttpStatus.Code code = HttpStatus.Code.LOCKED;

        Assert.assertEquals(423, code.getCode());
        Assert.assertEquals("Locked", code.getMessage());
    }

    @Test
    public void testStatus424_FAILED_DEPENDENCY() {
        HttpStatus.Code code = HttpStatus.Code.FAILED_DEPENDENCY;

        Assert.assertEquals(424, code.getCode());
        Assert.assertEquals("Failed Dependency", code.getMessage());
    }

    @Test
    public void testStatus426_UPRGADE_REQUIRED() {
        HttpStatus.Code code = HttpStatus.Code.UPGRADE_REQUIRED;

        Assert.assertEquals(426, code.getCode());
        Assert.assertEquals("Upgrade Required", code.getMessage());
    }

    @Test
    public void testStatus428_PRECONDITION_REQUIRED() {
        HttpStatus.Code code = HttpStatus.Code.PRECONDITION_REQUIRED;

        Assert.assertEquals(428, code.getCode());
        Assert.assertEquals("Precondition Required", code.getMessage());
    }

    @Test
    public void testStatus429_TOO_MANY_REQUESTS() {
        HttpStatus.Code code = HttpStatus.Code.TOO_MANY_REQUESTS;

        Assert.assertEquals(429, code.getCode());
        Assert.assertEquals("Too Many Requests", code.getMessage());
    }

    @Test
    public void testStatus500_INTERNAL_SERVER_ERROR() {
        HttpStatus.Code code = HttpStatus.Code.INTERNAL_SERVER_ERROR;

        Assert.assertEquals(500, code.getCode());
        Assert.assertEquals("Internal Server Error", code.getMessage());
    }

    @Test
    public void testStatus501_NOT_IMPLEMENTED() {
        HttpStatus.Code code = HttpStatus.Code.NOT_IMPLEMENTED;

        Assert.assertEquals(501, code.getCode());
        Assert.assertEquals("Not Implemented", code.getMessage());
    }

    @Test
    public void testStatus502_BAD_GATEWAY() {
        HttpStatus.Code code = HttpStatus.Code.BAD_GATEWAY;

        Assert.assertEquals(502, code.getCode());
        Assert.assertEquals("Bad Gateway", code.getMessage());
    }

    @Test
    public void testStatus503_SERVICE_UNAVAILABLE() {
        HttpStatus.Code code = HttpStatus.Code.SERVICE_UNAVAILABLE;

        Assert.assertEquals(503, code.getCode());
        Assert.assertEquals("Service Unavailable", code.getMessage());
    }

    @Test
    public void testStatus504_GATEWAYTIMEOUT() {
        HttpStatus.Code code = HttpStatus.Code.GATEWAY_TIMEOUT;

        Assert.assertEquals(504, code.getCode());
        Assert.assertEquals("Gateway Timeout", code.getMessage());
    }

    @Test
    public void testStatus505_HTTP_VERSION_NOT_SUPPORTED() {
        HttpStatus.Code code = HttpStatus.Code.HTPP_VERSION_NOT_SUPPORTED;

        Assert.assertEquals(505, code.getCode());
        Assert.assertEquals("HTTP Version Not Supported", code.getMessage());
    }

    @Test
    public void testStatus506_VARIANT_ALSO_NEGOTIATES() {
        HttpStatus.Code code = HttpStatus.Code.VARIANT_ALSO_NEGOTIATES;

        Assert.assertEquals(506, code.getCode());
        Assert.assertEquals("Variant Also Negotiates", code.getMessage());
    }

    @Test
    public void testStatus507_INSUFFICIENT_STORAGE() {
        HttpStatus.Code code = HttpStatus.Code.INSUFFICIENT_STORAGE;

        Assert.assertEquals(507, code.getCode());
        Assert.assertEquals("Insufficient Storage", code.getMessage());
    }

    @Test
    public void testStatus508_LOOP_DETECTED() {
        HttpStatus.Code code = HttpStatus.Code.LOOP_DETECTED;

        Assert.assertEquals(508, code.getCode());
        Assert.assertEquals("Loop Detected", code.getMessage());
    }

    @Test
    public void testStatus510_NOT_EXTENDED() {
        HttpStatus.Code code = HttpStatus.Code.NOT_EXTENDED;

        Assert.assertEquals(510, code.getCode());
        Assert.assertEquals("Not Extended", code.getMessage());
    }

    @Test
    public void testStatus511_NETWORK_AUTHENTICATION_REQUIRED() {
        HttpStatus.Code code = HttpStatus.Code.NETWORK_AUTHENTICATION_REQUIRED;

        Assert.assertEquals(511, code.getCode());
        Assert.assertEquals("Network Authentication Required", code.getMessage());
    }
}
