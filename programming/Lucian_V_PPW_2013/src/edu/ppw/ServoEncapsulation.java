package edu.ppw;

import com.neuronrobotics.sdk.dyio.peripherals.ServoChannel;
import com.neuronrobotics.sdk.util.ThreadUtil;

public class ServoEncapsulation {
	ServoChannel srv;
	private int timeDelay; 
		
	public ServoEncapsulation(ServoChannel input, int timeDelay){
		srv=input;
		this.timeDelay = timeDelay;
		
	}

	public void setPositionTimed(int positionTheServoShouldGoto, int timeInMs){
		int currentPositionOfServo = srv.getValue();
		
		System.out.println("Current Position = "+currentPositionOfServo);
		
		int differenceOfPosition = Math.abs(currentPositionOfServo-positionTheServoShouldGoto);
		
		System.out.println("Change = "+differenceOfPosition);
		
		srv.SetPosition(positionTheServoShouldGoto, ((double)timeInMs/1000.0));
		
		int timeEstimation = differenceOfPosition*timeDelay;
		
		if(timeEstimation>timeInMs){
			ThreadUtil.wait(timeEstimation);
		}else{
			ThreadUtil.wait(timeInMs);
		}
	
	

	}
	
}	