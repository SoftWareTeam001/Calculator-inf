package com.example.test.calculatorinf;

import android.util.Log;
import android.view.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

public class FractionClick implements View.OnClickListener{
    public FractionClick(){

    }
    @Override
    public void onClick(View v){
        Pattern pattern= Pattern.compile("(\\d{1,100})\\{\\\\textcolor\\{yellow\\}\\|\\}");
        Matcher matcher=pattern.matcher(MyString.FormulaString);
        FormulaView formulaView=(FormulaView)MainActivity.getMainActivity().findViewById(R.id.Formula);
        if(matcher.find()){
            MyString.FormulaString=MyString.FormulaString.replaceFirst("\\d{1,100}\\{\\\\textcolor\\{yellow\\}\\|\\}","\\\\frac{"+matcher.group(1)+"}{"+"{\\\\textcolor{yellow}|}}");
            formulaView.setText(MyString.FormulaString);
            Log.i(TAG,MyString.FormulaString);
            ControlVar.leftMove+=1;
        }
        else{
            ControlVar.leftMove+=3;
            MyString.ChangeFormula("\\frac{}{}");
            MyString.MoveCursor(ControlVar.leftMove);
        }
    }
}
