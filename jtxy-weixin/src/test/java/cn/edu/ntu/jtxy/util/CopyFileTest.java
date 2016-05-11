package cn.edu.ntu.jtxy.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CopyFileTest {
    private static final Logger logger = LoggerFactory.getLogger(CopyFileTest.class);

    @Test
    public void test() {

        //        File file = new File("F:\\ntujtxy\\images\\201605");
        File file = new File("F:\\ntujtxy\\images");
        //不存在该文件夹就新建
        logger.info("" + file.exists());
        if (!file.exists()) {
            file.mkdir();
        }
    }

    private long writeToFile(InputStream uploadedInputStream, String fileLocation, String fileName,
                             long maxSize) {

        logger.info(" fileLocation={},fileName={}", fileLocation, fileName);
        long fileSize = 0;

        try {
            File file = new File(fileLocation);
            //不存在该文件夹就新建
            if (!file.exists()) {
                file.mkdir();
            }

            int read = 0;
            byte[] bytes = new byte[4096];

            OutputStream out = new FileOutputStream(new File(file, fileName));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
                fileSize += read;
                if (fileSize > maxSize) {
                    fileSize = -1;
                    break;
                }
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return fileSize;
    }

}
