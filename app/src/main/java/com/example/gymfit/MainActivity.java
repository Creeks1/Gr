package com.example.gymfit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gymfit.Model.Users;
import com.example.gymfit.Prevalent.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog loadingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button joinButton = (Button) findViewById(R.id.main_join_btn);
        Button loginButton = (Button) findViewById(R.id.main_login_btn);
        loadingBar = new ProgressDialog(this);



        Paper.init(this);

        loginButton.setOnClickListener(view -> {
            Intent loginIntent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(loginIntent);
        });

        joinButton.setOnClickListener(view -> {
            Intent regIntent = new Intent(MainActivity.this,RegisterActivity.class);
            startActivity(regIntent);
        });

        String UserNumberKey = Paper.book().read(Prevalent.UserNumberKey);
        String UserСonfirmationNumberKey = Paper.book().read(Prevalent.UserСonfirmationNumberKey);

        if(UserNumberKey != "" && UserСonfirmationNumberKey != ""){
            if(!TextUtils.isEmpty(UserNumberKey) && !TextUtils.isEmpty(UserNumberKey)){
                ValidateUser(UserNumberKey, UserСonfirmationNumberKey);

                loadingBar.setTitle("Вход в приложение");
                loadingBar.setMessage("Подождите");
                loadingBar.setCanceledOnTouchOutside(false);
                loadingBar.show();
            }
        }
    }

    private void ValidateUser(final String Number, final String СonfirmationNumber) {

        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if(dataSnapshot.child("Users").child(Number).exists())
                {
                    Users usersData = dataSnapshot.child("Users").child(Number).getValue(Users.class);


                    if(Number.equals(СonfirmationNumber))
                    {
                        loadingBar.dismiss();
                        Toast.makeText(MainActivity.this, "Вход произведен успешно", Toast.LENGTH_SHORT).show();

                        Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(homeIntent);
                    }
                    else
                    {
                        loadingBar.dismiss();
                    }

                }
                else
                {
                    loadingBar.dismiss();
                    Toast.makeText(MainActivity.this, "Аккаунт с номером телефона " + Number + " не существует", Toast.LENGTH_SHORT).show();

                    Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                    startActivity(registerIntent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}