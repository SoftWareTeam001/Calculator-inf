package com.example.test.calculatorinf;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.scilab.forge.jlatexmath.core.AjLatexMath;

import java.io.FileOutputStream;

import io.github.kbiakov.codeview.classifier.CodeProcessor;

import static com.example.test.calculatorinf.R.layout.dialog_customize;

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
        Bind bind = new Bind();
        bind.BindFunction();
        //生成日志文件
        logInit();
        //外部类调用
    }
    //绑定事件函数
    //日志初始化
    private void logInit(){
        try {
            FileOutputStream fileOutputStream = MainActivity.this.openFileOutput("log.txt", MODE_APPEND);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ChangeFunction(View v){

    }
    public void ChangePage(View v){
        if(ControlVar.Mode==1&&!ControlVar.Shift&&!ControlVar.mainPage){
            MainActivity.getMainActivity().setContentView(R.layout.mat_one);
        }
        else if(ControlVar.Mode==2&&!ControlVar.Shift&&!ControlVar.mainPage){
            MainActivity.getMainActivity().setContentView(R.layout.complex_one);
        }
        else if(!ControlVar.Shift && ControlVar.mainPage){
            MainActivity.getMainActivity().setContentView(R.layout.cal_three);
        }
        else if(ControlVar.Shift && ControlVar.mainPage){
            MainActivity.getMainActivity().setContentView(R.layout.cal_four);
        }
        else if(!ControlVar.Shift && !ControlVar.mainPage){
            MainActivity.getMainActivity().setContentView(R.layout.activity_main);
        }
        else if(ControlVar.Shift && !ControlVar.mainPage){
            MainActivity.getMainActivity().setContentView(R.layout.cal_two);
        }
        ControlVar.mainPage=!ControlVar.mainPage;//改变状态
        Bind bind=new Bind();
        bind.BindFunction();
        FormulaView formulaView=(FormulaView)MainActivity.getMainActivity().findViewById(R.id.Formula);
        TextView textView=(TextView)MainActivity.getMainActivity().findViewById(R.id.Result);
        formulaView.setText(MyString.FormulaString);
        textView.setText(MyString.ResultString);
    }
}

