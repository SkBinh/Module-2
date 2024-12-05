import java.io.*;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter a source file path:");
            String sourcePath = reader.readLine();
            System.out.println("Enter a target file path:");
            String targetPath = reader.readLine();

            File sourceFile = new File(sourcePath);
            if (!sourceFile.exists()) {
                System.out.println("Source file does not exist.");
                return;
            }

            File targetFile = new File(targetPath);
            if (targetFile.exists()) {
                System.out.println("Target file already exists.");
                return;
            }
            try(Reader fileReader = new FileReader(sourcePath);
                Writer fileWriter = new FileWriter(targetPath)) {
                int character;
                int characterCount = 0;
                while ((character = fileReader.read()) != -1) {
                    fileWriter.write(character);
                    characterCount++;
                }
                System.out.println("Copied " + characterCount + " characters from " + sourcePath + " to " + targetPath);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
