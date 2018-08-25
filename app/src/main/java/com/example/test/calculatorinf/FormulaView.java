package com.example.test.calculatorinf;

import android.content.Context;
import android.util.AttributeSet;

import com.daquexian.flexiblerichtextview.FlexibleRichTextView;

import java.text.AttributedCharacterIterator;

public class FormulaView extends FlexibleRichTextView{
    static int leftMove=0;//设定括号左移位数
    public FormulaView(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }
}
