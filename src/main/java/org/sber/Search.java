package org.sber;

public class Search {
    static int[] searchMaxPopulation(City[] cityArray) {
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
        int[] result = searchMaxPopulation(cityArray);
        System.out.println("[" + result[0] + "] = " + result[1]);
    }
}
