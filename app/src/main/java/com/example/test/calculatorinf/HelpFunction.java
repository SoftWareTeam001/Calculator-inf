package com.example.test.calculatorinf;

import android.widget.TextView;
import android.widget.Toast;

public class HelpFunction {
    public HelpFunction(){

    }
    public void showToast(String message) {
        Toast toast = Toast.makeText(MainActivity.getMainActivity(), message, Toast.LENGTH_LONG);
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        toast.show();
    }
}
