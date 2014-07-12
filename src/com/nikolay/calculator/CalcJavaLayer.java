package com.nikolay.calculator;

public class CalcJavaLayer {
	static{
		System.loadLibrary("Calc");
	}
	
	native public double add(double a, double b);
	
	native public double subtract(double a, double b);
	
	native public double multiply(double a, double b);
	
	native public double divide(double a, double b);
}
