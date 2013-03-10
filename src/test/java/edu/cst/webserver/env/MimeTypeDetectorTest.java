package edu.cst.webserver.env;

import edu.cst.webserver.http.HttpMime;
import edu.cst.webserver.http.HttpRequestException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Demur
 */
public class MimeTypeDetectorTest {
    private String path = "/C:/Users/Demur/IdeaProjects/serv-cst/target/test-classes/filetypes/";
    private String getMimeType(String path) throws IOException, HttpRequestException {
        return MimeTypeDetector.detectMimeType(path);
    }

    /**
     * image/png
     * @throws IOException
     * @throws HttpRequestException
     */
    @Test
    public void testMimeTypeIsImagePNG() throws IOException, HttpRequestException {
        String path = MimeTypeDetectorTest.class.getResource("/filetypes/image.png").getPath();
        String mimeType = getMimeType(path);
        Assert.assertEquals(HttpMime.IMAGE_PNG, mimeType);
    }

    /**
     * image/jpeg
     * @throws IOException
     * @throws HttpRequestException
     */
    @Test
    public void testMimeTypeImageJPEG() throws IOException, HttpRequestException {
        String path = MimeTypeDetectorTest.class.getResource("/filetypes/image.jpeg").getPath();
        String mimeType = getMimeType(path);
        Assert.assertEquals(HttpMime.IMAGE_JPEG, mimeType);
    }

    /**
     * image/gif
     * @throws IOException
     * @throws HttpRequestException
     */
    @Test
    public void testMimeTypeImageGIF() throws IOException, HttpRequestException {
        String path = MimeTypeDetectorTest.class.getResource("/filetypes/image.gif").getPath();
        String mimeType = getMimeType(path);
        Assert.assertEquals(HttpMime.IMAGE_GIF, mimeType);
    }

    /**
     * text/plain
     * text on text.txt
     * @throws IOException
     * @throws HttpRequestException
     */
    @Test
    public void testMimeTypeTextPLAIN() throws IOException, HttpRequestException {
        String path = MimeTypeDetectorTest.class.getResource("/filetypes/text.txt").getPath();
        String mimeType = getMimeType(path);
        Assert.assertEquals(HttpMime.TEXT_PLAIN, mimeType);
    }

    /**
     * text/javascript
     * @throws IOException
     * @throws HttpRequestException
     */
   /* @Test
    public void testMimeTypeTextJS() throws IOException, HttpRequestException {
        String path = MimeTypeDetectorTest.class.getResource("/filetypes/text.js").getPath();
        String mimeType = getMimeType(path);
        Assert.assertEquals(HttpMime.TEXT_JAVASCRIPT, mimeType);
    }*/

    /**
     * text/css
     * @throws IOException
     * @throws HttpRequestException
     */
  /* @Test
    public void testMimeTypeTextCSS() throws IOException, HttpRequestException {
        String path = MimeTypeDetectorTest.class.getResource("/filetypes/text.css").getPath();
        String mimeType = getMimeType(path);
        Assert.assertEquals(HttpMime.TEXT_CSS, mimeType);
    }*/

    /**
     * application/xml
     * @throws IOException
     * @throws HttpRequestException
     */
    @Test
    public void testMimeTypeTextXML() throws IOException, HttpRequestException {
        String path = MimeTypeDetectorTest.class.getResource("/filetypes/app.xml").getPath();
        String mimeType = getMimeType(path);
        Assert.assertEquals(HttpMime.APPLICATION_XML, mimeType);
    }
    /**
     * Unknown filetype
     * @throws IOException
     * @throws HttpRequestException
     */
    @Test
    public void testUnknownMimeType() throws IOException, HttpRequestException {
        String path = MimeTypeDetectorTest.class.getResource("/filetypes/bb.brb").getPath();
        String mimeType = getMimeType(path);
        Assert.assertEquals(HttpMime.APPLICATION_OCTET_STREAM, mimeType);
    }

    @Test(expected = NullPointerException.class)
    public void testFileNotFound() throws IOException, HttpRequestException {
        String path = MimeTypeDetectorTest.class.getResource("/filetypes/no.no").getPath();
        String mimeType = getMimeType(path);
        Assert.assertEquals(HttpMime.APPLICATION_OCTET_STREAM, mimeType);
    }


}
