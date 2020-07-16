package com.bridgelabz.IPL_Analyser;

import com.bridgelabz.IPL_Analyser.controller.IPLAnalyser;
import com.bridgelabz.IPL_Analyser.exception.IPLAnalyserException;
import com.csvparser.CSVBuilderException;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
public class IPLAnalyserTest{
      private static IPLAnalyser iplAnalyzer;
      private static final String IPL_BATSMAN_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
      private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IPL2019FactsheetMostRuns.csv";
      private static final String IPL_BOWLER_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

      @BeforeClass
      public static void setUp() {
            iplAnalyzer = new IPLAnalyser();
      }
      @Test
      public void givenIPLBatsmanCSVFileReturnCorrectRecords() throws CSVBuilderException {
            int numOfEnteries = iplAnalyzer.loadIPLData(IPLAnalyser.Statistics.BATSMAN, IPL_BATSMAN_CSV_FILE_PATH);
            Assert.assertEquals(100, numOfEnteries);
      }
      @Test
      public void givenIPLBatsmanCSVData_WithWrongFile_ShouldThrowException() {
            try {
                  iplAnalyzer.loadIPLData(IPLAnalyser.Statistics.BATSMAN, WRONG_CSV_FILE_PATH);
            } catch (IPLAnalyserException e) {
                  Assert.assertEquals(IPLAnalyserException.ExceptionType.STATISTIC_FILE_PROBLEM, e.type);
            }
      }
}