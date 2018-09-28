package com.example.test.calculatorinf;

import android.util.Log;
import android.view.View;

import static android.content.ContentValues.TAG;

public class DeleteBtnClick implements View.OnClickListener {
    public FormulaView formulaView;
    public DeleteBtnClick(FormulaView formulaView){
        this.formulaView=formulaView;
    }
    @Override
    public void onClick(View v) {
        int location = MyString.FormulaString.indexOf("{\\textcolor{yellow}|}");
        String str="";
        while (true) {
            str=MyString.FormulaString.charAt(location - 1)+"";
            Log.i(TAG, "Char:"+str);
            if (location >= 25) {
                if (str.matches("[a-z]") || str.matches("[A-Z]") || str.matches("_")) {
                    StringBuilder s = new StringBuilder();
                    s.append(MyString.FormulaString.substring(0, location - 1));
                    s.append(MyString.FormulaString.substring(location, MyString.FormulaString.length()));
                    MyString.FormulaString = s.toString();
                    location-=1;
                }
                else if (str.matches("\\{") || str.matches("\\}")) {
//                    StringBuilder s = new StringBuilder();
//                    s.append(MyString.FormulaString.substring(0, location - 1));
//                    s.append(MyString.FormulaString.substring(location, MyString.FormulaString.length()));
//                    MyString.FormulaString = s.toString();
                    MyString.MoveCursor(ControlVar.leftMove+1);
                    ControlVar.leftMove+=1;
                    Log.i(TAG,"MoveCursor");
                    //删除空白大括号
                    MyString.FormulaString=MyString.FormulaString.replaceAll("\\{\\}","");
                    break;
                }
                else{
                    StringBuilder s = new StringBuilder();
                    s.append(MyString.FormulaString.substring(0, location - 1));
                    s.append(MyString.FormulaString.substring(location, MyString.FormulaString.length()));
                    MyString.FormulaString = s.toString();
                    break;
                }
            }
        else {
                this.formulaView.setText(MyString.FormulaString);
                break;
            }
        }
        Log.i(TAG, MyString.FormulaString);
        this.formulaView.setText(MyString.FormulaString);
    }
}
