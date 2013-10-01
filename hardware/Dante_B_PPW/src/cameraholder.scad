use<../../Vitamins/Actuators/StandardServo/StandardServo_Vitamin.scad>

use<../../Vitamins/Sensors/Camera/QuickCam_STX.scad>

use<../../Vitamins/Structural/SealedBearings/SealedBearing608_Vitamin.scad>
		
//QuickCam();
			
//StandardServoMotor(true, 1, true, .4);
			
//608BallBearing();	
			
function getRadius()= getQuickCamRadius (.3) +10;
function getThickness()	= 20;


module cameraHolder(){
	difference(){
		coreBar();
		translate([0,
		           0,
		           getQuickCamRadius (.3) -10]){
		rotate([0,
		        180,
		        0]
		        		){
			#QuickCam();
			}
		}	
	}
}
	
module coreBar(){
	intersection(){

	color("red")
		sphere(getRadius());
	
	translate([-getRadius(),
	           -getThickness()/2,
	           0])
	        		   
	    color("red")
			cube([	getRadius()*2,
			      	getThickness(),
			      	getRadius()]
	      				);
	}
	
}


cameraHolder();