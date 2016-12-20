package ru.rus.showsace.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ru.rus.showsace.R;

public class ForgotActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        final EditText etEmail = (EditText) findViewById(R.id.editTextForgot);

        Button sendBtn = (Button) findViewById(R.id.buttonSendPass);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etEmail.getText().length() < 5){
                    Toast.makeText(getBaseContext(), "введите email", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getBaseContext(), "пароль выслан", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            finish();
                        }
                    }, 2000);
                }

            }
        });
    }
}
