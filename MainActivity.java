package com.example.numbercoverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterViewAnimator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button submit;
    private Button decimal;
    private Button binary ;
    private Button hex ;
    private Button oct;
    private TextView answer;
    private TextView display;
    private EditText input;
    private Spinner spinner;
    protected String str;
    protected int num;
    protected String option;
    protected int tempNum;

    public boolean isBinary(String x){
        try{
            Long.parseLong(x,2);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    public boolean isDecimal(String x){
        try{
            Long.parseLong(x,10);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    public boolean isHexa(String x){
        try{
            Long.parseLong(x,16);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    public boolean isOctal(String x){
        try{
            Long.parseLong(x,8);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    public  void initializ(String x){
        try{
        str = input.getText().toString();
       // num = Integer.parseInt(str);
        if(x.equals("Decimal")){
            tempNum = Integer.parseInt(str,10) ;
        }else  if(x.equals("Binary")){
                tempNum = Integer.parseInt(str, 2);
        }else if(x.equals("Hexadecimal")){
            tempNum = Integer.parseInt(str,16);
        }
        else if(x.equals("Octal")){
            tempNum = Integer.parseInt(str,8);
        }
        } catch (NumberFormatException e){
            Toast.makeText(MainActivity.this,"The number is Not "+x,Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = findViewById(R.id.button2);
        decimal = findViewById(R.id.button9);
        binary = findViewById(R.id.button8);
        hex = findViewById(R.id.button7);
        oct = findViewById(R.id.button3);
        answer = findViewById(R.id.textView2);
        display = findViewById(R.id.textView);
        input = findViewById(R.id.editTextNumber);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(this,R.array.number_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        option = "";



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  if(option.equals("Decimal")) {
                      try {
                          initializ(option);
                          if(isDecimal(str)==true) {
                              answer.setText("Binary : " + Integer.toBinaryString(tempNum));
                          }
                      } catch (NumberFormatException n) {
                          Toast.makeText(MainActivity.this, "Number is Too Large or Small", Toast.LENGTH_SHORT).show();
                      }
                  }else if(option.equals("Binary")){
                      try{
                      initializ(option);
                          if(isBinary(str)==true){
                              answer.setText("Binary :"+Integer.toBinaryString(tempNum));
                          }
                      }  catch (NumberFormatException n) {
                          Toast.makeText(MainActivity.this, "Number is Too Large or Small", Toast.LENGTH_SHORT).show();
                      }
                  }else if(option.equals("Hexadecimal")){
                      try {
                          initializ(option);
                          if (isHexa(str) == true) {
                              answer.setText("Binary :" + Integer.toBinaryString(tempNum));
                          }
                      }  catch (NumberFormatException n) {
                          Toast.makeText(MainActivity.this, "Number is Too Large or Small", Toast.LENGTH_SHORT).show();
                      }
                  }
                  else if(option.equals("Octal")){
                      try{
                      initializ(option);
                      if(isOctal(str)==true){
                          answer.setText("Binary :"+Integer.toBinaryString(tempNum));
                      }
                      } catch (NumberFormatException n) {
                          Toast.makeText(MainActivity.this, "Number is Too Large or Small", Toast.LENGTH_SHORT).show();
                      }
                  }
                  else{
                      Toast.makeText(MainActivity.this,"Select a Base",Toast.LENGTH_SHORT).show();
                  }
            }
        });
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(option.equals("Decimal")) {
                    try {
                        initializ(option);
                        if(isDecimal(str)==true) {
                            answer.setText("Decimal : " + tempNum);
                        }
                    } catch (NumberFormatException n) {
                        Toast.makeText(MainActivity.this, "Number is Too Large or Small", Toast.LENGTH_SHORT).show();
                    }
                }else if(option.equals("Binary")){
                    try{
                    initializ(option);
                    if(isBinary(str)==true) {
                        answer.setText("Decimal :" + tempNum);
                    }
                    } catch (NumberFormatException n) {
                        Toast.makeText(MainActivity.this, "Number is Too Large or Small", Toast.LENGTH_SHORT).show();
                    }
                }else if(option.equals("Hexadecimal")){
                    try {
                        initializ(option);
                        if (isHexa(str) == true) {
                            answer.setText("Decimal :" + tempNum);
                        }
                    }  catch (NumberFormatException n) {
                        Toast.makeText(MainActivity.this, "Number is Too Large or Small", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(option.equals("Octal")){
                    try{
                    initializ(option);
                    if(isOctal(str)==true){
                        answer.setText("Decimal :"+tempNum);
                    }
                    } catch (NumberFormatException n) {
                        Toast.makeText(MainActivity.this, "Number is Too Large or Small", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this,"Select a Base",Toast.LENGTH_SHORT).show();
                }
            }
        });
        binary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(option.equals("Decimal")) {
                    try {
                        initializ(option);
                        if(isDecimal(str)==true) {
                            answer.setText("Binary : " + Integer.toBinaryString(tempNum));
                        }
                    } catch (NumberFormatException n) {
                        Toast.makeText(MainActivity.this, "Number is Too Large or Small", Toast.LENGTH_SHORT).show();
                    }
                }else if(option.equals("Binary")){
                    try{
                        initializ(option);
                        if(isBinary(str)==true) {
                            answer.setText("Binary :" + Integer.toBinaryString(tempNum));
                        }
                    }  catch (NumberFormatException n) {
                        Toast.makeText(MainActivity.this, "Number is Too Large or Small", Toast.LENGTH_SHORT).show();
                    }
                }else if(option.equals("Hexadecimal")){
                    try {
                        initializ(option);
                        if (isHexa(str) == true) {
                            answer.setText("Binary :" + Integer.toBinaryString(tempNum));
                        }
                    }  catch (NumberFormatException n) {
                        Toast.makeText(MainActivity.this, "Number is Too Large or Small", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(option.equals("Octal")){
                    try{
                        initializ(option);
                        if(isOctal(str)==true){
                            answer.setText("Binary :"+Integer.toBinaryString(tempNum));
                        }
                    } catch (NumberFormatException n) {
                        Toast.makeText(MainActivity.this, "Number is Too Large or Small", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this,"Select a Base",Toast.LENGTH_SHORT).show();
                }
            }
        });
        hex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(option.equals("Decimal")) {
                    try {
                        initializ(option);
                        if(isDecimal(str)==true) {
                            answer.setText("Hexadecimal : " + Integer.toHexString(tempNum));
                        }
                    } catch (NumberFormatException n) {
                        Toast.makeText(MainActivity.this, "Number is Too Large or Small", Toast.LENGTH_SHORT).show();
                    }
                }else if(option.equals("Binary")){
                    try{
                        initializ(option);
                        if(isBinary(str)==true) {
                            answer.setText("Hexadecimal :" +Integer.toHexString(tempNum));
                        }
                    }  catch (NumberFormatException n) {
                        Toast.makeText(MainActivity.this, "Number is Too Large or Small", Toast.LENGTH_SHORT).show();
                    }
                }else if(option.equals("Hexadecimal")){
                    try {
                        initializ(option);
                        if (isHexa(str) == true) {
                            answer.setText("Hexadecimal :" +Integer.toHexString(tempNum));
                        }
                    }  catch (NumberFormatException n) {
                        Toast.makeText(MainActivity.this, "Number is Too Large or Small", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(option.equals("Octal")){
                    try{
                        initializ(option);
                        if(isOctal(str)==true){
                            answer.setText("Hexadecimal :" +Integer.toHexString(tempNum));
                        }
                    } catch (NumberFormatException n) {
                        Toast.makeText(MainActivity.this, "Number is Too Large or Small", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this,"Select a Base",Toast.LENGTH_SHORT).show();
                }
            }
        });
        oct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(option.equals("Decimal")) {
                    try {
                        initializ(option);
                        if(isDecimal(str)) {
                            answer.setText("Octal : " + Integer.toOctalString(tempNum));
                        }
                    } catch (NumberFormatException n) {
                        Toast.makeText(MainActivity.this, "Number is Too Large or Small", Toast.LENGTH_SHORT).show();
                    }
                }else if(option.equals("Binary")){
                    try{
                        initializ(option);
                        if(isBinary(str)==true) {
                            answer.setText("Octal : " + Integer.toOctalString(tempNum));
                        }
                    }  catch (NumberFormatException n) {
                        Toast.makeText(MainActivity.this, "Number is Too Large or Small", Toast.LENGTH_SHORT).show();
                    }
                }else if(option.equals("Hexadecimal")){
                    try {
                        initializ(option);
                        if (isHexa(str) == true) {
                            answer.setText("Octal : " + Integer.toOctalString(tempNum));
                        }
                    }  catch (NumberFormatException n) {
                        Toast.makeText(MainActivity.this, "Number is Too Large or Small", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(option.equals("Octal")){
                    try{
                        initializ(option);
                        if(isOctal(str)==true){
                            answer.setText("Octal : " + Integer.toOctalString(tempNum));
                        }
                    } catch (NumberFormatException n) {
                        Toast.makeText(MainActivity.this, "Number is Too Large or Small", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this,"Select a Base",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        answer.setText("");
        String text = parent.getItemAtPosition(position).toString();
        option=text;

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(MainActivity.this, "Select a Base ", Toast.LENGTH_SHORT).show();
    }
}