package edu.ppw;

import com.neuronrobotics.sdk.dyio.DyIO;
import com.neuronrobotics.sdk.dyio.peripherals.DigitalOutputChannel;
import com.neuronrobotics.sdk.dyio.peripherals.ServoChannel;
import com.neuronrobotics.sdk.ui.ConnectionDialog;

public class PeterMain {
	public static void main(String[] args) {
		DyIO.disableFWCheck();
		DyIO dyio=new DyIO();
		if (!ConnectionDialog.getBowlerDevice(dyio)){
			System.exit(1);
		}
		DigitalOutputChannel doc = new DigitalOutputChannel(dyio.getChannel(0));
		//ServoChannel srv = new ServoChannel (dyio.getChannel(11));
		
		ServoEncapsullation myEncapsulation= new ServoEncapsullation(new ServoChannel (dyio.getChannel(11)), 10);
		
		
		long longest	= 0;
		long shortest   = 1000;
		// Blink the LED 5 times
		for(int i = 0; i < 20; i++) {
			//System.out.println("Blinking.");
			long timestamp = System.currentTimeMillis();
			
			boolean thisLoopIsOdd = (i % 2) == 1;
			if(thisLoopIsOdd){
				//System.out.println("this loop is odd"+i);
				//srv.SetPosition(200, 0);
				
				//System.out.println("Time for command to run: "+timepassed);
				
				myEncapsulation.setPositionTimed(200, 2000);
			}else{
				//System.out.println("This line is even"+i);
				//srv.SetPosition(50, 0);
				
				myEncapsulation.setPositionTimed(5, 0);
			}
			// Set the value high every other time, exit if unsuccessful
			if(!doc.setHigh(i % 2 == 1)) {
 				System.err.println("Could not connect to the device.");
				System.exit(0);
			}
			// pause between cycles so that the changes are visible

			long timepassed = System.currentTimeMillis() - timestamp;
			
			if (timepassed>longest)
				longest=timepassed;
			if(timepassed<shortest)
				shortest=timepassed;
			
			System.out.println("Time for command to run: "+timepassed/150+" longest: "+longest+" shortest: "+shortest);
		}
           System.exit(0);
	}

}