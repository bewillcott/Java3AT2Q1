/*
 *  File Name:    Ref.java
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
 * Date: 26 July 2021
 * ****************************************************************
 */
package com.bewsoftware.tafe.java3.at2.q1.utils;

/**
 * This is a struct used to pass another object into a method and/or return a
 * different/new object of that type.Similar to the {@code out }keyword in C#.
 *
 * @param <T> the type of the object being 'referenced'
 *
 * @author <a href="mailto:bw.opensource@yahoo.com">Bradley Willcott</a>
 *
 * @since 1.0
 * @version 1.0
 */
public class Ref<T> {

    /**
     * Default constructor.
     */
    public Ref() {
        // Nothing to do.
    }

    /**
     *
     */
    public T val;
}
