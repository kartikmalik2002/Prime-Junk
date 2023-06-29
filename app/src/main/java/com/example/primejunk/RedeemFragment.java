package com.example.primejunk;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.util.ArrayList;


public class RedeemFragment extends Fragment {

ArrayList<PojoItem> items_rewards;
AdapterItem adapterItem;
GridView gv_redeem ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_redeem, container, false);

        gv_redeem=(GridView) view.findViewById(R.id.gv_redeem);

        items_rewards=new ArrayList<>();

        items_rewards.add(new PojoItem(R.drawable.hh_a,"","30",""));
        items_rewards.add(new PojoItem(R.drawable.hh_c,"","200",""));
        items_rewards.add(new PojoItem(R.drawable.hh_d,"","200",""));
        items_rewards.add(new PojoItem(R.drawable.hh_e,"","250",""));
        items_rewards.add(new PojoItem(R.drawable.h2_b,"","1000",""));
        items_rewards.add(new PojoItem(R.drawable.hh_f,"","100",""));
        items_rewards.add(new PojoItem(R.drawable.hh_a,"","100",""));
        items_rewards.add(new PojoItem(R.drawable.hh_c,"","200",""));
        items_rewards.add(new PojoItem(R.drawable.hh_d,"","200",""));
        items_rewards.add(new PojoItem(R.drawable.hh_e,"","250",""));
        items_rewards.add(new PojoItem(R.drawable.h2_b,"","1000",""));
        items_rewards.add(new PojoItem(R.drawable.hh_f,"","100",""));


        adapterItem = new AdapterItem(getContext(),R.layout.grid_layout,items_rewards);
        gv_redeem.setAdapter(adapterItem);

        gv_redeem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0 :

                        if(Integer.parseInt(ApplicationClass.user.getProperty("balance").toString())<=Integer.parseInt(items_rewards.get(0).getNo_of_coins()))
                        {
                            Toast.makeText(getContext(), "insufficient balance", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            //ApplicationClass.balance.get(ApplicationClass.balance.size()-1).setBalance(ApplicationClass.balance.get(ApplicationClass.balance.size()-1).getBalance()-Integer.parseInt(items_rewards.get(0).getNo_of_coins()));
                            //Toast.makeText(getContext(), ApplicationClass.balance.get(0).getBalance(), Toast.LENGTH_SHORT).show();

                            int new_balance=Integer.parseInt(ApplicationClass.user.getProperty("balance").toString())-Integer.parseInt(items_rewards.get(0).getNo_of_coins());
                            ApplicationClass.user.setProperty("balance",new_balance);
                            Backendless.UserService.update(ApplicationClass.user, new AsyncCallback<BackendlessUser>() {
                                @Override
                                public void handleResponse(BackendlessUser response) {
                                    Toast.makeText(getContext(), "You redeemed the reward successfully", Toast.LENGTH_SHORT).show();

                                }

                                @Override
                                public void handleFault(BackendlessFault fault) {

                                    Toast.makeText(getContext(), "Error : "+fault.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });


//                            Backendless.Persistence.save(ApplicationClass.balance.get(ApplicationClass.balance.size()-1), new AsyncCallback<Coin>() {
//                                @Override
//                                public void handleResponse(Coin response) {
//                                    Toast.makeText(getContext(), "You redeemed the reward successfully", Toast.LENGTH_SHORT).show();
//
//                                }
//
//                                @Override
//                                public void handleFault(BackendlessFault fault) {
//
//                                }
//                            });
                        }
                        break;
                    case 1 :
                        if(Integer.parseInt(ApplicationClass.user.getProperty("balance").toString())<=Integer.parseInt(items_rewards.get(1).getNo_of_coins()))
                        {
                            Toast.makeText(getContext(), "insufficient balance", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            int new_balance=Integer.parseInt(ApplicationClass.user.getProperty("balance").toString())-Integer.parseInt(items_rewards.get(1).getNo_of_coins());
                            ApplicationClass.user.setProperty("balance",new_balance);
                            Backendless.UserService.update(ApplicationClass.user, new AsyncCallback<BackendlessUser>() {
                                @Override
                                public void handleResponse(BackendlessUser response) {
                                    Toast.makeText(getContext(), "You redeemed the reward successfully", Toast.LENGTH_SHORT).show();

                                }

                                @Override
                                public void handleFault(BackendlessFault fault) {

                                    Toast.makeText(getContext(), "Error : "+fault.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                        break;
                    case 2 :
                        if(Integer.parseInt(ApplicationClass.user.getProperty("balance").toString())<=Integer.parseInt(items_rewards.get(2).getNo_of_coins()))
                        {
                            Toast.makeText(getContext(), "insufficient balance", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            int new_balance=Integer.parseInt(ApplicationClass.user.getProperty("balance").toString())-Integer.parseInt(items_rewards.get(2).getNo_of_coins());
                            ApplicationClass.user.setProperty("balance",new_balance);
                            Backendless.UserService.update(ApplicationClass.user, new AsyncCallback<BackendlessUser>() {
                                @Override
                                public void handleResponse(BackendlessUser response) {
                                    Toast.makeText(getContext(), "You redeemed the reward successfully", Toast.LENGTH_SHORT).show();

                                }

                                @Override
                                public void handleFault(BackendlessFault fault) {

                                    Toast.makeText(getContext(), "Error : "+fault.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                        break;
                    case 3 :
                        if(Integer.parseInt(ApplicationClass.user.getProperty("balance").toString())<=Integer.parseInt(items_rewards.get(3).getNo_of_coins()))
                        {
                            Toast.makeText(getContext(), "insufficient balance", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            int new_balance=Integer.parseInt(ApplicationClass.user.getProperty("balance").toString())-Integer.parseInt(items_rewards.get(3).getNo_of_coins());
                            ApplicationClass.user.setProperty("balance",new_balance);
                            Backendless.UserService.update(ApplicationClass.user, new AsyncCallback<BackendlessUser>() {
                                @Override
                                public void handleResponse(BackendlessUser response) {
                                    Toast.makeText(getContext(), "You redeemed the reward successfully", Toast.LENGTH_SHORT).show();

                                }

                                @Override
                                public void handleFault(BackendlessFault fault) {

                                    Toast.makeText(getContext(), "Error : "+fault.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                        break;
                    case 4:
                        if(Integer.parseInt(ApplicationClass.user.getProperty("balance").toString())<=Integer.parseInt(items_rewards.get(4).getNo_of_coins()))
                        {
                            Toast.makeText(getContext(), "insufficient balance", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            int new_balance=Integer.parseInt(ApplicationClass.user.getProperty("balance").toString())-Integer.parseInt(items_rewards.get(4).getNo_of_coins());
                            ApplicationClass.user.setProperty("balance",new_balance);
                            Backendless.UserService.update(ApplicationClass.user, new AsyncCallback<BackendlessUser>() {
                                @Override
                                public void handleResponse(BackendlessUser response) {
                                    Toast.makeText(getContext(), "You redeemed the reward successfully", Toast.LENGTH_SHORT).show();

                                }

                                @Override
                                public void handleFault(BackendlessFault fault) {

                                    Toast.makeText(getContext(), "Error : "+fault.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                        break;

                    case 5:
                        if(Integer.parseInt(ApplicationClass.user.getProperty("balance").toString())<=Integer.parseInt(items_rewards.get(5).getNo_of_coins()))
                        {
                            Toast.makeText(getContext(), "insufficient balance", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            int new_balance=Integer.parseInt(ApplicationClass.user.getProperty("balance").toString())-Integer.parseInt(items_rewards.get(5).getNo_of_coins());
                            ApplicationClass.user.setProperty("balance",new_balance);
                            Backendless.UserService.update(ApplicationClass.user, new AsyncCallback<BackendlessUser>() {
                                @Override
                                public void handleResponse(BackendlessUser response) {
                                    Toast.makeText(getContext(), "You redeemed the reward successfully", Toast.LENGTH_SHORT).show();

                                }

                                @Override
                                public void handleFault(BackendlessFault fault) {

                                    Toast.makeText(getContext(), "Error : "+fault.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                        break;
                }
            }
        });






        return view;
    }
}