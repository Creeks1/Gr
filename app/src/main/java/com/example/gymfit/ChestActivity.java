package com.example.gymfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ChestActivity extends AppCompatActivity {

    private final int group_index = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest);

        ListView chestView = findViewById(R.id.chestGroup);
        final TextView txt_chest = findViewById(R.id.txt_chest);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.group_chest, android.R.layout.simple_list_item_1);
        chestView.setAdapter(adapter);

        chestView.setOnItemClickListener((adapterView, view, position, id) -> {

            Intent intent = new Intent(ChestActivity.this,ContentActivity.class);
            intent.putExtra("group_index", group_index);
            intent.putExtra("position", position);
            startActivity(intent);
        });
    }
}