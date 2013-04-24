package edu.cst.webserver.env;

import edu.cst.webserver.http.HttpMime;
import edu.cst.webserver.http.HttpRequestException;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Demur
 */
public class MimeTypeDetectorTest {
    private String getMimeType(String path) throws IOException, HttpRequestException {
        return MimeTypeDetector.getMimeType(new File(path));
    }

    /**
     * image/png
     * @throws IOException
     * @throws HttpRequestException
     */
    @Test
    public void testMimeTypeIsImagePNG() throws IOException, HttpRequestException {
        String path = MimeTypeDetectorTest.class.getResource("/filetypes/image.png").getPath();
        HttpMime mimePng =  HttpMime.IMAGE_PNG;
        String mimeType = getMimeType(path);
        Assert.assertEquals(mimePng.getMime(), mimeType);
    }

    /**
     * image/jpeg
     * @throws IOException
     * @throws HttpRequestException
     */
    @Test
    public void testMimeTypeImageJPEG() throws IOException, HttpRequestException {
        String path = MimeTypeDetectorTest.class.getResource("/filetypes/image.jpeg").getPath();

        HttpMime mimeJpeg =  HttpMime.IMAGE_JPEG;
        String mimeType = getMimeType(path);
        Assert.assertEquals(mimeJpeg.getMime(), mimeType);
    }

    /**
     * image/gif
     * @throws IOException
     * @throws HttpRequestException
     */
    @Test
    public void testMimeTypeImageGIF() throws IOException, HttpRequestException {
        String path = MimeTypeDetectorTest.class.getResource("/filetypes/image.gif").getPath();

        HttpMime mimeGif =  HttpMime.IMAGE_GIF;
        String mimeType = getMimeType(path);
        Assert.assertEquals(mimeGif.getMime(), mimeType);
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

        HttpMime mimeTextPlain =  HttpMime.TEXT_PLAIN;
        String mimeType = getMimeType(path);
        Assert.assertEquals(mimeTextPlain.getMime(), mimeType);
    }

    /**
     * text/javascript
     * @throws IOException
     * @throws HttpRequestException
     */
    @Test
    public void testMimeTypeTextJS() throws IOException, HttpRequestException {
        String path = MimeTypeDetectorTest.class.getResource("/filetypes/text.js").getPath();
        HttpMime mimeJs =  HttpMime.TEXT_JAVASCRIPT;

        String mimeType = getMimeType(path);
        Assert.assertEquals(mimeJs.getMime(), mimeType);
    }

    /**
     * text/css
     * @throws IOException
     * @throws HttpRequestException
     */
    @Test
    public void testMimeTypeTextCSS() throws IOException, HttpRequestException {
        String path = MimeTypeDetectorTest.class.getResource("/filetypes/text.css").getPath();
        HttpMime mimeCss =  HttpMime.TEXT_CSS;

        String mimeType = getMimeType(path);
        Assert.assertEquals(mimeCss.getMime(), mimeType);
    }

    /**
     * application/xml
     * @throws IOException
     * @throws HttpRequestException
     */
    @Test
    public void testMimeTypeTextXML() throws IOException, HttpRequestException {
        String path = MimeTypeDetectorTest.class.getResource("/filetypes/app.xml").getPath();

        HttpMime mimeXml =  HttpMime.APPLICATION_XML;
        String mimeType = getMimeType(path);
        Assert.assertEquals(mimeXml.getMime(), mimeType);
    }
    /**
     * Unknown filetype
     * @throws IOException
     * @throws HttpRequestException
     */
    @Test
    public void testUnknownMimeType() throws IOException, HttpRequestException {
        String path = MimeTypeDetectorTest.class.getResource("/filetypes/bb.brb").getPath();

        HttpMime mimeUnknown =  HttpMime.APPLICATION_OCTET_STREAM;
        String mimeType = getMimeType(path);
        Assert.assertEquals(mimeUnknown.getMime(), mimeType);
    }

    @Test(expected = NullPointerException.class)
    public void testFileNotFound() throws IOException, HttpRequestException {
        String path = MimeTypeDetectorTest.class.getResource("/filetypes/no.no").getPath();

        HttpMime mimeNotExists =  HttpMime.APPLICATION_OCTET_STREAM;
        String mimeType = getMimeType(path);
        Assert.assertEquals(mimeNotExists.getMime(), mimeType);
    }

}

