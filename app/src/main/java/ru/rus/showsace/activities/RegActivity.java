package ru.rus.showsace.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ru.rus.showsace.R;

public class RegActivity extends AppCompatActivity {

    private CheckBox chBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        final EditText regEtName = (EditText) findViewById(R.id.regeditText);
        final EditText regEtTel = (EditText) findViewById(R.id.regeditText2);
        final EditText regEtPass = (EditText) findViewById(R.id.regeditText3);
        final EditText regEtEmail = (EditText) findViewById(R.id.regeditText4);
        TextView laws = (TextView) findViewById(R.id.textViewLaws);
        chBox = (CheckBox) findViewById(R.id.regCheckBox);
        final Button regBtn = (Button) findViewById(R.id.regButton);
        regBtn.setEnabled(false);

        CompoundButton.OnCheckedChangeListener checker = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chBox.isChecked()){
                    regBtn.setEnabled(true);
                    regBtn.setBackgroundColor(Color.parseColor("#7851b3"));
                } else {
                    regBtn.setEnabled(false);
                    regBtn.setBackgroundColor(Color.parseColor("#ceced2"));
                }
            }
        };

        chBox.setOnCheckedChangeListener(checker);

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

        laws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), LawsActivity.class);
                startActivity(intent);
            }
        });

    }


}
