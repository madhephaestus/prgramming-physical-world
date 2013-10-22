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
		
		int positionDifferece = Math.abs(start-position) * 2; 
	
		myChannel.SetPosition(position, ((double)time)/1000.0 );
		
		if(time>positionDifferece){
			positionDifferece = time;
		}else{
			System.err.println("I can't move that fast! YOU SCREWED UP! I Need at least "+positionDifferece+"ms");
		}
		
		ThreadUtil.wait(positionDifferece);
	}
	
}
