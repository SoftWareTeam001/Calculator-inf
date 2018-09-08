package com.example.test.calculatorinf;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import java.io.FileOutputStream;

import static android.content.ContentValues.TAG;

public class Equal implements View.OnClickListener {
    private WebView webView;
    private TextView textView;
    private Context mContext;
    public Equal(WebView webView,TextView textView,Context mContext){
        this.webView=webView;
        this.textView=textView;
        this.mContext=mContext;
    }
    @Override
    public void onClick(View v){
        Log.i(TAG,handleFormulaString());
        webView.post(new Runnable() {
             @Override
             public void run() {
                 webView.evaluateJavascript("javascript:calculate("+handleFormulaString()+")", new ValueCallback<String>() {
                     @Override
                     public void onReceiveValue(String value) {
                         MyString.ResultString=value;
                         textView.setText(MyString.ResultString);
                         Log.i(TAG,MyString.ResultString);
                         if(!value.equals("null")){
                             try{
                                 MyLog myLog=new MyLog(mContext);
                                 myLog.WriteLog();
                                 reset();
                             }
                             catch (Exception e){
                                 e.printStackTrace();
                             }
                         }
                     }
                 });
             }
         });
}
    private String handleFormulaString(){
        String initString=MyString.FormulaString;
        //去除修饰
        initString=initString.replace("{\\textcolor{yellow}|}","");
        String Regex="(.*?\\{)";
        initString=initString.replaceFirst(Regex, "");
        initString=initString.replaceFirst(Regex, "");
        Regex="(\\}\\$\\$)";
        initString=initString.replaceFirst(Regex, "");

        //解决power
        Regex="(\\d+?^)";
        initString=initString.replaceAll("(?=\\d+\\^)","Math.pow(");
        initString=initString.replaceAll("(?<=\\^\\{\\d{1,100})\\}", ")");
        initString=initString.replaceAll("\\^\\{", ",");
        //解决三角函数
        initString=initString.replaceAll("\\\\sin","Math.sin");
        initString=initString.replaceAll("\\\\cos","Math.cos");
        initString=initString.replaceAll("\\\\tan","Math.cos");
        initString=initString.replaceAll("\\\\arcsin","Math.asin");
        initString=initString.replaceAll("\\\\arccos","Math.acos");
        initString=initString.replaceAll("\\\\arctan","Math.atan");
        //解决符号
        initString=initString.replaceAll("\\\\times","*");
        initString=initString.replaceAll("\\\\div","/");
        //解决对数
        initString=initString.replaceAll("\\\\ln","Math.log");
        initString=initString.replaceAll("\\\\lg","lg");
        //解决pi
        initString=initString.replaceAll("\\\\pi","Math.PI");
        return initString;
    }
    public void reset(){
        MyString.FormulaString="$$ \\Huge \\textcolor{cyan} {}$$";
        FormulaView.leftMove=0;
        MyLog.currentLog=0;
    }
}
