package com.example.test.calculatorinf;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

public class ShowBtnClick implements View.OnClickListener {
    public ShowButton showButton;
    public String Content;
    public ShowBtnClick(ShowButton showButton,String Content){
        this.showButton=showButton;
        this.Content=Content;
    }
    public void onClick(View v){

        MyString.PopTheEnd();
        showButton.ChangeFormula(Content);
        MyString.AddToEnd();
        Log.i(TAG,MyString.FormulaString);
        //转变
        if(ControlVar.Shift){
            MainActivity.getMainActivity().setContentView(R.layout.activity_main);
            ControlVar.Shift=false;
        }
        FormulaView formulaView=(FormulaView)MainActivity.getMainActivity().findViewById(R.id.Formula);
        formulaView.setText(MyString.FormulaString);
        Bind bind=new Bind();
        bind.BindFunction();
    }
}
