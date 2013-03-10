package edu.cst.webserver.http;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class HttpHeaderFieldParserExceptionsTest {
    private String header;

    public HttpHeaderFieldParserExceptionsTest(String header) {
        this.header = header;
    }

    @Parameterized.Parameters
    public static Collection getHeaders() {
        return Arrays.asList(new Object[][]{
                {"Accept : text/html"},
                {"Accept -Language: hello"},
                {"ვასიკო: hello"},
                {"Content{Type}: hello"},
                {""},
                {"a:"},
                {":b"},
                {"\t\t\t\ta:\t\t\t\t\n\r"},
                {"ა:ბ"},
                {"\t:ბ"},
                {"\t:\n"},
                {"header"},
                {null},
                {"' : '"},
        });
    }

    @Test(expected = HttpRequestException.class)
        public void testInvalidChartInHeaderFieldKeyThrowsException() throws HttpRequestException {
        HttpHeaderFieldParser.parse(header);
        Assert.fail("Fail Cause Header Field is: \"" + header + "\"");
    }
}