package edu.ppw;

import com.neuronrobotics.sdk.dyio.peripherals.ServoChannel;
import com.neuronrobotics.sdk.util.ThreadUtil;

public class ServoWrapper {

	private ServoChannel myChannel;

	public ServoWrapper(ServoChannel myChannel){
		this.myChannel = myChannel;
		
	}
	
	public void setPosition(int position,int time){
		int start = myChannel.getValue();
		
		int positionDifference =  Math.abs(start-position) * 2;
		
		myChannel.SetPosition(position, ((double)time)/1000.0 );
		
		if(time > positionDifference){
			positionDifference = time;
		}else{
			System.err.println("I cannot move that fast! Needs at least " + positionDifference + " milliseconds.");
		}
		
		ThreadUtil.wait(positionDifference);
		
		
	}
	
}
