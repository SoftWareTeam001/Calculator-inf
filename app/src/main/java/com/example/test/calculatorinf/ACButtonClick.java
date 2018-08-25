package com.example.test.calculatorinf;

import android.view.View;

public class ACButtonClick implements View.OnClickListener {
    private FormulaView formulaView;
    public ACButtonClick(FormulaView formulaView){
        this.formulaView=formulaView;
    }
    @Override
    public void onClick(View v){
        MyString.FormulaString="$$ \\Large \\textcolor{cyan} {}$$";
        formulaView.setText(MyString.FormulaString);
        FormulaView.leftMove=0;
    }
}
