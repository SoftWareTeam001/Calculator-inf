package com.example.test.calculatorinf;
import android.content.Context;
import android.content.res.AssetManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.daquexian.flexiblerichtextview.FlexibleRichTextView;
import org.scilab.forge.jlatexmath.core.AjLatexMath;
import org.scilab.forge.jlatexmath.core.TeXFormulaSettingsParser;

import java.io.FileInputStream;
import java.io.InputStream;

import io.github.kbiakov.codeview.classifier.CodeProcessor;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AjLatexMath.init(this); // init library: load fonts, create paint, etc.
        CodeProcessor.init(this);

        final FormulaView formulaView = (FormulaView) findViewById(R.id.Formula);
        MyString.FormulaString.append("$$ \\Large \\textcolor{cyan} { $$");
        final NumberButton button = (NumberButton) findViewById(R.id.NumberOneBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyString.PopTheEnd();
                button.ChangeFormula();
                MyString.AddToEnd();
                Log.i("MainActivity", MyString.FormulaString.toString());
                formulaView.setText(MyString.FormulaString.toString());
            }
        });
    }
}

