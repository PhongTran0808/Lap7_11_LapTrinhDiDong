package com.example.lap02;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class ReverseStringActivity extends AppCompatActivity {

    private EditText etInputString;
    private TextView tvReversedString;
    private Button btnSubmit;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reverse_string);


        etInputString = findViewById(R.id.et_input_string);
        tvReversedString = findViewById(R.id.tv_reversed_string);
        btnSubmit = findViewById(R.id.btn_reverse_submit);
        btnBack = findViewById(R.id.btn_back_from_reverse);


        btnSubmit.setOnClickListener(v -> reverseAndDisplayString());


        btnBack.setOnClickListener(v -> finish());
    }

    private void reverseAndDisplayString() {
        String input = etInputString.getText().toString().trim();

        if (TextUtils.isEmpty(input)) {
            Toast.makeText(this, "Vui lòng nhập chuỗi ký tự.", Toast.LENGTH_SHORT).show();
            tvReversedString.setText("[Chưa có kết quả]");
            return;
        }


        String[] words = input.split("\\s+");


        List<String> wordList = Arrays.asList(words);


        Collections.reverse(wordList);


        String reversedSentence = TextUtils.join(" ", wordList);

        String finalResult = reversedSentence.toUpperCase(Locale.getDefault());


        tvReversedString.setText(finalResult);

        Toast.makeText(this, "Chuỗi đảo ngược: " + finalResult, Toast.LENGTH_LONG).show();
    }
}