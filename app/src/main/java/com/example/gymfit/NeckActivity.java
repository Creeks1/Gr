package com.example.gymfit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class NeckActivity extends AppCompatActivity {


    private final int group_index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neck);

        ListView neckView = findViewById(R.id.neckGroup);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.group_neck, android.R.layout.simple_list_item_1);
        neckView.setAdapter(adapter);


        neckView.setOnItemClickListener((adapterView, view, position, id) -> {

            Intent intent = new Intent(NeckActivity.this,ContentActivity.class);
            intent.putExtra("group_index", group_index);
            intent.putExtra("position", position);
            startActivity(intent);
        });




    }

}
