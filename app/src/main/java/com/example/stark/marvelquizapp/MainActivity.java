package com.example.stark.marvelquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Button enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nametxt);
        enter = findViewById(R.id.btnenter);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nam = name.getText().toString();

                Toast.makeText(MainActivity.this,"You Made it "+nam+" !",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this,QuizPage.class);
                startActivity(intent);
            }
        });
    }
}
