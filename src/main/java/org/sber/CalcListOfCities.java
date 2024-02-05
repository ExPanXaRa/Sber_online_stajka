package org.sber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalcListOfCities {
    static Map<String, Integer> NumberOfCityInRegion(List<City> cities) {
        Map<String, Integer> countCities = new HashMap<>();

        for (City city : cities) {
            String region = city.getRegion();
            countCities.put(region, countCities.getOrDefault(region, 0) + 1);
        }

        return countCities;
    }
}
