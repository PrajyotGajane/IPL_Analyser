package com.bridgelabz.IPL_Analyser.adapters;

import com.bridgelabz.IPL_Analyser.exception.IPLAnalyserException;
import com.bridgelabz.IPL_Analyser.models.IPLBatsmanCSV;
import com.bridgelabz.IPL_Analyser.models.IPLBowlerCSV;
import com.bridgelabz.IPL_Analyser.models.IPLDAO;
import com.bridgelabz.IPL_Analyser.service.CSVBuilderException;
import com.bridgelabz.IPL_Analyser.service.CSVBuilderFactory;
import com.bridgelabz.IPL_Analyser.service.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public abstract class IPLAdaptor {
      public abstract Map<String, IPLDAO> loadIPLData(String... csvFilePath) throws CSVBuilderException, IPLAnalyserException;

      public static <E> Map<String, IPLDAO> loadIPLData(Class<E> iplClass, String csvFilePath) throws CSVBuilderException, IPLAnalyserException {
            Map<String, IPLDAO> statisticMap = new HashMap<>();
            try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
                  ICSVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
                  Iterator<E> csvIterator = icsvBuilder.getCSVFileIterator(reader, iplClass);
                  Iterable<E> csvIterable = () -> csvIterator;
                  if (iplClass.getSimpleName() == "IPLBatsmanCSV") {
                        StreamSupport.stream(csvIterable.spliterator(), false).
                                map(IPLBatsmanCSV.class::cast).
                                forEach(csvStatistic -> statisticMap.put(csvStatistic.player, new IPLDAO(csvStatistic)));
                  } else if (iplClass.getSimpleName() == "IPLBowlerCSV") {
                        StreamSupport.stream(csvIterable.spliterator(), false).
                                map(IPLBowlerCSV.class::cast).
                                forEach(csvStatistic -> statisticMap.put(csvStatistic.player, new IPLDAO(csvStatistic)));
                  }
                  return statisticMap;
            } catch (IOException ioException) {
                  throw new IPLAnalyserException(ioException.getMessage(), IPLAnalyserException.ExceptionType.STATISTIC_FILE_PROBLEM);
            } catch (RuntimeException | IPLAnalyserException runtimeException) {
                  throw new CSVBuilderException(runtimeException.getMessage(), CSVBuilderException.ExceptionType.ERROR_CAPTURING_CSV_HEADER);
            }
      }
}