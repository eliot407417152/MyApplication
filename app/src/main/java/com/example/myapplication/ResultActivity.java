package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import  java.text.NumberFormat;

public class ResultActivity extends AppCompatActivity{
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tvResult = (TextView) findViewById(R.id.tvResult);
        showResults();
    }

    private void showResults(){
        NumberFormat nf =NumberFormat.getInstance();
        Bundle bundle = getIntent().getExtras();
        int programming = bundle.getInt("programming");
        int dataStruct = bundle.getInt("dataStructure");
        int algorithm = bundle.getInt("algorithm");
        int sum = programming + dataStruct + algorithm;
        double average = sum / 3.0;
        String text = "programming = " + programming+
                "\ndataStructure = " + dataStruct +
                "\nalgorithm = " +algorithm +
                "\nsum = " + sum +
                "\naverage = " + nf.format(average);
        tvResult.setText(text);
        alert(average);
    }
    private void alert(double average){
        String message = new String();
        String title = new String();
        int pic = 0;

        if(average == 100){
            message = "100";
            title = "PASS";
            pic = R.drawable.circle;
        }

        else if (average>=60){
            message = "Congratulation!!";
            title = "PASS";
            pic = R.drawable.circle;
        }
        else{
            message = "bye:)";
            title = "FAIL";
            pic = R.drawable.bye;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.setIcon(pic);
        builder.show();
    }

    public void onBackClick(View view){
        finish();
    }
}