package com.example.gymfit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {


    private EditText regNickInput, regPasswordInput, regNumberInput;
    private ProgressDialog loadingBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button regBtn = (Button) findViewById(R.id.reg_btn);
        regNickInput = (EditText) findViewById(R.id.reg_nickname_input);
        regNumberInput = (EditText) findViewById(R.id.reg_number_input);
        regPasswordInput = (EditText) findViewById(R.id.reg_password_input);

        loadingBar = new ProgressDialog(this);


        regBtn.setOnClickListener(view -> CreateAccount());
    }

    private void CreateAccount() {
        String reg_nickname = regNickInput.getText().toString();
        String reg_number = regNumberInput.getText().toString();
        String reg_password = regPasswordInput.getText().toString();


        if(TextUtils.isEmpty(reg_nickname))
        {
            Toast.makeText(this, "Введите почту", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(reg_number))
        {
            Toast.makeText(this, "Введите номер телефона", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(reg_password))
        {
            Toast.makeText(this, "Введите подтверждение номера телефона", Toast.LENGTH_SHORT).show();
        }
        else
        {
            loadingBar.setTitle("Создание аккаунта");
            loadingBar.setMessage("Подождите");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            ValidateNumber(reg_nickname, reg_number, reg_password);

        }
    }

    private void ValidateNumber(String reg_nickname,String reg_number, String reg_password) {
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (!(dataSnapshot.child("Users").child(reg_number).exists()))
                {
                    HashMap<String, Object> userDataMap = new HashMap<>();
                    userDataMap.put("Email", reg_nickname);
                    userDataMap.put("Number", reg_number);
                    userDataMap.put("NumberConfirmation", reg_password);



                    RootRef.child("Users").child(reg_number).updateChildren(userDataMap)
                            .addOnCompleteListener(task -> {
                                if (task.isSuccessful())
                                {
                                    loadingBar.dismiss();
                                    Toast.makeText(RegisterActivity.this, "Регистрация прошла успешно", Toast.LENGTH_SHORT).show();


                                    Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                                    startActivity(loginIntent);
                                }
                                else
                                {
                                    loadingBar.dismiss();
                                    Toast.makeText(RegisterActivity.this, "Ошибка", Toast.LENGTH_SHORT).show();
                                }

                            });
                }
                else
                {
                    loadingBar.dismiss();
                    Toast.makeText(RegisterActivity.this, "Номер " + reg_number + " уже зарегистрирован", Toast.LENGTH_SHORT).show();
                    Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(loginIntent);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}