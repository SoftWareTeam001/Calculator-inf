package com.example.test.calculatorinf;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuAlertDialog implements View.OnClickListener {
    private Context mContext=MainActivity.getMainActivity();
    @Override
    public void onClick(View v){
        final String[] lesson = new String[]{"计算","矩阵","复数"};
        AlertDialog alert = null;
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        alert = builder
                .setTitle("模式选择")
                .setItems(lesson, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ControlVar.Mode=which;
                        TextView mainMode=(TextView)MainActivity.getMainActivity().findViewById(R.id.MainMode);
                        //计算模式
                        if(which==0){
                            MainActivity.getMainActivity().setContentView(R.layout.activity_main);
                            mainMode.setText("CAL");
                        }
                        //矩阵模式
                        else if(which==1){
                            MainActivity.getMainActivity().setContentView(R.layout.mat_one);
                            mainMode.setText("MAT");
                        }
                        else if(which==2){
                            MainActivity.getMainActivity().setContentView(R.layout.complex_one);
                            mainMode.setText("CML");
                        }
                        Bind bind=new Bind();
                        bind.BindFunction();
                        MyString.Clear();
                    }
                }).create();
        alert.show();
    }
}
