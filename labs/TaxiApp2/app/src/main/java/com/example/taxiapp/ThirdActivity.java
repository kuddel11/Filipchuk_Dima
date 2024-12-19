package com.example.taxiapp; // Замените на имя вашего пакета

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {

    private EditText etStartPoint, etEndPoint, etTime, etDate, etAdditionalInfo;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        etStartPoint = findViewById(R.id.etStartPoint);
        etEndPoint = findViewById(R.id.etEndPoint);
        etTime = findViewById(R.id.etTime);
        etDate = findViewById(R.id.etDate);
        etAdditionalInfo = findViewById(R.id.etAdditionalInfo);
        btnOk = findViewById(R.id.btnOk);

        btnOk.setOnClickListener(v -> {
            String startPoint = etStartPoint.getText().toString();
            String endPoint = etEndPoint.getText().toString();
            String time = etTime.getText().toString();
            String date = etDate.getText().toString();
            String additionalInfo = etAdditionalInfo.getText().toString();

            String route = "Начальная точка: " + startPoint + "\nКонечная точка: " + endPoint + "\nВремя: " + time + "\nДата: " + date + "\nДополнительная Информация: " + additionalInfo;

            Intent resultIntent = new Intent();
            resultIntent.putExtra("route", route);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}