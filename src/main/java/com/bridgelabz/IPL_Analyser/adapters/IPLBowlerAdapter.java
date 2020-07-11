package com.bridgelabz.IPL_Analyser.adapters;

import com.bridgelabz.IPL_Analyser.exception.IPLAnalyserException;
import com.bridgelabz.IPL_Analyser.models.IPLBatsmanCSV;
import com.bridgelabz.IPL_Analyser.models.IPLBowlerCSV;
import com.bridgelabz.IPL_Analyser.models.IPLDAO;
import com.bridgelabz.IPL_Analyser.service.CSVBuilderException;

import java.util.Map;

public class IPLBowlerAdapter extends IPLAdaptor{

      public Map<String, IPLDAO> loadIPLData(String... csvFilePath) throws CSVBuilderException, IPLAnalyserException {
            return super.loadIPLData(IPLBowlerCSV.class, csvFilePath[0]);
      }
}
