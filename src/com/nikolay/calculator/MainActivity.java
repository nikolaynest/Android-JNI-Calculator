package com.nikolay.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	private CalcJavaLayer javaCalc;
	private double a;
	private double b;
	private EditText firstNum;
	private EditText secondNum;
	private TextView result;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		javaCalc = new CalcJavaLayer();
		firstNum = (EditText)findViewById(R.id.firstNum);
		secondNum = (EditText)findViewById(R.id.secondNum); 
	    result = (TextView) findViewById(R.id.result);
		initButtons();
		
	}
	
	private void initButtons(){
		TableLayout table = (TableLayout) findViewById(R.id.table);
		for(int i = 0; i < table.getChildCount(); i++){
			TableRow row = (TableRow) table.getChildAt(i);
			for(int j = 0; j < row.getChildCount(); j++){
				if(row.getChildAt(j) instanceof Button){
					Button button = (Button) row.getChildAt(j);
					button.setOnClickListener(this);
				}
			}
		}
	}

	@Override
	public void onClick(View v) {
		if(checkEditTextNotEmpty(firstNum) && checkEditTextNotEmpty(secondNum)){
		
			String aString = firstNum.getText().toString();
			String bString = secondNum.getText().toString();
		
			a = Double.parseDouble(aString);
			b = Double.parseDouble(bString);
			double res;
			switch(v.getId()){
			case R.id.add:
				res = javaCalc.add(a, b);
				setResultTextView((Button)v, res);
				break;
			case R.id.multiply:
				res = javaCalc.multiply(a, b);
				setResultTextView((Button)v, res);
				break;
			case R.id.subtract:
				res = javaCalc.subtract(a, b);
				setResultTextView((Button)v, res);
				break;
			case R.id.divide:
				res = javaCalc.divide(a, b);
				setResultTextView((Button)v, res);
				break;
			}	
		}else{
			Toast.makeText(this, "You did not enter a number", Toast.LENGTH_SHORT).show();
		}
	}
	
	private void setResultTextView(Button btn, double res){
		result.setText(firstNum.getText().toString()+btn.getText().toString()+
				secondNum.getText().toString()+" = "+String.valueOf(res));
		firstNum.setText("");
		secondNum.setText("");
	}
	
	
	
	private boolean checkEditTextNotEmpty(EditText edit){
		String text = edit.getText().toString();
		if(TextUtils.isEmpty(text)){
			return false;
		}
		return true;
//		if (text.matches("") || text == null) {
//		    return false;
//		}
	}

}
