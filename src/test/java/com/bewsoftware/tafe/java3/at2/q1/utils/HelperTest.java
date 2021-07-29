/*
 *  File Name:    HelperTest.java
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
 * Date: 28 July 2021
 * ****************************************************************
 */
package com.bewsoftware.tafe.java3.at2.q1.utils;

import org.junit.jupiter.api.*;

import static com.bewsoftware.tafe.java3.at2.q1.utils.Helper.tryParseInt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author <a href="mailto:bw.opensource@yahoo.com">Bradley Willcott</a>
 */
public class HelperTest {

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    public HelperTest() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of tryParseInt method, of class Helper.
     * <p>
     * Expecting a {@code false } response.
     */
    @Test
    public void testTryParseIntFalse() {
        Ref<Integer> rtnVal = new Ref<>();

        assertFalse(tryParseInt("A", rtnVal), "Failed to parse!");
        assertNull(rtnVal.val, "Failed to return correct value!");

        assertFalse(tryParseInt("A123", rtnVal), "Failed to parse!");
        assertNull(rtnVal.val, "Failed to return correct value!");

        assertFalse(tryParseInt("Hi there!", rtnVal), "Failed to parse!");
        assertNull(rtnVal.val, "Failed to return correct value!");
    }

    /**
     * Test of tryParseInt method, of class Helper.
     * <p>
     * Expecting a {@code true } response.
     */
    @Test
    public void testTryParseIntTrue() {
        Ref<Integer> rtnVal = new Ref<>();

        assertTrue(tryParseInt("10", rtnVal), "Failed to parse!");
        assertEquals(10, rtnVal.val, "Failed to return correct value!");

        assertTrue(tryParseInt("123", rtnVal), "Failed to parse!");
        assertEquals(123, rtnVal.val, "Failed to return correct value!");

        assertTrue(tryParseInt("-123", rtnVal), "Failed to parse!");
        assertEquals(-123, rtnVal.val, "Failed to return correct value!");
    }

}
