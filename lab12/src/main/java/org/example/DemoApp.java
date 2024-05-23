package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApp implements CommandLineRunner {
    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java -jar jarpath.jar <inputFile> <outputFile>");
//            System.exit(1);
        }

        SpringApplication.run(DemoApp.class, args);
    }

    @Override
    public void run(String... args) {
        String inputFile = args[0];
        String outputFile = args[1];
        System.out.println(inputFile + " " + outputFile);

        Hasher h = (Hasher) context.getBean(RealHasher.class);

        h.hash(inputFile, outputFile);
    }
}