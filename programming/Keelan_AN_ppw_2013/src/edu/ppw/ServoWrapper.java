package edu.ppw ;

import com.neuronrobotics.sdk.dyio.peripherals.ServoChannel ;
import com.neuronrobotics.sdk.util.ThreadUtil;

public class ServoWrapper
{
	
	int milliseconds = 2 ;
	
	private ServoChannel myChannel ;
	private int positionDifference ;
	public ServoWrapper(ServoChannel myChannel)
	{
		this.myChannel = myChannel ;
		
	}
	
	public void setPosition(int position, int time, final EventManager event)
	{
		
		int start = myChannel.getValue() ;
		
		positionDifference = Math.abs(start - position) * milliseconds ;
		
		myChannel.SetPosition(position, ((double)time) / 1000.0 ) ;
		
		if( time  > positionDifference)
		{
			
			positionDifference=time ;
		
		}else{
			
			System.err.println("I can not move that fast! Needs at least " + positionDifference + " ms" ) ;
			
		}
			
		if (event == null)
		{
				
			ThreadUtil.wait(time) ;
			
		}else{
				
			new Thread()
			{
					
				public void run()
				{
					
					ThreadUtil.wait(positionDifference) ;
					event.onCompletion(myChannel) ;
				
				}
					
			}.start() ;
				
		}
		
	}
	
}