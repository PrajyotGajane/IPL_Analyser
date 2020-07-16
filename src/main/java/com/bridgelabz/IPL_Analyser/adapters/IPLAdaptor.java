package com.bridgelabz.IPL_Analyser.adapters;

import com.bridgelabz.IPL_Analyser.exception.IPLAnalyserException;
import com.bridgelabz.IPL_Analyser.models.IPLBatsmanCSV;
import com.bridgelabz.IPL_Analyser.models.IPLBowlerCSV;
import com.bridgelabz.IPL_Analyser.models.IPLDAO;
import com.csvparser.CSVBuilderFactory;
import com.csvparser.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

public abstract class IPLAdaptor {
      public abstract Map<String, IPLDAO> loadIPLData(String... csvFilePath) throws IPLAnalyserException;

      public static <E> Map<String, IPLDAO> loadIPLData(Class<E> iplClass, String csvFilePath) throws IPLAnalyserException {
            Map<String, IPLDAO> statisticMap = new HashMap<>();
            try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
                  ICSVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
                   Iterator<E> csvIterator = icsvBuilder.getCSVFileIterator(reader, iplClass);
                   Iterable<E> csvIterable = () -> csvIterator;
//                  List<E> csvIterable = icsvBuilder.getCSVFileList(reader, iplClass);
                  if (iplClass.getName() == "com.bridgelabz.IPL_Analyser.models.IPLBatsmanCSV") {
                        StreamSupport.stream(csvIterable.spliterator(), false).
                                map(IPLBatsmanCSV.class::cast).
                                forEach(csvStatistic -> statisticMap.put(csvStatistic.player, new IPLDAO(csvStatistic)));
                  } else if (iplClass.getName() == "com.bridgelabz.IPL_Analyser.models.IPLBowlerCSV") {
                        StreamSupport.stream(csvIterable.spliterator(), false).
                                map(IPLBowlerCSV.class::cast).
                                forEach(csvStatistic -> statisticMap.put(csvStatistic.player, new IPLDAO(csvStatistic)));
                  }
                  return statisticMap;
            } catch (IOException e) {
                 throw new IPLAnalyserException(e.getMessage(),
                          IPLAnalyserException.ExceptionType.STATISTIC_FILE_PROBLEM);
            } catch (RuntimeException e) {
                   throw new IPLAnalyserException(e.getMessage(),
                          IPLAnalyserException.ExceptionType.NO_STATISTIC_DATA);
            }
      }
}