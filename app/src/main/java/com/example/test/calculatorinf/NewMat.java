package com.example.test.calculatorinf;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

public class NewMat implements View.OnClickListener{
    public NewMat(){

    }
    public int Mrow;
    public int Mcolumn;
    public void onClick(View paramView){
        AlertDialog.Builder customizeDialog = new AlertDialog.Builder(MainActivity.getMainActivity());
        final View dialogView = LayoutInflater.from(MainActivity.getMainActivity()).inflate(R.layout.dialog_customize,null);
        customizeDialog.setTitle("添加一个新向量");
        customizeDialog.setView(dialogView);
        customizeDialog.setPositiveButton("添加",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 获取EditView中的输入内容
                        RadioGroup row=(RadioGroup)dialogView.findViewById(R.id.row);
                        RadioGroup column=(RadioGroup)dialogView.findViewById(R.id.column);
                        for (int i = 0; i < row.getChildCount(); i++) {
                            RadioButton rd = (RadioButton) row.getChildAt(i);
                            if(rd.isChecked()){
                                Mrow=Integer.parseInt(rd.getText().toString());
                            }
                        }
                        for (int i = 0; i < column.getChildCount(); i++) {
                            RadioButton rd = (RadioButton) column.getChildAt(i);
                            if(rd.isChecked()){
                                Mcolumn=Integer.parseInt(rd.getText().toString());
                            }
                        }
                        String rowStr="";
                        for(int i=1;i<Mrow;i++){
                            rowStr+="0&";
                        }
                        rowStr+="0\\\\";
                        String matstr="";
                        for(int i=0;i<Mcolumn;i++){
                            matstr+=rowStr;
                        }
                        String str="\\left[\\begin{matrix}"+matstr+"\\end{matrix}\\right]";
                        MyString.ChangeFormula(str);
                        ((FormulaView)MainActivity.getMainActivity().findViewById(R.id.Formula)).setText(MyString.FormulaString);
                        ControlVar.leftMove+=Mrow*Mcolumn*2+Mrow+19;
                        MyString.MoveCursor(ControlVar.leftMove);
                        Log.i(TAG,MyString.FormulaString);
                    }
                });
        customizeDialog.setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        customizeDialog.show();
    }
}
