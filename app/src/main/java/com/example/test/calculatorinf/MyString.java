package com.example.test.calculatorinf;

public class MyString {
    public static String FormulaString=new String();
    public static String ResultString=new String();
    //替换掉末尾的标识符
    public static void PopTheEnd(){
        FormulaString=FormulaString.replace("}$$","");
        for(int i=0;i<FormulaView.leftMove;i++){
            FormulaString=FormulaString.substring(0,FormulaString.length()-1);
        }
    }
    //添加末尾的标识符
    public static void AddToEnd(){
        for(int i=0;i<FormulaView.leftMove;i++){
            FormulaString+="}";
        }
        FormulaString+="}$$";

    }
}
