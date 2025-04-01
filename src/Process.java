// KF
// this class is for calling to the functions in Insights to find out the info

import java.io.*;
import java.util.*;

public class Process {
    public static void main(String[] args) throws IOException {
        List<City> city = Reader.readCities("cities.txt");

        Insights.TopThreeCitiesPerState(city);
        Insights.LowestPopulationCityPerState(city);
        Insights.DuplicateCityNames(city);
        Insights.CitiesInArkansas(city);
        Insights.LargestCityRankInArkansas(city);
    }
}
