package com.example.test.calculatorinf;

import android.view.View;

public class DoubleParaClick extends ShowBtnClick
{
  public DoubleParaClick(String paramString)
  {
    super(paramString);
  }

  public void onClick(View paramView)
  {
    ControlVar.initCursor = 4;
    ControlVar.leftMove += 4;
    super.onClick(paramView);
    MyString.MoveCursor(ControlVar.leftMove);
    ControlVar.sub = true;
  }
}