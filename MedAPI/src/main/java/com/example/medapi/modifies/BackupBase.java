package com.example.medapi.modifies;

import com.example.medapi.DAO.AllDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.time.LocalDateTime;

public class BackupBase {
//    public static void createBackup(String host, String port, String databaseName,
//                                    String username, String password, String backupPath) throws IOException {
//
//        String command = "mysqldump -h " + host + " -P " + port + " -u " + username +
//                " -p" + password + " " + databaseName + " > " + backupPath;
//
//        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
//        Process process = processBuilder.start();
//
//        // Wait for the process to complete
//        try {
//            int exitCode = process.waitFor();
//            if (exitCode == 0) {
//                System.out.println("Backup created successfully.");
//            } else {
//                System.err.println("Error creating backup. Exit code: " + exitCode);
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }


    public void createBackup() {
        // Logic to fetch and export data

        // Example: Export data to a file
        String backupFileName = "backup_" + LocalDateTime.now().toString() + ".sql";
        String backupFilePath = "c:/ospanel/userdata/temp/upload/" + backupFileName;

        // Execute system command to export data (this is just an example, actual implementation may vary)
        String command = "mysqldump -u root medInst > " + backupFilePath;
        executeCommand(command);

        // Save backup information to the database
        Backup backupEntity = new Backup();
        backupEntity.setFile_Name(backupFileName);
        backupEntity.setTime_stamp(LocalDateTime.now());
        AllDAO allDAO = new AllDAO();
        allDAO.addToTable("Backup", backupEntity);
//        backupRepository.save(backupEntity);
    }

    private void executeCommand(String command) {
        // Execute system command (implementation depends on your OS and security considerations)
    }
}
