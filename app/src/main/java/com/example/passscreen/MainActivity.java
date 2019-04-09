package com.example.passscreen;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mPassCodeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPassCodeTextView = findViewById(R.id.pass_code_text_view);

        findViewById(R.id.digit_0_button).setOnClickListener(this);
        findViewById(R.id.digit_1_button).setOnClickListener(this);
        findViewById(R.id.digit_2_button).setOnClickListener(this);
        findViewById(R.id.digit_3_button).setOnClickListener(this);
        findViewById(R.id.digit_4_button).setOnClickListener(this);
        findViewById(R.id.digit_5_button).setOnClickListener(this);
        findViewById(R.id.digit_6_button).setOnClickListener(this);
        findViewById(R.id.digit_7_button).setOnClickListener(this);
        findViewById(R.id.digit_8_button).setOnClickListener(this);
        findViewById(R.id.digit_9_button).setOnClickListener(this);

        Button backSpaceButton = findViewById(R.id.back_space_button);
        backSpaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentInput = mPassCodeTextView.getText().toString();
                if (currentInput.length() > 0) {
                    // ลบตัวขวาสุดทิ้ง
                    String newInput = currentInput.substring(0, currentInput.length() - 1);
                    mPassCodeTextView.setText(newInput);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        String currentInput = mPassCodeTextView.getText().toString();
        if (currentInput.length() < 4) {
            // ใช้ตัวเลขที่เป็น text บนปุ่ม
            String digit = ((Button) v).getText().toString();
            String newInput = currentInput + digit;
            mPassCodeTextView.setText(newInput);

            if (newInput.length() == 4) {
                if (isPassCodeValid(newInput)) {
                    new AlertDialog.Builder(MainActivity.this)
                            .setMessage("รหัสผ่านถูกต้อง")
                            .setPositiveButton("OK", null)
                            .show();
                } else {
                    Toast.makeText(
                            MainActivity.this,
                            newInput + " ไม่ใช่รหัสผ่านที่ถูกต้อง !!!",
                            Toast.LENGTH_SHORT
                    ).show();
                    mPassCodeTextView.setText("");
                }
            }
        }
    }

    private boolean isPassCodeValid(String newInput) {
        return "1234".equals(newInput);
    }
}
