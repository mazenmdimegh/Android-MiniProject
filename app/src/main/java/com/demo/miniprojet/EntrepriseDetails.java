package com.demo.miniprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EntrepriseDetails extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entreprise_details);
        getSupportActionBar().hide();

    }
    public void backHome(View v){
//        Intent intent= new Intent(this,Main.class);
//        startActivity(intent);

    }
}