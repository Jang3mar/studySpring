package com.example.medapi.modifies;

import java.io.IOException;

public class BackupBase {
    public static void createBackup(String host, String port, String databaseName,
                                    String username, String password, String backupPath) throws IOException {

        String command = "mysqldump -h " + host + " -P " + port + " -u " + username +
                " -p" + password + " " + databaseName + " > " + backupPath;

        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        Process process = processBuilder.start();

        // Wait for the process to complete
        try {
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Backup created successfully.");
            } else {
                System.err.println("Error creating backup. Exit code: " + exitCode);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
