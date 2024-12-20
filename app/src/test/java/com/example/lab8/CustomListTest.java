package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    //The following tests are from ChatGPT, "Help with the following: (test requirements)", 2024-10-25
    @Test
    public void hasCityTest() {
        list = MockCityList();
        City city = new City("Regina", "SK");
        list.addCity(city);
        assertEquals(true, list.hasCity(city)); // This will initially fail
    }

    @Test
    public void deleteCityTest() {
        list = MockCityList();
        City city = new City("Regina", "SK");
        list.addCity(city); // Add city first
        assertEquals(true, list.hasCity(city)); // Ensure city was added

        list.deleteCity(city); // Delete city
        assertEquals(false, list.hasCity(city)); // Check if city was deleted
    }

    @Test
    public void countCitiesTest() {
        list = MockCityList();
        assertEquals(0, list.countCities()); // Initially, the list is empty

        City city1 = new City("Regina", "SK");
        City city2 = new City("Edmonton", "AB");

        list.addCity(city1);
        list.addCity(city2);

        assertEquals(2, list.countCities()); // Check if the count is correct after adding cities
    }




}
