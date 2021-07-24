/*
 *  File Name:    CountryTest.java
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
 * Date: 24 July 2021
 * ****************************************************************
 */
package com.bewsoftware.tafe.java3.at2.q1;

import com.bewsoftware.tafe.java3.at2.q1.Country.City;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author <a href="mailto:bw.opensource@yahoo.com">Bradley Willcott</a>
 */
public class CountryTest {

    /**
     * Names of cities to test with.
     */
    private static final String[] CITIES =
    {
        "Canberra", "Adelaide", "Perth", "Sydney", "Melbourne", "Brisbane", "Darwin", "Hobart"
    };

    /**
     * Name of test country to test with.
     */
    private static final String COUNTRY_NAME = "Australia";

    /**
     * Name of test country to test with that sorts above {@value #COUNTRY_NAME }.
     */
    private static final String COUNTRY_NAME1 = "Antarctica";

    /**
     * Name of test country to test with that sorts below {@value #COUNTRY_NAME }.
     */
    private static final String COUNTRY_NAME2 = "Canada";

    /**
     * The number of cities to initially load.
     */
    private static final int NUMBER_OF_CITIES_TO_TEST = 4;

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }
    /**
     * Globally accessible Country.
     */
    private Country country;

    public CountryTest() {
    }

    @BeforeEach
    public void setUp() {
        country = new Country(COUNTRY_NAME);

        try
        {
            for (int i = 0; i < NUMBER_OF_CITIES_TO_TEST; i++)
            {
                country.addCity(CITIES[i]);
            }
        } catch (Exception ex)
        {
            System.err.println("country.addCity() - failed:\n");
            ex.printStackTrace();
        }
    }

    @AfterEach
    public void tearDown() {
        country = null;
    }

    /**
     * Test of addCity method, of class Country.
     */
    @Test
    public void testAddCity() {
        assertTrue(country.addCity(CITIES[5]), "Failed to add a city.");
    }

    /**
     * Test of addCity method, of class Country.
     */
    @Test
    public void testAddDuplicateCity() {
        assertFalse(country.addCity(CITIES[2]), "Failed: Added a duplicate city.");
    }

    /**
     * Test of compareTo method, of class Country.
     */
    @Test
    public void testCompareToDifferent1() {
        Country testCountry = new Country(COUNTRY_NAME1);
        assertTrue(country.compareTo(testCountry) > 0, "Failed to compare country of different name!");
    }

    /**
     * Test of compareTo method, of class Country.
     */
    @Test
    public void testCompareToDifferent2() {
        Country testCountry = new Country(COUNTRY_NAME2);
        assertTrue(country.compareTo(testCountry) < 0, "Failed to compare country of different name!");
    }

    /**
     * Test of compareTo method, of class Country.
     */
    @Test
    public void testCompareToSame() {
        Country testCountry = new Country(COUNTRY_NAME);
        assertEquals(0, country.compareTo(testCountry), "Failed to compare country of same name!");
    }

    /**
     * Test of equals method, of class Country.
     */
    @Test
    public void testEqualsToDifferent1() {
        Country testCountry = new Country(COUNTRY_NAME1);
        assertFalse(country.equals(testCountry), "Failed equals test - country of different name!");
    }

    /**
     * Test of equals method, of class Country.
     */
    @Test
    public void testEqualsToDifferent2() {
        Country testCountry = new Country(COUNTRY_NAME2);
        assertFalse(country.equals(testCountry), "Failed equals test - country of different name!");
    }

    /**
     * Test of equals method, of class Country.
     */
    @Test
    public void testEqualsToSame() {
        Country testCountry = new Country(COUNTRY_NAME);
        assertTrue(country.equals(testCountry), "Failed equals test - country of same name!");
    }

    /**
     * Test of getCities method, of class Country.
     */
    @Test
    public void testGetCities() {
        City[] cities = country.getCities();
        assertEquals(country.getNumberOfCities(), cities.length,
                     "Failed - wrong number of cities returned!");
    }

    /**
     * Test of getName method, of class Country.
     */
    @Test
    public void testGetName() {
        assertNotNull(country.getName(), "Failed - country.name is null!");
    }

    /**
     * Test of hashCode method, of class Country.
     */
    @Test
    public void testHashCodeDifferentName1() {
        int hashCode = country.hashCode();
        int hashCode1 = new Country(COUNTRY_NAME1).hashCode();
        assertNotEquals(hashCode, hashCode1,
                        "Failed - hashcodes were the same for a different country name!");
        assertTrue(hashCode > hashCode1,
                   "Failed - " + COUNTRY_NAME + "'s hashcode was not greater than " + COUNTRY_NAME1 + "'s hashcode!");
    }

    /**
     * Test of hashCode method, of class Country.
     */
    @Test
    public void testHashCodeDifferentName2() {
        int hashCode = country.hashCode();
        int hashCode2 = new Country(COUNTRY_NAME2).hashCode();
        assertNotEquals(hashCode, hashCode2,
                        "Failed - hashcodes were the same for a different country name!");
        assertTrue(hashCode < hashCode2,
                   "Failed - " + COUNTRY_NAME + "'s hashcode was not greater than " + COUNTRY_NAME2 + "'s hashcode!");
    }

    /**
     * Test of hashCode method, of class Country.
     */
    @Test
    public void testHashCodeSameName() {
        int hashCode = country.hashCode();
        assertEquals(hashCode, new Country(COUNTRY_NAME).hashCode(),
                     "Failed - hashcodes weren't the same for the same country name!");
    }

    /**
     * Test of size method, of class Country.
     */
    @Test
    public void testSize() {
        assertEquals(NUMBER_OF_CITIES_TO_TEST, country.size(), "Failed - wrong number of cities returned!");
    }

    /**
     * Test of toString method, of class Country.
     */
    @Test
    public void testToString() {
        assertNotNull(country.toString(), "Failed - toString() returned null!");
    }

}
