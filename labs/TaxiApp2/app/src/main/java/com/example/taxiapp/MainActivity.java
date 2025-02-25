package com.example.taxiapp; // Замените на имя вашего пакета

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText etPhone, etName, etSurname;
    private Button btnRegistration;
    private SharedPreferencesHelper sharedPreferencesHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        etPhone = findViewById(R.id.etPhone);
        etName = findViewById(R.id.etName);
        etSurname = findViewById(R.id.etSurname);
        btnRegistration = findViewById(R.id.btnRegistration);
        sharedPreferencesHelper = new SharedPreferencesHelper(this); // Инициализация вспомогательного класса

        // Восстановление данных из SharedPreferences при запуске
        String savedPhone = sharedPreferencesHelper.getPhone();
        String savedName = sharedPreferencesHelper.getName();
        String savedSurname = sharedPreferencesHelper.getSurname();

        if (!savedPhone.isEmpty()) {
            etPhone.setText(savedPhone);
            etName.setText(savedName);
            etSurname.setText(savedSurname);
            btnRegistration.setText("Вход");
        }

        btnRegistration.setOnClickListener(v -> {
            String phone = etPhone.getText().toString();
            String name = etName.getText().toString();
            String surname = etSurname.getText().toString();

            sharedPreferencesHelper.saveUserData(phone, name, surname); // Сохранение данных

            Intent intent = new Intent(MainActivity.this, SecondActivity.class); // Замените SecondActivity на имя вашего второго Activity
            intent.putExtra("phone", phone);
            intent.putExtra("name", name);
            intent.putExtra("surname", surname);
            startActivity(intent);
        });
    }

    // ... (методы жизненного цикла onStart, onResume, onPause, onStop, onDestroy -  как в предыдущем примере) ...
}