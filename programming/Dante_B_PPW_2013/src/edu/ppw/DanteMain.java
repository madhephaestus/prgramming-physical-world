package edu.ppw;

import com.neuronrobotics.sdk.dyio.DyIO;
import com.neuronrobotics.sdk.dyio.peripherals.DigitalOutputChannel;
import com.neuronrobotics.sdk.dyio.peripherals.ServoChannel;
import com.neuronrobotics.sdk.ui.ConnectionDialog;
import com.neuronrobotics.sdk.util.ThreadUtil;

public class DanteMain {

	public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println("Dumbo went to destruction slayeth");
		
		DyIO.disableFWCheck();
		
		DyIO dyio=new DyIO();
		dyio.enableDebug();
		if (!ConnectionDialog.getBowlerDevice(dyio)){
			System.exit(1);
		}
		
		//If your DyIO is using a lower voltage power source, you need to disable the brownout detect
		dyio.setServoPowerSafeMode(false);
		

		
		//ServoChannel srv = new ServoChannel (dyio.getChannel(11));
		ServoWrapper wrapper = new ServoWrapper(new ServoChannel (dyio.getChannel(11)));
		
		ServoWrapper wrapper2 = new ServoWrapper(new ServoChannel (dyio.getChannel(12)));
		
		DigitalOutputChannel doc = new DigitalOutputChannel(dyio.getChannel(0));
		
		long startTime;
		
				
		for(int i = 0		;i < 100	;i++	){
			
			startTime = System.currentTimeMillis();
			
			boolean isThisLoopEven = (i % 2) == 0;
			
			EventManager manager = new EventManager();
			
			if(isThisLoopEven){
					//System.out.println("This loop is even" +i);
					wrapper.setPosition(200,2000,manager);
					wrapper2.setPosition(200,2000,manager);
					//srv.SetPosition(200, 0);
					doc.setHigh(isThisLoopEven);
					
			}else{
				//System.out.println("This loop is odd" +i);
				wrapper.setPosition(50,0,manager);
				wrapper2.setPosition(50,0,manager);
				//srv.SetPosition(50, 0);
				doc.setHigh(isThisLoopEven);
			}
			System.out.print("\r\nWaiting");
			while(! manager.hasCompletedCycle()){
				ThreadUtil.wait(10);
				System.out.print(".");
			}
			System.out.println("This Loop Took " + (System.currentTimeMillis() - startTime) /150 / 2  + "ms");
		} 
		
		dyio.disconnect();
		System.exit(0);
		}
	}

