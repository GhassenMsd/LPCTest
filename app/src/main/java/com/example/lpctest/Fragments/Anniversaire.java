package com.example.lpctest.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lpctest.Adapters.PotAdapter;
import com.example.lpctest.Entities.Pot;
import com.example.lpctest.R;
import com.example.lpctest.retro.ApiUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Anniversaire extends Fragment {

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_anniversaire, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        ApiUtil.getServiceClass().getAllPots().enqueue(new Callback<List<Pot>>() {
            @Override
            public void onResponse(Call<List<Pot>> call, Response<List<Pot>> response) {
                if(response.isSuccessful()){

                    List<Pot> pots = response.body();
                    List<Pot> listAnniversaire = new ArrayList<>();

                    for (int i = 0; i < pots.size(); i++) {
                        if(pots.get(i).getCategory()==0){
                            listAnniversaire.add(pots.get(i));
                        }
                    }

                    PotAdapter adapter = new PotAdapter(getActivity(),listAnniversaire);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    recyclerView.setAdapter(adapter);
                }else{
                    Toast.makeText(getContext(),"response not succes",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<Pot>> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

}
