package com.example.gymfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class BackActivity extends AppCompatActivity {


    private final int group_index = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);


        ListView backView = findViewById(R.id.backGroup);
        final TextView txt_back = findViewById(R.id.txt_back);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.group_back, android.R.layout.simple_list_item_1);
        backView.setAdapter(adapter);


        backView.setOnItemClickListener((adapterView, view, position, id) -> {

            Intent intent = new Intent(BackActivity.this,ContentActivity.class);
            intent.putExtra("group_index", group_index);
            intent.putExtra("position", position);
            startActivity(intent);
        });
    }
}