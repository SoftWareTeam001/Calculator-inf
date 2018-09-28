package com.example.test.calculatorinf;

import android.util.Log;

public class MyString {
    public static String FormulaString=new String();
    public static String ResultString=new String();
    public static String InitString="$$ \\Huge \\textcolor{cyan} {{\\textcolor{yellow}|}}$$";
    //替换掉末尾的标识符
    public static void PopTheEnd(){
        FormulaString=FormulaString.replace("{\\textcolor{yellow}|}","");
        FormulaString=FormulaString.replace("}$$","");
        for(int i=0;i<FormulaView.leftMove;i++){
            FormulaString=FormulaString.substring(0,FormulaString.length()-1);
        }
    }
    //添加末尾的标识符
    public static void AddToEnd(){
        FormulaString+="{\\textcolor{yellow}|}";
        for(int i=0;i<FormulaView.leftMove;i++){
            FormulaString+="}";
        }
        FormulaString+="}$$";
    }
    public static void MoveCursor(int paramInt)
    {
        FormulaString = FormulaString.replace("{\\textcolor{yellow}|}", "");
        int i = FormulaString.length();
        StringBuilder localStringBuilder = new StringBuilder(FormulaString);
        localStringBuilder.insert(i - paramInt - 2 - 1, "{\\textcolor{yellow}|}");
        FormulaString = localStringBuilder.toString();
        ((FormulaView)MainActivity.getMainActivity().findViewById(R.id.Formula)).setText(FormulaString);
        Log.i("ContentValues", FormulaString);
    }
    public static void ChangeFormula(String paramString)
    {
        String str = FormulaString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("{\\textcolor{yellow}|}");
        FormulaString = str.replace("{\\textcolor{yellow}|}", localStringBuilder.toString());
    }
}
