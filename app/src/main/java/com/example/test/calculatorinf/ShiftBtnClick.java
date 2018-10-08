package com.example.test.calculatorinf;

import android.view.View;
import android.widget.TextView;

public class ShiftBtnClick implements View.OnClickListener {
    public ShiftBtnClick(){

    }
    @Override
    public void onClick(View v){
        if(ControlVar.Shift && ControlVar.mainPage){
            MainActivity.getMainActivity().setContentView(R.layout.activity_main);
            ControlVar.Shift=false;
        }
        else if(!ControlVar.Shift &&ControlVar.mainPage){
            MainActivity.getMainActivity().setContentView(R.layout.vice_cal_first);
            ControlVar.Shift=true;
        }
        else if(ControlVar.Shift && !ControlVar.mainPage){
            MainActivity.getMainActivity().setContentView(R.layout.cal_three);
            ControlVar.Shift=false;
        }
        else if(!ControlVar.Shift && !ControlVar.mainPage){
            MainActivity.getMainActivity().setContentView(R.layout.cal_four);
            ControlVar.Shift=true;
        }
        Bind bind=new Bind();
        bind.BindFunction();
        FormulaView formulaView=(FormulaView)MainActivity.getMainActivity().findViewById(R.id.Formula);
        TextView textView=(TextView)MainActivity.getMainActivity().findViewById(R.id.Result);
        formulaView.setText(MyString.FormulaString);
        textView.setText(MyString.ResultString);
    }
}
