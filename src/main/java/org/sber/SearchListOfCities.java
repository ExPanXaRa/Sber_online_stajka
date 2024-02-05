package org.sber;

public class SearchListOfCities {
    static int[] MaxPopulation(City[] cityArray) {
        if (cityArray == null) {
            throw new NullPointerException("cityArray is null");
        }

        int maxPopulation = 0;
        int indexOfMaxPopulation = -1;
        for (int i = 0; i < cityArray.length; i++) {
            if (cityArray[i].getPopulation() > maxPopulation) {
                maxPopulation = cityArray[i].getPopulation();
                indexOfMaxPopulation = i;
            }
        }
        return new int[]{indexOfMaxPopulation, maxPopulation};
    }

    static void printIndexAndMaxPopulation(City[] cityArray) {
        if (cityArray == null) {
            throw new NullPointerException("cityArray is null");
        }

        int[] result = MaxPopulation(cityArray);
        System.out.println("[" + result[0] + "] = " + result[1]);
    }
}
