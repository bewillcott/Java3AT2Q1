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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
    private final List<City> cities = new ArrayList<>();

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
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.name);
        return hash;
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

    @Override
    public int compareTo(Country o) {
        return name.compareTo(o.name);
    }

    /**
     * The number of cities in this country.
     *
     * @return number of cities
     */
    public int size() {
        return cities.size();
    }

    /**
     * Get country name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Stores the new city.
     *
     * @param name of city
     *
     * @return {@code true } if successful
     */
    public boolean add(final String name) {
        return cities.add(new City(Objects.requireNonNull(name, "name must not be null")));
    }

    /**
     * Get sorted list of cities in this country.
     *
     * @return array of cities
     */
    public City[] getCities() {
        City[] arrCities = cities.toArray(new City[cities.size()]);
        Arrays.sort(arrCities);
        return arrCities;
    }

    @Override
    public String toString() {
        return "Country{ name = " + name + "\ncities = " + cities + '}';
    }

    /**
     * Holds data about a single city.
     */
    public class City {

        /**
         * The city's name.
         */
        private final String name;

        /**
         * Instantiate a new City.
         *
         * @param name of city
         */
        public City(final String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "City{" + "name=" + name + '}';
        }
    }
}
