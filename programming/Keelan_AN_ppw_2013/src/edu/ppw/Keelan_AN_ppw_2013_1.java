package edu.ppw ;
import java.io.Console ;

import com.neuronrobotics.sdk.dyio.DyIO ;
import com.neuronrobotics.sdk.dyio.peripherals.DigitalOutputChannel ;
import com.neuronrobotics.sdk.dyio.peripherals.ServoChannel ;
import com.neuronrobotics.sdk.ui.ConnectionDialog ;
import com.neuronrobotics.sdk.util.ThreadUtil ;
// these are webpages that have the information to allow the variables to work.

public class Keelan_AN_ppw_2013_1 {

	public static void main(String[] args) {
		System.out.println("Hello world!") ;
		System.out.println("I like pie") ;
		
		for(int i=0 ; i<10 ; i++)
		{
			
			System.out.println("current value of i="+i);  //print the current value of i.
			
		}
		DyIO.disableFWCheck() ;
		DyIO dyio = new DyIO() ;
		
		
		if (!ConnectionDialog.getBowlerDevice(dyio))
		{
			
			System.exit(1) ;
		
		}
		
		dyio.enableDebug() ;
		
		//If your DyIO is using a lower voltage power source, you need to disable the brownout detect
		dyio.setServoPowerSafeMode(false) ;
		
		//ServoChannel srv = new ServoChannel (	dyio.getChannel(11)	) ;
		
		ServoWrapper wrapper = new ServoWrapper(
												new ServoChannel (
																  dyio.getChannel(11)
																  )
												) ;

		ServoWrapper wrapper2 = new ServoWrapper(
				new ServoChannel (
								  dyio.getChannel(12)
								  )
				) ;
		
		DigitalOutputChannel doc = new DigitalOutputChannel( dyio.getChannel(0) ) ;
		
		long startTime ;
		
		//repeat until i == 100, adding 1 to i each time. i starts at 0.
		for( int i = 0 ; i < 100 ; i++ )
		{
			
			startTime = System.currentTimeMillis() ;
			
			boolean isThisLoopEven = (i % 2) == 0 ;
			
			EventManager manager = new EventManager() ;
			
			if (isThisLoopEven)
			{
				
				//System.out.println("This loop is even " + i) ;
				wrapper.setPosition(200, 2000, manager) ;
				wrapper2.setPosition(200, 2000, manager) ;
				doc.setHigh(isThisLoopEven) ;
				
			}else{
				
				//System.out.println("This loop is odd " + i) ;
				wrapper.setPosition(50, 0, manager) ;
				wrapper2.setPosition(50, 0, manager) ;
				doc.setHigh(isThisLoopEven) ;
				
			}
			
			System.out.print("\r\nWaiting.") ;
			while (! manager.hasCompletedCycle() ) {
				ThreadUtil.wait(100) ;
				System.out.print(".") ;
			}
			
			System.out.println( "This loop took " + (System.currentTimeMillis() - startTime)/150/2 + " ms" ) ;
		
		}
		
		dyio.disconnect() ;   //end connection with the dyio and system
		System.exit(0) ;
		
	}
	
}