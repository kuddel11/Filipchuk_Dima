package com.example.taxiapp; // Замените на имя вашего пакета

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {
    private static final String PREFS_NAME = "TaxiPrefs";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_NAME = "name";
    private static final String KEY_SURNAME = "surname";
    private SharedPreferences sharedPreferences;

    public SharedPreferencesHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void saveUserData(String phone, String name, String surname) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_PHONE, phone);
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_SURNAME, surname);
        editor.apply();
    }

    public String getPhone() {
        return sharedPreferences.getString(KEY_PHONE, "");
    }

    public String getName() {
        return sharedPreferences.getString(KEY_NAME, "");
    }

    public String getSurname() {
        return sharedPreferences.getString(KEY_SURNAME, "");
    }
}