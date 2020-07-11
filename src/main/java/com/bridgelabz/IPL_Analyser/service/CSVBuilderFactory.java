package com.bridgelabz.IPL_Analyser.service;

public class CSVBuilderFactory {
      public static ICSVBuilder createCSVBuilder() {
            return new OpenCSVBuilder();
      }
}
