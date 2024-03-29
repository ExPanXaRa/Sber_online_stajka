package org.sber;

public class City {
    private final String name;
    private final String region;
    private final String district;
    private final int population;
    private final String foundation;

    City(String name, String region, String district, int population, String foundation) {
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    @Override
    public String toString() {
        return "City{name='" + name + "', region='" + region + "', district='" + district +
                "', population=" + population + ", foundation='" + foundation + "'}";
    }

    String getName() {
        return name;
    }

    String getDistrict() {
        return district;
    }

    String getRegion() {
        return region;
    }

    int getPopulation() {
        return population;
    }


}