package com.bridgelabz.IPL_Analyser.adapters;

import com.bridgelabz.IPL_Analyser.controller.IPLAnalyser;
import com.bridgelabz.IPL_Analyser.exception.IPLAnalyserException;
import com.bridgelabz.IPL_Analyser.models.IPLDAO;

import java.util.Map;

public class IPLAdaptorFactory {

      public <E> Map<String, IPLDAO> getIPLAdaptor(IPLAnalyser.Statistics statistics, String... csvFilePath) throws IPLAnalyserException{
            if (statistics.equals(IPLAnalyser.Statistics.BATSMAN)) {
                  System.out.println("Adaptor factory");
                  return new IPLBatsmanAdapter().loadIPLData(csvFilePath);
            }
            if (statistics.equals(IPLAnalyser.Statistics.BOWLER))
                  return new IPLBowlerAdapter().loadIPLData(csvFilePath);
            throw new IPLAnalyserException("Invalid stat type", IPLAnalyserException.ExceptionType.INVALID_STATISTIC_TYPE);
      }
}
