package edu.ppw;
import com.neuronrobotics.sdk.dyio.DyIO;
import com.neuronrobotics.sdk.dyio.peripherals.ServoChannel;
import com.neuronrobotics.sdk.ui.ConnectionDialog;
import com.neuronrobotics.sdk.util.ThreadUtil;
// this is the webpage's that have the information to allow the variables to work.

public class Keelan_AN_ppw_2013_1 {

	public static void main(String[] args) {
		System.out.println("helloWorld");  //prints helloWorld onto the web. can be made by typing syso and then ctrl space.
		System.out.println("chaChaCha");   // ditto

		for(int  i=0	;i<10	;i++	){  // i++ means i + 1
			System.out.println("current value of i="+i);  // this change's i
			
		}

		DyIO dyio=new DyIO();
		
		
		if (!ConnectionDialog.getBowlerDevice(dyio)){
			System.exit(1);
		}
		dyio.enableDebug();
		//If your DyIO is using a lower voltage power source, you need to disable the brownout detect
		dyio.setServoPowerSafeMode(false);
		
		ServoChannel srv = new ServoChannel (	dyio.getChannel(11)	); // this tells the srv what channel to use
		
		for(int  i=3	;i<10	;i++	) {  //this tells i what to start at, what to end at, and how many to change by
			srv.SetPosition(i*20, 1); //this tells it how many time to do this per second(s). 
			
			ThreadUtil.wait(6000);
		
		}
		
		dyio.disconnect();   //this ends connection with the dyio
		
	}
	
}
