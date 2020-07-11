package com.bridgelabz.IPL_Analyser;

import com.bridgelabz.IPL_Analyser.controller.IPLAnalyser;
import org.junit.Before;

public class IPLAnalyserTest {
      private static IPLAnalyser iplAnalyser;

      private static final String IPL_BATSMAN_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
      private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IPL2019FactsheetMostRuns.csv";
      private static final String IPL_BOWLER_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWkts.csv";
      @Before
      public static void setUp() {
            iplAnalyser = new IPLAnalyser();
      }

}
