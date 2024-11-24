package com.example.ecommerceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    Context context;
    ArrayList<itemsModel> itemsModels;

    public MyAdapter(Context context, ArrayList<itemsModel> itemsModels) {
        this.context = context;
        this.itemsModels = itemsModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.items, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        itemsModel itemsmodel = itemsModels.get(position);  // Access instance of itemsModel

        holder.name.setText(itemsmodel.getName());  // Use instance method
        holder.price.setText(itemsmodel.getPrice());  // Use instance method
        Picasso.get().load(itemsmodel.getImage()).into(holder.image);  // Use instance method
    }

    @Override
    public int getItemCount() {
        return itemsModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        TextView price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
        }
    }
}
