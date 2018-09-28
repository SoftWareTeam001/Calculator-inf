package com.example.test.calculatorinf;

import android.util.Log;
import android.view.View;

public class SpecialBtnClick extends ShowBtnClick
{
    public SpecialBtnClick(String paramString)
    {
        super(paramString);
    }

    public void onClick(View paramView)
    {
        ControlVar.leftMove += 1;
        super.onClick(paramView);
        MyString.MoveCursor(ControlVar.leftMove);
        Log.i("ContentValues", MyString.FormulaString);
    }
}