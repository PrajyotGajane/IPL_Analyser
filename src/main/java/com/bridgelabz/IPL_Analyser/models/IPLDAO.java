package com.bridgelabz.IPL_Analyser.models;

public class IPLDAO {
      public String player;
      public int match;
      public int numOfFour;
      public int numOfSix;
      public int runs;
      public int fiveWicket;
      public int fourWicket;
      public double strikeRate;
      public double average;
      public double bowlerAverage;
      public double battingAverage;
      public int allWicket;
      public double economy;
      public int wicket;

      public IPLDAO(IPLBatsmanCSV csvStat) {
            player = csvStat.player;
            average = csvStat.average;
            battingAverage = csvStat.average;
            match = csvStat.match;
            numOfFour = csvStat.numOfFour;
            numOfSix = csvStat.numOfSix;
            strikeRate = csvStat.strikeRate;
            runs = csvStat.runs;
      }

      public IPLDAO(IPLBowlerCSV csvStat) {
            player = csvStat.player;
            average = csvStat.average;
            bowlerAverage = csvStat.average;
            strikeRate = csvStat.strikeRate;
            economy = csvStat.economy;
            fiveWicket = csvStat.fiveWicket;
            fourWicket = csvStat.fourWicket;
            wicket = csvStat.wicket;
      }
}
