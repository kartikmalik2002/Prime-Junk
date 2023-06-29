package com.example.primejunk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuizQuestions extends AppCompatActivity {

    TextView tv_name,tv_que,tv_score;
    RadioButton rb_a,rb_b,rb_c,rb_d;
    RadioGroup rg_options;
    Button btn_next,btn_quit;
    String name;
    ArrayList<String> question;
    ArrayList<String> options0;
    ArrayList<String> options1;
    ArrayList<String> options2;
    ArrayList<String> options3;
    ArrayList<String> options4;
    ArrayList<ArrayList<String>> options;
    ArrayList<Integer> answers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_questions);
        tv_name= (TextView) findViewById(R.id.tv_name);
        tv_que= (TextView) findViewById(R.id.tv_que);
        tv_score= (TextView) findViewById(R.id.tv_score);
        rb_a=(RadioButton) findViewById(R.id.rb_a);
        rb_b=(RadioButton) findViewById(R.id.rb_b);
        rb_c=(RadioButton) findViewById(R.id.rb_c);
        rb_d=(RadioButton) findViewById(R.id.rb_d);
        btn_next=(Button) findViewById(R.id.btn_next);
        btn_quit=(Button) findViewById(R.id.btn_quit);
        rg_options=(RadioGroup) findViewById(R.id.rg_options);

        question = new ArrayList<String>();
        question.add("Which method can be defined only once in a program?");
        question.add("Which keyword is used by method to refer to the current object that invoked it?");
        question.add("Which of these access specifiers can be used for an interface?");
        question.add("Which of the following is correct way of importing an entire package ‘pkg’?");
        question.add("What is the return type of Constructors?");

        options0 = new ArrayList<>();
        options1 = new ArrayList<>();
        options2 = new ArrayList<>();
        options3 = new ArrayList<>();
        options4 = new ArrayList<>();

        options = new ArrayList<>();

        answers = new ArrayList<>();

        options0.add("finalize method");
        options0.add("main method");
        options0.add("static method");
        options0.add("private method");

        options1.add("import");
        options1.add("this");
        options1.add("catch");
        options1.add("abstract");

        options2.add("public");
        options2.add("protected");
        options2.add("private");
        options2.add("All of the mentioned");

        options3.add("Import pkg.");
        options3.add("import pkg.*");
        options3.add("Import pkg.*");
        options3.add("import pkg.");

        options4.add("int");
        options4.add("float");
        options4.add("void");
        options4.add("None of the mentioned");

        options.add(options0);
        options.add(options1);
        options.add(options2);
        options.add(options3);
        options.add(options4);

        tv_que.setText(question.get(0));
        rb_a.setText(options0.get(0));
        rb_b.setText(options0.get(1));
        rb_c.setText(options0.get(2));
        rb_d.setText(options0.get(3));

        answers.add(R.id.rb_b);
        answers.add(R.id.rb_b);
        answers.add(R.id.rb_a);
        answers.add(R.id.rb_b);
        answers.add(R.id.rb_d);

        final int[] i = {0};
        final int[] score = { 0 };

        tv_score.setText(0 + "");
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checked = rg_options.getCheckedRadioButtonId();



                if(checked==answers.get(i[0]))
                {
                    score[0]++;
                    tv_score.setText(score[0] +"");

                }
                if(i[0]==4){


                    if(checked==answers.get((i[0]-1)))
                    {
                        score[0]++;


                    }

                    Intent intent = new Intent(getApplicationContext(),QuizResult.class);
                    intent.putExtra("correct","Correct Answers : "+ score[0]);
                    intent.putExtra("wrong","Wrong Answers : "+ (5-score[0]));
                    intent.putExtra("final", score[0]);
                    startActivity(intent);

                }
                if((rb_a.isChecked()||rb_b.isChecked()||rb_c.isChecked()||rb_d.isChecked())&&(i[0]!=4))
                {
                    if(i[0]==3){
                        btn_next.setText("submit");
                        btn_quit.setVisibility(View.GONE);
                    }
                    tv_que.setText(question.get(i[0]+1));

                    rb_a.setText(options.get(i[0]+1).get(0));
                    rb_b.setText(options.get(i[0]+1).get(1));
                    rb_c.setText(options.get(i[0]+1).get(2));
                    rb_d.setText(options.get(i[0]+1).get(3));

                    i[0]++;





                }
                else {
                    if(i[0]!=4){
                        Toast.makeText(QuizQuestions.this, "Please select an option", Toast.LENGTH_SHORT).show();
                    }}
            }
        });


        btn_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),QuizResult.class);
                intent.putExtra("correct","Correct Answers : "+ score[0]);
                intent.putExtra("wrong","Wrong Answers : "+ (5-score[0]));
                intent.putExtra("final", score[0]);
                startActivity(intent);
            }
        });



        name = getIntent().getStringExtra("name");

        tv_name.setText("Hello "+name);








    }
}