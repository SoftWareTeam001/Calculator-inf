package com.example.test.calculatorinf;

import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

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
        //文本框滚动
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        textView.setHorizontallyScrolling(true);
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
        ShowButton sinH=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.SinH);
        ShowButton cosH=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.CosH);
        ShowButton tanH=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.TanH);
        ShowButton arcSinH=(ShowButton) MainActivity.getMainActivity().findViewById(R.id.ArcSinH);
        ShowButton arcCosH=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.ArcCosH);
        ShowButton arcTanH=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.ArcTanH);
        ShowButton reciprocal=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.Reciprocal);
        ShowButton cube=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.Cube);
        ShowButton threeRoot=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.Cube_root);
        ShowButton nRoot=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.NRoot);
        ShowButton power=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.Power);
        MyButton fraction=(MyButton)MainActivity.getMainActivity().findViewById(R.id.Fraction);
        ShowButton combination=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.Combination);
        ShowButton permutation=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.Permutation);
        ShowButton squreRoot=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.SquareRoot);
        ShowButton mod=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.Mod);
        ShowButton gcd=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.GCD);
        ShowButton lcm=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.LCM);
        ShowButton exponent=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.Exponent);
        ShowButton logx=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.LogX);
        ShowButton npr=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.NPr);
        //括号
        ShowButton leftBrackets = (ShowButton) MainActivity.getMainActivity().findViewById(R.id.LeftBrackets);
        ShowButton rightBrackets = (ShowButton) MainActivity.getMainActivity().findViewById(R.id.RightBrackets);
        //常数
        ShowButton constPi = (ShowButton) MainActivity.getMainActivity().findViewById(R.id.ConstPi);
        ShowButton constE=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.Conste);
        //特殊
        ShowButton square = (ShowButton) MainActivity.getMainActivity().findViewById(R.id.Square);
        ShowButton res=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.Res);

        //功能
        MyButton clear = (MyButton) MainActivity.getMainActivity().findViewById(R.id.Clear);
        MyButton delete = (MyButton) MainActivity.getMainActivity().findViewById(R.id.Delete);
        MyButton directionRight = (MyButton) MainActivity.getMainActivity().findViewById(R.id.DirectionRight);
        MyButton equal = (MyButton) MainActivity.getMainActivity().findViewById(R.id.Equal);
        MyButton directionUp = (MyButton) MainActivity.getMainActivity().findViewById(R.id.DirectionUp);
        MyButton directionDown = (MyButton) MainActivity.getMainActivity().findViewById(R.id.DirectionDown);
        MyButton history = (MyButton) MainActivity.getMainActivity().findViewById(R.id.History);
        MyButton shift=(MyButton)MainActivity.getMainActivity().findViewById(R.id.BtnShift);
        MyButton directionLeft=(MyButton)MainActivity.getMainActivity().findViewById(R.id.DirectionLeft);
        ShowButton factorial=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.Factorial);
        ShowButton abs=(ShowButton)MainActivity.getMainActivity().findViewById(R.id.ABS);
        MyButton menu=(MyButton)MainActivity.getMainActivity().findViewById(R.id.Menu);
        MyButton newMat=(MyButton)MainActivity.getMainActivity().findViewById(R.id.NewMat);
        //第一个页面
        if(ControlVar.Mode==0&&ControlVar.mainPage &&!ControlVar.Shift){
            //firstRow
            shift.setOnClickListener(new ShiftBtnClick());
            directionUp.setOnClickListener(new UpDirectionBtnClick(textView, MainActivity.getMainActivity()));
            delete.setOnClickListener(new DeleteBtnClick(formulaView));
            //secondRow
            clear.setOnClickListener(new ACButtonClick(formulaView));
            directionLeft.setOnClickListener(new LeftBtnClick(formulaView));
            directionDown.setOnClickListener(new DownDirectionBtnClick(textView, MainActivity.getMainActivity()));
            directionRight.setOnClickListener(new RightBtnClick(formulaView));
            history.setOnClickListener(new HistoryClick(MainActivity.getMainActivity()));
            //third Row
            constPi.setOnClickListener(new ShowBtnClick("\\pi "));
            ln.setOnClickListener(new ShowBtnClick("\\ln("));
            sin.setOnClickListener(new ShowBtnClick("\\sin("));
            cos.setOnClickListener(new ShowBtnClick("\\cos("));
            tan.setOnClickListener(new ShowBtnClick("\\tan("));
            //fourth row
            square.setOnClickListener(new ShowBtnClick("^{2}"));
            squreRoot.setOnClickListener(new SpecialBtnClick("\\sqrt[2]{}"));
            leftBrackets.setOnClickListener(new ShowBtnClick("("));
            rightBrackets.setOnClickListener(new ShowBtnClick(")"));
            //fifth row
            numberSeven.setOnClickListener(new ShowBtnClick("7"));
            numberEight.setOnClickListener(new ShowBtnClick("8"));
            numberNine.setOnClickListener(new ShowBtnClick("9"));
            multiply.setOnClickListener(new ShowBtnClick("\\times "));
            divide.setOnClickListener(new ShowBtnClick("\\div "));
            //sixth row
            numberFour.setOnClickListener(new ShowBtnClick("4"));
            numberFive.setOnClickListener(new ShowBtnClick("5"));
            numberSix.setOnClickListener(new ShowBtnClick("6"));
            add.setOnClickListener(new ShowBtnClick("+"));
            minus.setOnClickListener(new ShowBtnClick("-"));
            //seventh row
            numberOne.setOnClickListener(new ShowBtnClick("1"));
            numberTwo.setOnClickListener(new ShowBtnClick("2"));
            numberThree.setOnClickListener(new ShowBtnClick("3"));
            res.setOnClickListener(new ShowBtnClick("Res"));
            //eighth row
            numberZero.setOnClickListener(new ShowBtnClick("0"));
            numberPint.setOnClickListener(new ShowBtnClick("."));
            equal.setOnClickListener(new Equal(webView,textView,MainActivity.getMainActivity()));
            //ninth row
            menu.setOnClickListener(new MenuAlertDialog());
        }
        //第二个页面
        else if(ControlVar.Shift &&ControlVar.mainPage){
            //firstRow
            shift.setOnClickListener(new ShiftBtnClick());
            directionUp.setOnClickListener(new UpDirectionBtnClick(textView, MainActivity.getMainActivity()));
            delete.setOnClickListener(new DeleteBtnClick(formulaView));
            //secondRow
            clear.setOnClickListener(new ACButtonClick(formulaView));
            directionLeft.setOnClickListener(new LeftBtnClick(formulaView));
            directionDown.setOnClickListener(new DownDirectionBtnClick(textView, MainActivity.getMainActivity()));
            directionRight.setOnClickListener(new RightBtnClick(formulaView));
            history.setOnClickListener(new HistoryClick(MainActivity.getMainActivity()));
            //third row
            constE.setOnClickListener(new ShowBtnClick("\\mathrm{e}"));
            log.setOnClickListener(new ShowBtnClick("\\lg("));
            arcSin.setOnClickListener(new ShowBtnClick("\\arcsin("));
            arcCos.setOnClickListener(new ShowBtnClick("\\arccos"));
            arcTan.setOnClickListener(new ShowBtnClick("\\arctan("));
            //fourth row
            reciprocal.setOnClickListener(new ShowBtnClick("^{-1}"));
            cube.setOnClickListener(new ShowBtnClick("^{3}"));
            threeRoot.setOnClickListener(new SpecialBtnClick("\\sqrt[3]{}"));
            leftBrackets.setOnClickListener(new ShowBtnClick("("));
            rightBrackets.setOnClickListener(new ShowBtnClick(")"));
            //fifth row
            power.setOnClickListener(new SpecialBtnClick("^{}"));
            //sixth row
            combination.setOnClickListener(new DoubleParaClick("C_{}^{}",4,3));
            permutation.setOnClickListener(new DoubleParaClick("P_{}^{}",4,3));
            //seventh row
            //eighth row
            exponent.setOnClickListener(new SpecialBtnClick("\\mathrm{e}^{}"));
            //ninth row
            menu.setOnClickListener(new MenuAlertDialog());
    }
        //第三个页面
        else if(!ControlVar.Shift &&!ControlVar.mainPage){
            //first row
            shift.setOnClickListener(new ShiftBtnClick());
            //second row
            combination.setOnClickListener(new DoubleParaClick("C_{}^{}",4,3));
            permutation.setOnClickListener(new DoubleParaClick("P_{}^{}",4,3));
            //third row
            threeRoot.setOnClickListener(new SpecialBtnClick("\\sqrt[3]{}"));
            nRoot.setOnClickListener(new DoubleParaClick("\\sqrt[]{}",3,2));
            sin.setOnClickListener(new ShowBtnClick("\\sin("));
            cos.setOnClickListener(new ShowBtnClick("\\cos("));
            tan.setOnClickListener(new ShowBtnClick("\\tan("));
            //fourth row
            cube.setOnClickListener(new ShowBtnClick("^{3}"));
            power.setOnClickListener(new SpecialBtnClick("^{}"));
            sinH.setOnClickListener(new ShowBtnClick("\\sinh("));
            cosH.setOnClickListener(new ShowBtnClick("\\cosh("));
            tanH.setOnClickListener(new ShowBtnClick("\\tanh("));
            //fifth row
            fraction.setOnClickListener(new FractionClick());
            mod.setOnClickListener(new DoubleParaClick("{}\\equiv{}",9,8));
            gcd.setOnClickListener(new DoubleParaClick("\\gcd(,)",2,1));
            lcm.setOnClickListener(new DoubleParaClick("\\lcm(,)",2,1));
            //sixth row
            factorial.setOnClickListener(new ShowBtnClick("!"));
            exponent.setOnClickListener(new SpecialBtnClick("\\mathrm{e}^{}"));
            log.setOnClickListener(new ShowBtnClick("\\lg("));
            //seventh row
            reciprocal.setOnClickListener(new ShowBtnClick("^{-1}"));
            constE.setOnClickListener(new ShowBtnClick("\\mathrm{e}"));
            logx.setOnClickListener(new DoubleParaClick("\\log_{}^{}",4,3));
            //eightth row
            npr.setOnClickListener(new ShowBtnClick("NPr("));
            abs.setOnClickListener(new SpecialBtnClick("||"));
            //ninth row
            menu.setOnClickListener(new MenuAlertDialog());
        }
        //第四个页面
        else if(!ControlVar.mainPage && ControlVar.Shift){
            //first row
            shift.setOnClickListener(new ShiftBtnClick());
            //second row
            combination.setOnClickListener(new DoubleParaClick("C_{}^{}",4,3));
            permutation.setOnClickListener(new DoubleParaClick("P_{}^{}",4,3));
            //third row
            threeRoot.setOnClickListener(new SpecialBtnClick("\\sqrt[3]{}"));
            nRoot.setOnClickListener(new DoubleParaClick("\\sqrt[]{}",3,2));
            arcSin.setOnClickListener(new ShowBtnClick("\\asin("));
            arcCos.setOnClickListener(new ShowBtnClick("\\acos("));
            arcTan.setOnClickListener(new ShowBtnClick("\\atan("));
            //fourth row
            cube.setOnClickListener(new ShowBtnClick("^{3}"));
            power.setOnClickListener(new SpecialBtnClick("^{}"));
            arcSinH.setOnClickListener(new ShowBtnClick("\\asinh("));
            arcCosH.setOnClickListener(new ShowBtnClick("\\acosh("));
            arcTanH.setOnClickListener(new ShowBtnClick("\\atanh("));
            //fifth row
            fraction.setOnClickListener(new FractionClick());
            mod.setOnClickListener(new DoubleParaClick("{}\\equiv{}",9,8));
            gcd.setOnClickListener(new DoubleParaClick("\\gcd(,)",2,1));
            lcm.setOnClickListener(new DoubleParaClick("\\lcm(,)",2,1));
            //sixth row
            factorial.setOnClickListener(new ShowBtnClick("!"));
            exponent.setOnClickListener(new SpecialBtnClick("\\mathrm{e}^{}"));
            log.setOnClickListener(new ShowBtnClick("\\lg("));
            //seventh row
            reciprocal.setOnClickListener(new ShowBtnClick("^{-1}"));
            constE.setOnClickListener(new ShowBtnClick("\\mathrm{e}"));
            logx.setOnClickListener(new DoubleParaClick("\\log_{}^{}",4,3));
            //eightth row
            npr.setOnClickListener(new ShowBtnClick("NPr("));
            abs.setOnClickListener(new SpecialBtnClick("||"));
            //ninth row
            menu.setOnClickListener(new MenuAlertDialog());
        }
        //矩阵第一个页面
        else if(ControlVar.Mode==1&&!ControlVar.Shift&&ControlVar.mainPage){
            //firstRow
            shift.setOnClickListener(new ShiftBtnClick());
            directionUp.setOnClickListener(new UpDirectionBtnClick(textView, MainActivity.getMainActivity()));
            delete.setOnClickListener(new DeleteBtnClick(formulaView));
            //secondRow
            clear.setOnClickListener(new ACButtonClick(formulaView));
            directionLeft.setOnClickListener(new LeftBtnClick(formulaView));
            directionDown.setOnClickListener(new DownDirectionBtnClick(textView, MainActivity.getMainActivity()));
            directionRight.setOnClickListener(new RightBtnClick(formulaView));
            history.setOnClickListener(new HistoryClick(MainActivity.getMainActivity()));
            //third row
            //fifth row
            numberSeven.setOnClickListener(new ShowBtnClick("7"));
            numberEight.setOnClickListener(new ShowBtnClick("8"));
            numberNine.setOnClickListener(new ShowBtnClick("9"));
            multiply.setOnClickListener(new ShowBtnClick("\\times "));
            divide.setOnClickListener(new ShowBtnClick("\\div "));
            //sixth row
            numberFour.setOnClickListener(new ShowBtnClick("4"));
            numberFive.setOnClickListener(new ShowBtnClick("5"));
            numberSix.setOnClickListener(new ShowBtnClick("6"));
            add.setOnClickListener(new ShowBtnClick("+"));
            minus.setOnClickListener(new ShowBtnClick("-"));
            //seventh row
            numberOne.setOnClickListener(new ShowBtnClick("1"));
            numberTwo.setOnClickListener(new ShowBtnClick("2"));
            numberThree.setOnClickListener(new ShowBtnClick("3"));
            res.setOnClickListener(new ShowBtnClick("Res"));
            //eighth row
            numberZero.setOnClickListener(new ShowBtnClick("0"));
            numberPint.setOnClickListener(new ShowBtnClick("."));
            equal.setOnClickListener(new Equal(webView,textView,MainActivity.getMainActivity()));
            //ninth row
            menu.setOnClickListener(new MenuAlertDialog());
            newMat.setOnClickListener(new NewMat());
        }
        //复数第一个页面
        else if(ControlVar.Mode==2&&!ControlVar.Shift&&ControlVar.mainPage){
            //ninth row
            menu.setOnClickListener(new MenuAlertDialog());
        }
    }
}
