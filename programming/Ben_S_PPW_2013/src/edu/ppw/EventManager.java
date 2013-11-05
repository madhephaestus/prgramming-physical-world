package edu.ppw;

import com.neuronrobotics.sdk.dyio.peripherals.ServoChannel;

public class EventManager {
	
	boolean channelOneHasFired=false;
	
	boolean channelTwoHasFired=false;
	
	public void onCompletion(ServoChannel myChannel) {
		
		int channelNumber = myChannel.getChannel().getChannelNumber();
		
		System.out.println("The event has happened"+myChannel.getChannel().getChannelNumber());
		
		if(channelNumber == 11){
			
			channelOneHasFired=true;
			
		}
		
		if(channelNumber == 12){
			
			channelTwoHasFired=true;
			
		}
		
	}
	
	public boolean hasCompletedCycle(){
		
		return channelOneHasFired  && channelTwoHasFired;
		
	}

}
