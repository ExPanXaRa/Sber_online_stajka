package org.sber;

import java.util.Comparator;
import java.util.List;

public class SortListOfCities {
    static void sortByCity(List<City> cities) {
        if (cities == null) {
            throw new NullPointerException("cities is null");
        }

        cities.sort(Comparator.comparing(City::getName, String.CASE_INSENSITIVE_ORDER));
    }

    static void sortByDistrictAndCity(List<City> cities) {
        if (cities == null) {
            throw new NullPointerException("cities is null");
        }

        cities.sort(Comparator.comparing(City::getDistrict)
                .thenComparing((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName())));
    }
}
