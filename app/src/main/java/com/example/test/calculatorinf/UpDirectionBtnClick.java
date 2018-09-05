package com.example.test.calculatorinf;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;

public class UpDirectionBtnClick implements View.OnClickListener {
    private FormulaView formulaView;
    private TextView textView;
    private Context context;
    public UpDirectionBtnClick(FormulaView formulaView,TextView textView,Context context){
        this.formulaView=formulaView;
        this.textView=textView;
        this.context=context;
    }
    @Override
    public void onClick(View v){
        MyLog myLog=new MyLog(context);
        String[] lastLog=myLog.GetLastLog();
        formulaView.setText(lastLog[0]);
        textView.setText(lastLog[1]);
        MyString.FormulaString=lastLog[0];
        MyString.ResultString=lastLog[1];
    }
}
