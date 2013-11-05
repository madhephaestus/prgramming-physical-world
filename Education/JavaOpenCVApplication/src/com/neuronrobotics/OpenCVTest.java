package com.neuronrobotics;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Rect;



import com.neuronrobotics.jniloader.FaceDetector;
import com.neuronrobotics.jniloader.OpenCVJNILoader;
import com.neuronrobotics.sdk.dyio.DyIO;
import com.neuronrobotics.sdk.dyio.peripherals.DigitalOutputChannel;
import com.neuronrobotics.sdk.dyio.peripherals.ServoChannel;
import com.neuronrobotics.sdk.ui.ConnectionDialog;

import edu.ppw.ServoEncapsulation;

public class OpenCVTest {
	int frameX = 640;
	int frameY = 480;
	  public void run() {
		FaceDetector faceDetectorObject = new FaceDetector(0);
		
		JFrame frame = new JFrame();
		ImageIcon icon = new ImageIcon();
		frame .setContentPane(new  JLabel(icon));
		frame.setSize(frameX, frameY);
		frame.setVisible(true);
		frame .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DyIO.disableFWCheck();
		
		DyIO dyio=new DyIO();
		if (!ConnectionDialog.getBowlerDevice(dyio)){
			System.exit(1);
		}
		DigitalOutputChannel doc = new DigitalOutputChannel(dyio.getChannel(0));
		
		//ServoChannel srv = new ServoChannel (dyio.getChannel(11));
		
		
		ServoEncapsulation panServo = 
				
				new ServoEncapsulation(new ServoChannel (dyio.getChannel(11)), 1);
		
		ServoEncapsulation tiltServo = 
				
				new ServoEncapsulation(new ServoChannel (dyio.getChannel(12)), 1);
		
		int panServoPosition =127;
		int tiltServoPosition =127;
		while (true){
			Rect [] faces = faceDetectorObject.getFaces();
			for(Rect r:faces){
				//System.out.println("Face at x:"+r.x+" y:"+r.y+" size:"+r.height*r.width);
				//this is where our servo code goes
				int centerx = (r.x+r.width/2);
				int centery = (r.y+r.height/2);
				System.out.println("The center x = "+centerx+" y = "+centery);
				
				int diffx = centerx -(frameX/2);
				int diffy = centery -(frameY/2);
				
				System.out.println("The Difference x = "+diffx+" y = "+diffy);
				
				panServoPosition += diffx*-.02;
				
				if(panServoPosition>200)
					panServoPosition=200;
				if(panServoPosition<50)
					panServoPosition=50;
				
				tiltServoPosition += diffy*.02;
				
				if(tiltServoPosition>200)
					tiltServoPosition=200;
				if(tiltServoPosition<50)
					tiltServoPosition=50;
			}
			tiltServo.setPositionTimed(tiltServoPosition, 0);
			panServo.setPositionTimed(panServoPosition, 0);
			
			try {
				BufferedImage image = faceDetectorObject.getLatestImage();
				icon.setImage(image);
				frame.repaint();
			} catch (Exception e) {
				// TODO Auto-generated catch block = 
				e.printStackTrace();
			} 
		}
		   
		    
	  }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OpenCVJNILoader.load();
        
        new OpenCVTest().run();
	}

}
