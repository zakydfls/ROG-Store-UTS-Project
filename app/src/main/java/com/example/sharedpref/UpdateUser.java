package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class UpdateUser extends AppCompatActivity {
    Button updateDaftar;
    EditText txtupdateUname, txtupdatePass;
    EditText txtupdateName;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);
        txtupdatePass = (EditText) findViewById(R.id.updatePass);
        txtupdateName = findViewById(R.id.nameUser);
        txtupdateUname = findViewById(R.id.updateUname);
        updateDaftar = findViewById(R.id.updateDaftar);

        sharedPreferences = getSharedPreferences("MYDATA", MODE_PRIVATE);

        setData(sharedPreferences);
    }

    private void setData(SharedPreferences sharedPreferences) {
        txtupdateName.setText(sharedPreferences.getString("nama", ""));
        txtupdateUname.setText(sharedPreferences.getString("user", ""));
        txtupdatePass.setText(sharedPreferences.getString("pass", ""));
    }

    @SuppressLint("ApplySharedPref")
    public void Update(View view) {
        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nama", txtupdateName.getText().toString());
        editor.putString("user", txtupdateUname.getText().toString());
        editor.putString("pass", txtupdatePass.getText().toString());
        editor.commit();
        Intent iMain = new Intent(UpdateUser.this,
                LoginActivity.class);
        startActivity(iMain);
    }
}