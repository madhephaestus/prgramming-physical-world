package edu.ppw;

import com.neuronrobotics.sdk.dyio.peripherals.ServoChannel;

public class Eventoverlooker {
	
	boolean channelonehasFired=false;
	boolean channeltwohasFired=false;
	
	public void onCompletion(ServoChannel myChannel){
		int channelNumber =myChannel.getChannel().getChannelNumber();
		
		System.out.println("the event has happened on channel: "+channelNumber);
		
		if(channelNumber == 11){
			channelonehasFired=true;
		}
		if(channelNumber == 12){
			channeltwohasFired=true;
		}
	}
	
	public boolean hascompletedCycle(){
		
		return channelonehasFired && channeltwohasFired;
	}

}
