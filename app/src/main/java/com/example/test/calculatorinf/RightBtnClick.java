package com.example.test.calculatorinf;

import android.util.Log;
import android.view.View;

import static android.content.ContentValues.TAG;

public class RightBtnClick implements View.OnClickListener {
    private FormulaView formulaView;
    public RightBtnClick(FormulaView formulaView){
        this.formulaView=formulaView;
    }
    @Override
    public void onClick(View v){
        if(FormulaView.leftMove>0){
            FormulaView.leftMove-=1;
            MyString.PopTheEnd();
            MyString.AddToEnd();
            formulaView.setText(MyString.FormulaString);
            Log.i(TAG,MyString.FormulaString);
        }
    }
}
