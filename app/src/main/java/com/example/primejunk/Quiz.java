package com.example.primejunk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {

    Button btn_start;

    EditText et_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        btn_start = (Button) findViewById(R.id.btn_start);

        et_name= (EditText) findViewById(R.id.et_name);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_name.getText().toString().isEmpty())
                {
                    Toast.makeText(Quiz.this, "First Enter Your Name to Start a Quiz", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(),QuizQuestions.class);
                    intent.putExtra("name",et_name.getText().toString().trim());
                    startActivity(intent);


                }
            }
        });

    }

    }