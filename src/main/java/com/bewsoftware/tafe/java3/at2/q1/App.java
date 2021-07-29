/*
 *  File Name:    App.java
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

import com.bewsoftware.tafe.java3.at2.q1.classes.Country;
import com.bewsoftware.tafe.java3.at2.q1.gui.Dialogs;
import com.bewsoftware.tafe.java3.at2.q1.gui.MainWindowController;
import com.bewsoftware.tafe.java3.at2.q1.utils.LinkedList;
import com.bewsoftware.tafe.java3.at2.q1.utils.Serialization;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The is the application entry point.
 *
 * @author <a href="mailto:bw.opensource@yahoo.com">Bradley Willcott</a>
 *
 * @since 1.0
 * @version 1.0
 */
public class App extends Application {

    /**
     * Filename of serialized data.
     * <p>
     * This is the Country stored data.
     */
    private static final String DATA_FILENAME = "Java3AT2Q1.dat";

    private static final String APP_TITLE = "Java3 AT2 Question 1";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    /**
     * Linked list containing all the countries.
     */
    private LinkedList<Country> countries;

    /**
     * The FXML Loader instance.
     */
    private FXMLLoader fxmlLoader;

    /**
     * The Scene instance.
     */
    private Scene scene;

    /**
     * Default constructor.
     */
    public App() {
        // Nothing to do.
    }

    @Override
    public void start(Stage primaryStage) throws IOException, ClassNotFoundException {
        countries = new LinkedList<>(false);

        try
        {
            countries = Serialization.read(countries, DATA_FILENAME);

        } catch (IOException | ClassNotFoundException e)
        {
            Dialogs.displayMessage("Loading data file",
                                   "The data was found to be corrupted.\nUnable to read in.");
        }

        scene = new Scene(loadFXML("/fxml/MainWindow"), 450, 300);
        MainWindowController mwc = fxmlLoader.getController();
        mwc.setCountries(countries);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle(APP_TITLE);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        Serialization.write(countries, DATA_FILENAME);
    }

    /**
     * Find and load an fxml file.
     *
     * @param fxml name of file to load
     *
     * @return the loaded object hierarchy
     *
     * @throws IOException if any
     */
    private Parent loadFXML(String fxml) throws IOException {
        URL url = App.class.getResource(fxml + ".fxml");
        fxmlLoader = new FXMLLoader(url);
        return fxmlLoader.load();
    }

}
