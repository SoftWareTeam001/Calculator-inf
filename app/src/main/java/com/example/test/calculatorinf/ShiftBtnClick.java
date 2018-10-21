package com.example.test.calculatorinf;

import android.view.View;
import android.widget.TextView;

public class ShiftBtnClick implements View.OnClickListener {
    public ShiftBtnClick(){

    }
    @Override
    public void onClick(View v){
        if(ControlVar.Mode==1 && ControlVar.Shift){
            MainActivity.getMainActivity().setContentView(R.layout.mat_one);
        }
        else if(ControlVar.Mode==2 && ControlVar.Shift){
            MainActivity.getMainActivity().setContentView(R.layout.complex_one);
        }
        else if(ControlVar.Shift && ControlVar.mainPage){
            MainActivity.getMainActivity().setContentView(R.layout.activity_main);
        }
        else if(!ControlVar.Shift &&ControlVar.mainPage){
            MainActivity.getMainActivity().setContentView(R.layout.cal_two);
        }
        else if(ControlVar.Shift && !ControlVar.mainPage){
            MainActivity.getMainActivity().setContentView(R.layout.cal_three);
        }
        else if(!ControlVar.Shift && !ControlVar.mainPage){
            MainActivity.getMainActivity().setContentView(R.layout.cal_four);
        }
        ControlVar.Shift=!ControlVar.Shift;
        Bind bind=new Bind();
        bind.BindFunction();
        FormulaView formulaView=(FormulaView)MainActivity.getMainActivity().findViewById(R.id.Formula);
        TextView textView=(TextView)MainActivity.getMainActivity().findViewById(R.id.Result);
        formulaView.setText(MyString.FormulaString);
        textView.setText(MyString.ResultString);
    }
}
