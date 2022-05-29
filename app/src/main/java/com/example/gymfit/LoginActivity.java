package com.example.gymfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gymfit.Model.Users;
import com.example.gymfit.Prevalent.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rey.material.widget.CheckBox;

import io.paperdb.Paper;

public class LoginActivity extends AppCompatActivity {

    private Button loginBtn;
    private EditText loginNickInput,loginNumberInput, loginPasswordInput;
    private ProgressDialog loadingBar;
    private final String parentDbName = "Users";

    private CheckBox checkBoxSave;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginBtn = (Button) findViewById(R.id.login_btn);
        loginNumberInput = (EditText) findViewById(R.id.login_number_input);
        loginPasswordInput = findViewById(R.id.login_password_input);
        loadingBar = new ProgressDialog(this);


        checkBoxSave = (CheckBox)findViewById(R.id.login_checkbox);
        Paper.init(this);


        loginBtn.setOnClickListener(view -> loginUser());


    }

    private void loginUser() {
        String number = loginNumberInput.getText().toString();
        String password = loginPasswordInput.getText().toString();


        if(TextUtils.isEmpty(number))
        {
            Toast.makeText(this, "Введите номер", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Введите пароль", Toast.LENGTH_SHORT).show();
        }
        else
        {
            loadingBar.setTitle("Вход в приложение");
            loadingBar.setMessage("Подождите");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            ValidateUser(number, password);
        }
    }

    private void ValidateUser(String number, String password) {

        if(checkBoxSave.isChecked()){
            Paper.book().write(Prevalent.UserNumberKey, number);
            Paper.book().write(Prevalent.UserСonfirmationNumberKey, password);

        }
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if(dataSnapshot.child(parentDbName).child(number).exists())
                {
                    Users usersData = dataSnapshot.child(parentDbName).child(number).getValue(Users.class);



                    if(number.equals(password))
                    {
                        loadingBar.dismiss();
                        Toast.makeText(LoginActivity.this, "Вход произведен успешно", Toast.LENGTH_SHORT).show();

                        Intent homeIntent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(homeIntent);
                    }
                    else
                    {
                        loadingBar.dismiss();
                        Toast.makeText(LoginActivity.this, "Неверный номер телефона", Toast.LENGTH_SHORT).show();
                    }

                }
                else
                {
                    loadingBar.dismiss();
                    Toast.makeText(LoginActivity.this, "Аккаунт с номером телефона " + number + " не существует", Toast.LENGTH_SHORT).show();

                    Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivity(registerIntent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}