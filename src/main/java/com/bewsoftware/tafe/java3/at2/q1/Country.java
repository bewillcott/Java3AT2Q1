/*
 *  File Name:    Country.java
 *  Project Name: Java3AT2Q1
 *
 *  Copyright (c) 2021 Bradley Willcott
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * ****************************************************************
 * Name: Bradley Willcott
 * ID:   M198449
 * Date: 22 July 2021
 * ****************************************************************
 */
package com.bewsoftware.tafe.java3.at2.q1;

import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This class stores information about a country.
 * <p>
 * It also contains an inner class for cities.
 *
 * @author <a href="mailto:bw.opensource@yahoo.com">Bradley Willcott</a>
 *
 * @since 1.0
 * @version 1.0
 */
public class Country implements Comparable<Country> {

    /**
     * Storage for the cities
     */
    private final SortedSet<City> cities = new TreeSet<>();

    /**
     * The country's name
     */
    private final String name;

    /**
     * Instantiate a new Country
     *
     * @param name of country
     */
    public Country(final String name) {
        this.name = Objects.requireNonNull(name, "The country's name must not be null!");
    }

    /**
     * Stores the new city.
     *
     * @param city name
     *
     * @return {@code true } if successful, {@code false } otherwise
     */
    public boolean addCity(final String city) {
        return cities.add(new City(Objects.requireNonNull(city, "City's name must not be null!")));
    }

    @Override
    public int compareTo(Country o) {
        return name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Country other = (Country) obj;
        return Objects.equals(this.name, other.name);
    }

    /**
     * Get sorted array of the cities in this country.
     *
     * @return array of cities
     */
    public City[] getCities() {
        return cities.toArray(new City[cities.size()]);
    }

    /**
     * Get the country's name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get number of cities in this country.
     *
     * @return number of cities
     */
    public int getNumberOfCities() {
        return cities.size();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.name);
        return hash;
    }

    /**
     * The number of cities in this country.
     *
     * @return number of cities
     */
    public int size() {
        return cities.size();
    }

    @Override
    public String toString() {
        return "Country{ name = " + name + "\ncities = " + cities + '}';
    }

    /**
     * Holds data about a single city.
     */
    public class City implements Comparable<City> {

        /**
         * The city's name.
         */
        private final String name;

        /**
         * The population of the city.
         */
        private int population;

        /**
         * Instantiate a new City.
         *
         * @param name of city
         */
        public City(final String name) {
            this.name = name;
        }

        @Override
        public int compareTo(City o) {
            return name.compareTo(Objects.requireNonNull(o, "Can't compare with a null City object").getName());
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
            {
                return true;
            }
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            final City other = (City) obj;
            return Objects.equals(this.name, other.name);
        }

        /**
         * Get the name.
         *
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * Get the population.
         *
         * @return the population
         */
        public int getPopulation() {
            return population;
        }

        /**
         * Set the population to value.
         *
         * @param value to set
         */
        public void setPopulation(final int value) {
            population = value;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 47 * hash + Objects.hashCode(this.name);
            return hash;
        }

        @Override
        public String toString() {
            return "City{" + "name=" + name + '}';
        }
    }
}
