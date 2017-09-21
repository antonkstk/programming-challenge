package de.exxcellent.challenge;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static void main(String... args) {

        CSVReader reader = new CSVReader();

        // parse csv data files by specifying the needed columns
        String dayWithSmallestTempSpread = reader.readCSV("weather.csv", 1, 2);     // Your day analysis function call …
        String teamWithSmallesGoalSpread = reader.readCSV("football.csv", 5, 6); // Your goal analysis function call …

        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
    }
}
