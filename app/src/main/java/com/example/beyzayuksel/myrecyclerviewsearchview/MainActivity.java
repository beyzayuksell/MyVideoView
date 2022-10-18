package com.example.beyzayuksel.myrecyclerviewsearchview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.example.beyzayuksel.myrecyclerviewsearchview.adapter.CarRecyclerAdapter;
import com.example.beyzayuksel.myrecyclerviewsearchview.model.Car;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Car> cars;
    private RecyclerView recyclerView;
    private CarRecyclerAdapter carRecyclerAdapter;
    private Toolbar toolbar;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewSettings();
        fillTheArray();

        // Configure the search info and add any event listeners...
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // search view için, enter a bastığımızda yapılacak işlemleri yapar.
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            // search view içinde metin değiştirğindeki işlmeleri yapar.
            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<Car> newCarsList = new ArrayList<>();
                // markaya(brand)  göre arama yapılıyor.
                for(Car car : cars){
                    if(car.getBrand().toLowerCase(Locale.ROOT).contains(newText.toLowerCase())){
                        newCarsList.add(car);
                    }
                }

                carRecyclerAdapter.setCars(newCarsList);
                // Değişikliklerin olması için notify metodu yazmamız gerekli.
                carRecyclerAdapter.notifyDataSetChanged();
                return true;
            }
        });


        carRecyclerAdapter.notifyDataSetChanged();
    }


    private void fillTheArray() {
       cars.add(new Car(R.drawable.ic_launcher_background, "BMW", "3.18 - E36"));
       cars.add(new Car(R.drawable.ic_launcher_foreground, "Audi", "A6"));
       cars.add(new Car(R.drawable.ic_launcher_background, "Mercedes", "3.18 - E38"));
       cars.add(new Car(R.drawable.ic_launcher_foreground, "BMW", "3.18 - E36"));
       cars.add(new Car(R.drawable.ic_launcher_background, "Audi", "A6"));
       cars.add(new Car(R.drawable.ic_launcher_foreground, "Mercedes", "3.18 - E38"));
    }

    private void viewSettings(){
        recyclerView = findViewById(R.id.recyclerview);

        searchView = findViewById(R.id.searchview);
        searchView.clearFocus();

        cars = new ArrayList<>(); // boş bir dizi oluşturduk.
        carRecyclerAdapter = new CarRecyclerAdapter(cars); // Adaptere araba listesini ekliyoruz.

        recyclerView.setAdapter(carRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));// adapterimi maine (set ettim)buraya bağladım.

    }
}