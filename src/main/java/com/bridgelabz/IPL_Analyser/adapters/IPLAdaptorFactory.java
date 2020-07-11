package com.bridgelabz.IPL_Analyser.adapters;

import com.bridgelabz.IPL_Analyser.controller.IPLAnalyser;
import com.bridgelabz.IPL_Analyser.exception.IPLAnalyserException;
import com.bridgelabz.IPL_Analyser.models.IPLDAO;

import java.util.Map;

public class IPLAdaptorFactory {
      public <E> Map<String, IPLDAO> getIPLAdaptor(IPLAnalyser.PlayerType player, String... csvFilePath) throws IPLAnalyserException {
            if (player.equals(IPLAnalyser.PlayerType.BATSMAN))
                  return new IPLBatsmanAdapter().loadIPLData(csvFilePath);
            if (player.equals(IPLAnalyser.PlayerType.BOWLER))
                  return new IPLBowlerAdapter().loadIPLData(csvFilePath);
            throw new IPLAnalyserException("Invalid stat type", IPLAnalyserException.ExceptionType.INVALID_STATISTIC_TYPE);
      }
}
