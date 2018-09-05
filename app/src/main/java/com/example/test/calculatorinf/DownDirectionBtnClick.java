package com.example.test.calculatorinf;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;

public class DownDirectionBtnClick implements View.OnClickListener {
    private FormulaView formulaView;
    private TextView textView;
    private Context context;
    public DownDirectionBtnClick(FormulaView formulaView, TextView textView, Context context){
        this.formulaView=formulaView;
        this.textView=textView;
        this.context=context;
    }
    @Override
    public void onClick(View v){
        MyLog myLog=new MyLog(context);
        String[] nextLog=myLog.GetNextLog();
        formulaView.setText(nextLog[0]);
        textView.setText(nextLog[1]);
        MyString.FormulaString=nextLog[0];
        MyString.ResultString=nextLog[1];
    }
}
