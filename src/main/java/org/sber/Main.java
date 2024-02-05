package org.sber;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    static void readFileInModel(String path, List<City> cities) {
        if (cities == null || path == null) {
            throw new NullPointerException("cities or path is null");
        }

        File file = new File(path);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] separatedData = line.split(";");
                int tempPopulation = 0;

                if (separatedData.length < 6) {
                    String[] tempArr = new String[6];
                    System.arraycopy(separatedData, 0, tempArr, 0, separatedData.length);
                    separatedData = tempArr;
                }

                try {
                    tempPopulation = Integer.parseInt(separatedData[4]);
                } catch (NumberFormatException e) {
                    // System.out.println("Ошибка при преобразовании типов: " + e.getMessage()); // не уверен нужно ли выводить
                }

                cities.add(new City(separatedData[1], separatedData[2], separatedData[3], tempPopulation, separatedData[5]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void printListOfModel(List<City> cities) {
        if (cities == null) {
            throw new NullPointerException("cities is null");
        }
        for (City city : cities) {
            System.out.println(city.toString());
        }
    }

    static void printRegionsAndCities(Map<String, Integer> numCitiesInRegion) {
        if (numCitiesInRegion == null) {
            throw new NullPointerException("numCitiesInRegion is null");
        }
        for (Map.Entry<String, Integer> entry : numCitiesInRegion.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }


    public static void main(String[] args) {
        // 1 задание
        List<City> cities = new ArrayList<>();
        String path = "src\\main\\resources\\Задача ВС Java Сбер.csv";
        readFileInModel(path, cities);
        printListOfModel(cities);

        // 2 задание
        SortListOfCities.sortByCity(cities);
        SortListOfCities.sortByDistrictAndCity(cities);
        printListOfModel(cities);

        // 3 задание
        City[] cityArray = cities.toArray(new City[0]);
        int[] maxPopulation = SearchListOfCities.MaxPopulation(cityArray);
        SearchListOfCities.printIndexAndMaxPopulation(cityArray);

        // 4 задание
        Map<String, Integer> numCitiesInRegion = CalcListOfCities.NumberOfCityInRegion(cities);
        printRegionsAndCities(numCitiesInRegion);
    }
}