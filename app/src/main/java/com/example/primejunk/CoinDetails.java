package com.example.primejunk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class CoinDetails extends AppCompatActivity {
TextView tv_btn_history,tv_btn_earn_coins,tv_btn_redeem_coins,coin_balance;



//String whereClause = "userEmail ='"+ApplicationClass.user.getEmail()+"'";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_details);

        tv_btn_earn_coins=findViewById(R.id.tv_btn_earn_coins);
        tv_btn_history=findViewById(R.id.tv_btn_history);
        tv_btn_redeem_coins=findViewById(R.id.tv_btn_redeem_coins);
        coin_balance= (TextView) findViewById(R.id.coin_balance);

        coin_balance.setText(String.valueOf(ApplicationClass.user.getProperty("balance")));

//        DataQueryBuilder queryBuilder = DataQueryBuilder.create();
//        queryBuilder.setWhereClause(whereClause);

//        Backendless.Persistence.of(Coin.class).find(queryBuilder, new AsyncCallback<List<Coin>>() {
//            @Override
//            public void handleResponse(List<Coin> response) {
//                ApplicationClass.balance=response;
//                Toast.makeText(CoinDetails.this, ApplicationClass.balance.get(ApplicationClass.balance.size()-1).getBalance()+"", Toast.LENGTH_SHORT).show();
//                coin_balance.setText(String.valueOf(ApplicationClass.balance.get(ApplicationClass.balance.size()-1).getBalance()));
//            }
//
//            @Override
//            public void handleFault(BackendlessFault fault) {
//
//            }
//        });



        tv_btn_redeem_coins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), NavigationDrawersActivity.class);
                intent.putExtra("redeem_coins",R.id.tv_btn_redeem_coins);
                startActivity(intent);
            }

        });
        tv_btn_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), NavigationDrawersActivity.class);
                intent.putExtra("history",R.id.tv_btn_history);
                startActivity(intent);
            }

        });
        tv_btn_earn_coins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), NavigationDrawersActivity.class);
                intent.putExtra("earn_coins",R.id.tv_btn_earn_coins);
                startActivity(intent);
            }

        });

        int reward = getIntent().getIntExtra("final_score",0);


        int available_coins = Integer.parseInt(coin_balance.getText().toString());

       coin_balance.setText(available_coins + reward +"");
    }


}