// KF

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Insights {
    // method to find the top 3 most populated cities in each state
    public static void TopThreeCitiesPerState(List<City> cities) {
        Map<String, List<City>> stateCities = cities.stream()
                .collect(Collectors.groupingBy(city -> city.state));

        System.out.println("Top 3 Cities Per State:");
        for (String state : stateCities.keySet()) {
            List<City> sorted = stateCities.get(state).stream()
                    .sorted((a, b) -> Integer.compare(b.population, a.population))
                    .limit(3)
                    .collect(Collectors.toList());
            System.out.println(state + ": " + sorted);
        }
    }
    // method to find the city wiht lowest population
    public static void LowestPopulationCityPerState(List<City> cities) {
        Map<String, Optional<City>> lowestCityPerState = cities.stream()
                .collect(Collectors.groupingBy(city -> city.state,
                        Collectors.minBy(Comparator.comparingInt(city -> city.population))));

        System.out.println("Lowest Population City Per State:");
        lowestCityPerState.forEach((state, city) ->
                city.ifPresent(c -> System.out.println(state + ": " + c.name + " - " + c.population)));
    }
    // method to find city names that appear in multiple states
    public static void DuplicateCityNames(List<City> cities) {
        Map<String, List<City>> cityNameGroups = cities.stream()
                .collect(Collectors.groupingBy(city -> city.name));

        System.out.println("Cities with Duplicate Names:");
        cityNameGroups.values().stream()
                .filter(list -> list.size() > 1)
                .forEach(list -> list.forEach(c -> System.out.println(c.name + ", " + c.state + ", " + c.population)));
    }
    // find the largest city in arkansa
    public static void CitiesInArkansas(List<City> cities) {
        System.out.println("Cities in Arkansas:");
        cities.stream()
                .filter(city -> city.state.equals("AR"))
                .forEach(city -> System.out.println(city.name + " - " + city.population));
    }
    // determine population rank for the city above ^^
    public static void LargestCityRankInArkansas(List<City> cities) {
        List<City> sortedByPopulation = cities.stream()
                .sorted((a, b) -> Integer.compare(b.population, a.population))
                .collect(Collectors.toList());

        City largestARCity = cities.stream()
                .filter(city -> city.state.equals("AR"))
                .max(Comparator.comparingInt(city -> city.population))
                .orElse(null);

        if (largestARCity != null) {
            int rank = sortedByPopulation.indexOf(largestARCity) + 1;
            System.out.println("Largest City in Arkansas: " + largestARCity.name + " - Rank: " + rank);
        } else {
            System.out.println("No cities found in Arkansas.");
        }
    }
}