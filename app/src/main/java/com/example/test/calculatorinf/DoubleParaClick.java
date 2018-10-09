package com.example.test.calculatorinf;

import android.view.MotionEvent;
import android.view.View;

public class DoubleParaClick extends ShowBtnClick
{
  public int FirstParaMove;
  public int SecondParaMove;
  public DoubleParaClick(String paramString,int FirstParaMove,int SecondParaMove)
  {
    super(paramString);
    this.FirstParaMove=FirstParaMove;
    this.SecondParaMove=SecondParaMove;
  }

  public void onClick(View paramView)
  {
    ControlVar.initCursor = FirstParaMove;
    ControlVar.leftMove += FirstParaMove;
    super.onClick(paramView);
    MyString.MoveCursor(ControlVar.leftMove);
    ControlVar.sub = true;
    ControlVar.NextMove=SecondParaMove;
  }
}