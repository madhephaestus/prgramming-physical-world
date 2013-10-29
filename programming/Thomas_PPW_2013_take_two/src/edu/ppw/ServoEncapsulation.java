package edu.ppw;

import com.neuronrobotics.sdk.dyio.peripherals.ServoChannel;
import com.neuronrobotics.sdk.util.ThreadUtil;

public class ServoEncapsulation {
	ServoChannel srv;
	private int timeDelay;

	public ServoEncapsulation(ServoChannel input,int timeDelay){
			srv = input;
			this.timeDelay = timeDelay;
	}
	
	public void setPositionTimed(int targetPositionOfServo,int timeInMs){
		int currentPositionOfServo = srv.getValue();
	
		int differenceOfPosition = Math.abs(currentPositionOfServo-targetPositionOfServo);
		
		System.out.println("Change = "+differenceOfPosition);
		
		srv.SetPosition(targetPositionOfServo,((double) timeInMs/1000.0));
		
		int timeEstimation = differenceOfPosition*timeDelay;
		
		if(timeEstimation>timeInMs){
			ThreadUtil.wait(timeEstimation);
		
		}else{
			ThreadUtil.wait(timeInMs);
		}
	}
}