package com.example.lpctest.Fragments;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.lpctest.Adapters.PotAdapter;
import com.example.lpctest.DataBase.DBManager;
import com.example.lpctest.Entities.Pot;
import com.example.lpctest.R;
import com.example.lpctest.retro.ApiUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Depart extends Fragment {

    RecyclerView recyclerView;
    View view;
    private DBManager dbManager;
    ProgressBar progressBar;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_anniversaire, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        progressBar = view.findViewById(R.id.homeprogress);


        ApiUtil.getServiceClass().getAllPots().enqueue(new Callback<List<Pot>>() {
            @Override
            public void onResponse(Call<List<Pot>> call, Response<List<Pot>> response) {
                if(response.isSuccessful()){

                    List<Pot> pots = response.body();
                    List<Pot> listDepart = new ArrayList<>();

                    Filter(pots,listDepart);

                }else{
                    Toast.makeText(getContext(),"Oups une erreur est survenue",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<Pot>> call, Throwable t) {
                dbManager = new DBManager(getActivity());
                dbManager.open();

                Cursor cursor = dbManager.fetch();
                List<Pot> potList = new ArrayList<>();
                if(cursor!=null && cursor.getCount() > 0)
                {
                    if (cursor.moveToFirst())
                    {
                        do {
                            for (int i = 0; i <= cursor.getCount(); i++){
                                Pot pot = new Pot(cursor.getString(0),cursor.getString(1),cursor.getString(2),Integer.parseInt(cursor.getString(3)),Integer.parseInt(cursor.getString(4)),Float.parseFloat(cursor.getString(5)));
                                Log.d("pot", "onFailure: "+pot.toString());
                                potList.add(pot);
                            }
                        } while (cursor.moveToNext());
                    }
                    List<Pot> listDepart1 = new ArrayList<>();

                    Filter(potList,listDepart1);

                }else {
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(getContext(),"Oups une erreur est survenue",Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }
    private void setViewLayout(int id){
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(id, null);
        ViewGroup rootView = (ViewGroup) getView();
        rootView.removeAllViews();

        final FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT);
        rootView.addView(view,params);

    }

    private void Filter(List<Pot> listOrigin,List<Pot> listfiltree){
        for (int i = 0; i < listOrigin.size(); i++) {
            if(listOrigin.get(i).getCategory()==1){
                listfiltree.add(listOrigin.get(i));

                dbManager = new DBManager(getActivity());
                dbManager.open();

                dbManager.insert(listOrigin.get(i));
            }
        }

        if(listfiltree.size()==0){
            setViewLayout(R.layout.response_null);
            progressBar.setVisibility(View.INVISIBLE);
        }else{
            PotAdapter adapter = new PotAdapter(getActivity(),listfiltree);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(adapter);
            progressBar.setVisibility(View.INVISIBLE);

        }
    }
}
