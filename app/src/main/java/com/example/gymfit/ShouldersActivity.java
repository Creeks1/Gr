package com.example.gymfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ShouldersActivity extends AppCompatActivity {

    private final int group_index = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulders);

        ListView shouldersView = findViewById(R.id.shouldersGroup);
        final TextView txt_shoulders = findViewById(R.id.txt_shoulders);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.group_shoulders, android.R.layout.simple_list_item_1);
        shouldersView.setAdapter(adapter);

        shouldersView.setOnItemClickListener((adapterView, view, position, id) -> {

            Intent intent = new Intent(ShouldersActivity.this,ContentActivity.class);
            intent.putExtra("group_index", group_index);
            intent.putExtra("position", position);
            startActivity(intent);
        });
    }
}