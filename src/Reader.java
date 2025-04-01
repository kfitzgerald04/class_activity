// KF
// this class is for parsing the data using the BufferREader import
// the parsing of the file comes from the main columns in the file, cities, states, and populations

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Reader {
    public static List<City> readCities(String filename) throws IOException {
        List<City> city = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    city.add(new City(parts[0], parts[1], Integer.parseInt(parts[2])));
                }
            }
        }
        return city;
    }
}
