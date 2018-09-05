package com.example.test.calculatorinf;

import android.content.Context;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

import static android.content.Context.MODE_PRIVATE;

public class HistoryClick implements View.OnClickListener {
    private Context context;
    public HistoryClick(Context context){
        this.context=context;
    }
    @Override
    public void onClick(View v){
        try {
            FileOutputStream fileOutputStream = context.openFileOutput("log.txt",MODE_PRIVATE);
            fileOutputStream.write("".getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
