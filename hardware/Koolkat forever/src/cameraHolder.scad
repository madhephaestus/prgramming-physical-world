use <../../Vitamins/Actuators/StandardServo/StandardServo_Vitamin.scad>
use <../../Vitamins/Sensors/Camera/QuickCam_STX.scad>
use <../../Vitamins/Structural/SealedBearings/SealedBearing608_Vitamin.scad>

//QuickCam();
//StandardServoMotor(true, 1, false, .4);
//608BallBearing();

function getRadius()	=	getQuickCamRadius(.3)	+	10;
function getThickness()	=	20;

module coreBar(){
	intersection(){
		sphere( getRadius() );
	
		translate([-getRadius(),
	           -getThickness()/2,
	           0]){
			cube([	getRadius()*2,
			      	getThickness(),
			      	getRadius()]);
		
		}
	}
}

module cameraHolder(){
	difference(){

		coreBar();
		translate([0,0,getQuickCamRadius(.3)]){
		rotate([0,180,0])
		#QuickCam();
		}
	}
}

//QuickCam();

cameraHolder();
	