use <../../Vitamins/Actuators/StandardServo/StandardServo_Vitamin.scad>

use <../../Vitamins/Sensors/Camera/QuickCam_STX.scad>

use <../../Vitamins/Structural/SealedBearings/SealedBearing608_Vitamin.scad>

//QuickCam();
//StandardServoMotor(true, 1, true, .4);
//608BallBearing();



function getRadius() = getQuickCamRadius(.3) + 10;
function getThickness() = 20;

module coreBar(){
	//creating the intersection
	intersection(){
		//the core sphere
		sphere( getRadius() );
		//the cross section
		translate([-getRadius(),-getThickness()/2,0]){
			
			cube([getRadius()*2,getThickness(),getRadius()]);
		}
		//end the intersection
	}
}

module cameraHolder(){
	//subtracting camera from core bar
	difference(){
		coreBar();
		rotate([0,180,0]){
			translate([0,0,-getQuickCamRadius(.3)]){
				QuickCam();
			}
		}
	}
}

cameraHolder();


