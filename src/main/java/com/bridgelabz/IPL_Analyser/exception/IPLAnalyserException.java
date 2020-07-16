package com.bridgelabz.IPL_Analyser.exception;

public class IPLAnalyserException extends RuntimeException {
      public enum ExceptionType {NO_STATISTIC_DATA, INVALID_STATISTIC_TYPE, STATISTIC_FILE_PROBLEM}

      public ExceptionType type;

      public IPLAnalyserException(String message, ExceptionType type) {
            super(message);
            this.type = type;
      }
}
