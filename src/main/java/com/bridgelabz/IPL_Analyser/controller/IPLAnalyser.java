package com.bridgelabz.IPL_Analyser.controller;

import com.bridgelabz.IPL_Analyser.adapters.IPLAdaptorFactory;
import com.bridgelabz.IPL_Analyser.models.IPLDAO;
import com.csvparser.CSVBuilderException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class IPLAnalyser {
      public enum Statistics {
            BOWLER, BATSMAN
      }
      Map<String, IPLDAO> statisticMap = new HashMap<>();
      List<IPLDAO> collect;

      public int loadIPLData(Statistics statistics, String... csvFilePath) throws CSVBuilderException {
            statisticMap = new IPLAdaptorFactory().getIPLAdaptor(statistics, csvFilePath);
            return statisticMap.size();
      }
}
