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

module cameraInterface(){
	//subtract camera from core bar
	difference(){
		coreBar();
		//rotate camera
		rotate([0,180,0]){
			//translate camera (in negative direction because Z-axis is flipped
			translate([0,0,-getQuickCamRadius(.3)]){
				QuickCam();
			}
		}
	}
}

module endCap(){
	//end cap for camera holder
	cylinder(h=10,r=getThickness()/2,center=false);
}

module cameraHolder(){
	
	cameraInterface();
	//end cap tranlations and rotations
	translate([(getRadius())-10,0,0]){
		rotate([0,90,0]){
			#endCap();
		}
	}
	
	translate([(-getRadius())+10,0,0]){
		rotate([0,-90,0]){
			endCap();
		}
	}
}

cameraHolder();


