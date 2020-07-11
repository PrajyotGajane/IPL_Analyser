package com.bridgelabz.IPL_Analyser.service;
public class CSVBuilderException extends Exception {
      public ExceptionType type;
      public enum ExceptionType {
            CENSUS_FILE_PROBLEM, WRONG_FILE_TYPE, RUN_TIME_EXCEPTION, UNABLE_TO_PARSE,ERROR_CAPTURING_CSV_HEADER;
      }
      public CSVBuilderException(String message, ExceptionType type) {
            super(message);
            this.type = type;
      }
}
