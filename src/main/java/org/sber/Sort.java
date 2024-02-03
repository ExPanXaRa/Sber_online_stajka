package org.sber;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {
    static void sortBySity(List<City> cities) {
        Collections.sort(cities, Comparator.comparing(City::getName, String.CASE_INSENSITIVE_ORDER));
    }

    static void sortByDistrictAndSity(List<City> cities) {
        Collections.sort(cities, Comparator.comparing(City::getDistrict)
                .thenComparing((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName())));
    }
}
