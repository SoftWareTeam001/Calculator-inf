package com.example.test.calculatorinf;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DownDirectionBtnClick implements View.OnClickListener {
    private TextView textView;
    private Context context;
    public DownDirectionBtnClick( TextView textView, Context context){
        this.textView=textView;
        this.context=context;
    }
    @Override
    public void onClick(View v){
        try{
            MyLog myLog=new MyLog(context);
            String[] nextLog=myLog.GetNextLog();
            FormulaView formulaView=(FormulaView)MainActivity.getMainActivity().findViewById(R.id.Formula);
            formulaView.setText(nextLog[0]);
            textView.setText(nextLog[1]);
            MyString.FormulaString=nextLog[0];
            MyString.ResultString=nextLog[1];
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
