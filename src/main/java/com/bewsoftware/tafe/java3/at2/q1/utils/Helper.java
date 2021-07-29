/*
 *  File Name:    Helper.java
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
 * Date: 27 July 2021
 * ****************************************************************
 */
package com.bewsoftware.tafe.java3.at2.q1.utils;

/**
 * Contains a helper method.
 *
 * @author <a href="mailto:bw.opensource@yahoo.com">Bradley Willcott</a>
 *
 * @since 1.0
 * @version 1.0
 */
public class Helper {

    /**
     * Process a string trying to parse it into an int.
     *
     * @param value  string to parse
     * @param rtnVal struct to hold the parsed int
     *
     * @return {@code true } if successful, {@code false } otherwise
     */
    public static boolean tryParseInt(final String value, Ref<Integer> rtnVal) {
        boolean rtn = false;

        try
        {
            rtnVal.val = Integer.parseInt(value);
            rtn = true;
        } catch (NumberFormatException e)
        {
            // Ignore it
        }

        return rtn;
    }

    /**
     * Not meant to be instantiated.
     */
    private Helper() {
    }
}
