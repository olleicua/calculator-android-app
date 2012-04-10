package com.olleicua.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class CalculatorActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            	switch (position) {
                case 0 : // 1
                	text += "1";
                	number(1) ;
                	break ;
                case 1 : // 2
                	text += "2";
                	number(2) ;
                	break ;
                case 2 : // 3
                	text += "3";
                	number(3) ;
                	break ;
                case 3 : // plus
                	text += "+";
                	evaluate() ;
                	operator = PLUS ;
                	break ;
                case 4 : // 4
                	text += "4";
                	number(4) ;
                	break ;
                case 5 : // 5
                	text += "5";
                	number(5) ;
                	break ;
                case 6 : // 6
                	text += "6";
                	number(6) ;
                	break ;
                case 7 : // minus
                	text += "-";
                	evaluate() ;
                	operator = MINUS ;
                	break ;
                case 8 : // 7
                	text += "7";
                	number(7) ;
                	break ;
                case 9 : // 8
                	text += "8";
                	number(8) ;
                	break ;
                case 10 : // 9
                	text += "9";
                	number(9) ;
                	break ;
                case 11 : // times
                	text += "x";
                	evaluate() ;
                	operator = TIMES ;
                	break ;
                case 12 : // equals
                	text += "=";
                	evaluate() ;
                	value = previousValue ;
                	break ;
                case 13 : // zero
                	number(0) ;
                	break ;
                case 14 : // clear
                	text = "";
                	cleared = true ;
                	value = 0 ;
                	previousValue = 0 ;
                	operator = NONE ;
                	break ;
                case 15 : // divide
                	text += "Ö";
                	evaluate() ;
                	operator = DIVIDE ;
                	break ;
                default :
                	break ;
                }
            	//display.setText(display());
            	//display.show();
            	Toast.makeText(CalculatorActivity.this, display(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    
    public void number(int n) {
    	cleared = false ;
    	value *= 10 ;
    	value += n ;
    }
    
    public void evaluate() {
    	switch (operator) {
    	case 1 :
    		previousValue += value ;
    		break ;
    	case 2 :
    		previousValue -= value ;
    		break ;
    	case 3 :
    		previousValue *= value ;
    		break ;
    	case 4 :
    		previousValue /= value ;
    		break ;
    	case 0 :
    		previousValue = value ;
    		break ;
    	default :
    		break ;
    	}
    	value = 0 ;
    	operator = NONE ;
    }
    
    public String display() {
    	switch (operator) {
    	case 1 :
    		return Integer.toString(previousValue) + " + " + Integer.toString(value) ;
       	case 2 :
    		return Integer.toString(previousValue) + " - " + Integer.toString(value) ;
    	case 3 :
    		return Integer.toString(previousValue) + " x " + Integer.toString(value) ;
    	case 4 :
    		return Integer.toString(previousValue) + " Ö " + Integer.toString(value) ;
    	default :
    		if (cleared) {
    			return "" ;
    		}
    		if (0 == previousValue) {
    			return Integer.toString(value) ;
    		}
    		return Integer.toString(previousValue) ;
    	}
    }

    // OPERATOR CONSTANTS
    private int NONE = 0 ;
    private int PLUS = 1 ;
    private int MINUS = 2 ;
    private int TIMES = 3 ;
    private int DIVIDE = 4 ;

    // STATE VARIABLES
    public String text = "" ;
    public Boolean cleared = true ;
    public int operator = NONE ;
    public int value = 0 ;
    public int previousValue = 0 ;
    //public Toast display = Toast.makeText(CalculatorActivity.this, "", Toast.LENGTH_SHORT);
}