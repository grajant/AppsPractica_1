package com.example.glego.practica1apps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Flags
    private static boolean addFlag = false;
    private static boolean subFlag = false;
    private static boolean divFlag = false;
    private static boolean mulFlag = false;
    private static boolean equalFlag = false;
    private static boolean mathError = false;
    private static boolean isFloat = false;
    private static boolean isCleared = true;
    // Graphical Objects
    private TextView editableText;
    private TextView resultText;

    // String values
    private String totalText = "";
    private String currentText = "";

    // Numeric variables
    Double accumulator = 0.0;
    Double currentNumber = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editableText = (TextView) findViewById(R.id.numbersText);
        resultText = (TextView) findViewById(R.id.resultText);
        Log.d("Checking", accumulator.toString());


    }
    /************ Functions for buttons ****************/
    public void clearButtonClicked(View view) {
        addFlag = false;
        subFlag = false;
        divFlag = false;
        mulFlag = false;
        equalFlag = false;
        isFloat = false;
        isCleared = true;
        editableText.setText("");
        resultText.setText("0");
        totalText = "";
        currentText = "";
        accumulator = 0.0;
    }

    public void resultButtonClicked(View view) {     //result
        if(!isCleared && !currentText.equals("")) {
            calculateResult();
            equalFlag = true;
            currentText = "";
        }
    }

    public void pointButtonClicked(View view) {     //point
        if (!isFloat) {
            showCurrentText(".");
            isFloat = true;
        }
    }

    public void eraseButtonClicked(View view) {
        if(!currentText.equals("")) {
            if (currentText.length() == 1) {
                currentText = "";
            }
            else
                currentText = currentText.subSequence(0, currentText.length() - 1).toString();
            if (totalText.length() == 1)
                totalText = "";
            else
                totalText = totalText.subSequence(0, totalText.length() - 1).toString();
            showCurrentText("");
        }
    }

    public void zeroButtonClicked(View view) {     //#0
        showCurrentText("0");
    }

    public void oneButtonClicked(View view) {       // #1
        showCurrentText("1");
    }

    public void twoButtonClicked(View view) {       // #2
        showCurrentText("2");
    }
    public void threeButtonClicked(View view) {     // #3
        showCurrentText("3");
    }

    public void fourButtonClicked(View view) {     //#4
        showCurrentText("4");
    }

    public void fiveButtonClicked(View view) {     //#5
        showCurrentText("5");
    }

    public void sixButtonClicked(View view) {     //#6
        showCurrentText("6");
    }

    public void sevenButtonClicked(View view) {     //#7
        showCurrentText("7");
    }

    public void eightButtonClicked(View view) {     //#8
        showCurrentText("8");
    }

    public void nineButtonClicked(View view) {     //#9
        showCurrentText("9");
    }

    public void multiplyButtonClicked(View view) {     //multiply
        if( (!mulFlag && !addFlag && !subFlag && !divFlag && !isCleared) || !currentText.equals("")  ) {
            calculateResult();
            if (mathError)
                processMathError();
            else {
                showAllText(" x ");
                currentText = "";
                mulFlag = true;
            }
        }
    }

    public void divideButtonClicked(View view) {     //divide
        if( (!mulFlag && !addFlag && !subFlag && !divFlag && !isCleared) || !currentText.equals("") ) {
            calculateResult();
            if (mathError)
                processMathError();
            else {
                showAllText(" \u00F7 ");
                currentText = "";
                divFlag = true;
            }
        }
    }

    public void addButtonClicked(View view) {     //add
        if( (!mulFlag && !addFlag && !subFlag && !divFlag && !isCleared) || !currentText.equals("") ) {
            calculateResult();
            if(mathError)
                processMathError();
            else {
                showAllText(" + ");
                currentText = "";
                addFlag = true;
            }
        }
    }

    public void subButtonClicked(View view) {     //subtrac
        if( (!mulFlag && !addFlag && !subFlag && !divFlag) || (!currentText.equals("") || isCleared)) {
            calculateResult();
            if (mathError)
                processMathError();
            else{
                showAllText(" - ");
                currentText = "";
                subFlag = true;
            }
        }
    }
    /**************************************************/
    /******** Functions to display information ********/
    private void showCurrentText(String number){
        totalText += number;
        currentText += number;
        if(currentText.equals(""))
            resultText.setText("0");
        else
            resultText.setText(currentText);
        equalFlag = false;
        mathError = false;
    }

    private void showAllText(String number){
        totalText += number;
        editableText.setText(totalText);
        isCleared = false;
    }
    private void showResult(){
        currentText = accumulator.toString();
        resultText.setText(currentText);
        currentText = "";
    }
    /**************************************************/

    /********************************************************/
    /****** Functions to calculate every operation *********/
    private void add(){
        try {
            currentNumber = Double.parseDouble(currentText);
        }catch (Exception e){
            Log.i("Error:", currentNumber.toString());
        }
        accumulator += currentNumber;
        showResult();
    }

    private void subtract(){
        currentNumber = Double.parseDouble(currentText);
        accumulator -= currentNumber;
        showResult();
    }
    private void multiply(){
        currentNumber = Double.parseDouble(currentText);
        accumulator *= currentNumber;
        showResult();
    }

    private void divide(){
        currentNumber = Double.parseDouble(currentText);
        try{
            if(currentNumber == 0.0) {
                resultText.setText("Math Error");
                totalText = "";
                currentText = "";
                isCleared = true;
                mathError = true;
            }
            else {
                accumulator /= currentNumber;
                showResult();
            }
        }catch (Exception e){
            Log.i("Division Error:", "Divided by zero");
        }

    }
    /*****************************************************/

    private void calculateResult(){
        if(addFlag){
            add();
            showAllText("");
            addFlag = false;
        }else if(subFlag){
            subtract();
            showAllText("");
            subFlag = false;
        }else if(mulFlag){
            multiply();
            showAllText("");
            mulFlag = false;
        }else if(divFlag) {
            divide();
            showAllText("");
            divFlag = false;
        }else {
            if(!isCleared && !equalFlag){
                totalText = currentText;
            }
            try {
                accumulator = Double.parseDouble(currentText);
            }catch (Exception e){
                Log.i("Bad conversion: ", accumulator.toString());
            }
        }
        isFloat = false;
        equalFlag = false;
    }

    private void processMathError(){
        accumulator = 0.0;
        mathError = false;
        isCleared = true;
    }

}
