package com.sunitawebapp.sharedpreferenceusedapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    TextView tvLogin;
    TextInputEditText etnUsername,etnPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvLogin=findViewById(R.id.tvLogin);
        etnPassword=findViewById(R.id.etnPassword);
        etnUsername=findViewById(R.id.etnUsername);

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // Storing data into SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("Login",MODE_PRIVATE);

               // Creating an Editor object to edit(write to the file)
                SharedPreferences.Editor myEdit = sharedPreferences.edit();

               // Storing the key and its value as the data fetched from edittext
                myEdit.putString("Username", etnUsername.getText().toString());
                myEdit.putString("Password", etnPassword.getText().toString());
                myEdit.putBoolean("islogin", true);
                // Once the changes have been made,
                // we need to commit to apply those changes made,
                // otherwise, it will throw an error
                myEdit.commit();

                Intent mainIntent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(mainIntent);
                //finish();
            }
        });

    }


}
