package com.example.test.calculatorinf;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

public class RightBtnClick
        implements View.OnClickListener
{
    private FormulaView formulaView;

    public RightBtnClick(FormulaView paramFormulaView)
    {
        this.formulaView = paramFormulaView;
    }

    public void onClick(View paramView)
    {
//        if ((ControlVar.leftMove > 0) && (!ControlVar.sub))
//        {
//            ControlVar.leftMove -= 1;
//            MyString.MoveCursor(ControlVar.leftMove);
//        }
        if (ControlVar.sub)
        {
            ControlVar.leftMove -= ControlVar.NextMove;
            MyString.MoveCursor(ControlVar.leftMove);
            ControlVar.sub = false;
        }
        else{
            int location = MyString.FormulaString.indexOf("{\\textcolor{yellow}|}");
            Boolean hasMoved=false;
            while (true) {
                StringBuilder str = new StringBuilder();
                str.append(MyString.FormulaString.charAt(location+21));
                Log.i("GifHeaderParser", str.toString());
                if (!str.toString().matches("[0-9]")&&ControlVar.leftMove>0){
                    ControlVar.leftMove -= 1;
                    location += 1;
                    hasMoved=true;
                }
                else {
                    if(!hasMoved){
                        Log.i(TAG,"not moved");
                        ControlVar.leftMove -= 1;
                    }
                    break;
                }
            }
            MyString.MoveCursor(ControlVar.leftMove);//不知道为什么，反正可以运行
        }
        Log.i("ContentValues", MyString.FormulaString);
    }
}