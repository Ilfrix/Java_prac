package org.example;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

import javax.management.MBeanServer;
import java.lang.management.ManagementFactory;

import javax.management.ObjectName;

@Service
@AllArgsConstructor
public class SchedulerService implements SchedulerServiceMBean {
    GameService gameService;

    BuildingService buildingService;

    @PostConstruct
    private void init() {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        try {
            ObjectName name = new ObjectName("org:type=example,name=scheduler");

            mbs.registerMBean(this, name);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Scheduled(fixedDelay = 180_000)
    public void task() throws IOException {
        String path = "files";
        System.out.println("Scheduled task");
        for (File myFile : Objects.requireNonNull(new File(path).listFiles())) {
            if (myFile.isFile()) {
                myFile.delete();
            }
        }

        File file = new File(path + "/addresses.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(gameService.getGames().toString());
        fileWriter.close();

        file = new File(path + "/buildings.txt");
        file.createNewFile();
        fileWriter = new FileWriter(file);
        fileWriter.write(buildingService.getBuildings().toString());
        fileWriter.close();
    }
}
