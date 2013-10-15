package edu.ppw;

import com.neuronrobotics.sdk.dyio.DyIO;
import com.neuronrobotics.sdk.dyio.peripherals.DigitalOutputChannel;
import com.neuronrobotics.sdk.dyio.peripherals.ServoChannel;
import com.neuronrobotics.sdk.ui.ConnectionDialog;
import com.neuronrobotics.sdk.util.ThreadUtil;

public class DeclanMain {

	public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println("Banana");
		
		for (int i=0	; i < 10	;i++	){
			System.out.println("Current value of i = "+i);
			
		}
		
		DyIO.disableFWCheck();
		
		DyIO dyio=new DyIO();
		//dyio.enableDebug();
		if (!ConnectionDialog.getBowlerDevice(dyio)){
			System.exit(1);
		}
		
		//If your DyIO is using a lower voltage power source, you need to disable the brownout detect
		dyio.setServoPowerSafeMode(false);
		

		
		
		ServoChannel srv = new ServoChannel (dyio.getChannel(11));
		
		
		DigitalOutputChannel doc = new DigitalOutputChannel(dyio.getChannel(1));
		
		long startTime = System.currentTimeMillis();
		for (int i=0	; i < 100	;i++	){
			
			startTime = System.currentTimeMillis();
			
			boolean isThisLoopEven = (i % 2) == 0;
			
			if(isThisLoopEven){
			//System.out.println("This Loop is even " +i);
			srv.SetPosition(200, 0);
			doc.setHigh(isThisLoopEven);
		
			}else{
				//System.out.println("This Loop is odd " +i);
				srv.SetPosition(50, 0);
				doc.setHigh(isThisLoopEven);
				
			}
			
			System.out.println("This loop took " +(System.currentTimeMillis()-startTime)+" ms");
			//ThreadUtil.wait(6000);
		}
		
		dyio.disconnect();
		System.exit(0);
	}
	


}
