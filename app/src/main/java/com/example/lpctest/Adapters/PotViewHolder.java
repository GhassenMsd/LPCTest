package com.example.lpctest.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lpctest.R;

public class PotViewHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public TextView montant;
    public TextView nombre;
    public ImageView imageView;


    public PotViewHolder(@NonNull View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.name);
        montant = (TextView) itemView.findViewById(R.id.amount);
        nombre = (TextView) itemView.findViewById(R.id.nombre);
        imageView = (ImageView) itemView.findViewById(R.id.imagePot);
    }
}
