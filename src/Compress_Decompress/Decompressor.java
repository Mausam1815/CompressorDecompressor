package Compress_Decompress;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class Decompressor {
//    METHOD FO DECOMPRESSING A FILE.
    public static void method(File compressedFile, File decompressedFile) throws IOException {
        try (FileInputStream fis = new FileInputStream(compressedFile);
             GZIPInputStream gzipInput = new GZIPInputStream(fis);
             FileOutputStream fos = new FileOutputStream(decompressedFile)) {

            byte[] buffer = new byte[1024];
            int len;

            while((len = gzipInput.read(buffer)) != -1) {
//                READ COMPRESSED DARA FROM THE INPUT FILE, DECOMPRESS IT, AND WRITE IT TO THE OUTPUT FILE.
                fos.write(buffer, 0, len);
            }
        }
    }
    public static void main(String[] args) {
//        ENTRY POINT FOR TESTING THE DECOMPRESSOR.
    }
}
