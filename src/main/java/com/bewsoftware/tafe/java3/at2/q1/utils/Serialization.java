/*
 *  File Name:    Serialization.java
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
 * Date: 25 July 2021
 * ****************************************************************
 */
package com.bewsoftware.tafe.java3.at2.q1.utils;

import java.io.*;

/**
 * Utility class that provides methods for writing and reading serialized data.
 *
 * @author <a href="mailto:bw.opensource@yahoo.com">Bradley Willcott</a>
 *
 * @since 1.0
 * @version 1.0
 */
public class Serialization {

    /**
     * Create a new object from the contents of the binary file.
     *
     * @param <T>      class of object to store
     * @param t        object to store
     * @param filename binary file to read from
     *
     * @return newly created object
     *
     * @throws IOException            if any
     * @throws ClassNotFoundException if any
     */
    @SuppressWarnings("unchecked")
    public static <T> T read(T t, final String filename) throws IOException, ClassNotFoundException {
        T rtn = t;

        File file = new File(filename);
        if (file.exists())
        {
            try (ObjectInputStream objToread = new ObjectInputStream(new FileInputStream(filename)))
            {
                rtn = (T) objToread.readObject();
            }
        }

        return rtn;
    }

    /**
     * Write out the object to the binary file.
     *
     * @param <T>      class of object to store
     * @param t        object to store
     * @param filename binary file to write to
     *
     * @throws IOException if any
     */
    public static <T> void write(final T t, final String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename)))
        {
            oos.writeObject(t);
        }
    }

    /**
     * Not normally instantiated.
     */
    private Serialization() {
    }
}
