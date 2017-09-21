package de.exxcellent.challenge;

import java.io.*;

/**
 * Created by anton on 9/21/17.
 */
public class CSVReader {

   private String result;
   private int smallestSpread;

   /**
    * this method contains the general logic of
    * reading a text file
    * @param filePath to a file in the resources folder
    * @param column_1 first column we have to work with
    * @param column_2 second column we have to work with
    * @return either Day or Football team's name
    */
   public String readCSV(String filePath, int column_1, int column_2) {

      try {
         InputStream stream = getClass().getResourceAsStream(filePath);
         BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
         String line;
         // reset the values if used before
         smallestSpread = 100;
         result = "";
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

   /**
    * calculating the diff between two values of the same record
    * @param dataLine parsed line, separated by ,
    * @return diff
    */
   private int calculateDiff(String[] dataLine, int column_1, int column_2) {
      return Math.abs(Integer.parseInt(dataLine[column_1]) - Integer.parseInt(dataLine[column_2]));
   }

   /**
    * process the parsed data according to the given task (weather challenge)
    * @param line one line from buffer
    */
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
