package com.bridgelabz.IPL_Analyser.service;

import com.bridgelabz.IPL_Analyser.exception.IPLAnalyserException;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public class OpenCSVBuilder<E> implements ICSVBuilder {
      /**
       * to load data from CSV data file
       *
       * @param reader
       * @param csvClass
       * @return iterator
       * @throws IPLAnalyserException
       */
      public Iterator<E> getCSVFileIterator(Reader reader, Class csvClass) throws IPLAnalyserException {
            return getCSVBean(reader, csvClass).iterator();
      }

      public List getCSVFileList(Reader reader, Class csvClass) throws IPLAnalyserException {
            return getCSVBean(reader, csvClass).parse();
      }

      private CsvToBean<E> getCSVBean(Reader reader, Class csvClass) throws IPLAnalyserException {
            try {
                  CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
                  csvToBeanBuilder.withType(csvClass);
                  csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
                  return csvToBeanBuilder.build();
            } catch (IllegalStateException e) {
                  throw new IPLAnalyserException(e.getMessage(), IPLAnalyserException.ExceptionType.UNABLE_TO_PARSE);
            }
      }
}
