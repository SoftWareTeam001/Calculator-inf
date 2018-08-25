package com.example.test.calculatorinf;

import android.util.Log;
import android.view.View;

import static android.content.ContentValues.TAG;

public class SpecialBtnClick extends ShowBtnClick {
    public SpecialBtnClick(ShowButton showButton,FormulaView formulaView,String Content){
        super(showButton,formulaView,Content);
    }
    @Override
    public void onClick(View v){
        super.onClick(v);
        FormulaView.leftMove+=1;
    }
}
