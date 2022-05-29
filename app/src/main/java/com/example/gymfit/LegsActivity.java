package com.example.gymfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class LegsActivity extends AppCompatActivity {


    private final int group_index = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legs);

        ListView legsView = findViewById(R.id.legsGroup);
        final TextView txt_legs = findViewById(R.id.txt_legs);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.group_legs, android.R.layout.simple_list_item_1);
        legsView.setAdapter(adapter);


        legsView.setOnItemClickListener((adapterView, view, position, id) -> {

            Intent intent = new Intent(LegsActivity.this,ContentActivity.class);
            intent.putExtra("group_index", group_index);
            intent.putExtra("position", position);
            startActivity(intent);
        });
    }
}