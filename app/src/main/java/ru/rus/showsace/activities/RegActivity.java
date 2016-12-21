package ru.rus.showsace.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import ru.rus.showsace.R;

public class RegActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        final EditText regEtName = (EditText) findViewById(R.id.regeditText);
        final EditText regEtTel = (EditText) findViewById(R.id.regeditText2);
        final EditText regEtPass = (EditText) findViewById(R.id.regeditText3);
        final EditText regEtEmail = (EditText) findViewById(R.id.regeditText4);
        CheckBox chBox = (CheckBox) findViewById(R.id.regCheckBox);
        Button regBtn = (Button) findViewById(R.id.regButton);
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((regEtName.getText().length() < 1) | (regEtTel.getText().length() < 1)){
                    Toast.makeText(getBaseContext(), "Пожалуйста заполните все поля", Toast.LENGTH_SHORT).show();
                } else if ((regEtPass.getText().length() < 1) | (regEtEmail.getText().length() < 1)){
                    Toast.makeText(getBaseContext(), "Пожалуйста заполните все поля", Toast.LENGTH_SHORT).show();
                } else if ((regEtPass.getText().length() > 1) && (regEtPass.getText().length() < 5)){
                    Toast.makeText(getBaseContext(), "Придумайте более сложный пароль", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getBaseContext(), "Регистрация прошла успешно", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
