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
        while (true) {
            StringBuilder str = new StringBuilder();
            str.append(MyString.FormulaString.charAt(location - 1));
            Log.i("GifHeaderParser", str.toString());
            if (location >= 25) {
                if (str.toString().matches("[a-z]")||str.toString().matches(" ")) {
                    ControlVar.leftMove += 1;
                    location -= 1;
                }
                else {
                    break;
                }
            }
        }
        ControlVar.leftMove += 1;
        MyString.MoveCursor(ControlVar.leftMove);
        Log.i("GifHeaderParser", MyString.FormulaString);
    }
}