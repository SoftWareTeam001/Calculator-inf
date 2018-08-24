package com.example.test.calculatorinf;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.widget.Button;

public class MyButton {

    private String this_String;

    public void onClickButton(String this_String){
        System.out.println(this_String);//屏幕上输出字符
    }

    public MyButton(String this_String) {
        this.this_String=this_String;
    }
}