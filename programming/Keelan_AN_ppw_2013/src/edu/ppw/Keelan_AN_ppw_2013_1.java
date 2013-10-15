package edu.ppw;
import java.io.Console;

import com.neuronrobotics.sdk.dyio.DyIO;
import com.neuronrobotics.sdk.dyio.peripherals.DigitalOutputChannel;
import com.neuronrobotics.sdk.dyio.peripherals.ServoChannel;
import com.neuronrobotics.sdk.ui.ConnectionDialog;
import com.neuronrobotics.sdk.util.ThreadUtil;
// these are webpages that have the information to allow the variables to work.

public class Keelan_AN_ppw_2013_1 {

	public static void main(String[] args) {
		System.out.println("Hello world!");
		System.out.println("I like pie");
		
		for(int  i=0	;i<10	;i++){  // i++ means i + 1
			System.out.println("current value of i="+i);  // this changes i by the value of i.
			
		}
		DyIO.disableFWCheck();
		DyIO dyio = new DyIO();
		
		
		if (!ConnectionDialog.getBowlerDevice(dyio)){
			System.exit(1);
		}
		
		dyio.enableDebug();
		
		//If your DyIO is using a lower voltage power source, you need to disable the brownout detect
		dyio.setServoPowerSafeMode(false);
		
		ServoChannel srv = new ServoChannel (	dyio.getChannel(11)	); // this tells the srv what channel to use
		
		DigitalOutputChannel doc = new DigitalOutputChannel( dyio.getChannel(0) );
		
		long startTime ;
		
		for( int i = 0 ; i < 100 ; i++ ) {  //this tells it what to start at, what to end at, and how many to change by
			
			startTime = System.currentTimeMillis() ;
			
			boolean isThisLoopEven = (i % 2) == 0 ;
			
			if (isThisLoopEven) {
				
				//System.out.println("This loop is even " + i) ;
				srv.SetPosition(200, 0) ;
				doc.setHigh(isThisLoopEven) ;
				
			}else{
				
				//System.out.println("This loop is odd " + i) ;
				srv.SetPosition(50, 1) ;
				doc.setHigh(isThisLoopEven) ;
				
			}
			
			System.out.println( "This loop took " + (System.currentTimeMillis() - startTime) + " ms" );
			//ThreadUtil.wait(6000) ;
		
		}
		
		dyio.disconnect();   //this ends connection with the dyio and system
		System.exit(0);
		
	}
	
}