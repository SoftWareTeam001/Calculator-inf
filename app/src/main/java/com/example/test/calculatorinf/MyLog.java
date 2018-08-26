package com.example.test.calculatorinf;

import android.service.autofill.FillEventHistory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MyLog {
    public MyLog(){
    }
    public String ReadLogFile(FileInputStream fileInputStream){
        String res="";
        try{
            int length=fileInputStream.available();
            byte[] buffer=new byte[length];
            fileInputStream.read(buffer);
            res=new String(buffer);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }
    public void WriteLog(   String writestr,FileOutputStream fileOutputStream) throws IOException {
        try{
            byte [] bytes = writestr.getBytes();
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
