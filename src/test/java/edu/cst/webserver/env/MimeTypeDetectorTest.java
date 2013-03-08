package edu.cst.webserver.env;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Demur
 */
public class MimeTypeDetectorTest {

    @Test
    public void testMimeTypeIsImagePNG() throws IOException {
        String path = MimeTypeDetectorTest.class.getResource("/filetypes/img.png").getPath();
        String mimeType = MimeTypeDetector.detectMimeType(path).getDetectedMimeType();
        Assert.assertEquals("image/png", mimeType);
    }


}
