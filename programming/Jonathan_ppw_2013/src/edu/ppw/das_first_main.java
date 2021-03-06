package edu.ppw;

import com.neuronrobotics.sdk.dyio.DyIO;
import com.neuronrobotics.sdk.dyio.peripherals.DigitalOutputChannel;
import com.neuronrobotics.sdk.dyio.peripherals.ServoChannel;
import com.neuronrobotics.sdk.ui.ConnectionDialog;

public class das_first_main {

	public static void main(String[] args) {
		DyIO.disableFWCheck();
		DyIO dyio=new DyIO();
		if (!ConnectionDialog.getBowlerDevice(dyio)){
			System.exit(1);
		}
		DigitalOutputChannel doc = new DigitalOutputChannel(dyio.getChannel(0));
		
		ServoChannel srv = new ServoChannel (dyio.getChannel(11));
		long longest	 = 0;
		long shortest	 = 1000;
		// Blink the LED 5 times
		for(int i = 0; i < 20; i++) {
			long timestamp = System.currentTimeMillis();
			
			boolean thisLoopIsOdd = (i % 2) == 1;
					
					if(thisLoopIsOdd){
						//System.out.println("This loop is odd "+i);
						
						srv.SetPosition(200, 0);

					}else{
						//System.out.println("This loop is even "+i);
						srv.SetPosition(50, 0);
					}
			
			// Set the value high every other time, exit if unsuccessful
			if(!doc.setHigh(i % 2 == 1)) {
				System.err.println("Could not connect to the device.");
				System.exit(0);
			}
			// pause between cycles so that the changes are visible
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long timePassed = System.currentTimeMillis()-timestamp;
			
			if(timePassed>longest)
				longest=timePassed;
			if(timePassed<shortest)
				shortest=timePassed;
			
			System.out.println("time for command to run: "+timePassed+" longest: "+longest+" shortest: "+shortest);
		}
           System.exit(0);
	}

}
