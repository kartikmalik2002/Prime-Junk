package com.example.primejunk;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;


public class HomeFragment extends Fragment {

    ArrayList<PojoItem> items , items_recyclable;
    GridView gv_degradable,gv_recyclable;
    AdapterItem adapterItem;
    FloatingActionButton fab_cart;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view =inflater.inflate(R.layout.fragment_home, container, false);



         items= new ArrayList<PojoItem>();
         items_recyclable= new ArrayList<PojoItem>();


        gv_degradable=view.findViewById(R.id.gv_degradable);
        gv_recyclable=view.findViewById(R.id.gv_recyclable);
        fab_cart= (FloatingActionButton) view.findViewById(R.id.fab_cart);


        items.add(new PojoItem(R.drawable.degpic_a,"5+ Kg","10","per kg"));
        items.add(new PojoItem(R.drawable.degpic_b,"10+ Kg","20","per kg"));
        items.add(new PojoItem(R.drawable.degpic_c,"20+ Kg","25","per kg"));
        items.add(new PojoItem(R.drawable.degpic_a,"30+ Kg","30","per kg"));

        adapterItem= new AdapterItem(getContext(),R.layout.grid_layout,items);
        gv_degradable.setAdapter(adapterItem);


        items_recyclable.add(new PojoItem(R.drawable.recpic_a,"50+","10","per bottle"));
        items_recyclable.add(new PojoItem(R.drawable.recpic_b,"10+","15","per kg"));
        items_recyclable.add(new PojoItem(R.drawable.recpic_c,"50+","20","per bottle"));
        items_recyclable.add(new PojoItem(R.drawable.recpic_d,"5+ Kg","20","per kg"));



        adapterItem= new AdapterItem(getContext(),R.layout.grid_layout,items_recyclable);
        gv_recyclable.setAdapter(adapterItem);

        gv_recyclable.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0 :


                        AppDatabase db= Room.databaseBuilder(requireContext(),AppDatabase.class,"cart_db").fallbackToDestructiveMigration().allowMainThreadQueries().build();
                                ItemDao itemDao=db.ItemDao();

                                Boolean check=itemDao.is_exist(5);
                                if(check==false)
                                {
                                    int pid=5;

                                    String quantity =items_recyclable.get(0).getQuantity();
                                    String title ="Recyclable";
                                    String rate=items_recyclable.get(0).getRate();
                                    int no_of_coins=Integer.parseInt(items_recyclable.get(0).getNo_of_coins());

                                    itemDao.insertrecord(new Item(pid,title,quantity,rate,no_of_coins));
                                    Toast.makeText(getContext(), "item added to list", Toast.LENGTH_SHORT).show();


                                }
                                else
                                {
                                    Toast.makeText(getContext(), "already in list", Toast.LENGTH_SHORT).show();
                                }



                        break;
                    case 1 :
                         db= Room.databaseBuilder(requireContext(),AppDatabase.class,"cart_db").fallbackToDestructiveMigration().allowMainThreadQueries().build();
                         itemDao=db.ItemDao();

                        if(itemDao.is_exist(6)==false)
                        {
                            int pid=6;

                            String quantity =items_recyclable.get(1).getQuantity();
                            String title ="Recyclable";
                            String rate=items_recyclable.get(1).getRate();
                            int no_of_coins=Integer.parseInt(items_recyclable.get(1).getNo_of_coins());

                            itemDao.insertrecord(new Item(pid,title,quantity,rate,no_of_coins));
                            Toast.makeText(getContext(), "item added to list", Toast.LENGTH_SHORT).show();


                        }
                        else
                        {
                            Toast.makeText(getContext(), "already in list", Toast.LENGTH_SHORT).show();
                        }

                        break;
                    case 2 :
                         db= Room.databaseBuilder(requireContext(),AppDatabase.class,"cart_db").fallbackToDestructiveMigration().allowMainThreadQueries().build();
                         itemDao=db.ItemDao();
                        check=itemDao.is_exist(7);
                        if(check==false)
                        {
                            int pid=7;

                            String quantity =items_recyclable.get(2).getQuantity();
                            String title ="Recyclable";
                            String rate=items_recyclable.get(2).getRate();
                            int no_of_coins=Integer.parseInt(items_recyclable.get(2).getNo_of_coins());


                            itemDao.insertrecord(new Item(pid,title,quantity,rate,no_of_coins));
                            Toast.makeText(getContext(), "item added to list", Toast.LENGTH_SHORT).show();


                        }
                        else
                        {
                            Toast.makeText(getContext(), "already in list", Toast.LENGTH_SHORT).show();
                        }

                        break;
                    case 3 :
                         db= Room.databaseBuilder(requireContext(),AppDatabase.class,"cart_db").fallbackToDestructiveMigration().allowMainThreadQueries().build();
                         itemDao=db.ItemDao();
                         check=itemDao.is_exist(8);
                        if(check==false)
                        {
                            int pid=8;

                            String quantity =items_recyclable.get(3).getQuantity();
                            String title ="Recyclable";
                            String rate=items_recyclable.get(3).getRate();
                            int no_of_coins=Integer.parseInt(items_recyclable.get(3).getNo_of_coins());


                            itemDao.insertrecord(new Item(pid,title,quantity,rate,no_of_coins));
                            Toast.makeText(getContext(), "item added to list", Toast.LENGTH_SHORT).show();


                        }
                        else
                        {
                            Toast.makeText(getContext(), "already in list", Toast.LENGTH_SHORT).show();
                        }

                        break;
                }
            }
        });


        gv_degradable.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0 :
                        AppDatabase db= Room.databaseBuilder(requireContext(),AppDatabase.class,"cart_db").fallbackToDestructiveMigration().allowMainThreadQueries().build();
                        ItemDao itemDao=db.ItemDao();
                        Boolean check=itemDao.is_exist(1);
                        if(check==false)
                        {
                            int pid=1;

                            String quantity =items.get(0).getQuantity();
                            String title ="Degradable";
                            String rate=items.get(0).getRate();
                            int no_of_coins=Integer.parseInt(items.get(0).getNo_of_coins());


                            itemDao.insertrecord(new Item(pid,title,quantity,rate,no_of_coins));
                            Toast.makeText(getContext(), "item added to list", Toast.LENGTH_SHORT).show();


                        }
                        else
                        {
                            Toast.makeText(getContext(), "already in list", Toast.LENGTH_SHORT).show();
                        }



                        break;
                    case 1 :
                        db= Room.databaseBuilder(requireContext(),AppDatabase.class,"cart_db").fallbackToDestructiveMigration().allowMainThreadQueries().build();
                        itemDao=db.ItemDao();

                        if(itemDao.is_exist(2)==false)
                        {
                            int pid=2;

                            String quantity =items.get(1).getQuantity();
                            String title ="Degradable";
                            String rate=items.get(1).getRate();
                            int no_of_coins=Integer.parseInt(items.get(1).getNo_of_coins());


                            itemDao.insertrecord(new Item(pid,title,quantity,rate,no_of_coins));
                            Toast.makeText(getContext(), "item added to list", Toast.LENGTH_SHORT).show();


                        }
                        else
                        {
                            Toast.makeText(getContext(), "already in list", Toast.LENGTH_SHORT).show();
                        }

                        break;
                    case 2 :
                        db= Room.databaseBuilder(requireContext(),AppDatabase.class,"cart_db").fallbackToDestructiveMigration().allowMainThreadQueries().build();
                        itemDao=db.ItemDao();
                        check=itemDao.is_exist(3);
                        if(check==false)
                        {
                            int pid=3;

                            String quantity =items.get(2).getQuantity();
                            String title ="Degradable";
                            String rate=items.get(2).getRate();
                            int no_of_coins=Integer.parseInt(items.get(2).getNo_of_coins());


                            itemDao.insertrecord(new Item(pid,title,quantity,rate,no_of_coins));
                            Toast.makeText(getContext(), "item added to list", Toast.LENGTH_SHORT).show();


                        }
                        else
                        {
                            Toast.makeText(getContext(), "already in list", Toast.LENGTH_SHORT).show();
                        }

                        break;
                    case 3 :
                        db= Room.databaseBuilder(requireContext(),AppDatabase.class,"cart_db").fallbackToDestructiveMigration().allowMainThreadQueries().build();
                        itemDao=db.ItemDao();
                        check=itemDao.is_exist(4);
                        if(check==false)
                        {
                            int pid=4;

                            String quantity =items.get(3).getQuantity();
                            String title ="Degradable";
                            String rate=items.get(3).getRate();
                            int no_of_coins=Integer.parseInt(items.get(3).getNo_of_coins());


                            itemDao.insertrecord(new Item(pid,title,quantity,rate,no_of_coins));
                            Toast.makeText(getContext(), "item added to list", Toast.LENGTH_SHORT).show();


                        }
                        else
                        {
                            Toast.makeText(getContext(), "already in list", Toast.LENGTH_SHORT).show();
                        }

                        break;
                }
            }
        });
                fab_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(),Cart.class);
                startActivity(intent);
            }
        });



        return view;
    }
}