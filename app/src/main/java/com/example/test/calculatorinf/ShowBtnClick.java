package com.example.test.calculatorinf;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

public class ShowBtnClick implements View.OnClickListener {
    public ShowButton showButton;
    public FormulaView formulaView;
    public String Content;
    public ShowBtnClick(ShowButton showButton,FormulaView formulaView,String Content){
        this.showButton=showButton;
        this.formulaView=formulaView;
        this.Content=Content;
    }
    public void onClick(View v){
        MyString.PopTheEnd();
        showButton.ChangeFormula(Content);
        MyString.AddToEnd();
        formulaView.setText(MyString.FormulaString);
        Log.i(TAG,MyString.FormulaString);
    }
}
