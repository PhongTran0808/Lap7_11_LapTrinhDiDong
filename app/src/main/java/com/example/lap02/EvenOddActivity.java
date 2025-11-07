package com.example.lap02;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class EvenOddActivity extends AppCompatActivity {

    private EditText etNumberArray;
    private TextView tvEvenNumbers;
    private TextView tvOddNumbers;
    private Button btnSubmit;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_even_odd);

        etNumberArray = findViewById(R.id.et_number_array);
        tvEvenNumbers = findViewById(R.id.tv_even_numbers);
        tvOddNumbers = findViewById(R.id.tv_odd_numbers);
        btnSubmit = findViewById(R.id.btn_submit_even_odd);
        btnBack = findViewById(R.id.btn_back_from_even_odd);

        btnSubmit.setOnClickListener(v -> analyzeNumbers());
        btnBack.setOnClickListener(v -> finish());
    }

    private void analyzeNumbers() {
        String input = etNumberArray.getText().toString().trim();

        if (TextUtils.isEmpty(input)) {
            Toast.makeText(this, "Vui lòng nhập mảng số.", Toast.LENGTH_SHORT).show();
            tvEvenNumbers.setText("[Chưa có kết quả]");
            tvOddNumbers.setText("[Chưa có kết quả]");
            return;
        }

        String[] numberStrings = input.split("\\s+");

        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        int validCount = 0;

        for (String numStr : numberStrings) {

            if (numStr.isEmpty()) continue;

            try {
                int number = Integer.parseInt(numStr.trim());
                validCount++;

                if (number % 2 == 0) {
                    evenNumbers.add(number);
                } else {
                    oddNumbers.add(number);
                }
            } catch (NumberFormatException e) {
            }
        }

        if (validCount == 0) {
            Toast.makeText(this, "Không có số hợp lệ nào được tìm thấy.", Toast.LENGTH_SHORT).show();
            tvEvenNumbers.setText("[Không tìm thấy số chẵn]");
            tvOddNumbers.setText("[Không tìm thấy số lẻ]");
            return;
        }

        tvEvenNumbers.setText(evenNumbers.isEmpty() ?
                "[Không tìm thấy số chẵn]" :
                TextUtils.join(", ", evenNumbers));

        tvOddNumbers.setText(oddNumbers.isEmpty() ?
                "[Không tìm thấy số lẻ]" :
                TextUtils.join(", ", oddNumbers));
    }
}