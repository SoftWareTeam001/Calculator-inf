package com.example.test.calculatorinf;

import android.view.MotionEvent;
import android.view.View;

public class DoubleParaClick extends ShowBtnClick
{
  public int MoveNumber;
  public DoubleParaClick(String paramString,int MoveNumber)
  {
    super(paramString);
    this.MoveNumber=MoveNumber;
  }

  public void onClick(View paramView)
  {
    ControlVar.initCursor = MoveNumber;
    ControlVar.leftMove += MoveNumber;
    super.onClick(paramView);
    MyString.MoveCursor(ControlVar.leftMove);
    ControlVar.sub = true;
  }
}