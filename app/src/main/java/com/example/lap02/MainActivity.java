package com.example.lap02;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button btnTask1 = findViewById(R.id.btn_task1);
        Button btnTask3 = findViewById(R.id.btn_task3);
        Button btnTask4 = findViewById(R.id.btn_task4);

        btnTask1.setOnClickListener(v -> startActivity(new Intent(this, AvatarActivity.class)));
        btnTask3.setOnClickListener(v -> startActivity(new Intent(this, EvenOddActivity.class)));
        btnTask4.setOnClickListener(v -> startActivity(new Intent(this, ReverseStringActivity.class)));
    }

}