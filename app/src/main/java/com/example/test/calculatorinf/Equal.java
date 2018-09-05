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
    private String jsContent;
    private TextView textView;
    private Context mContext;
    public Equal(WebView webView,String jsContent,TextView textView,Context mContext){
        this.webView=webView;
        this.jsContent=jsContent;
        this.textView=textView;
        this.mContext=mContext;
    }
    @Override
    public void onClick(View v){
        WebSettings webSettings = webView.getSettings();
        // 设置与Js交互的权限
        webSettings.setJavaScriptEnabled(true);
        // 设置允许JS弹窗
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
//        String ExeJs=jsContent+"eval("+handleFormulaString()+")";
        Log.i(TAG,handleFormulaString());
        String ExeJs="eval("+handleFormulaString()+")";
        webView.evaluateJavascript(ExeJs, new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String s) {
                MyString.ResultString=s;
                Log.i(TAG,MyString.ResultString);
                textView.setText(MyString.ResultString);
                if(s!=null){
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
        initString=initString.replaceAll("Sin","Math.sin");
        initString=initString.replaceAll("Cos","Math.cos");
        initString=initString.replaceAll("Tan","Math.cos");
        //解决符号
        initString=initString.replaceAll("\\\\times","*");
        initString=initString.replaceAll("\\\\div","/");
        //解决对数
        initString=initString.replaceAll("Ln","Math.log");
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
