package com.example.codeplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SkipActivity2 extends AppCompatActivity {

    Button next, skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip2);

        next = findViewById(R.id.next);
        skip = findViewById(R.id.skipbutton);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SkipActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}