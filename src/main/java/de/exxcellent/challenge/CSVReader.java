package de.exxcellent.challenge;

import java.io.*;

/**
 * Created by anton on 9/21/17.
 */
public class CSVReader {

   private String result;
   private int smallestSpread = 100;

   public String readCSV(String filePath, int column_1, int column_2) {

      try {
         InputStream stream = getClass().getResourceAsStream(filePath);
         BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
         String line;

         // skip the first line
         reader.readLine();

         while ((line = reader.readLine()) != null) {
            processData(line, column_1, column_2);
         }

         reader.close();
      }
      catch (IOException ex) {
         System.out.println(ex.getMessage());
      }
      return result;
   }

   private int calculateDiff(String[] dataLine, int column_1, int column_2) {
      return Math.abs(Integer.parseInt(dataLine[column_1]) - Integer.parseInt(dataLine[column_2]));
   }

   private void processData(String line, int column_1, int column_2) {
      String separator = ",";
      String[] record = line.split(separator);
      int spread = calculateDiff(line.split(separator), column_1, column_2);
      if (spread < smallestSpread) {
         smallestSpread = spread;
         result = record[0];
      }
   }
}
