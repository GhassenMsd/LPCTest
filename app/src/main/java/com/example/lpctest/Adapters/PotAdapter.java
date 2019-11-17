package com.example.lpctest.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lpctest.Entities.Pot;
import com.example.lpctest.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PotAdapter extends RecyclerView.Adapter<PotViewHolder> {
    private Context context;
    private List<Pot> potList;

    public PotAdapter(Context context, List<Pot> potList) {
        this.context = context;
        this.potList = potList;
    }

    @NonNull
    @Override
    public PotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pot, parent, false);
        return new PotViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PotViewHolder holder, int position) {
        Pot pot = potList.get(position);
        Drawable NoImage = holder.imageView.getContext().getResources().getDrawable(R.drawable.ic_launcher_background);

        if(potList.get(position).getImageUrl()==null){
            holder.imageView.setImageDrawable(NoImage);
        }else {
            Picasso.get().load(potList.get(position).getImageUrl()).into(holder.imageView, new Callback() {
                @Override
                public void onSuccess() {
                }

                @Override
                public void onError(Exception e) {
                }
            });
        }


        holder.nombre.setText(String.valueOf(pot.getContributorsCount()));
        holder.name.setText(pot.getName());
        holder.montant.setText(String.valueOf(pot.getAmount())+"€ récoltés");

    }

    @Override
    public int getItemCount() {
        return potList.size();
    }
}
