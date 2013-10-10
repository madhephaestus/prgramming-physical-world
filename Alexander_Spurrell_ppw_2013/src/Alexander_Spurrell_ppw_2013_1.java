import com.neuronrobotics.sdk.dyio.DyIO;
import com.neuronrobotics.sdk.dyio.peripherals.ServoChannel;
import com.neuronrobotics.sdk.ui.ConnectionDialog;
import com.neuronrobotics.sdk.util.ThreadUtil;


public class Alexander_Spurrell_ppw_2013_1 {

	public static void main(String[] args) {
		System.out.println("helloWorld");
		System.out.println("chaChaCha");

		for(int  i=0	;i<10	;i++	){
			System.out.println("current value of i="+i);
			
		}

		DyIO dyio=new DyIO();
		
		
		if (!ConnectionDialog.getBowlerDevice(dyio)){
			System.exit(1);
		}
		dyio.enableDebug();
		//If your DyIO is using a lower voltage power source, you need to disable the brownout detect
		dyio.setServoPowerSafeMode(false);
		
		ServoChannel srv = new ServoChannel (	dyio.getChannel(11)	);
		
		for(int  i=3	;i<10	;i++	) {
			srv.SetPosition(i*20, 1);
			
			ThreadUtil.wait(6000);
		
		}
		
		dyio.disconnect();
		
	}
	
}
