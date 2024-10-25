package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * this gets size of the list
     * @return
     */
    public int getCount(){
        return cities.size();
    }
    /**
     * this adds a city object to the list
     *the second phase, you can add the
     city * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }
    //The following methods are from ChatGPT, "Help with the following: (test requirements)", 2024-10-25
    //I didn't intend for it to write these methods, but it nonetheless did as part as helping me
    //write tests.
    //The documentation is is written by me
    /**
     * This checks whether a specific city object is in the list
     * @param city - the city object we are looking for
     * @return true if the list does contain the city
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * This removes  a specific city object from the list
     * @param city - the city object we want to remove
     */
    public void deleteCity(City city) {
        cities.remove(city);
    }
    /**
     * This checks how many cities are in the list
     * @return int - the number of cities in the list
     */
    public int countCities() {
        return cities.size();
    }

}
