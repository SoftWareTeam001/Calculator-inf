package com.example.test.calculatorinf;

import android.content.Context;
import android.service.autofill.FillEventHistory;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import static android.content.ContentValues.TAG;

public class MyLog {
    public static int currentLog=0;
    private Context mContext;
    public MyLog(Context mContext){
        this.mContext=mContext;
    }
    public String ReadLogFile(){
        StringBuilder sb = new StringBuilder("");
        try{
            FileInputStream input = mContext.openFileInput("log.txt");
            byte[] temp = new byte[10240];
            int len = 0;
            //读取文件内容:
            while ((len = input.read(temp)) > 0) {
                sb.append(new String(temp, 0, len));
            }
            //关闭输入流
            input.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }
    public void WriteLog() throws IOException {
        try{
            FileOutputStream fileOutputStream=mContext.openFileOutput("log.txt",Context.MODE_APPEND);
            String log=MyString.FormulaString+":"+MyString.ResultString+"\n";
            fileOutputStream.write(log.getBytes());
            fileOutputStream.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public  String[] GetLastLog(){
        String allLog=ReadLogFile();
        String lastFormula="";
        String lastResult="";
        String[] res={lastFormula,lastResult};
        try{
            String log[]=allLog.split("\n");
            if((log.length-1-MyLog.currentLog)>0){
                MyLog.currentLog+=1;
                String lastLog=log[log.length-1-MyLog.currentLog];
                lastFormula=lastLog.split(":")[0];
                lastResult=lastLog.split(":")[1];
                res[0]=lastFormula;
                res[1]=lastResult;
                FormulaView.leftMove=0;
                Log.i(TAG,currentLog+":"+lastFormula);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }
    public String[] GetNextLog(){
        String allLog=ReadLogFile();
        String nextFormular="";
        String nextResult="";
        String[] res={nextFormular,nextResult};
        String log[]=allLog.split("\n");
        try {
            if((currentLog>0)){
                currentLog-=1;
                String nextLog=log[log.length-currentLog-1];
                nextFormular=nextLog.split(":")[0];
                nextResult=nextLog.split(":")[1];
                log[0]=nextFormular;
                log[1]=nextResult;
                FormulaView.leftMove=0;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return log;
    }
}
