package Compress_Decompress;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Compressor {
//    METHOD FOR COMPRESSING FILE.
    public static void method (File inputFile, File compressedFile) throws IOException {
        try (FileInputStream fis = new FileInputStream(inputFile);
            FileOutputStream fos = new FileOutputStream(compressedFile);
            GZIPOutputStream gzipOutput = new GZIPOutputStream(fos)) {

            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer)) != -1) {
//                READ DATA FROM INPUT FILE AND WRITE IT TO COMPRESSED OUTPUT FILE.
                gzipOutput.write(buffer, 0, len);
            }
        }
    }
    public static void main(String[] args) {
//        ENTRY POINT FOR TESTING THE COMPRESSOR.
    }
}
