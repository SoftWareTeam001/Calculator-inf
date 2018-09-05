package com.example.test.calculatorinf;
import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.daquexian.flexiblerichtextview.TextWithFormula;

import org.scilab.forge.jlatexmath.core.AjLatexMath;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import io.github.kbiakov.codeview.classifier.CodeProcessor;
public class MainActivity extends AppCompatActivity {
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //引入latex
        AjLatexMath.init(this); // init library: load fonts, create paint, etc.
        CodeProcessor.init(this);
        //初始化
        MyString.FormulaString = MyString.FormulaString + "$$ \\Huge \\textcolor{cyan} {}{\\textcolor{yellow}|}$$";
        FormulaView formulaView=(FormulaView)findViewById(R.id.Formula);
        formulaView.setText(MyString.FormulaString);
        //绑定事件
        BindFunction();
        //生成日志文件
        logInit();
        //外部类调用
    }
    //绑定事件函数
    public void BindFunction(){
        FormulaView formulaView = (FormulaView) findViewById(R.id.Formula);
        WebView webView=(WebView)findViewById(R.id.webview);
        TextView textView=(TextView)findViewById(R.id.Result);
        //绑定控件
        //十个数字
        ShowButton numberZero=(ShowButton)findViewById(R.id.NumberZero);
        ShowButton numberOne = (ShowButton) findViewById(R.id.NumberOne);
        ShowButton numberTwo=(ShowButton)findViewById(R.id.NumberTwo);
        ShowButton numberThree=(ShowButton)findViewById(R.id.NumberThree);
        ShowButton numberFour=(ShowButton)findViewById(R.id.NumberFour);
        ShowButton numberFive=(ShowButton)findViewById(R.id.NumberFive);
        ShowButton numberSix=(ShowButton)findViewById(R.id.NumberSix);
        ShowButton numberSeven=(ShowButton)findViewById(R.id.NumberSeven);
        ShowButton numberEight=(ShowButton)findViewById(R.id.NumberEight);
        ShowButton numberNine=(ShowButton)findViewById(R.id.NumberNine);
        ShowButton numberPint=(ShowButton)findViewById(R.id.Point);
        //运算符
        ShowButton add=(ShowButton)findViewById(R.id.Add);
        ShowButton minus=(ShowButton)findViewById(R.id.Minus);
        ShowButton multiply=(ShowButton)findViewById(R.id.Multiply);
        ShowButton divide=(ShowButton)findViewById(R.id.Divide);
        //函数
        ShowButton sin=(ShowButton)findViewById(R.id.Sin);
        ShowButton cos=(ShowButton)findViewById(R.id.Cos);
        ShowButton tan=(ShowButton)findViewById(R.id.Tan);
        ShowButton ln=(ShowButton)findViewById(R.id.Ln);
        //括号
        ShowButton leftBrackets=(ShowButton)findViewById(R.id.LeftBrackets);
        ShowButton rightBrackets=(ShowButton)findViewById(R.id.RightBrackets);
        //常数
        ShowButton constPi=(ShowButton)findViewById(R.id.ConstPi);
        //特殊
        ShowButton square=(ShowButton)findViewById(R.id.Square);

        //功能
        MyButton clear=(MyButton)findViewById(R.id.Clear);
        MyButton delete=(MyButton)findViewById(R.id.Delete);
        MyButton directionRight=(MyButton)findViewById(R.id.DirectionRight);
        MyButton equal=(MyButton)findViewById(R.id.Equal);
        MyButton directionUp=(MyButton)findViewById(R.id.DirectionUp);
        MyButton directionDown=(MyButton)findViewById(R.id.DirectionDown);
        MyButton history=(MyButton)findViewById(R.id.History);
        //设置监听

        //十个数字
        numberZero.setOnClickListener(new ShowBtnClick(numberZero,formulaView,(String)("0")));
        numberOne.setOnClickListener(new ShowBtnClick(numberOne,formulaView,(String)("1")));
        numberTwo.setOnClickListener(new ShowBtnClick(numberTwo,formulaView,(String)("2")));
        numberThree.setOnClickListener(new ShowBtnClick(numberThree,formulaView,(String)("3")));
        numberFour.setOnClickListener(new ShowBtnClick(numberFour,formulaView,(String)("4")));
        numberFive.setOnClickListener(new ShowBtnClick(numberFive,formulaView,(String)("5")));
        numberSix.setOnClickListener(new ShowBtnClick(numberSix,formulaView,(String)("6")));
        numberSeven.setOnClickListener(new ShowBtnClick(numberSeven,formulaView,(String)("7")));
        numberEight.setOnClickListener(new ShowBtnClick(numberEight,formulaView,(String)("8")));
        numberNine.setOnClickListener(new ShowBtnClick(numberNine,formulaView,(String)("9")));
        numberPint.setOnClickListener(new ShowBtnClick(numberPint,formulaView,(String)(".")));
        //运算符
        add.setOnClickListener(new ShowBtnClick(add,formulaView,"+"));
        minus.setOnClickListener(new ShowBtnClick(minus,formulaView,"-"));
        multiply.setOnClickListener(new ShowBtnClick(multiply,formulaView,"\\times "));
        divide.setOnClickListener(new ShowBtnClick(divide,formulaView,"\\div "));
        //函数
        sin.setOnClickListener(new ShowBtnClick(sin,formulaView,"Sin("));
        cos.setOnClickListener(new ShowBtnClick(cos,formulaView,"Cos("));
        tan.setOnClickListener(new ShowBtnClick(tan,formulaView,"Tan("));
        ln.setOnClickListener(new ShowBtnClick(ln,formulaView,"Ln("));
        //括号
        leftBrackets.setOnClickListener(new ShowBtnClick(leftBrackets,formulaView,"("));
        rightBrackets.setOnClickListener(new ShowBtnClick(rightBrackets,formulaView,")"));
        //常数
        constPi.setOnClickListener(new ShowBtnClick(constPi,formulaView,"\\pi "));
        //特殊
        square.setOnClickListener(new SpecialBtnClick(constPi,formulaView,"^{}"));
        //功能
        clear.setOnClickListener(new ACButtonClick(formulaView));
        delete.setOnClickListener(new DeleteBtnClick(formulaView));
        directionRight.setOnClickListener(new RightBtnClick(formulaView));
        directionUp.setOnClickListener(new UpDirectionBtnClick(formulaView,textView,MainActivity.this));
        directionDown.setOnClickListener(new DownDirectionBtnClick(formulaView,textView,MainActivity.this));
        directionDown.setOnClickListener(new HistoryClick(MainActivity.this));
        //启动JS引擎
        InputStream inputStream=getResources().openRawResource(R.raw.main_function);
        String jsFileContent=ReadRawFile(inputStream);
        //等号
        try{
            equal.setOnClickListener(new Equal(webView,jsFileContent,textView,MainActivity.this));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    //读取js文件
    public String ReadRawFile(InputStream inputStream){
        InputStreamReader inputStreamReader=null;
        String result="";
        try{
            inputStreamReader=new InputStreamReader(inputStream,"utf-8");
        }
        catch(UnsupportedEncodingException e1){
            e1.printStackTrace();
        }
        BufferedReader reader=new BufferedReader(inputStreamReader);
        String line;
        try{
            while ((line=reader.readLine())!=null){
                result+=line;
            }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        return result;
    }
    //日志初始化
    private void logInit() {
        try {
            FileOutputStream fileOutputStream =MainActivity.this.openFileOutput("log.txt", MODE_APPEND);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void showToast(String message){
        Toast toast = Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG);
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        toast.show();
    }
    private String readFile(String fileName){
        StringBuilder sb = new StringBuilder("");
        try{
            FileInputStream input =openFileInput(fileName);
            byte[] temp = new byte[1024];
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
}

