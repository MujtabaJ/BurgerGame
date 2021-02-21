package com.example.codeplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.codeplay.utils.ViewDialog;

public class SkipActivity extends AppCompatActivity {

    Button next, skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip);

        next = findViewById(R.id.next);
        skip = findViewById(R.id.skipbutton);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SkipActivity.this, SkipActivity2.class);
                startActivity(intent);
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(SkipActivity.this, "Congratulations!!, You have successfully made the burger");
            }
        });
    }

}