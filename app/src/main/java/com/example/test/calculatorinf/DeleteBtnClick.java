package com.example.test.calculatorinf;

import android.view.View;

public class DeleteBtnClick implements View.OnClickListener {
    public FormulaView formulaView;
    public DeleteBtnClick(FormulaView formulaView){
        this.formulaView=formulaView;
    }
    @Override
    public void onClick(View v){
        MyString.FormulaString=MyString.FormulaString.substring(0,MyString.FormulaString.length()-4);
        MyString.AddToEnd();
        formulaView.setText(MyString.FormulaString);
    }
}
