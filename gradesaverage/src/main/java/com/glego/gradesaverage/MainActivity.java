package com.glego.gradesaverage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText practicasEditT;
    private EditText avanceIEditT;
    private EditText avanceIIEditT;
    private EditText avanceIIIEditT;
    private EditText finalAppEditT;
    private TextView finalGradeEditT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        practicasEditT = (EditText) findViewById(R.id.practicasET);
        avanceIEditT = (EditText) findViewById(R.id.avanceIET);
        avanceIIEditT = (EditText) findViewById(R.id.avanceIIET);
        avanceIIIEditT = (EditText) findViewById(R.id.avanceIIIET);
        finalAppEditT = (EditText) findViewById(R.id.finalAppET);
        finalGradeEditT = (TextView) findViewById(R.id.finalGradeET);
    }

    public void calculateGrade(View view) {
        //Double gradeSum = 0.0;
        Double average;
        String practicas, avanceI, avanceII, avanceIII, finalApp;

        practicas = practicasEditT.getText().toString();
        avanceI = avanceIEditT.getText().toString();
        avanceII = avanceIIEditT.getText().toString();
        avanceIII = avanceIIIEditT.getText().toString();
        finalApp = finalAppEditT.getText().toString();

        if ( practicas.equals("") | avanceI.equals("") | avanceII.equals("") |
                avanceIII.equals("") | finalApp.equals("")){
            Toast.makeText(this, R.string.empty_fields,Toast.LENGTH_LONG).show();
        }else {
            if ( Double.parseDouble(practicasEditT.getText().toString()) > 5 )
                Toast.makeText(this, "La nota de practicas es mayor que 5.\n" + getString(R.string.grade_error), Toast.LENGTH_SHORT).show();
            else if ( Double.parseDouble(avanceIEditT.getText().toString()) > 5 )
                Toast.makeText(this, "La nota de avance 1 es mayor que 5.\n" + getString(R.string.grade_error), Toast.LENGTH_SHORT).show();
            else if ( Double.parseDouble(avanceIIEditT.getText().toString()) > 5 )
                Toast.makeText(this, "La nota de avance 2 es mayor que 5.\n" + getString(R.string.grade_error), Toast.LENGTH_SHORT).show();
            else if ( Double.parseDouble(avanceIIIEditT.getText().toString()) > 5 )
                Toast.makeText(this, "La nota de avance 3 es mayor que 5.\n" + getString(R.string.grade_error), Toast.LENGTH_SHORT).show();
            else if ( Double.parseDouble(finalAppEditT.getText().toString()) > 5 )
                Toast.makeText(this, "La nota de la aplicación final es mayor que 5.\n" + getString(R.string.grade_error), Toast.LENGTH_SHORT).show();
            else {
                average = Double.parseDouble(practicasEditT.getText().toString()) * 0.6;
                average += Double.parseDouble(avanceIEditT.getText().toString()) * 0.05;
                average += Double.parseDouble(avanceIIEditT.getText().toString()) * 0.07;
                average += Double.parseDouble(avanceIIIEditT.getText().toString()) * 0.08;
                average += Double.parseDouble(finalAppEditT.getText().toString()) * 0.2;

                finalGradeEditT.setText(average.toString());

                if( average >= 0 && average <= 1 ){
                    Toast.makeText(this, "Estás en el lugar equivocado", Toast.LENGTH_SHORT).show();
                }else if( average > 1 && average <= 2){
                    Toast.makeText(this, "Remal", Toast.LENGTH_SHORT).show();
                }else if( average > 2 && average <= 3){
                    Toast.makeText(this, "Es posible recuperarse", Toast.LENGTH_SHORT).show();
                }else if( average > 3 && average <= 4){
                    Toast.makeText(this, "Normalito", Toast.LENGTH_SHORT).show();
                }else if( average > 4 && average <= 4.5){
                    Toast.makeText(this, "Muy bien", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Excelente estudiante", Toast.LENGTH_SHORT).show();
                }
            }


        }
        /*
        a. Si la nota está entre 0 y 1 imprime “Estas en el lugar equivocado”
        b. Si la nota está entre 1.1 y 2 imprime “Remal”
        c. Si la nota está entre 2.1 y 3 imprime “Es posible recuperarse”
        d. Si la nota está entre 3.1 y 4 imprime “Normalito”
        e. Si la nota está entre 4.1 y 4.5 imprime “Muy Bien”
        f. Si la nota está entre 4.6 y 5 imprime “Excelente estudiante”
         */
    }
}
