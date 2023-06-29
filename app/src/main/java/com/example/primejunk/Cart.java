package com.example.primejunk;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;
import com.backendless.BackendlessUser;
import com.backendless.persistence.BackendlessDataCollection;
import com.backendless.persistence.BackendlessSerializer;

import java.util.List;

public class Cart extends AppCompatActivity implements myadapter.mListener{
    RecyclerView recview;
    Button btn_request_pick_up;
    TextView tv_empty;
    List<Item> items;

    androidx.appcompat.widget.Toolbar toolbar_cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        tv_empty=(TextView) findViewById(R.id.tv_empty);
        btn_request_pick_up= (Button) findViewById(R.id.btn_start_request);

        toolbar_cart= findViewById(R.id.toolbar_cart);
        setSupportActionBar(toolbar_cart);

        getroomdata();
        if(items.size()==0)
        {
            tv_empty.setVisibility(View.VISIBLE);
        }
        else{
            btn_request_pick_up.setVisibility(View.VISIBLE);
        }


        btn_request_pick_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //int sum =Integer.parseInt((String) current_balance);

                int sum = (int)ApplicationClass.user.getProperty("balance");;
                for(int i =0;i<items.size();i++)
                {
                    sum+=items.get(i).getNo_of_coins();
                }
//                Coin coin = new Coin();
//                coin.setBalance(sum);
//                coin.setUserEmail(ApplicationClass.user.getEmail());


                ApplicationClass.user.setProperty("balance",sum);
                 Backendless.UserService.update(ApplicationClass.user, new AsyncCallback<BackendlessUser>() {
                     @Override
                     public void handleResponse(BackendlessUser response) {
                         Toast.makeText(Cart.this, "Coins Credited into your balance", Toast.LENGTH_SHORT).show();
                         items.clear();
                         Cart.this.finish();
                     }

                     @Override
                     public void handleFault(BackendlessFault fault) {

                         Toast.makeText(Cart.this, "Error : "+fault.getMessage(), Toast.LENGTH_SHORT).show();
                     }
                 });

            }
        });




    }

    public void getroomdata()

    {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "cart_db").allowMainThreadQueries().build();
        ItemDao itemDao = db.ItemDao();

        recview=findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        items=itemDao.getallitem();


        myadapter adapter=new myadapter(this,items);
        recview.setAdapter(adapter);
    }

    @Override
    public void removeButtonVisibility() {
        tv_empty.setVisibility(View.VISIBLE);
        btn_request_pick_up.setVisibility(View.GONE);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //HomeFragment homeFragment =new HomeFragment();
        switch (item.getItemId())
        {
            case R.id.home:
                //if(frameLayout.getContext()!=homeFragment.getContext())
                    //getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,homeFragment).commit();

                //toolbar.setTitle(R.string.prime_junk);

                Intent intent = new Intent(this,NavigationDrawersActivity.class);
                startActivity(intent);
                return true;

            case R.id.coin:
                Intent intent1 = new Intent(getApplicationContext(),CoinDetails.class);
                startActivity(intent1);
                return true;

        }

        return true;

    }


}
