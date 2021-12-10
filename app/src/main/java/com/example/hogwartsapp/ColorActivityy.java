package com.example.hogwartsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ColorActivityy extends AppCompatActivity {
    private TextView chooseView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        initColor();
        initColorGroup();
        chooseView = findViewById(R.id.chooseView);

    }

    private void initColor() {
        SharedPreferences sharedPref = getSharedPreferences("ColorActivityPreferences", Context.MODE_PRIVATE);
        int colorGroup = sharedPref.getInt("colorGroup", 0XFFFF0000);
        int colorGroup2 = sharedPref.getInt("colorGroup", 0XFF0000FF);
        int colorGroup3 = sharedPref.getInt("colorGroup", 0XFF00FF00);



        RadioButton yellow = findViewById(R.id.yellowrButton);
        RadioButton blue = findViewById(R.id.bluerButton);
        RadioButton green = findViewById(R.id.greenrButton);
        RadioButton red = findViewById(R.id.redrButton);

        if (colorGroup==(0XFFFF0000)) {
            red.setChecked(true);
        } else if (colorGroup2==(0XFF0000FF)) {
            blue.setChecked(true);
        } else if (colorGroup3==(0XFF00FF00)) {
            green.setChecked(true);
        } else {
            yellow.setChecked(true);
        }
    }
    private void initColorGroup() {
        RadioGroup rg = findViewById(R.id.colorGroup);
        RadioButton red = findViewById(R.id.redrButton);
        RadioButton green =  findViewById(R.id.greenrButton);
        RadioButton blue = findViewById(R.id.bluerButton);


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(red.isChecked()){
                    SharedPreferences sp =getSharedPreferences("ColorActivityPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("color", 0xFFFF0000);
                    editor.apply();
                    chooseView.setText("You have chosen Gryffindor!");
                }
                else if( blue.isChecked()){
                    SharedPreferences sp =getSharedPreferences("ColorActivityPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("color", 0xFF0000FF);
                    editor.apply();
                    chooseView.setText("You have chosen Ravenclaw!");
                }

                else if(green.isChecked()){
                    SharedPreferences sp =getSharedPreferences("ColorActivityPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("color", 0xFF00FF00);
                    editor.apply();
                    chooseView.setText("You have chosen Slytherin!");


                } else{
                    SharedPreferences sp =getSharedPreferences("ColorActivityPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("color", 0xFFFFFF00);
                    editor.apply();
                    chooseView.setText("You have chosen Hufflepuff!");


                }
            }
        });
    }
}