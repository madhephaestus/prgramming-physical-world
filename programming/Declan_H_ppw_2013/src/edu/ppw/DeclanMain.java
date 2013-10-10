package edu.ppw;

import com.neuronrobotics.sdk.dyio.DyIO;
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
		
		for (int i=3	; i < 10	;i++	){
			System.out.println("Current value of i = "+i);
			srv.SetPosition(i*20, 1);
		
			ThreadUtil.wait(6000);
		}
		
		dyio.disconnect();
	}
	


}