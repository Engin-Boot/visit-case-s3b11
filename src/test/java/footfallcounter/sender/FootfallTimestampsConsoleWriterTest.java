package footfallcounter.sender;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class FootfallTimestampsConsoleWriterTest {
    /*@Test(expected = FileNotFoundException.class)
    public void whenFileNotFoundAtFilePathThenThrowException() throws IOException
    {
        FootfallTimestampsCSVReader.readFootfallTimestampsFromCSV("Database/nonexistentfile.csv");
    }

    @Test
    public void whenCSVFileIsFoundAndEmptyThenReturnEmptyList() throws IOException
    {
        List<DateTime> returnedFootfallTimestamps = FootfallTimestampsCSVReader.readFootfallTimestampsFromCSV("Database/EmptyDataset.csv");
        assertThat(returnedFootfallTimestamps.isEmpty(), equalTo(true));
    }*/

    /*@Test(expected = Exception.class)
    public void whenCSVFileHasDataOfIncorrectFormatThenThrowException() throws IOException
    {
        List<DateTime> returnedFootfallTimestamps = FootfallTimestampsCSVReader.readFootfallTimestampsFromCSV("Database/IncorrectDataFormatDataset.csv");
        assertThat(returnedFootfallTimestamps.isEmpty(), equalTo(true));
    }*/

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void whenListContainingDateTimeObjectsIsPassedThenConsoleWritesTheObjects() throws Exception
    {
        List<DateTime> footfallTimestamps = new ArrayList<DateTime>();
        DateTime sampleObject1 = new DateTime("4/1/2020", "21:46");
        DateTime sampleObject2 = new DateTime("8/2/2020", "11:56");
        footfallTimestamps.add(sampleObject1);
        footfallTimestamps.add(sampleObject2);

        FootfallTimestampsConsoleWriter.writeFootfallTimestampsToConsole(footfallTimestamps);

        Assert.assertEquals("4/1/2020 21:46\n" + "8/2/2020 11:56", systemOutRule.getLog().trim());
    }

    @Test
    public void whenEmptyListOfTypeDateTimeIsPassedThenConsoleWritesNothing() throws Exception
    {
        List<DateTime> expectedFootfallTimestamps = new ArrayList<DateTime>();
        FootfallTimestampsConsoleWriter.writeFootfallTimestampsToConsole(expectedFootfallTimestamps);
        Assert.assertEquals("", systemOutRule.getLog().trim());
    }
}
