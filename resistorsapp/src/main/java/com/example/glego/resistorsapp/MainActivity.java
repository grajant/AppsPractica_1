package com.example.glego.resistorsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.glego.resistorsapp.MESSAGE";
    /******* Graphical Objects ***************/
    private Button color_1_Button;
    private Button color_2_Button;
    private Button multiplierButton;
    private Button toleranceButton;
    private TextView valueTextV;
    /*********************************/

    /******* Buttons color variables ********/
    private short firstBandColor;
    private short secondBandColor;
    private short multiplierColor;
    private short toleranceColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ListView listView = (ListView) findViewById(R.id.listView);
        color_1_Button = (Button) findViewById(R.id.color_1_Button);
        color_2_Button = (Button) findViewById(R.id.color_2_Buton);
        multiplierButton = (Button) findViewById(R.id.multiplierButton);
        toleranceButton = (Button) findViewById(R.id.toleranceButton);
        valueTextV = (TextView) findViewById(R.id.valueText);
        /************** Set Defaults colors to buttons *******************/
        color_1_Button.setBackgroundResource(R.color.saddlebrown);
        color_2_Button.setBackgroundResource(R.color.black);
        multiplierButton.setBackgroundResource(R.color.red);
        toleranceButton.setBackgroundResource(R.color.goldenrod);

        firstBandColor = 1;
        secondBandColor = 0;
        multiplierColor = 2;
        toleranceColor = 1;
        /*****************************************************************/
        /*** Calculate default value ***/
        calculateResistorValue();

        /*ArrayList<ResistorCode> list = ResistorCode.defaultValues();
        MyAdapter adapter = new MyAdapter(this, list);
        listView.setAdapter(adapter);*/

        //listView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if( requestCode == 1 && resultCode == RESULT_OK){
            setColor(data.getExtras().getString("color"), requestCode); // Set new colors
            calculateResistorValue();   // Calculate the new value
        }else if ( requestCode == 2 && resultCode == RESULT_OK){
            setColor(data.getExtras().getString("color"), requestCode);
            calculateResistorValue();
        }else if ( requestCode == 3 && resultCode == RESULT_OK) {
            setColor(data.getExtras().getString("color"), requestCode);
            calculateResistorValue();
        }else if ( requestCode == 4 && resultCode == RESULT_OK) {
            setColor(data.getExtras().getString("color"), requestCode);
            calculateResistorValue();
        }
    }

    /*********** Send Information to another activity ************/
    public void bandClicked(View view) {
        Intent intent = new Intent(this, ColorsListActivity.class);

        int value = view.getId();
        Log.d("El Id es: ", "" + value);
        Log.d("Boton 1 Id: ", "" + R.id.color_1_Button);
        switch (view.getId()) {
            case R.id.color_1_Button:
                intent.putExtra(EXTRA_MESSAGE, 1);
                startActivityForResult(intent, 1);
                break;
            case R.id.color_2_Buton:
                intent.putExtra(EXTRA_MESSAGE, 2);
                startActivityForResult(intent, 2);
                break;
            case R.id.multiplierButton:
                intent.putExtra(EXTRA_MESSAGE, 3);
                startActivityForResult(intent, 3);
                break;
            case R.id.toleranceButton:
                intent.putExtra(EXTRA_MESSAGE, 4);
                startActivityForResult(intent, 4);
                break;
            default:

        }
    }

    /********* Calculate resistor value based on colors ***********************/
    private void calculateResistorValue(){
        int result;
        if(multiplierColor == 0) {
            result = firstBandColor * 10 + secondBandColor;
            valueTextV.setText("" + result + "\t\u2126 \t\u00B1" + toleranceColor * 5 + "%");
        }else if(multiplierColor == 1){
            result = firstBandColor*100 + secondBandColor*10;
            valueTextV.setText("" + result + "\t\u2126 \t\u00B1" + toleranceColor*5 + "%");
        }else if(multiplierColor == 2 && secondBandColor == 0){
            valueTextV.setText("" + firstBandColor + "\tK\u2126 \t\u00B1" + toleranceColor * 5 + "%");
        }else if(multiplierColor == 2){
            valueTextV.setText("" + firstBandColor + "." + secondBandColor + "\tK\u2126 \t\u00B1" + toleranceColor*5 + "%");
        }else if(multiplierColor == 3) {
            valueTextV.setText("" + firstBandColor + "" + secondBandColor + "\tK\u2126 \t\u00B1" + toleranceColor * 5 + "%");
        }else if (multiplierColor == 4){
            valueTextV.setText("" + firstBandColor + "" + secondBandColor + "0" + "\tK\u2126 \t\u00B1" + toleranceColor * 5 + "%");
        }else if (multiplierColor == 5){
            valueTextV.setText("" + firstBandColor + "." + secondBandColor + "\tM\u2126 \t\u00B1" + toleranceColor*5 + "%");
        }else if (multiplierColor == 6) {
            valueTextV.setText("" + firstBandColor + "" + secondBandColor + "\tM\u2126 \t\u00B1" + toleranceColor * 5 + "%");
        }else if (multiplierColor == 7){
            valueTextV.setText("" + firstBandColor + "" + secondBandColor + "0" + "\tM\u2126 \t\u00B1" + toleranceColor * 5 + "%");
        }else if (multiplierColor == 10){
            valueTextV.setText("" + firstBandColor + "." + secondBandColor + "\t\u2126 \t\u00B1" + toleranceColor * 5 + "%");
        }else if (multiplierColor == 11){
            valueTextV.setText("0." + firstBandColor + secondBandColor + "\t\u2126 \t\u00B1" + toleranceColor * 5 + "%");
        }
    }

    /************* Set new colors and values after any change ****************/
    private void setColor(String color, int band){
        int colorCode = 0;
        short value = 0;

        switch (color){
            case "Negro":
                colorCode = R.color.black;
                value = 0;
            case "Marrón":
                colorCode = R.color.saddlebrown;
                value = 1;
                break;
            case "Rojo":
                colorCode = R.color.red;
                value = 2;
                break;
            case "Naranja":
                colorCode = R.color.orangered;
                value = 3;
                break;
            case "Amarillo":
                colorCode = R.color.yellow;
                value = 4;
                break;
            case "Verde":
                colorCode = R.color.green;
                value = 5;
                break;
            case "Azul":
                colorCode = R.color.blue;
                value = 6;
                break;
            case "Violeta":
                colorCode = R.color.purple;
                value = 7;
                break;
            case "Gris":
                colorCode = R.color.gray;
                value = 8;
                break;
            case "Blanco":
                colorCode = R.color.white;
                value = 9;
                break;
            case "Dorado":
                colorCode = R.color.goldenrod;
                value = 10;
                break;
            case "Plateado":
                colorCode = R.color.silver;
                value = 11;
                break;
            default:
        }

        switch (band){
            case 1:
                firstBandColor = value;
                color_1_Button.setBackgroundResource(colorCode);
                break;
            case 2:
                secondBandColor = value;
                color_2_Button.setBackgroundResource(colorCode);
                break;
            case 3:
                multiplierColor = value;
                multiplierButton.setBackgroundResource(colorCode);
                break;
            case 4:
                toleranceColor = (short)(value - 9); // To obtain 1 or 2!
                toleranceButton.setBackgroundResource(colorCode);
                break;
            default:
        }
    }
}
