package com.example.laba2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import android.view.GestureDetector.SimpleOnGestureListener;

public class MainActivity extends AppCompatActivity {

    private GestureDetector gestureDetector;
    private TextView gestureTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestureTextView = findViewById(R.id.gestureTextView);

        gestureDetector = new GestureDetector(this, new MyGestureListener());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private class MyGestureListener extends SimpleOnGestureListener {
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            gestureTextView.setText("Одиночный клик");
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            gestureTextView.setText("Двойной клик");
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            gestureTextView.setText("Долгий клик");
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float xDiff = e1.getX() - e2.getX();
            float yDiff = e1.getY() - e2.getY();
            String direction;

            if (Math.abs(xDiff) > Math.abs(yDiff)) {
                if (xDiff > 100) {
                    direction = "влево";
                } else {
                    direction = "вправо";
                }
            } else {
                if (yDiff > 100) {
                    direction = "вверх";
                } else {
                    direction = "вниз";
               }
            }
            gestureTextView.setText("Свайп " + direction);
            return true;
        }
    }
}