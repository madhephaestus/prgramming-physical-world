package edu.ppw;

import com.neuronrobotics.sdk.dyio.DyIO;
import com.neuronrobotics.sdk.dyio.peripherals.DigitalOutputChannel;
import com.neuronrobotics.sdk.dyio.peripherals.ServoChannel;
import com.neuronrobotics.sdk.ui.ConnectionDialog;
import com.neuronrobotics.sdk.util.ThreadUtil;

public class LucianMain {

	public static void main(String[] args) {
		DyIO.disableFWCheck();
		DyIO dyio=new DyIO();
		if (!ConnectionDialog.getBowlerDevice(dyio)){
			System.exit(1);
		}
		DigitalOutputChannel doc = new DigitalOutputChannel(dyio.getChannel(0));
		
		//ServoChannel srv = new ServoChannel (dyio.getChannel(11));
		
		
		ServoEncapsulation myEncapsulation = 
				
				new ServoEncapsulation(new ServoChannel (dyio.getChannel(11)), 6);
		
		ServoEncapsulation myEncapsulation2 = 
				
				new ServoEncapsulation(new ServoChannel (dyio.getChannel(12)), 6);
		
		
		
		long longest	= 0;
		long shortest	= 1000;
		// Blink the LED 5 times
		for(int i = 0; i < 20; i++) {
			long timestamp = System.currentTimeMillis();
			boolean thisLoopIsOdd = (i % 2) == 1;
			
			if(thisLoopIsOdd){
//				System.out.println("This loop is odd");
				//srv.SetPosition(200, 0);
				long timePassed = System.currentTimeMillis()-timestamp; 
				
				if(timePassed>longest)
					longest=timePassed;
				if(timePassed<shortest)
					shortest=timePassed;
				System.out.println("Time for command to run: "+timePassed+" longest: "+longest+" shortest: "+shortest);
				myEncapsulation2.setPositionTimed(200, 2000);
				myEncapsulation.setPositionTimed(200, 2000);
			}else{
				
				myEncapsulation2.setPositionTimed(50, 0);
				myEncapsulation.setPositionTimed(50, 0);
//				System.out.println("This loop is even");
				//srv.SetPosition(50, 0);
			}
			
			// Set the value high every other time, exit if unsuccessful
			if(!doc.setHigh(i % 2 == 1)) {
				System.err.println("Could not connect to the device.");
				System.exit(0);
			}
			// pause between cycles so that the changes are visible
		}
           System.exit(0);
		
	}  

}
