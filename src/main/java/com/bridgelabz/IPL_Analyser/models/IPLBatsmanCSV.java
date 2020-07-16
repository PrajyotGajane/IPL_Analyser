package com.bridgelabz.IPL_Analyser.models;
import com.opencsv.bean.CsvBindByName;
public class IPLBatsmanCSV {
      @CsvBindByName(column = "PLAYER", required = true)
      public String player;

      @CsvBindByName(column = "Mat", required = true)
      public int match;

      @CsvBindByName(column = "Runs", required = true)
      public int runs;

      @CsvBindByName(column = "Avg", required = true)
      public double average;

      @CsvBindByName(column = "SR", required = true)
      public double strikeRate;

      @CsvBindByName(column = "4s", required = true)
      public int numOfFour;

      @CsvBindByName(column = "6s", required = true)
      public int numOfSix;

      public IPLBatsmanCSV() {
      }

      public IPLBatsmanCSV(String player, int runs, double average, double strikeRate) {
            this.player = player;
            this.runs = runs;
            this.average = average;
            this.strikeRate = strikeRate;
      }

      @Override
      public String toString() {
            return "IPLBatsmanCSV{" +
                    "player='" + player + '\'' +
                    ", match=" + match +
                    ", runs='" + runs + '\'' +
                    ", average=" + average +
                    ", strikeRate=" + strikeRate +
                    ", numOfFour=" + numOfFour +
                    ", numOfSix=" + numOfSix +
                    '}';
      }
}
