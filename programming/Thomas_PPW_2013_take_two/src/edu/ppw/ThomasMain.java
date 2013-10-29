package edu.ppw;
import com.neuronrobotics.sdk.dyio.DyIO;
import com.neuronrobotics.sdk.dyio.peripherals.DigitalOutputChannel;
import com.neuronrobotics.sdk.dyio.peripherals.ServoChannel;
import com.neuronrobotics.sdk.ui.ConnectionDialog;
import com.neuronrobotics.sdk.util.ThreadUtil;
public class ThomasMain {
	public static void main(String[] args) {
		DyIO.disableFWCheck();
		DyIO dyio=new DyIO();
		if (!ConnectionDialog.getBowlerDevice(dyio)){
			System.exit(1);
		}
		DigitalOutputChannel doc = new DigitalOutputChannel(dyio.getChannel(0));
		//ServoChannel srv = new ServoChannel (dyio.getChannel(11));
		
		
		ServoEncapsulation myEncapsulation = 
				
				new ServoEncapsulation(new ServoChannel (dyio.getChannel(11)), 10);
		
ServoEncapsulation myEncapsulation2 = 
				
				new ServoEncapsulation(new ServoChannel (dyio.getChannel(12)), 10);
		
		
		long longest	= 0;
		long shortest	= 1000;
		// Blink the LED 5 times
		for(int i = 0; i < 20; i++) {
			System.out.println("Blinking.");
			boolean thisLoopIsOdd = i % 2 == 1;
			long timestamp = System.currentTimeMillis();
			if(thisLoopIsOdd){
				//System.out.println("This Loop is odd "+i);
				//srv.SetPosition(200, 0);
				myEncapsulation.setPositionTimed(200, 2000);
				myEncapsulation2.setPositionTimed(200, 2000);
			}else{
				//System.out.println("This loop is even "+i);
				//srv.SetPosition(50, 0);
				myEncapsulation.setPositionTimed(50, 0);
				myEncapsulation2.setPositionTimed(50, 0);
			}
			// Set the value high every other time, exit if unsuccessful
			if(!doc.setHigh(i % 2 == 1)) {
				System.err.println("Could not connect to the device.");
				System.exit(0);
			}
			// pause between cycles so that the changes are visible
			
			long timepassed = System.currentTimeMillis()-timestamp;
			
			if(timepassed>longest)
				longest=timepassed;
			if(timepassed<shortest)
				shortest=timepassed;
			System.out.println("Time for command to run: "+timepassed/150+" longest: "+longest/150+" shortest: "+shortest/150+"");
		}
           System.exit(0);
	}

}