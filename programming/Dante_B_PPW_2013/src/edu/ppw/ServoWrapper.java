package edu.ppw;

import com.neuronrobotics.sdk.dyio.peripherals.ServoChannel;
import com.neuronrobotics.sdk.util.ThreadUtil;

public class ServoWrapper {
	
	private ServoChannel myChannel;
	 
	private int positionDifferece;
	
	public ServoWrapper(ServoChannel myChannel){
   		
		this.myChannel = myChannel;
		
	}
	
	public void setPosition(int position,int time,final EventManager event){
		
		int start = myChannel.getValue();
		
		positionDifferece = Math.abs(start-position) * 2; 
	
		myChannel.SetPosition(position, ((double)time)/1000.0 );
		

		if(time>positionDifferece){
			positionDifferece = time;
		}else{
			System.err.println("I can't move that fast! YOU SCREWED UP! I Need at least "+positionDifferece+"ms");
		}
	
		if(event == null){
			ThreadUtil.wait(positionDifferece);
		}else{
			new Thread(){
				public void run(){
					ThreadUtil.wait(positionDifferece);
					event.onCompletion(myChannel);
				}
			}.start();
		}
	}
	
}
