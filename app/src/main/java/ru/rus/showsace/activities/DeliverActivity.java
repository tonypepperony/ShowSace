package ru.rus.showsace.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import ru.rus.showsace.R;

public class DeliverActivity extends AppCompatActivity {
    private TextView stoimost;
    EditText address;
    Button next2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliver);

        stoimost = (TextView) findViewById(R.id.etDeliver);

        next2 = (Button) findViewById(R.id.nextButton);

        RadioButton radioButton1 = (RadioButton) findViewById(R.id.rButton1);
        radioButton1.setOnClickListener(rbListener);

        RadioButton radioButton2 = (RadioButton) findViewById(R.id.rButton2);
        radioButton2.setOnClickListener(rbListener);

        final RadioButton radioButton3 = (RadioButton) findViewById(R.id.rButton3);
        radioButton3.setOnClickListener(rbListener);

        address = (EditText) findViewById(R.id.editText4);
        address.setVisibility(View.INVISIBLE);

        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButton3.isChecked() && address.getText().length() > 5){
                    Intent intent = new Intent(getBaseContext(), FinishActivity.class);
                    startActivity(intent);
                } else if(radioButton3.isChecked() && address.getText().length() <= 5) {
                    Toast.makeText(getBaseContext(), "введите адрес", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getBaseContext(), FinishActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    View.OnClickListener rbListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            RadioButton rb = (RadioButton) view;
                switch (rb.getId()) {
                    case R.id.rButton1: stoimost.setText("стоимость: бесплатно");
                        address.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.rButton2: stoimost.setText(R.string.st100rub);
                        address.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.rButton3: stoimost.setText(R.string.st100rub);
                        address.setVisibility(View.VISIBLE);
                        break;
                    default:
                        address.setText(" ");
                        break;
                }
        }
    };
}
