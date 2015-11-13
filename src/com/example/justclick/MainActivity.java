package com.example.justclick;

import android.net.wifi.p2p.WifiP2pManager.ActionListener;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;
import java.util.Random;
import java.util.Timer;

public class MainActivity extends Activity {
	
	public Button btn1, btn2, btn3, btn4, btn5, btn6, btn7;
	public TextView tv1, tv2;
	public ImageView img1;
	public Chronometer cro;
	public Random random = new Random();
	public int randomInt,valRep, cont, contbtn;
	public boolean croVal;
	public Timer t= new Timer();
	
	void funcMain() {
		if(contbtn==valRep){
			btn1.setBackgroundResource(R.drawable.lowgreen);
			btn2.setBackgroundResource(R.drawable.lowblue);
	        btn3.setBackgroundResource(R.drawable.loworange);
	        btn4.setBackgroundResource(R.drawable.lowred);
			
			do{
				valRep=randomInt;
				randomInt = random.nextInt(4) + 1;			
			}while(valRep==randomInt);
			if(valRep==1){
				if(randomInt==2)
					btn1.setBackgroundResource(R.drawable.green2);
				else if(randomInt==3)
					     btn1.setBackgroundResource(R.drawable.green1);
					 else if(randomInt==4)
						      btn1.setBackgroundResource(R.drawable.green3);
			}
			else if(valRep==2){
					if(randomInt==1)
						btn2.setBackgroundResource(R.drawable.blue1);
					else if(randomInt==3)
						     btn2.setBackgroundResource(R.drawable.blue3);
						 else if(randomInt==4)
							      btn2.setBackgroundResource(R.drawable.blue2);
			     }
			     else if(valRep==3){
				    	 if(randomInt==1)
								btn3.setBackgroundResource(R.drawable.orange1);
							else if(randomInt==2)
								     btn3.setBackgroundResource(R.drawable.orange3);
								 else if(randomInt==4)
									      btn3.setBackgroundResource(R.drawable.orange2);
			    	 
			          }
				      else if(valRep==4){
					    	  if(randomInt==1)
									btn4.setBackgroundResource(R.drawable.red3);
								else if(randomInt==2)
									     btn4.setBackgroundResource(R.drawable.red1);
									 else if(randomInt==3)
										      btn4.setBackgroundResource(R.drawable.red2);				    	  
				           }
			if(croVal==false){
					cro.setBase(SystemClock.elapsedRealtime());
					cro.start();
					croVal=true;
			}
		}
		else{
			btn1.setBackgroundResource(R.drawable.red);
			btn2.setBackgroundResource(R.drawable.red);
			btn3.setBackgroundResource(R.drawable.red);
			btn4.setBackgroundResource(R.drawable.red);
			cro.setVisibility(View.INVISIBLE);
			btn1.setClickable(false);
			btn2.setClickable(false);
			btn3.setClickable(false);
			btn4.setClickable(false);
			btn5.setVisibility(View.VISIBLE);
			btn6.setVisibility(View.VISIBLE);
			tv1.setText("Click para Iniciar");
			tv2.setText("Clicks: "+(cont-1));
			cont=0;
		}
	}

	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btn1=(Button) findViewById(R.id.Button1);
        btn2=(Button) findViewById(R.id.Button2);
        btn3=(Button) findViewById(R.id.Button3);
        btn4=(Button) findViewById(R.id.Button4);
        btn5=(Button) findViewById(R.id.button5);
        btn6=(Button) findViewById(R.id.button6);
        btn7=(Button) findViewById(R.id.button7);
        
        tv1=(TextView) findViewById(R.id.textView1);
        tv2=(TextView) findViewById(R.id.textView2);
        
        img1=(ImageView) findViewById(R.id.imageView1);
        
        cro=(Chronometer) findViewById(R.id.chronometer1);
        
        btn1.setClickable(false);
		btn2.setClickable(false);
		btn3.setClickable(false);
		btn4.setClickable(false);
        
        btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				contbtn=1;
				cont++;
				tv1.setText("Clicks: "+cont);	
				funcMain();
			}

        });
        
        btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				contbtn=2;			
				cont++;
				tv1.setText("Clicks: "+cont);
				funcMain();
			}
        });
        
        btn3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				contbtn=3;			
				cont++;
				tv1.setText("Clicks: "+cont);
				funcMain();
			}
        });
        
        btn4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				contbtn=4;				
				cont++;
				tv1.setText("Clicks: "+cont);
				funcMain();
			}
        });
        
        btn5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				contbtn=valRep;
				randomInt = random.nextInt(4) + 1;
		        funcMain();
		        
		        tv2.setText(null);
		        btn5.setVisibility(View.INVISIBLE);
				btn6.setVisibility(View.INVISIBLE);
				cro.setVisibility(View.VISIBLE);
				btn1.setClickable(true);
				btn2.setClickable(true);
				btn3.setClickable(true);
				btn4.setClickable(true);
			}
        });
        
        btn7.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				randomInt = random.nextInt(4) + 1;
				croVal=true;
		        funcMain();
		        croVal=false;
		        btn7.setVisibility(View.INVISIBLE);
		        img1.setVisibility(View.INVISIBLE);
		        tv1.setText("Click para Iniciar");
		        cro.setVisibility(View.VISIBLE);
			}
        });
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
