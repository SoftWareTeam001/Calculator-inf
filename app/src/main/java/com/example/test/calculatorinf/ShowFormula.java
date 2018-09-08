package com.example.test.calculatorinf;

import android.widget.TextView;

public class ShowFormula {
    private FormulaView formulaView;
    private TextView textView;
    public ShowFormula(FormulaView formulaView,TextView textView){
        this.formulaView=formulaView;
        this.textView=textView;
    }
    public void Show(){
        formulaView.setText(MyString.FormulaString);
        textView.setText(MyString.ResultString);
    }
}
