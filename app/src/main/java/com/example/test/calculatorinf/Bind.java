package com.example.test.calculatorinf;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

public class Bind {
    public Bind(){

    }
    public void BindFunction() {
        FormulaView formulaView = (FormulaView) MainActivity.getMainActivity().findViewById(R.id.Formula);
        TextView textView = (TextView) MainActivity.getMainActivity().findViewById(R.id.Result);
        WebView webView = (WebView) MainActivity.getMainActivity().findViewById(R.id.webview);
        webView.loadUrl("file:///android_asset/index.html");
        // 设置与Js交互的权限
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //绑定控件
        //十个数字
        ShowButton numberZero = (ShowButton) MainActivity.getMainActivity().findViewById(R.id.NumberZero);
        ShowButton numberOne = (ShowButton) MainActivity.getMainActivity().findViewById(R.id.NumberOne);
        ShowButton numberTwo = (ShowButton) MainActivity.getMainActivity().findViewById(R.id.NumberTwo);
        ShowButton numberThree = (ShowButton) MainActivity.getMainActivity().findViewById(R.id.NumberThree);
        ShowButton numberFour = (ShowButton) MainActivity.getMainActivity().findViewById(R.id.NumberFour);
        ShowButton numberFive = (ShowButton) MainActivity.getMainActivity().findViewById(R.id.NumberFive);
        ShowButton numberSix = (ShowButton) MainActivity.getMainActivity().findViewById(R.id.NumberSix);
        ShowButton numberSeven = (ShowButton) MainActivity.getMainActivity().findViewById(R.id.NumberSeven);
        ShowButton numberEight = (ShowButton) MainActivity.getMainActivity().findViewById(R.id.NumberEight);
        ShowButton numberNine = (ShowButton) MainActivity.getMainActivity().findViewById(R.id.NumberNine);
        ShowButton numberPint = (ShowButton) MainActivity.getMainActivity().findViewById(R.id.Point);
        //运算符
        ShowButton add = (ShowButton) MainActivity.getMainActivity().findViewById(R.id.Add);
        ShowButton minus = (ShowButton) MainActivity.getMainActivity().findViewById(R.id.Minus);
        ShowButton multiply = (ShowButton) MainActivity.getMainActivity().findViewById(R.id.Multiply);
        ShowButton divide = (ShowButton) MainActivity.getMainActivity().findViewById(R.id.Divide);
        //函数
        ShowButton sin = (ShowButton) MainActivity.getMainActivity().findViewById(R.id.Sin);
        ShowButton cos = (ShowButton) MainActivity.getMainActivity().findViewById(R.id.Cos);
        ShowButton tan = (ShowButton) MainActivity.getMainActivity().findViewById(R.id.Tan);
        ShowButton ln = (ShowButton) MainActivity.getMainActivity().findViewById(R.id.Ln);
        ShowButton log=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.Log);
        ShowButton arcSin=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.ArcSin);
        ShowButton arcCos=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.ArcCos);
        ShowButton arcTan=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.ArcTan);
        ShowButton reciprocal=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.Reciprocal);
        ShowButton cube=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.Cube);
        ShowButton threeRoot=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.Cube_root);
        ShowButton power=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.Power);
        ShowButton fraction=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.Fraction);
        ShowButton combination=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.Combination);
        ShowButton permutation=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.Permutation);
        //括号
        ShowButton leftBrackets = (ShowButton) MainActivity.getMainActivity().findViewById(R.id.LeftBrackets);
        ShowButton rightBrackets = (ShowButton) MainActivity.getMainActivity().findViewById(R.id.RightBrackets);
        //常数
        ShowButton constPi = (ShowButton) MainActivity.getMainActivity().findViewById(R.id.ConstPi);
        ShowButton constE=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.Conste);
        //特殊
        ShowButton square = (ShowButton) MainActivity.getMainActivity().findViewById(R.id.Square);
        //功能
        MyButton clear = (MyButton) MainActivity.getMainActivity().findViewById(R.id.Clear);
        MyButton delete = (MyButton) MainActivity.getMainActivity().findViewById(R.id.Delete);
        MyButton directionRight = (MyButton) MainActivity.getMainActivity().findViewById(R.id.DirectionRight);
        MyButton equal = (MyButton) MainActivity.getMainActivity().findViewById(R.id.Equal);
        MyButton directionUp = (MyButton) MainActivity.getMainActivity().findViewById(R.id.DirectionUp);
        MyButton directionDown = (MyButton) MainActivity.getMainActivity().findViewById(R.id.DirectionDown);
        MyButton history = (MyButton) MainActivity.getMainActivity().findViewById(R.id.History);
        MyButton shift=(MyButton)MainActivity.getMainActivity().findViewById(R.id.BtnShift);
        //按完shift
        if(ControlVar.Shift){
            constE.setOnClickListener(new ShowBtnClick(constE,"e"));
            log.setOnClickListener(new ShowBtnClick(log,"\\lg("));
            arcSin.setOnClickListener(new ShowBtnClick(arcSin,"\\arcsin("));
            arcCos.setOnClickListener(new ShowBtnClick(arcCos,"\\arccos"));
            arcTan.setOnClickListener(new ShowBtnClick(arcTan,"\\arctan("));
            reciprocal.setOnClickListener(new ShowBtnClick(reciprocal,"^{-1}"));
            cube.setOnClickListener(new ShowBtnClick(reciprocal,"^{3}"));
            threeRoot.setOnClickListener(new SpecialBtnClick(threeRoot,"\\sqrt[3]{}"));
            power.setOnClickListener(new SpecialBtnClick(power,"^{}"));
        }
        //未按shift
        else{
            //数字
            numberZero.setOnClickListener(new ShowBtnClick(numberZero,(String) ("0")));
            numberOne.setOnClickListener(new ShowBtnClick(numberOne,(String) ("1")));
            numberTwo.setOnClickListener(new ShowBtnClick(numberTwo,(String) ("2")));
            numberThree.setOnClickListener(new ShowBtnClick(numberThree,(String) ("3")));
            numberFour.setOnClickListener(new ShowBtnClick(numberFour,(String) ("4")));
            numberFive.setOnClickListener(new ShowBtnClick(numberFive,(String) ("5")));
            numberSix.setOnClickListener(new ShowBtnClick(numberSix,(String) ("6")));
            numberSeven.setOnClickListener(new ShowBtnClick(numberSeven,(String) ("7")));
            numberEight.setOnClickListener(new ShowBtnClick(numberEight,(String) ("8")));
            numberNine.setOnClickListener(new ShowBtnClick(numberNine,(String) ("9")));
            numberPint.setOnClickListener(new ShowBtnClick(numberPint,(String) (".")));
            //运算符
            add.setOnClickListener(new ShowBtnClick(add,"+"));
            minus.setOnClickListener(new ShowBtnClick(minus,"-"));
            multiply.setOnClickListener(new ShowBtnClick(multiply,"\\times "));
            divide.setOnClickListener(new ShowBtnClick(divide,"\\div "));
            //函数
            sin.setOnClickListener(new ShowBtnClick(sin,"\\sin("));
            cos.setOnClickListener(new ShowBtnClick(cos,"\\cos("));
            tan.setOnClickListener(new ShowBtnClick(tan,"\\tan("));
            ln.setOnClickListener(new ShowBtnClick(ln,"\\ln("));
            //常数
            constPi.setOnClickListener(new ShowBtnClick(constPi,"\\pi "));
            //特殊
            square.setOnClickListener(new ShowBtnClick(constPi,"^{2}"));
        }
        //通用部分
        //括号
        leftBrackets.setOnClickListener(new ShowBtnClick(leftBrackets,"("));
        rightBrackets.setOnClickListener(new ShowBtnClick(rightBrackets,")"));
        //功能
        clear.setOnClickListener(new ACButtonClick(formulaView));
        delete.setOnClickListener(new DeleteBtnClick(formulaView));
        directionRight.setOnClickListener(new RightBtnClick(formulaView));
        directionUp.setOnClickListener(new UpDirectionBtnClick(textView, MainActivity.getMainActivity()));
        directionDown.setOnClickListener(new DownDirectionBtnClick(textView, MainActivity.getMainActivity()));
        history.setOnClickListener(new HistoryClick(MainActivity.getMainActivity()));
        //等号
        equal.setOnClickListener(new Equal(webView,textView,MainActivity.getMainActivity()));
        //Shift
        shift.setOnClickListener(new ShiftBtnClick());
    }
}
