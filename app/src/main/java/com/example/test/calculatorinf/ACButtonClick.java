package com.example.test.calculatorinf;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class ACButtonClick
        implements View.OnClickListener
{
    private FormulaView formulaView;

    public ACButtonClick(FormulaView paramFormulaView)
    {
        this.formulaView = paramFormulaView;
    }

    public void onClick(View paramView)
    {
        MyString.FormulaString = MyString.InitString;
        this.formulaView.setText(MyString.FormulaString);
        ((TextView)MainActivity.getMainActivity().findViewById(R.id.Result)).setText("");
        ControlVar.reset();
    }
}