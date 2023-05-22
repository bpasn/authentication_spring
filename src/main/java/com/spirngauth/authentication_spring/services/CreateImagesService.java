package com.spirngauth.authentication_spring.services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import org.apache.commons.codec.binary.Base64;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.random.RandomGenerator;

import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Component
public class CreateImagesService {
    @Value("${app.MOUNT_PATH}")
    private String basePath;

    @Autowired
    private Environment env;


    private String dateFormat = "MMMMMdd";
    private final static Logger logger = LoggerFactory.getLogger(CreateImagesService.class);

    // public String createImage(File[] files) throws Exception {

    //     // byte[] array = new byte[7]; // length is bounded by 7
    //     // new Random().nextBytes(array);
    //     // String generatedString = new String(array, Charset.forName("UTF-8"));
    //     // String parts = base64.split(",")[1];
    //     // String base64 =
    //     // "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";

    //     byte[] name = Base64.encodeBase64("hello World".getBytes());
    //     byte[] data = Base64.decodeBase64(new String(name).getBytes("UTF-8"));
    //     String path = "/Users/prpasn/Desktop/authentication_spring/src/main/resources/storate/file.png";
    //     File file = new File(path);
    //     if(!file.exists()) { 
    //         file.createTempFile(base64, path, file);

    //     }

    //     try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
    //         outputStream.write(data);
    //         return path;
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         logger.error(path);
    //         throw new Exception(e.getMessage());
    //     }
    // }
    public String createImage(List<File> files) throws IOException,FileNotFoundException {

        //random String
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        // Format Date
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat,new Locale("en", "EN"));
        String dateString = simpleDateFormat.format(date);  

        Path pathDir = Paths.get(basePath,dateString);
        File path = new File(pathDir.toString());
        String filename = "teestfile" + ".png";
        File fullPath = new File(pathDir.toString(),filename);
        if(!path.exists()){
            path.mkdirs();
        }
       if(!fullPath.exists()){
        fullPath.createNewFile();
       }


        return "Success";
    }

}
