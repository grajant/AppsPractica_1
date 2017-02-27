package com.example.glego.geometricfigures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /********** Radio Buttons ************/
    private RadioButton squareRadioButton;
    private RadioButton triangleRadioButton;
    private RadioButton circleRadioButton;
    private RadioButton cubeRadioButton;
    /******        Labels        *******/
    private TextView firstFieldLabel;
    private TextView secondFieldLabel;
    private TextView areaLabel;
    private TextView perimeterLabel;
    private TextView volumeLabel;
    /******    EditTexts   *******/
    private EditText firstFieldEdit;
    private EditText secondFieldEdit;
    private EditText areaEdit;
    private EditText perimeterEdit;
    private EditText volumeEdit;

    private Button button;
    /***   Variables **********/
    private Double base;
    private Double height;
    private Double area;
    private Double perimeter;
    private Double volume;
    /******** Flag   ***********/
    private short whatIsChecked = 0;

    private static double PI = 3.14159;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        squareRadioButton = (RadioButton) findViewById(R.id.squareRadioButton);
        triangleRadioButton = (RadioButton) findViewById(R.id.triangleRadioButton);
        circleRadioButton = (RadioButton) findViewById(R.id.circleRadioButton);
        cubeRadioButton = (RadioButton) findViewById(R.id.cubeRadioButton);

        firstFieldLabel = (TextView) findViewById(R.id.firstFieldLabel);
        secondFieldLabel = (TextView) findViewById(R.id.secondFieldLabel);
        areaLabel = (TextView) findViewById(R.id.areaLabel);
        perimeterLabel = (TextView) findViewById(R.id.perimeterLabel);
        volumeLabel = (TextView) findViewById(R.id.volumeLabel);

        firstFieldEdit = (EditText) findViewById(R.id.firstFieldEdit);
        secondFieldEdit = (EditText) findViewById(R.id.secondFieldEdit);
        areaEdit = (EditText) findViewById(R.id.areaEdit);
        perimeterEdit = (EditText) findViewById(R.id.perimeterEdit);
        volumeEdit = (EditText) findViewById(R.id.volumeEdit);

        button = (Button) findViewById(R.id.button);
        /*********** Set invisible unnecessary components *******/
        firstFieldLabel.setVisibility(View.INVISIBLE);
        firstFieldEdit.setVisibility(View.INVISIBLE);
        secondFieldLabel.setVisibility(View.INVISIBLE);
        secondFieldEdit.setVisibility(View.INVISIBLE);
        button.setVisibility(View.INVISIBLE);
        areaLabel.setVisibility(View.INVISIBLE);
        areaEdit.setVisibility(View.INVISIBLE);
        perimeterEdit.setVisibility(View.INVISIBLE);
        perimeterLabel.setVisibility(View.INVISIBLE);
        volumeEdit.setVisibility(View.INVISIBLE);
        volumeLabel.setVisibility(View.INVISIBLE);
    }

    public void radioButtonClicked(View view) {
        switch (view.getId()){
            case R.id.squareRadioButton:
                unCheck();
                showElements("Lado del cuadrado:", "lado", "", "");
                whatIsChecked = 1;
                break;
            case R.id.triangleRadioButton:
                unCheck();
                showElements("Base del triágulo:", "base", "Altura del triángulo:", "altura");
                whatIsChecked = 2;
                break;
            case R.id.circleRadioButton:
                unCheck();
                showElements("Radio del círculo:", "radio", "", "");
                whatIsChecked = 3;
                break;
            case R.id.cubeRadioButton:
                unCheck();
                showElements("Lado del cubo:", "lado", "", "");
                whatIsChecked = 4;
                break;
            default:
        }
    }

    private void unCheck(){
        switch (whatIsChecked){
            case 1:
                squareRadioButton.setChecked(false);
                break;
            case 2:
                triangleRadioButton.setChecked(false);
                break;
            case 3:
                circleRadioButton.setChecked(false);
                break;
            case 4:
                cubeRadioButton.setChecked(false);
                break;
            default:
        }
    }

    public void calculateButtonClicked(View view) {
        boolean error = false;
        if(firstFieldEdit.getText().toString().equals(""))
            Toast.makeText(this, R.string.empty_field, Toast.LENGTH_SHORT).show();
        else {
            base = Double.parseDouble(firstFieldEdit.getText().toString());
            switch (whatIsChecked) {
                case 1:
                    area = base * base;
                    perimeter = base * 4;
                    break;
                case 2:
                    if(secondFieldEdit.getText().toString().equals("")) {
                        Toast.makeText(this, R.string.empty_field, Toast.LENGTH_SHORT).show();
                        error = true;
                    }
                    else {
                        height = Double.parseDouble(secondFieldEdit.getText().toString());
                        area = 0.5 * base * height;
                        perimeter = base * 3;
                    }
                    break;
                case 3:
                    area = PI * base * base;
                    perimeter = 2 * PI * base;
                    break;
                case 4:
                    area = 6 * base * base;
                    perimeter = 12 * base;
                    volume = base * base * base;
                    break;
                default:
            }
            if (!error) {
                areaEdit.setText(area.toString());
                perimeterEdit.setText(perimeter.toString());
                areaEdit.setVisibility(View.VISIBLE);
                areaLabel.setVisibility(View.VISIBLE);
                perimeterEdit.setVisibility(View.VISIBLE);
                perimeterLabel.setVisibility(View.VISIBLE);
                if (whatIsChecked == 4) {
                    volumeEdit.setText(volume.toString());
                    volumeEdit.setVisibility(View.VISIBLE);
                    volumeLabel.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    private void showElements(String firstField, String firstHint, String secondField, String secondHint){
        firstFieldEdit.setText("");
        /***** Set visible items ***********/
        firstFieldLabel.setText(firstField);
        firstFieldEdit.setHint(firstHint);
        firstFieldEdit.setVisibility(View.VISIBLE);
        firstFieldLabel.setVisibility(View.VISIBLE);
        button.setVisibility(View.VISIBLE);

        /*** Set invisible items *****/
        secondFieldLabel.setVisibility(View.INVISIBLE);
        secondFieldEdit.setVisibility(View.INVISIBLE);
        areaLabel.setVisibility(View.INVISIBLE);
        areaEdit.setVisibility(View.INVISIBLE);
        perimeterEdit.setVisibility(View.INVISIBLE);
        perimeterLabel.setVisibility(View.INVISIBLE);
        volumeEdit.setVisibility(View.INVISIBLE);
        volumeLabel.setVisibility(View.INVISIBLE);
        if(!secondField.equals("")){
            secondFieldEdit.setText("");
            secondFieldLabel.setText(secondField);
            secondFieldEdit.setHint(secondHint);
            secondFieldLabel.setVisibility(View.VISIBLE);
            secondFieldEdit.setVisibility(View.VISIBLE);
        }
    }
}
