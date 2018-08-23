package com.example.test.calculatorinf;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.daquexian.flexiblerichtextview.FlexibleRichTextView;
import org.scilab.forge.jlatexmath.core.AjLatexMath;
import io.github.kbiakov.codeview.classifier.CodeProcessor;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AjLatexMath.init(this); // init library: load fonts, create paint, etc.
        CodeProcessor.init(this);
        FlexibleRichTextView richTextView = (FlexibleRichTextView) findViewById(R.id.Formula);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("$$ \\Huge \\textcolor{cyan}");
        stringBuilder.append("{x^2+y^2+\\int}");
        stringBuilder.append("$$");
        richTextView.setText(stringBuilder.toString());
    }
}
