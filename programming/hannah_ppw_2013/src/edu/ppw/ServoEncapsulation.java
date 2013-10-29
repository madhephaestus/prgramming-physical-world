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
	public void setPositionTimed(int positionTheServoShouldGoTo, int timeInMs){
		// This gets the current estimated time value from the servo
		int currentPositionOfServoToBegin = srv.getValue();
			
		System.out.println("Curent Position = "+currentPositionOfServoToBegin);
		// this calculates the number of 'ticks' the servo will move
		int differenceOfPosition = Math.abs(currentPositionOfServoToBegin-positionTheServoShouldGoTo);
			
		System.out.println("Change = "+differenceOfPosition);
		// actually send the data to the device	
		srv.SetPosition(positionTheServoShouldGoTo, ((double)timeInMs/1000.0));
		// calculate how long we think the servo will take to get to its final position
		int timeEstimation = differenceOfPosition*timeDelay;
			
		if(timeEstimation>timeInMs){
			ThreadUtil.wait(timeEstimation);		
		}
		else{
			ThreadUtil.wait(timeInMs);
		}
	}
}
