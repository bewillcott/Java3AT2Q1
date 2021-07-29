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
package com.bewsoftware.tafe.java3.at2.q1.classes;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Iterator;
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
public class Country implements Comparable<Country>, Externalizable, Iterable<Country.City> {

    /**
     * Error message text.
     */
    private static final String DATA_ITEGRITY_FAILED = "data integrity failed.";

    /**
     * Used by serialization process.
     */
    private static final long serialVersionUID = -8556410555437835899L;

    /**
     * Storage for the cities
     */
    private transient SortedSet<City> cities = new TreeSet<>();

    /**
     * The country's name
     */
    private String name;

    /**
     * Default constructor for deserialization.
     */
    public Country() {
    }

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

    /**
     * Stores the new city.
     *
     * @param city       name
     * @param population of city
     *
     * @return {@code true } if successful, {@code false } otherwise
     */
    public boolean addCity(final String city, final int population) {
        return cities.add(new City(Objects.requireNonNull(city, "City's name must not be null!"),
                                   population));
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
     * Get the City object with the required name.
     *
     * @param name of required city
     *
     * @return City object if found, {@code  null } otherwise
     */
    public City getCity(String name) {
        for (City city : cities)
        {
            if (city.name.equals(name))
            {
                return city;
            }
        }

        return null;
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

    @Override
    public Iterator<City> iterator() {
        return cities.iterator();
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int hashCode;
        int totalHashCode;

        // process 'name'
        name = (String) in.readObject();
        hashCode = in.readInt();
        totalHashCode = hashCode;

        if (name.hashCode() != hashCode)
        {
            throw new IOException(DATA_ITEGRITY_FAILED);
        }

        // process 'cities'
        int numOfCities = in.readInt();
        hashCode = in.readInt();
        totalHashCode += hashCode;

        if (Objects.hashCode(numOfCities) != hashCode)
        {
            throw new IOException(DATA_ITEGRITY_FAILED);
        }

        for (int i = 0; i < numOfCities; i++)
        {
            // process 'city'
            City city = (City) in.readObject();
            hashCode = in.readInt();
            totalHashCode += hashCode;

            if (city.hashCode() != hashCode)
            {
                throw new IOException(DATA_ITEGRITY_FAILED);
            }

            cities.add(city);
        }

        // process 'finish'
        int thc = in.readInt();

        if (totalHashCode != thc)
        {
            throw new IOException(DATA_ITEGRITY_FAILED);
        }
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        int hashCode;
        int totalHashCode;

        // process 'name'
        out.writeObject(name);
        hashCode = name.hashCode();
        totalHashCode = hashCode;
        out.writeInt(hashCode);

        // process 'cities'
        int numOfCities = cities.size();
        out.writeInt(numOfCities);
        hashCode = Objects.hashCode(numOfCities);
        totalHashCode += hashCode;
        out.writeInt(hashCode);

        for (City city : cities)
        {
            out.writeObject(city);
            hashCode = city.hashCode();
            totalHashCode += hashCode;
            out.writeInt(hashCode);
        }

        // finish
        out.writeInt(totalHashCode);
    }

    /**
     * Holds data about a single city.
     */
    public static class City implements Comparable<City>, Externalizable {

        /**
         * Used by the serialization process.
         */
        private static final long serialVersionUID = 13869021485029436L;

        /**
         * The city's name.
         */
        private String name;

        /**
         * The population of the city.
         */
        private int population;

        /**
         * Default constructor for deserialization.
         */
        public City() {
        }

        /**
         * Instantiate a new City.
         *
         * @param name of city
         */
        public City(final String name) {
            this.name = name;
        }

        /**
         * Instantiate a new City.
         *
         * @param name       of city
         * @param population of the city
         */
        public City(final String name, final int population) {
            this.name = name;
            this.population = population;
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
            int hash = 5;
            hash = 43 * hash + Objects.hashCode(this.name);
            hash = 43 * hash + this.population;
            return hash;
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            int hashCode;
            int totalHashCode;

            // process 'name'
            name = (String) in.readObject();
            hashCode = in.readInt();
            totalHashCode = hashCode;

            if (name.hashCode() != hashCode)
            {
                throw new IOException(DATA_ITEGRITY_FAILED);
            }

            // process 'population'
            population = in.readInt();
            hashCode = in.readInt();
            totalHashCode += hashCode;

            if (Objects.hashCode(population) != hashCode)
            {
                throw new IOException(DATA_ITEGRITY_FAILED);
            }

            // process 'finish'
            int thc = in.readInt();

            if (totalHashCode != thc)
            {
                throw new IOException(DATA_ITEGRITY_FAILED);
            }
        }

        @Override
        public String toString() {
            return "City{" + "name = " + name + '}';
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            int hashCode;
            int totalHashCode;

            // process 'name'
            out.writeObject(name);
            hashCode = name.hashCode();
            totalHashCode = hashCode;
            out.writeInt(hashCode);

            // process 'population'
            out.writeInt(population);
            hashCode = Objects.hashCode(population);
            totalHashCode += hashCode;
            out.writeInt(hashCode);

            // finish
            out.writeInt(totalHashCode);
        }
    }
}
