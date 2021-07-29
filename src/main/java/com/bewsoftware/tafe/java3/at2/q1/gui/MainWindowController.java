/*
 *  File Name:    MainWindowController.java
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
package com.bewsoftware.tafe.java3.at2.q1.gui;

import com.bewsoftware.tafe.java3.at2.q1.classes.Country;
import com.bewsoftware.tafe.java3.at2.q1.classes.Country.City;
import com.bewsoftware.tafe.java3.at2.q1.utils.LinkedList;
import com.bewsoftware.tafe.java3.at2.q1.utils.Ref;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static com.bewsoftware.tafe.java3.at2.q1.gui.Dialogs.displayMessage;
import static com.bewsoftware.tafe.java3.at2.q1.utils.Helper.tryParseInt;

/**
 * FXML Controller class for the {@code MainWindow.fxml } file.
 *
 * @author <a href="mailto:bw.opensource@yahoo.com">Bradley Willcott</a>
 *
 * @since 1.0
 * @version 1.0
 */
public class MainWindowController {

    /**
     * Just to keep build process happy.
     * <p>
     * Need to export this class's package so it can be documented in the Javadoc API.
     */
    public MainWindowController() {
        // Nothing to do.
    }

    /**
     * fx:id="btnAddCity"
     */
    @FXML
    private Button btnAddCity; // Value injected by FXMLLoader
    /**
     * Holds all the button objects.
     */
    private ButtonStruct buttonData;

    /**
     * Holds all the city objects.
     */
    private CityStruct cityData;

    /**
     * Holds all the country objects.
     */
    private CountryStruct countryData;

    /**
     * fx:id="ivAddCity"
     */
    @FXML
    private ImageView ivAddCity; // Value injected by FXMLLoader

    /**
     * fx:id="ivAddCountry"
     */
    @FXML
    private ImageView ivAddCountry; // Value injected by FXMLLoader

    /**
     * fx:id="lblPopVal"
     */
    @FXML
    private Label lblPopVal; // Value injected by FXMLLoader

    /**
     * fx:id="lbCities"
     */
    @FXML
    private ListView<String> lvCities; // Value injected by FXMLLoader

    /**
     * fx:id="lbCountries"
     */
    @FXML
    private ListView<String> lvCountries; // Value injected by FXMLLoader

    /**
     * fx:id="txtCity"
     */
    @FXML
    private TextField txtCity; // Value injected by FXMLLoader

    /**
     * fx:id="txtCountry"
     */
    @FXML
    private TextField txtCountry; // Value injected by FXMLLoader

    /**
     * fx:id="txtPopulation"
     */
    @FXML
    private TextField txtPopulation;

    /**
     * Set the Linked list containing all the countries.
     *
     * @param countries the linked list
     */
    public void setCountries(final LinkedList<Country> countries) {
        countryData.lList = countries;
        updateLvCountries();
    }

    /**
     * The event handler for the btnAddCity button's Click event.
     *
     * @param event data
     */
    @FXML
    private void btnAddCityClick(ActionEvent event) {
        // Get current text values from the TextFields
        String text = txtCity.getText();
        String tPop = txtPopulation.getText();

        // Do we have both, a country and a city to work with?
        if (countryData.selected != null && !text.isEmpty())
        { // Yes - What are we doing?
            switch (btnAddCity.getText())
            {
                // Adding a new city ...
                case ButtonStruct.ADD ->
                {
                    // Is there something in the population TextField to process?
                    if (!tPop.isBlank())
                    { // Yes - Prepare return value holder
                        Ref<Integer> pop = new Ref<>();

                        // Do we have a valid integer?
                        if (tryParseInt(tPop, pop))
                        { // Yes - Add a new city object
                            countryData.selected.addCity(text, pop.val);
                            txtCity.clear();
                            txtPopulation.clear();
                            updateLvCities();
                        } else
                        { // No - Display message
                            displayMessage("New City Information", "The population must be a valid whole number.");
                            txtPopulation.requestFocus();
                            txtPopulation.selectAll();
                        }
                    } else
                    { // No - Add a new city object (pop: 0)
                        countryData.selected.addCity(text);
                        txtCity.clear();
                        updateLvCities();
                    }
                }

                // Changing the population value for this city ...
                case ButtonStruct.ACCEPT ->
                {
                    // Is there something in the population TextField to process?
                    if (!tPop.isBlank())
                    { // Yes - Prepare return value holder
                        Ref<Integer> pop = new Ref<>();

                        // Do we have a valid integer?
                        if (tryParseInt(tPop, pop))
                        { // Yes - Update value in city object
                            cityData.selected.setPopulation(pop.val);
                            updateLvCities();
                        } else
                        { // No - Display message
                            displayMessage("New City Information", "The population must be a valid whole number.");
                            txtPopulation.requestFocus();
                            txtPopulation.selectAll();
                        }
                    } else
                    { // No - Reset population value in city object
                        cityData.selected.setPopulation(0);
                        updateLvCities();
                    }
                }

                default ->
                {
                    // Nothing to do
                }
            }
        }
    }

    /**
     * The event handler for the btnAddCountry button's Click event.
     *
     * @param event data
     */
    @FXML
    private void btnAddCountryClick(ActionEvent event) {
        // Get current text value from the TextField
        String text = txtCountry.getText();

        // Is there something to process?
        // if so, then was it sucessfully added to the list?
        if (!text.isEmpty() && countryData.lList.add(new Country(text)))
        { // Yes - finish up
            updateLvCountries();
            txtCountry.clear();
            countryData.selection.select(text);
        }
    }

    /**
     * This method is called by the FXMLLoader when initialization is complete.
     */
    @FXML
    private void initialize() {

        // Check that all the FXML variables were successfully injected by FXMLLoader
        assert txtCountry != null : "fx:id=\"txtCountry\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert ivAddCountry != null : "fx:id=\"ivAddCountry\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert lvCountries != null : "fx:id=\"lvCountries\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert lblPopVal != null : "fx:id=\"lblPopVal\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert txtCity != null : "fx:id=\"txtCity\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert txtPopulation != null : "fx:id=\"txtPopulation\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert btnAddCity != null : "fx:id=\"btnAddCity\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert ivAddCity != null : "fx:id=\"ivAddCity\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert lvCities != null : "fx:id=\"lvCities\" was not injected: check your FXML file 'MainWindow.fxml'.";

        // Create the Button icon images
        buttonData = new ButtonStruct();
        buttonData.bluePlus = new Image(ButtonStruct.BLUE_PLUS_ICON);
        buttonData.greenAccept = new Image(ButtonStruct.GREEN_ACCEPT_ICON);

        // Set the initial images to replace the development placeholders
        ivAddCountry.setImage(buttonData.bluePlus);
        ivAddCity.setImage(buttonData.bluePlus);

        // Setup sorted list for the countries ListView
        countryData = new CountryStruct();
        countryData.oList = lvCountries.itemsProperty().get();
        SortedList<String> sList = new SortedList<>(countryData.oList, String::compareTo);
        lvCountries.setItems(sList);

        // Get the SelectionModel for the countries ListView
        countryData.selection = lvCountries.getSelectionModel();
        countryData.selection.getSelectedItems().addListener((ListChangeListener.Change<? extends String> c) ->
        {
            // Process next change
            while (c.next())
            {
                // Has a country has been selected?
                if (c.wasAdded())
                { // Yes - Get the Country object and update the cities ListView
                    String temp = c.getAddedSubList().get(0);
                    countryData.selected = countryData.lList.get(new Country(temp));
                    updateLvCities();

                    // Has a country has been deselected?
                } else if (c.wasRemoved())
                { // Yes - Clear the county reference and update the cities ListView
                    countryData.selected = null;
                    updateLvCities();
                }
            }
        });

        // Get the ObservableList for the cities ListView
        cityData = new CityStruct();
        cityData.oList = lvCities.itemsProperty().get();

        // Get the SelectionModel for the cities ListView
        cityData.selection = lvCities.getSelectionModel();
        cityData.selection.getSelectedItems().addListener((ListChangeListener.Change<? extends String> c) ->
        {
            // Process next change
            while (c.next())
            {
                // Has a city has been selected?
                if (c.wasAdded())
                { // Yes - Get the City object
                    String selected = c.getAddedSubList().get(0);
                    String[] cityString = selected.split(" \\[");
                    cityData.selected = countryData.selected.getCity(cityString[0]);

                    // Display the city's information in the TextFields
                    txtCity.setText(cityData.selected.getName());
                    txtCity.setDisable(true);  // Don't want users changing this

                    txtPopulation.setText("" + cityData.selected.getPopulation());
                    txtPopulation.requestFocus();

                    btnAddCity.setText(ButtonStruct.ACCEPT);
                    ivAddCity.setImage(buttonData.greenAccept);

                    // A city has been deselected
                } else if (c.wasRemoved())
                { // Yes - Reset everything
                    txtCity.clear();
                    txtCity.setDisable(false);
                    txtCity.setStyle("");
                    txtPopulation.clear();
                    cityData.selected = null;
                    btnAddCity.setText(ButtonStruct.ADD);
                    ivAddCity.setImage(buttonData.bluePlus);
                }
            }
        });
    }

    /**
     * Update the ListView containing the cities.
     */
    private void updateLvCities() {
        cityData.oList.clear();

        // Do we have a country to work with?
        if (countryData.selected != null)
        { // Yes
            for (Country.City city : countryData.selected)
            {
                cityData.oList.add(city.getName() + " [" + city.getPopulation() + "]");
            }
        }
    }

    /**
     * Update the ListView containing the countries.
     */
    private void updateLvCountries() {
        countryData.oList.clear();

        for (Country country : countryData.lList)
        {
            countryData.oList.add(country.getName());
        }
    }

    /**
     * A struct to hold the collection of objects related to the buttons.
     *
     * @since 1.0
     * @version 1.0
     */
    private class ButtonStruct {

        /**
         * Icon filename path.
         */
        public static final String BLUE_PLUS_ICON = "/blue-add-button-25.png";

        /**
         * Button text constant.
         */
        public static final String ACCEPT = "Accept";

        /**
         * Button text constant.
         */
        public static final String ADD = "Add";

        /**
         * Icon filename path.
         */
        public static final String GREEN_ACCEPT_ICON = "/green-accept-button-25.png";

        /**
         * Replacement image for "Add".
         */
        public Image bluePlus;

        /**
         * Replacement image for "Accept".
         */
        public Image greenAccept;

    }

    /**
     * A struct to hold the collection of objects related to cities.
     *
     * @since 1.0
     * @version 1.0
     */
    private class CityStruct {

        /**
         * The Observable list used inside the lvCountries ListView.
         */
        public ObservableList<String> oList;

        /**
         * The currently selected city.
         */
        public City selected;

        /**
         * The SelectionModel used inside the lvCountries ListView.
         */
        public MultipleSelectionModel<String> selection;
    }

    /**
     * A struct to hold the collection of objects related to countries.
     *
     * @since 1.0
     * @version 1.0
     */
    private class CountryStruct {

        /**
         * Linked list containing all the countries.
         */
        public LinkedList<Country> lList;

        /**
         * The Observable list used inside the lvCountries ListView.
         */
        public ObservableList<String> oList;

        /**
         * The currently selected country.
         */
        public Country selected;

        /**
         * The SelectionModel used inside the lvCountries ListView.
         */
        public MultipleSelectionModel<String> selection;
    }

}
