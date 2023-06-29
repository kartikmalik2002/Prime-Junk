package com.example.primejunk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizResult extends AppCompatActivity {

    TextView tv_correct, tv_wrong,tv_final;
    Button btn_restart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        tv_correct = (TextView) findViewById(R.id.tv_correct);
        tv_wrong = (TextView) findViewById(R.id.tv_wrong);
        tv_final = (TextView) findViewById(R.id.tv_final);
        btn_restart = (Button) findViewById(R.id.btn_restart);

        tv_correct.setText(getIntent().getStringExtra("correct"));
        tv_wrong.setText(getIntent().getStringExtra("wrong"));
        int final_scr = getIntent().getIntExtra("final",0);
        tv_final.setText(final_scr+"");
        String final_score = tv_final.getText().toString();
        //int finalInt = Integer.parseInt(tv_final.getText().toString());
        if (final_score.equals("4")||final_score.equals("5")) {
            Toast.makeText(this, "Yay you won 2 coins ", Toast.LENGTH_LONG).show();}


            btn_restart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (final_score.equals("4")||final_score.equals("5"))
                    {
                        Intent intent = new Intent(QuizResult.this, CoinDetails.class);
                        intent.putExtra("final_score", 2);
                        startActivity(intent);
                    }

                    else{
                        Intent intent = new Intent(QuizResult.this, CoinDetails.class);
                        intent.putExtra("final_score", 0);
                        startActivity(intent);

                    }


                }
            });








    }}