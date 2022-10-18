package com.example.beyzayuksel.myrecyclerviewsearchview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beyzayuksel.myrecyclerviewsearchview.R;
import com.example.beyzayuksel.myrecyclerviewsearchview.model.Car;

import java.util.ArrayList;

public class CarRecyclerAdapter extends RecyclerView.Adapter<CarRecyclerAdapter.MyViewHolder> {

    /*Adapter: tutucu
    *
    * Eventtır.
    *
    * */

    private ArrayList<Car> cars;

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    // Adaptere araba listesini ekliyoruz.
    public CarRecyclerAdapter(ArrayList<Car> cars) {
        this.cars = cars;
    }

    // görüntünün xml ini Recyclerview e koyar.
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_single_item, parent, false);
        return new MyViewHolder(view);
    }

    // hangi itemda olduğumuzu gösterir.
    // oluşturduğumuz view e değerler atıyoruz.
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.trModel.setText(cars.get(position).getModel());
        holder.tvBrand.setText(cars.get(position).getBrand());
        holder.imgLogo.setImageResource(cars.get(position).getLogo());
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    // benim görüntümün içinde neler olduğunu belirtiyorum
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvBrand, trModel;
        ImageView imgLogo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBrand = itemView.findViewById(R.id.textView);
            trModel = itemView.findViewById(R.id.textView2);
            imgLogo = itemView.findViewById(R.id.imageView);
        }
    }
}
