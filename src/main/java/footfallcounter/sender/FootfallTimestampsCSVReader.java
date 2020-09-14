package footfallcounter.sender;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class FootfallTimestampsCSVReader {

    public static List<DateTime> readFootfallTimestampsFromCSV(String csvFilePath) throws IOException{

        List<DateTime> footfall = new ArrayList<DateTime>();
        String csvSplitBy = " ";
        String row = "";

        try (BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath))) {

            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(csvSplitBy);
                DateTime temp = new DateTime(data[0], data[1]);
                footfall.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return footfall;
    }

}
