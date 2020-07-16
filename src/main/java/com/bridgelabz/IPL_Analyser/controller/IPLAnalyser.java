package com.bridgelabz.IPL_Analyser.controller;

import com.bridgelabz.IPL_Analyser.adapters.IPLAdaptorFactory;
import com.bridgelabz.IPL_Analyser.models.IPLDAO;
import com.csvparser.CSVBuilderException;
import com.google.gson.Gson;

import java.util.*;
import java.util.stream.Collectors;

public class IPLAnalyser {
      public enum Player {
            BOWLER, BATSMAN
      }
      Map<String, IPLDAO> statisticMap = new HashMap<>();
      List<IPLDAO> collect;

      public int loadIPLData(Player player, String... csvFilePath) throws CSVBuilderException {
            statisticMap = new IPLAdaptorFactory().getIPLAdaptor(player, csvFilePath);
            return statisticMap.size();
      }
      public String getStatWiseSortedData(){
            String sortedStateCensusJson = "";
            ArrayList<Object> censusDTOs = new ArrayList<>();
            censusDTOs = this.statisticMap.values()
                    .stream().sorted(Comparator.comparing((IPLDAO c) -> c.average))
                    .map(censusDAO -> censusDAO.getSpecificCensusData())
                    .collect(Collectors.toCollection(ArrayList::new));
            sortedStateCensusJson = new Gson().toJson(censusDTOs);
            return sortedStateCensusJson;
      }
}
