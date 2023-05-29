package com.spirngauth.authentication_spring.services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import org.apache.commons.codec.binary.Base64;

import java.util.ArrayList;
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
import org.springframework.web.multipart.MultipartFile;

import com.spirngauth.authentication_spring.repository.ProductImageRepository;

@Service
@Component
public class CreateImagesService {
    @Value("${app.MOUNT_PATH}")
    private String basePath;

   
    private String dateFormat = "MMMMMdd";
    public List<String> createImage(MultipartFile[] files, String id)
            throws Exception, IOException, FileNotFoundException {

        List<String> paths = new ArrayList<>();
        // Format Date
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, new Locale("en", "EN"));
        String dateString = simpleDateFormat.format(date);
        Path pathDir = Paths.get(basePath, dateString, id);

        if (!Files.exists(pathDir)) {
            Files.createDirectories(pathDir);
        }
        for (MultipartFile file : files) {
            String filename = file.getOriginalFilename();
            Path fullPath = Paths.get(pathDir.toString(), filename);
            try (InputStream inputStream = file.getInputStream()) {
                Path filePath = pathDir.resolve(filename);
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException io) {
                throw new IOException("Could not save file: " + filename, io);
            }
            paths.add(fullPath.toString());
        }
        return paths;

    }

}
