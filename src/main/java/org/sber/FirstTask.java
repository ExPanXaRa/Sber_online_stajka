package org.sber;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FirstTask {

    static void readFileInCity(String path, List<City> cities) {
        File file = new File(path);
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                String[] separatedData = data.split(";");
                int tempPopulation = 0;

                if (separatedData.length < 6) {
                    String[] tempArr = new String[separatedData.length + 1];
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
            System.out.println("Файл не найден");
        }
    }

    public static void main(String[] args) {
        List<City> cities = new ArrayList<>();
        String path = "src/main/resources/Задача ВС Java Сбер.csv";

        readFileInCity(path, cities);
        Sort.sortBySity(cities);
        Sort.sortByDistrictAndSity(cities);

        for (City city : cities) {
            System.out.println(city.toString());
        }
    }
}