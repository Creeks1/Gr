package com.example.gymfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.paperdb.Paper;

public class HomeActivity extends AppCompatActivity {

    private Button exitBtn;


    private Button first, second, third, fourth, fifth, sixth, seventh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        exitBtn = (Button)findViewById(R.id.Exit);

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Paper.book().destroy();
                Intent exitIntent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(exitIntent);
            }
        });


        init();

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, NeckActivity.class);
                startActivity(intent);
            }
        });

        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ShouldersActivity.class);
                startActivity(intent);
            }
        });

        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ChestActivity.class);
                startActivity(intent);
            }
        });

        fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, BackActivity.class);
                startActivity(intent);
            }
        });

        fifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, HandsActivity.class);
                startActivity(intent);
            }
        });

        sixth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, PressActivity.class);
                startActivity(intent);
            }
        });
        seventh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, LegsActivity.class);
                startActivity(intent);
            }
        });


    }


    private void init(){
        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        third = findViewById(R.id.third);
        fourth = findViewById(R.id.fourth);
        fifth = findViewById(R.id.fifth);
        sixth = findViewById(R.id.sixth);
        seventh = findViewById(R.id.seventh);
    }
}