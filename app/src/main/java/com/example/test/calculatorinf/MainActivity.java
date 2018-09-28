package com.example.test.calculatorinf;
import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.daquexian.flexiblerichtextview.TextWithFormula;

import org.scilab.forge.jlatexmath.core.AjLatexMath;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import io.github.kbiakov.codeview.classifier.CodeProcessor;
public class MainActivity extends AppCompatActivity {
    private static MainActivity mainActivity;
    public MainActivity(){
        mainActivity=this;
    }
    public static MainActivity getMainActivity(){
        return mainActivity;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //引入latex
        AjLatexMath.init(this); // init library: load fonts, create paint, etc.
        CodeProcessor.init(this);
        //初始化
        MyString.FormulaString = MyString.InitString;
        FormulaView formulaView = (FormulaView) findViewById(R.id.Formula);
        formulaView.setText(MyString.FormulaString);
        //绑定事件
        Bind bind=new Bind();
        bind.BindFunction();
        //生成日志文件
        logInit();
        //外部类调用
    }

    //绑定事件函数



    //日志初始化
    private void logInit() {
        try {
            FileOutputStream fileOutputStream = MainActivity.this.openFileOutput("log.txt", MODE_APPEND);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ChangeFunction(View v){

    }
}

