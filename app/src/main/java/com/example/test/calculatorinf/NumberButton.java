package com.example.test.calculatorinf;

public class NumberButton extends MyButton{
    public NumberButton(String this_String){
        super(this_String);
    }
    public double typeChange(String this_string){
        double value = Double.valueOf(this_string.toString());
        return value;
    }

}
