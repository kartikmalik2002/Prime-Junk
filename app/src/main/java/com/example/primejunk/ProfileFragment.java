package com.example.primejunk;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileFragment extends Fragment {

    CircleImageView civ_profile_pic_profile ;
    TextView tv_profile_name_profile;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        civ_profile_pic_profile = (CircleImageView) view.findViewById(R.id.civ_profile_pic_profile);
        tv_profile_name_profile= (TextView) view.findViewById(R.id.tv_profile_name_profile);

        gso= new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc= GoogleSignIn.getClient( getContext(),gso);


        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getContext());

        if(account!= null){
            String name = account.getDisplayName();
            Uri pic = account.getPhotoUrl();

           tv_profile_name_profile.setText(name);
            if(pic==null)
            {
                civ_profile_pic_profile.setImageResource(R.drawable.profile_pic_blank);
            }
            else {
                civ_profile_pic_profile.setImageURI(pic);
            }

        }

        return view;
    }
}