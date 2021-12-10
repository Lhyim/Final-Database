package com.example.hogwartsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    private ConstraintLayout layout;
    private EditText editName;
    private TextView titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setForEditing(true);
        layout = findViewById(R.id.layout);
        editName = findViewById(R.id.nameEdit);
        titleView = findViewById(R.id.titleView);
        initColorButton();
    }
    private void setForEditing(boolean enabled) {
        EditText editName = findViewById(R.id.nameEdit);
        editName.setEnabled(enabled);
    }

        private void initColorButton() {
        Button ColorButton = findViewById(R.id.ColorButton);
        ColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ColorActivityy.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

        public void onResume() {
        super.onResume();
        SharedPreferences sharedPref = getSharedPreferences("ColorActivityPreferences", Context.MODE_PRIVATE);

        int colorGroup = sharedPref.getInt("color", 0XFFFF0000);
        int colorGroup2 = sharedPref.getInt("color", 0XFF0000FF);
        int colorGroup3 = sharedPref.getInt("color", 0XFF00FF00);


        if (colorGroup == (0XFFFF0000)) {
            layout.setBackgroundColor(colorGroup);
            String name = editName.getText().toString();
            titleView.setText("Hello "+name+"!\nYou have chosen Gryffindor!");
        } else if (colorGroup2 == (0XFF0000FF)) {
            layout.setBackgroundColor(colorGroup2);
            String name = editName.getText().toString();
            titleView.setText("Hello "+name+"\nYou have chosen Ravenclaw!");
        } else if (colorGroup3 == (0XFF00FF00)) {
            layout.setBackgroundColor(colorGroup3);
            String name = editName.getText().toString();
            titleView.setText("Hello "+name+"\nYou have chosen Slytherin!");
        } else {
            String name = editName.getText().toString();
            layout.setBackgroundColor(colorGroup);
            titleView.setText("Hello "+name+"\nYou have chosen Hufflepuff!");
        }
    }
}