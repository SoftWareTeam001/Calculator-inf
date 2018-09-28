package com.example.test.calculatorinf;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class ShowBtnClick implements View.OnClickListener
{
    public String Content;

    public ShowBtnClick(String content)
    {
        this.Content = content;
    }

    public void onClick(View paramView)
    {
        MyString.ChangeFormula(this.Content);
        Log.i("ContentValues", MyString.FormulaString);
        if (ControlVar.Shift)
        {
            MainActivity.getMainActivity().setContentView(R.layout.activity_main);
            ControlVar.Shift = false;
        }
        ((FormulaView)MainActivity.getMainActivity().findViewById(R.id.Formula)).setText(MyString.FormulaString);
        new Bind().BindFunction();
    }
}