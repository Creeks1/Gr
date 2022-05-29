package com.example.gymfit;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class ContentActivity  extends AppCompatActivity {

    private int group_index;
    private int position;
    private TextView content_text;
    private ImageView main_photo;



    /**------------------------------   Neck    --------------------------------------*/
    private final int [] neck_array = {R.string.neck_1, R.string.neck_2, R.string.neck_3};
    private final int [] neck_array_image ={R.drawable.neck1,R.drawable.neck2,R.drawable.neck3};
    /**----------------------------    Shoulder    -----------------------------------*/
    private final int [] shoulder_array ={R.string.shoulders_1,R.string.shoulders_2,R.string.shoulders_3};
    private final int [] shoulder_array_image ={R.drawable.shoulders1,R.drawable.shoulders2,R.drawable.shoulders3};
    /**------------------------------   Chest    --------------------------------------*/
    private final int [] chest_array ={R.string.chest_1,R.string.chest_2,R.string.chest_3};
    private final int [] chest_array_image ={R.drawable.chest1,R.drawable.chest2,R.drawable.chest3};
    /**------------------------------   Back    --------------------------------------*/
    private final int [] back_array ={R.string.back_1,R.string.back_2,R.string.back_3,R.string.back_4};
    private final int [] back_array_image ={R.drawable.back1,R.drawable.back2,R.drawable.back3,R.drawable.back4};
    /**------------------------------   Hands    --------------------------------------*/
    private final int [] hands_array ={R.string.hands_1,R.string.hands_2,R.string.hands_3};
    private final int [] hands_array_image ={R.drawable.hands1,R.drawable.hands2,R.drawable.hands3};
    /**------------------------------   Press    --------------------------------------*/
    private final int [] press_array ={R.string.press_1,R.string.press_2,R.string.press_3,R.string.press_4};
    private final int [] press_array_image ={R.drawable.press1,R.drawable.press2,R.drawable.press3,R.drawable.press4};
    /**------------------------------   Legs    --------------------------------------*/
    private final int [] legs_array ={R.string.legs_1,R.string.legs_2,R.string.legs_3};
    private final int [] legs_array_image ={R.drawable.legs1,R.drawable.legs2,R.drawable.legs3};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_screen);

        content_text = findViewById(R.id.text_main_content);
        main_photo = findViewById(R.id.main_photo);

        reciveIntent();

    }


    private void reciveIntent() {

        Intent i = getIntent();
        if (i != null){
            group_index = i.getIntExtra("group_index", 0);
            position = i.getIntExtra("position", 0);

        }

        switch (group_index){
            case 0:
                content_text.setText(neck_array[position]);
                main_photo.setImageResource(neck_array_image[position]);
                break;
            case 1:
                content_text.setText(shoulder_array[position]);
                main_photo.setImageResource(shoulder_array_image[position]);
                break;
            case 2:
                content_text.setText(chest_array[position]);
                main_photo.setImageResource(chest_array_image[position]);
                break;
            case 3:
                content_text.setText(back_array[position]);
                main_photo.setImageResource(back_array_image[position]);
                break;
            case 4:
                content_text.setText(hands_array[position]);
                main_photo.setImageResource(hands_array_image[position]);
                break;
            case 5:
                content_text.setText(press_array[position]);
                main_photo.setImageResource(press_array_image[position]);
                break;
            case 6:
                content_text.setText(legs_array[position]);
                main_photo.setImageResource(legs_array_image[position]);
                break;
        }




    }


}
