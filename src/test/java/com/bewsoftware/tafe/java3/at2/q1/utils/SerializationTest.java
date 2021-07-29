/*
 *  File Name:    SerializationTest.java
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

import java.io.File;
import org.junit.jupiter.api.*;

import static com.bewsoftware.tafe.java3.at2.q1.utils.Serialization.read;
import static com.bewsoftware.tafe.java3.at2.q1.utils.Serialization.write;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author <a href="mailto:bw.opensource@yahoo.com">Bradley Willcott</a>
 */
public class SerializationTest {

    /**
     * Name of file to use in tests.
     */
    private static final String FILENAME = "SerializationTest.dat";

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    public SerializationTest() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
        File file = new File(FILENAME);
        if (file.exists())
        {
            file.delete();
        }
    }

    /**
     * Test of read method, of class Serialization.
     */
    @Test
    public void testRead() throws Exception {
        String text = "No file!";

        String rtn = read(text, FILENAME);

        assertEquals(0, text.compareTo(rtn), "Failed to compare as equal!");
    }

    /**
     * Test of write and read methods, of class Serialization.
     */
    @Test
    public void testWriteRead() throws Exception {
        String text = "Some text to write.";

        // Store it
        write(text, FILENAME);

        // Get it back
        String rtn = read(text, FILENAME);

        assertEquals(0, text.compareTo(rtn), "Failed to compare as equal!");
    }
}
