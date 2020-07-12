package com.bridgelabz.IPL_Analyser.adapters;

import com.bridgelabz.IPL_Analyser.exception.IPLAnalyserException;
import com.bridgelabz.IPL_Analyser.models.IPLBatsmanCSV;
import com.bridgelabz.IPL_Analyser.models.IPLBowlerCSV;
import com.bridgelabz.IPL_Analyser.models.IPLDAO;
import java.util.Map;
public class IPLBatsmanAdapter extends IPLAdaptor{
      public Map<String, IPLDAO> loadIPLData(String... csvFilePath) throws IPLAnalyserException {
            System.out.println("Batsman adaptor");
            return super.loadIPLData(IPLBatsmanCSV.class, csvFilePath[0]);
      }
}
