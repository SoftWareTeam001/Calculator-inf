package com.example.test.calculatorinf;

public class ControlVar
{
    public static boolean Shift = false;
    public static int initCursor = 0;
    public static int leftMove = 0;
    public static boolean rad = true;
    public static boolean sub = false;
    public static boolean sup = false;
    public static boolean mainPage=true;
    public static int NextMove=1;
    public static void reset()
    {
        Shift = false;
        leftMove = 0;
        sub = false;
        sup = false;
        initCursor = 0;
        rad = true;
    }
}