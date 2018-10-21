package com.example.test.calculatorinf;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class LeftBtnClick implements View.OnClickListener {
    private FormulaView formulaView;

    public LeftBtnClick(FormulaView paramFormulaView) {
        this.formulaView = paramFormulaView;
    }

    public void onClick(View paramView) {
        int location = MyString.FormulaString.indexOf("{\\textcolor{yellow}|}");
        Boolean hasMoved=false;
        while (true) {
            StringBuilder str = new StringBuilder();
            str.append(MyString.FormulaString.charAt(location - 1));
            Log.i("GifHeaderParser", str.toString());
                if (!str.toString().matches("[0-9]")&&location>25){
                    ControlVar.leftMove += 1;
                    location -= 1;
                    hasMoved=true;
                }
                else {
                    if(!hasMoved){
                        ControlVar.leftMove += 1;
                    }
                    break;
                }
        }
        MyString.MoveCursor(ControlVar.leftMove);
        Log.i("GifHeaderParser", MyString.FormulaString);
    }
}