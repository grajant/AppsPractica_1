package com.example.glego.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private EditText editPesosText;
    private EditText editDollarsText;
    private Double pesos;
    private Double dollars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editPesosText =  (EditText) findViewById(R.id.editPesosValue);
        editDollarsText  = (EditText) findViewById(R.id.editDollarsValue);
        //editPesosText.setOnFocusChangeListener(editPesosListener);
        editPesosText.addTextChangedListener(editPesosWatcher);
        editDollarsText.addTextChangedListener(editDollarsWatcher);
    }

    public void sendMessage(View view){
        //Intent intent = new Intent(this, DisplayMessageActivity.class);


        //double pesosValue = Double.parseDouble(editText.getText().toString());

        //int value = Integer.parseInt(message);
        //intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);
    }

    /*private View.OnFocusChangeListener editPesosListener = new View.OnFocusChangeListener() {
        public void onFocusChange(View v, boolean hasFocus) {
            if(hasFocus)
                pesosFocus = true;
        }
    };*/

    private TextWatcher editPesosWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if(editPesosText.hasFocus()) {
                try {
                    pesos = Double.parseDouble(s.toString());
                }catch (Exception e){
                    pesos = 0.0;
                }
                dollars = pesos / 2800.0;
                editDollarsText.setText(String.format("%1$.3f", dollars));
            }
        }
    };

    private TextWatcher editDollarsWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (editDollarsText.hasFocus()) {
                try {
                    dollars = Double.parseDouble(s.toString());
                } catch (Exception e) {
                    dollars = 0.0;
                }
                pesos = dollars * 2800.0;

                editPesosText.setText(String.format("%1$.1f", pesos));

            }
        }

    };
}
