package com.example.primejunk;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;


public class EarnCoins extends Fragment {



    ArrayList<PojoItem> items_play_games , items_solve_quizes;
    GridView gv_play_games,gv_solve_quizes;
    AdapterItem adapterItem_play_games,adapterItem_solve_quizes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_earn_coins, container, false);



        items_play_games= new ArrayList<PojoItem>();
        items_solve_quizes= new ArrayList<PojoItem>();


        gv_play_games=view.findViewById(R.id.gv_solve_games);
        gv_solve_quizes=view.findViewById(R.id.gv_solve_quizes);


        items_play_games.add(new PojoItem(R.drawable.game_a,"Get Upto","10",""));
        items_play_games.add(new PojoItem(R.drawable.game_b,"Get Upto","20",""));
        items_play_games.add(new PojoItem(R.drawable.game_c,"Get Upto","30",""));
        items_play_games.add(new PojoItem(R.drawable.game_d,"Get Upto","10",""));

        adapterItem_play_games= new AdapterItem(getContext(),R.layout.grid_layout,items_play_games);
        gv_play_games.setAdapter(adapterItem_play_games);


        items_solve_quizes.add(new PojoItem(R.drawable.quiz_pic_a,"Get Upto","10",""));
        items_solve_quizes.add(new PojoItem(R.drawable.quiz_pic_b,"Get Upto","20",""));
        items_solve_quizes.add(new PojoItem(R.drawable.quiz_pic_c,"Get Upto","30",""));
        items_solve_quizes.add(new PojoItem(R.drawable.quiz_pic_d,"Get Upto","10",""));

        adapterItem_solve_quizes= new AdapterItem(getContext(),R.layout.grid_layout,items_solve_quizes);
        gv_solve_quizes.setAdapter(adapterItem_solve_quizes);

        gv_solve_quizes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0 :

                        Intent intent = new Intent(requireActivity(),Quiz.class);
                        startActivity(intent);
                        break;
                    case 1 :
                        Toast.makeText(getContext(), "1", Toast.LENGTH_SHORT).show();
                        break;
                    case 2 :
                        Toast.makeText(getContext(), "2", Toast.LENGTH_SHORT).show();
                        break;
                    case 3 :
                        Toast.makeText(getContext(), "3", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });




        return view;
    }
}