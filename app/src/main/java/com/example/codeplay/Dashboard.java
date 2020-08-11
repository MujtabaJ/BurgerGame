package com.example.codeplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {

    Button burgerMakerPlay;
    Button buildingMakerPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        init();

    }

    public void clickListner(View view){
        if (view.getId() == R.id.playburgermaker) {
            // button1 action
            Intent mainIntent = new Intent(Dashboard.this, BurgerMakerPlay.class);
            Dashboard.this.startActivity(mainIntent);
        } else if (view.getId() == R.id.playbuildingmaker) {
            //button2 action
            Intent mainIntent = new Intent(Dashboard.this, BuildingMakerPlay.class);
            Dashboard.this.startActivity(mainIntent);
        }
    }

    public void init(){
        burgerMakerPlay = findViewById(R.id.playburgermaker);
        buildingMakerPlay = findViewById(R.id.playbuildingmaker);
    }


}