package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private String input, answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);

    }

    public void ButtonClick(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();

        switch (data){
            case "AC":
                input = "";
            break;
            case "C":
                if (input.length() > 0){
                    String newText = input.substring(0,input.length()-1);
                    input = newText;
                }
            case "=":
                Solve();
                answer = input;
                break;
            case "X":
                input += "*";
                break;
            default:
                if (input == null){
                    input = "";
                }
                if (data.equals("+") || data.equals("/") || data.equals("-")){
                    Solve();
                }
                input += data;
        }
        tv.setText(input);
    }
    public void Solve(){
        if (input.split("\\*").length == 2){
            String[] number = input.split("\\*");
            try {
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = mul+"";
            }catch (Exception ignored){

            }
        }
    }
}