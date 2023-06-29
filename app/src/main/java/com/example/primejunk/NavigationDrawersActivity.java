package com.example.primejunk;

import androidx.annotation.GravityInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.UserService;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessException;
import com.backendless.exceptions.BackendlessFault;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class NavigationDrawersActivity extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar toolbar;
    NavigationView navigationView;

    ActionBarDrawerToggle actionBarDrawerToggle;

    DrawerLayout drawerLayout ;
    FrameLayout frameLayout;
    CircleImageView civ_profile_pic;
    TextView tv_profile_name;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    public static final int REQUEST_CODE = 100;

    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawers);
        toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        gso= new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc= GoogleSignIn.getClient(this,gso);


        navigationView = (NavigationView) findViewById(R.id.nav_view);
        drawerLayout =(DrawerLayout) findViewById(R.id.nav_drawer);

        //fab_cart= (FloatingActionButton) findViewById(R.id.fab_cart);
        View view = navigationView.inflateHeaderView(R.layout.nav_view_header_layout);

        civ_profile_pic= (CircleImageView) view.findViewById(R.id.civ_profile_pic);
        tv_profile_name= (TextView) view.findViewById(R.id.tv_profile_name);



        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);

        if(account!= null){
            String name = account.getDisplayName();
            Uri pic = account.getPhotoUrl();

            tv_profile_name.setText(name);
            if(pic==null)
            {
                civ_profile_pic.setImageResource(R.drawable.profile_pic_blank);
            }
            else {
                civ_profile_pic.setImageURI(pic);
            }

        }
        //tv_profile_name.setText(ApplicationClass.user.getProperty("name").toString());



        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        frameLayout = (FrameLayout) findViewById(R.id.frame_layout);

         if(getIntent().getIntExtra("redeem_coins",0)!=0){


             getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new RedeemFragment()).commit();
             toolbar.setTitle("Redeem Coins");
             id=0;

        }
        else if(getIntent().getIntExtra("earn_coins",0)!=0){

            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new EarnCoins()).commit();
             toolbar.setTitle(R.string.earn_coins);
             id=0;

        }
        else if(getIntent().getIntExtra("history",0)!=0){

            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new HistoryFragment()).commit();
             toolbar.setTitle(R.string.history);
             id=0;

        }


        else {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
        }


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.profile:
                        Toast.makeText(NavigationDrawersActivity.this, "a", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new ProfileFragment()).commit();
                        toolbar.setTitle("Profile");
                        drawerLayout.closeDrawer(GravityCompat.START);

                        break;

                    case R.id.redeem:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new RedeemFragment()).commit();
                        toolbar.setTitle("Redeem Coins");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.history:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new HistoryFragment()).commit();
                        toolbar.setTitle("History");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.earn_coins:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new EarnCoins()).commit();
                        toolbar.setTitle("Earn Coins");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.logout:
                        drawerLayout.closeDrawer(GravityCompat.START);





                         Backendless.UserService.logout(new AsyncCallback<Void>() {
                             @Override
                             public void handleResponse(Void response) {
                                 Toast.makeText(NavigationDrawersActivity.this, "logout successful", Toast.LENGTH_SHORT).show();
                                 NavigationDrawersActivity.this.finish();
                                 Intent intent = new Intent(NavigationDrawersActivity.this,Login.class);
                                 intent.putExtra("logout",true);
                                 startActivity(intent);
                             }

                             @Override
                             public void handleFault(BackendlessFault fault) {

                                 Toast.makeText(NavigationDrawersActivity.this, "Error "+fault.getMessage(), Toast.LENGTH_SHORT).show();
                             }
                         });

                        break;
                }
                return true;
            }
        });




    }

//    private void SignOut() {
//        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                finish();
//                startActivity(new Intent(getApplicationContext(),Login.class));
//            }
//        });
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        HomeFragment homeFragment =new HomeFragment();
        switch (item.getItemId())
        {
            case R.id.home:
                if(frameLayout.getContext()!=homeFragment.getContext())
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,homeFragment).commit();

                toolbar.setTitle(R.string.prime_junk);
                return true;

            case R.id.coin:
                Intent intent = new Intent(getApplicationContext(),CoinDetails.class);
                startActivity(intent);
                return true;

        }

        return true;

    }


}