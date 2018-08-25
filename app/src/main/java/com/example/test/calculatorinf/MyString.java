package com.example.test.calculatorinf;

public class MyString {
    public static StringBuilder FormulaString=new StringBuilder();
    public static void PopTheEnd(){
        int start=FormulaString.length()-3;
        int end=FormulaString.length();
        FormulaString.delete(start,end);
    }
    public static void AddToEnd(){
        FormulaString.append(" }$$");
    }
}
