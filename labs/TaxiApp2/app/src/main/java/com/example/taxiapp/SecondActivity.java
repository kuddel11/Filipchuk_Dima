package com.example.taxiapp; // Замените на имя вашего пакета

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private TextView tvNameSurname, tvPhone, tvRoute;
    private Button btnSetPath, btnCallTaxi;
    private static final int REQUEST_CODE_SET_PATH = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvNameSurname = findViewById(R.id.tvNameSurname);
        tvPhone = findViewById(R.id.tvPhone);
        tvRoute = findViewById(R.id.tvRoute);
        btnSetPath = findViewById(R.id.btnSetPath);
        btnCallTaxi = findViewById(R.id.btnCallTaxi);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String surname = intent.getStringExtra("surname");
        String phone = intent.getStringExtra("phone");

        tvNameSurname.setText(name + " " + surname);
        tvPhone.setText(phone);

        btnSetPath.setOnClickListener(v -> {
            Intent intentPath = new Intent(SecondActivity.this, ThirdActivity.class);
            startActivityForResult(intentPath, REQUEST_CODE_SET_PATH);
        });

        btnCallTaxi.setOnClickListener(v -> {
            Toast.makeText(this, "Такси отправлено!", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SET_PATH && resultCode == RESULT_OK) {
            String route = data.getStringExtra("route");
            tvRoute.setText(route);
            btnCallTaxi.setEnabled(true);
        }
    }
}