package data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {
    public static void writeToFile(String filePath, String content, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, append))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static List<String> readFromFile(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return lines;
    }

    public static boolean replaceFile(String sourcePath, String targetPath) {
        File source = new File(sourcePath);
        File target = new File(targetPath);

        if (!target.delete()) {
            System.out.println("Error: Unable to delete original file.");
            return false;
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if (!source.renameTo(target)) {
            System.out.println("Error: Unable to rename temporary file.");
            return false;
        }
        return true;
    }
}
