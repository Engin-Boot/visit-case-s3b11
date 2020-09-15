package footfallcounter.sender;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

//FileExtensionNotCSV - Future Scope
//TimestampMustContainDateAndTime - Future Scope

public class FootfallTimestampsCSVReaderTest {

    @Test(expected = FileNotFoundException.class)
    public void whenFileNotFoundAtFilePathThenThrowException() throws IOException
    {
        FootfallTimestampsCSVReader.readFootfallTimestampsFromCSV("Database/nonexistentfile.csv");
    }

    @Test
    public void whenCSVFileIsFoundAndEmptyThenReturnEmptyList() throws IOException
    {
        List<DateTime> returnedFootfallTimestamps = FootfallTimestampsCSVReader.readFootfallTimestampsFromCSV("Database/EmptyDataset.csv");
        assertThat(returnedFootfallTimestamps.isEmpty(), equalTo(true));
    }

    @Test
    public void whenCSVFileHasValidDataThenReturnListOfFootfallTimestamps() throws IOException
    {
        List<DateTime> expectedFootfallTimestamps = new ArrayList<DateTime>();
        DateTime sampleObject1 = new DateTime("4/1/2020", "21:46");
        DateTime sampleObject2 = new DateTime("8/2/2020", "11:56");
        expectedFootfallTimestamps.add(sampleObject1);
        expectedFootfallTimestamps.add(sampleObject2);

        List<DateTime> returnedFootfallTimestamps = FootfallTimestampsCSVReader.readFootfallTimestampsFromCSV("Database/TestDataset.csv");
        for (int i=0; i<returnedFootfallTimestamps.size();i++)
        {
            Assert.assertEquals(expectedFootfallTimestamps.get(i).Date,returnedFootfallTimestamps.get(i).Date);
            Assert.assertEquals(expectedFootfallTimestamps.get(i).Time, returnedFootfallTimestamps.get(i).Time);
        }
    }
}