package com.example.gymfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PressActivity extends AppCompatActivity {

    private final int group_index = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_press);

        ListView pressView = findViewById(R.id.pressGroup);
        final TextView txt_press = findViewById(R.id.txt_press);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.group_press, android.R.layout.simple_list_item_1);
        pressView.setAdapter(adapter);


        pressView.setOnItemClickListener((adapterView, view, position, id) -> {

            Intent intent = new Intent(PressActivity.this,ContentActivity.class);
            intent.putExtra("group_index", group_index);
            intent.putExtra("position", position);
            startActivity(intent);
        });
    }
}