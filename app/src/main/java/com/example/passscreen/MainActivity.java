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

        Button digit0Button = findViewById(R.id.digit_0_button);
        Button digit1Button = findViewById(R.id.digit_1_button);
        Button digit2Button = findViewById(R.id.digit_2_button);
        Button digit3Button = findViewById(R.id.digit_3_button);
        Button digit4Button = findViewById(R.id.digit_4_button);
        Button digit5Button = findViewById(R.id.digit_5_button);
        Button digit6Button = findViewById(R.id.digit_6_button);
        Button digit7Button = findViewById(R.id.digit_7_button);
        Button digit8Button = findViewById(R.id.digit_8_button);
        Button digit9Button = findViewById(R.id.digit_9_button);

        digit0Button.setOnClickListener(this);
        digit1Button.setOnClickListener(this);
        digit2Button.setOnClickListener(this);
        digit3Button.setOnClickListener(this);
        digit4Button.setOnClickListener(this);
        digit5Button.setOnClickListener(this);
        digit6Button.setOnClickListener(this);
        digit7Button.setOnClickListener(this);
        digit8Button.setOnClickListener(this);
        digit9Button.setOnClickListener(this);

        Button backSpaceButton = findViewById(R.id.back_space_button);
        backSpaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentInput = mPassCodeTextView.getText().toString();
                if (currentInput.length() > 0) {
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
            String digit = ((Button) v).getText().toString();
            String newInput = currentInput + digit;
            mPassCodeTextView.setText(newInput);

            if (newInput.length() == 4) {
                if (checkPassCode(newInput)) {
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

    private boolean checkPassCode(String newInput) {
        return "1234".equals(newInput);
    }
}
