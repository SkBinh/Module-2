import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountryListReader {
    public static void main(String[] args) {
        String csvFile = "country.csv";
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] countryData = line.split(csvSplitBy);

                int id = Integer.parseInt(countryData[0].trim());
                String code = countryData[1].replace("\"", "").trim();
                String name = countryData[2].replace("\"", "").trim();

                System.out.println("ID: " + id + ", Code: " + code + ", Name: " + name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}