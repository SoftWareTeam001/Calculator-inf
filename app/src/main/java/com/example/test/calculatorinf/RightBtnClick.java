package com.example.test.calculatorinf;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class RightBtnClick
        implements View.OnClickListener
{
    private FormulaView formulaView;

    public RightBtnClick(FormulaView paramFormulaView)
    {
        this.formulaView = paramFormulaView;
    }

    public void onClick(View paramView)
    {
        if ((ControlVar.leftMove > 0) && (!ControlVar.sub))
        {
            ControlVar.leftMove -= 1;
            MyString.MoveCursor(ControlVar.leftMove);
        }
        if (ControlVar.sub)
        {
            ControlVar.leftMove -= ControlVar.NextMove;
            MyString.MoveCursor(ControlVar.leftMove);
            ControlVar.sub = false;
        }
        Log.i("ContentValues", MyString.FormulaString);
    }
}