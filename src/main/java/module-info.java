/*
 *  File Name:    module-info.java
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

/**
 * This module contains the files required to develop and run the program associated
 * with this project: Java3 AT2 Q1.
 *
 * @author <a href="mailto:bw.opensource@yahoo.com">Bradley Willcott</a>
 *
 * @since 1.0
 * @version 1.0
 */
module Java3AT2Q1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens com.bewsoftware.tafe.java3.at2.q1.gui to javafx.fxml;
    exports com.bewsoftware.tafe.java3.at2.q1;

    // These packages are exported to allow the Javadoc program to
    // process them and produce Project Level API documentation,
    // instead of the ussual external Developer Level API documentation.
    exports com.bewsoftware.tafe.java3.at2.q1.classes;
    exports com.bewsoftware.tafe.java3.at2.q1.gui;
    exports com.bewsoftware.tafe.java3.at2.q1.utils;
}
