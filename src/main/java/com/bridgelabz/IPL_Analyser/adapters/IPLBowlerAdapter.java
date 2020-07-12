package com.bridgelabz.IPL_Analyser.adapters;

import com.bridgelabz.IPL_Analyser.exception.IPLAnalyserException;
import com.bridgelabz.IPL_Analyser.models.IPLBowlerCSV;
import com.bridgelabz.IPL_Analyser.models.IPLDAO;

import java.util.Map;

public class IPLBowlerAdapter extends IPLAdaptor{
      public Map<String, IPLDAO> loadIPLData(String... csvFilePath) throws IPLAnalyserException {
            Map<String, IPLDAO> iplMap = super.loadIPLData(IPLBowlerCSV.class, csvFilePath[0]);
            return iplMap;
      }
}
