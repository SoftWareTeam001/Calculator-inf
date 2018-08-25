package com.example.test.calculatorinf;

public class MyString {
    public static String FormulaString=new String();
    //替换掉末尾的标识符
    public static void PopTheEnd(){
        FormulaString=FormulaString.replace("}$$","");
    }
    //添加末尾的标识符
    public static void AddToEnd(){
        FormulaString+="}$$";
    }
}
