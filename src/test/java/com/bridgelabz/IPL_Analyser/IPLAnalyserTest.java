package com.bridgelabz.IPL_Analyser;

import com.bridgelabz.IPL_Analyser.controller.IPLAnalyser;
import com.bridgelabz.IPL_Analyser.exception.IPLAnalyserException;
import com.bridgelabz.IPL_Analyser.models.IPLBatsmanCSV;
import com.bridgelabz.IPL_Analyser.models.IPLDAO;
import com.csvparser.CSVBuilderException;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
public class IPLAnalyserTest{
      private static IPLAnalyser iplAnalyser;
      private String sortedData;
      private static final String IPL_BATSMAN_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
      private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IPL2019FactsheetMostRuns.csv";
      private static final String IPL_BOWLER_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

      @BeforeClass
      public static void setUp() {
            iplAnalyser = new IPLAnalyser();
      }
      @Test
      public void givenIPLBatsmanCSVFileReturnCorrectRecords() throws CSVBuilderException {
            int numOfEnteries = iplAnalyser.loadIPLData(IPLAnalyser.Player.BATSMAN, IPL_BATSMAN_CSV_FILE_PATH);
            Assert.assertEquals(100, numOfEnteries);
      }
      @Test
      public void givenIPLBatsmanCSVData_WithWrongFile_ShouldThrowException() {
            try {
                  iplAnalyser.loadIPLData(IPLAnalyser.Player.BATSMAN, WRONG_CSV_FILE_PATH);
            } catch (IPLAnalyserException e) {
                  Assert.assertEquals(IPLAnalyserException.ExceptionType.STATISTIC_FILE_PROBLEM, e.type);
            }
      }
      @Test
      public void givenIPLBatsman_WhenSortedOnAverage_ShouldReturnSortedResult() {
            iplAnalyser.loadIPLData(IPLAnalyser.Player.BATSMAN, IPL_BATSMAN_CSV_FILE_PATH);
            sortedData = iplAnalyser.getStatWiseSortedData();
            IPLBatsmanCSV[] iplData = new Gson().fromJson(sortedData, IPLBatsmanCSV[].class);
            Assert.assertEquals("MS Dhoni", iplData[iplData.length -1].player);
      }
}
