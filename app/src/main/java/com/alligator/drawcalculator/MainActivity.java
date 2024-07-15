package com.alligator.drawcalculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.lang.Character;

public class MainActivity extends AppCompatActivity
{
    // <editor-fold desc="Public Declarations">
    public String CurrentExpression;
    public char CurrentOperand;
    public double Result;
    private TextView _currentExpressionText;
    private TextView _currentOutputText;
    // </editor-fold>

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        _currentExpressionText = findViewById(R.id.currentCalc);
        _currentOutputText = findViewById(R.id.solutionView);
        CurrentExpression = "";
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void GetValue(View v)
    {
        if (!(v instanceof Button)) return;
        Button currButton = (Button) v;
        String currentText = currButton.getText().toString();
        if(currentText.equals("=")) return;
        CurrentExpression += currentText;
        _currentExpressionText.setText(CurrentExpression);
//        char currentChar = currentText.charAt(0);
//        if(Character.isDigit(currentChar))
//        {
//            Log.d("current value",String.valueOf(currentChar));
//        }
    }
}