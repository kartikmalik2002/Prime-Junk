package com.example.primejunk;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Register extends AppCompatActivity {

    public static final int REQUEST_CODE = 100;

    FusedLocationProviderClient fusedLocationProviderClient;
    private View mProgressView;
    private View mLoginFormView;
    private TextView tvLoad;
    EditText et_name, et_email, et_password, et_reenter_password, et_phone;
    Button btn_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        tvLoad = findViewById(R.id.tvLoad);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(Register.this);

        //askPermission();


        et_name = (EditText) findViewById(R.id.et_name);
        et_email = (EditText) findViewById(R.id.et_email);
        et_password = (EditText) findViewById(R.id.et_password);
        et_reenter_password = (EditText) findViewById(R.id.et_reenter_password);
        et_phone = (EditText) findViewById(R.id.et_phone);


        btn_register = (Button) findViewById(R.id.btn_register);


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_name.getText().toString().isEmpty() || et_email.getText().toString().isEmpty() || et_password.getText().toString().isEmpty() || et_reenter_password.getText().toString().isEmpty() || et_phone.getText().toString().isEmpty()) {
                    Toast.makeText(Register.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                } else {

                    String name = et_name.getText().toString().trim();
                    String email = et_email.getText().toString().trim();
                    String password = et_password.getText().toString().trim();
                    String reenter_password = et_reenter_password.getText().toString().trim();
                    String phone = et_phone.getText().toString().trim();

//                    if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)
//                            == PackageManager.PERMISSION_GRANTED) {
//                        fusedLocationProviderClient.getLastLocation()
//                                .addOnSuccessListener(new OnSuccessListener<Location>() {
//                                    @Override
//                                    public void onSuccess(Location location) {
//                                        if (location != null) {
//                                            Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
//                                            List<Address> addresses;
//
//                                            try {
//
//                                                addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
//
//                                                ApplicationClass.address = addresses.get(0).getAddressLine(0);
//                                                Toast.makeText(Register.this, ApplicationClass.address, Toast.LENGTH_LONG).show();
//
//                                            } catch (IOException e) {
//                                                e.printStackTrace();
//                                            }
//
//                                        }
//                                    }
//                                });
//                    }

                    if (password.equals(reenter_password)) {


                        BackendlessUser user = new BackendlessUser();
                        user.setEmail(email);
                        user.setPassword(password);
                        user.setProperty("name", name);
                        user.setProperty("phone", phone);
                        //user.setProperty("address", ApplicationClass.address);
                        user.setProperty("balance", 0);


                        showProgress(true);

                        Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
                            @Override
                            public void handleResponse(BackendlessUser response) {
                                ApplicationClass.user = user;
                                Toast.makeText(Register.this, "User Successfully Registered", Toast.LENGTH_SHORT).show();
                                Register.this.finish();
                                Intent intent = new Intent(Register.this,MapActivity.class);
                                startActivity(intent);
                            }

                            @Override
                            public void handleFault(BackendlessFault fault) {

                                Toast.makeText(Register.this, "Error " + fault.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                    } else {
                        Toast.makeText(Register.this, "Password didn't match", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }


        /**
         * Shows the progress UI and hides the login form.
         */
        private void showProgress ( final boolean show){
// On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
// for very easy animations. If available, use these APIs to fade-in
// the progress spinner.
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
            tvLoad.setVisibility(show ? View.VISIBLE : View.GONE);
            tvLoad.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    tvLoad.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        }

        private void askPermission () {
            ActivityCompat.requestPermissions(Register.this, new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
        }
    }
