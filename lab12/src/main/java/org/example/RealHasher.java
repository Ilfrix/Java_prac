package org.example;


import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.io.FileNotFoundException;

@Component
public class RealHasher implements Hasher {
    private String inputFile;
    private String outputFile;

    public void hash(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;

        try {
            InputStream inputStream = new FileInputStream(this.inputFile);
            OutputStream outputStream = new FileOutputStream(this.outputFile);

            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                digest.update(buffer, 0, bytesRead);
            }

            byte[] hash = digest.digest();
            outputStream.write(hash);

            inputStream.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            try {
                OutputStream outputStream = new FileOutputStream(this.outputFile);
                outputStream.write(("null").getBytes());
                outputStream.close();
            } catch (Exception e2) {
                System.err.println(e2);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @PostConstruct
    public void init() {
        System.out.println("hasher ready");
    }

    @PreDestroy
    public void cleanUp() {
        File file = new File(this.inputFile);
        if (file.exists()) {
            file.delete();
        }
    }
}