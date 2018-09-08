package com.example.test.calculatorinf;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;

public class UpDirectionBtnClick implements View.OnClickListener {
    private TextView textView;
    private Context context;
    public UpDirectionBtnClick(TextView textView,Context context){
        this.textView=textView;
        this.context=context;
    }
    @Override
    public void onClick(View v){
        MyLog myLog=new MyLog(context);
        String[] lastLog=myLog.GetLastLog();
        FormulaView formulaView=(FormulaView)MainActivity.getMainActivity().findViewById(R.id.Formula);
        formulaView.setText(lastLog[0]);
        textView.setText(lastLog[1]);
        MyString.FormulaString=lastLog[0];
        MyString.ResultString=lastLog[1];
    }
}
