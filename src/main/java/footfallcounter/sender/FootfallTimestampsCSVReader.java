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

        try (BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath))) {
            String row = csvReader.readLine();
            boolean flag = (row != null) && (!row.equals(""));
            while (flag){
                String[] data = row.split(csvSplitBy);
                DateTime temp = new DateTime(data[0], data[1]);
                footfall.add(temp);
                row = csvReader.readLine();
                flag = (row != null) && (!row.equals(""));
            }

        } catch (IOException e) {
            throw(e);
        }
        return footfall;
    }

}
