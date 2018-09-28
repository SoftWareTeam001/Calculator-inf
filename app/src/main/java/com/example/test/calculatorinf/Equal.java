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
        Log.i(TAG,"handleResult"+handleFormulaString());
        webView.post(new Runnable() {
             @Override
             public void run() {
             webView.evaluateJavascript("javascript:calculate("+handleFormulaString()+")", new ValueCallback<String>() {
                 @Override
                 public void onReceiveValue(String value) {
                     MyString.ResultString=value;
                     textView.setText(MyString.ResultString);
                     Log.i(TAG,MyString.ResultString);
                     if(value=="null"){
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
        Log.i(TAG,initString);
        //解决组合
        initString=initString.replaceAll("C_\\{","math.combinations(");
        initString=initString.replaceAll("(?<=math.combinations\\(.{1,100})\\}\\^\\{",",");
        initString=initString.replaceAll("(?<=math.combinations\\(.{1,100},.{1,100})\\}",")");
        //解决排列
        initString=initString.replaceAll("P_\\{","math.permutations(");
        initString=initString.replaceAll("(?<=math.permutations\\(.{1,100})\\}\\^\\{",",");
        initString=initString.replaceAll("(?<=math.permutations\\(.{1,100},.{1,100})\\}",")");
        //解决根号
        initString=initString.replaceAll("\\\\sqrt\\[2\\]\\{","math.sqrt(");
        initString=initString.replaceAll("(?<=math.sqrt\\(.{1,100})\\}",")");
        //解决power
        initString=initString.replaceAll("(?=\\d{1,100}\\^)","math.pow(");
        initString=initString.replaceAll("(?<=\\^\\{\\d{1,100})\\}", ")");
        initString=initString.replaceAll("\\^\\{", ",");
        //解决三角函数
        if(ControlVar.rad){
            initString=initString.replaceAll("\\\\sin","math.sin");
            initString=initString.replaceAll("\\\\cos","math.cos");
            initString=initString.replaceAll("\\\\tan","math.cos");
            initString=initString.replaceAll("\\\\arcsin","math.asin");
            initString=initString.replaceAll("\\\\arccos","math.acos");
            initString=initString.replaceAll("\\\\arctan","math.atan");
        }
        //解决符号
        initString=initString.replaceAll("\\\\times","*");
        initString=initString.replaceAll("\\\\div","/");
        //解决对数
        initString=initString.replaceAll("\\\\ln","math.log");
        initString=initString.replaceAll("\\\\lg","lg");
        //解决pi
        initString=initString.replaceAll("\\\\pi","math.PI");
        //res
        MyLog myLog=new MyLog(MainActivity.getMainActivity());
        String res=myLog.GetLastLog()[1];
        Log.i(TAG,"res:"+res);
        if(res!=""){
            initString=initString.replaceAll("Res",res);
            MyLog.currentLog-=1;
        }
        else{
            initString=initString.replaceAll("Res","0");
        }
        //e
        initString=initString.replaceAll("e","math.E");
        //删除删除时保留的括号
        initString=initString.replaceAll("\\{","").replaceAll("\\}","");
        return initString;
    }
    public void reset(){
        MyString.FormulaString=MyString.InitString;
        MyString.ResultString="";
        ControlVar.leftMove=0;
        ControlVar.sub=false;
        ControlVar.Shift=false;
        MyLog.currentLog=0;
    }
}
