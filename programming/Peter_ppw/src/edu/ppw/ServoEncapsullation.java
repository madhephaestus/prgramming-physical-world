package edu.ppw;

import com.neuronrobotics.sdk.dyio.peripherals.ServoChannel;
import com.neuronrobotics.sdk.util.ThreadUtil;

public class ServoEncapsullation {
	ServoChannel srv;
	private int timeDelay;
	
	public ServoEncapsullation(ServoChannel input, int timeDelay){
		srv = input;
		this.timeDelay = timeDelay;
		
	}
	
	public void setPositionTimed(int positionTheServoShouldGoto, int timeInMs){
		// this gets the current estimated value from the servo
		int currentPostionOfServoToBegin = srv.getValue();
		System.out.println("Current position = "+currentPostionOfServoToBegin);
		//this calculates the number of *ticks* the server will move
		int differenceOfPosition = Math.abs(currentPostionOfServoToBegin - positionTheServoShouldGoto) ;
		
		System.out.println("Change = "+differenceOfPosition);
		// actually send the data to the device
		srv.SetPosition(positionTheServoShouldGoto, ((double)timeInMs/1000.0));
		// calculate how long we think the servo will take to get
		// to its position.
		int timeEstimation = differenceOfPosition*timeDelay;
		
		if(timeEstimation>timeInMs){
			ThreadUtil.wait(timeEstimation);
		}else{
			ThreadUtil.wait(timeInMs);
		}
	}
	
}
