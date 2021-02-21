package com.example.codeplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SkipActivity3 extends AppCompatActivity {

    Button next, skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip3);

        next = findViewById(R.id.next);
        skip = findViewById(R.id.skipbutton);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SkipActivity3.this, SkipActivity2.class);
            }
        });
    }
}