package com.example.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView solution, result;
    MaterialButton plus, minus, ac, multiply, c_button, open_bracket, close_bracket, divide, equal, dot, one, two, three, four, five, six, seven, eight, nine, zero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        solution = findViewById(R.id.solution);

        assignID(plus, R.id.plus);
        assignID(minus, R.id.minus);
        assignID(ac, R.id.ac);
        assignID(multiply, R.id.multiply);
        assignID(c_button, R.id.c_button);
        assignID(open_bracket, R.id.open_bracket);
        assignID(close_bracket, R.id.close_bracket);
        assignID(divide, R.id.divide);
        assignID(equal, R.id.equal);
        assignID(dot, R.id.dot);
        assignID(one, R.id.one);
        assignID(two, R.id.two);
        assignID(three, R.id.three);
        assignID(four, R.id.four);
        assignID(five, R.id.five);
        assignID(six, R.id.six);
        assignID(seven, R.id.seven);
        assignID(eight, R.id.eight);
        assignID(nine, R.id.nine);
        assignID(zero, R.id.zero);

    }

    void assignID(MaterialButton button, int id) {
        button = findViewById(id);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        MaterialButton button = (MaterialButton) view;
        String data = button.getText().toString();
        String datatoCalculate = solution.getText().toString();

        if(data.equals("AC")){
            solution.setText("");
            result.setText("0");
            return;
        }
        if (data.equals("=")){
            solution.setText(result.getText().toString());
            result.setText("");
            return;
        }

        if (data.equals("C")){

                datatoCalculate = datatoCalculate.substring(0, datatoCalculate.length() - 1);
        } else{
            datatoCalculate = datatoCalculate + data;
        }
        solution.setText(datatoCalculate);

        String finalResult = getResult(datatoCalculate);
        if (!finalResult.equals("Error")){
            result.setText(finalResult);
        }
    }

    String getResult(String data) {
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scope = context.initStandardObjects();
           String finalResult = context.evaluateString(scope,data, "JavaScript", 1, null).toString();
           if (finalResult.endsWith(".0")){
                finalResult = finalResult.replace(".0", "");
           }
            return finalResult;
        } catch (Exception e) {
            return "Error";
        }
    }
}
