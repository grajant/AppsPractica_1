package com.example.glego.resistorsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by HOME-I on 19/02/2017.
 */

public class ColorsListActivity extends AppCompatActivity {

    private ArrayList<ResistorCode> list;
    private ListView listView;
    private TextView titleTextV;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors_list);
        titleTextV = (TextView) findViewById(R.id.listColorTitle);
        Intent intent = getIntent();

        int value = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0);

        switch (value){
            case 1:
                list = ResistorCode.firstBandValues();
                titleTextV.setText("Primera banda");
                setList();
                break;
            case 2:
                list = ResistorCode.secondBandValues();
                titleTextV.setText("Segunda banda");
                setList();
                break;
            case 3:
                list = ResistorCode.multiplierBand();
                titleTextV.setText("Multiplicador");
                setList();
                break;
            case 4:
                list = ResistorCode.toleranceBand();
                titleTextV.setText("Tolerancia");
                setList();
                break;
            default:
        }
    }

    private void setList(){
        MyAdapter adapter = new MyAdapter(this, list);
        listView = (ListView) findViewById(R.id.listView_Colors);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(listItemListener);
    }

    OnItemClickListener listItemListener = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent();
            ResistorCode selectedColor = list.get(position);

            intent.putExtra("color", selectedColor.color);
            setResult(RESULT_OK, intent);
            finish();
        }
    };
}
