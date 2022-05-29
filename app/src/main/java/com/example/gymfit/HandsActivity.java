package com.example.gymfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class HandsActivity extends AppCompatActivity {


    private final int group_index = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hands);

        ListView handsView = findViewById(R.id.handsGroup);
        final TextView txt_hands = findViewById(R.id.txt_hands);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.group_hands, android.R.layout.simple_list_item_1);
        handsView.setAdapter(adapter);

        handsView.setOnItemClickListener((adapterView, view, position, id) -> {

            Intent intent = new Intent(HandsActivity.this,ContentActivity.class);
            intent.putExtra("group_index", group_index);
            intent.putExtra("position", position);
            startActivity(intent);
        });
    }
}