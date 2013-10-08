use <../../Vitamins/Actuators/StandardServo/StandardServo_Vitamin.scad>

use <../../Vitamins/Sensors/Camera/QuickCam_STX.scad>

use <../../Vitamins/Structural/SealedBearings/SealedBearing608_Vitamin.scad>

//QuickCam();
//StandardServoMotor(true, 1, true, .4);
//608BallBearing();

function getRadius() = getQuickCamRadius(.3) + 10;
function getThickness() = 20;

module coreBar(){
	intersection(){
		sphere( getRadius() );
		translate([-getRadius(),-getThickness()/2,0]){
			cube([getRadius()*2,getThickness(),getRadius()]);
		}
	}
}

module cameraInterface(){
	difference(){
		coreBar();
		translate([0,0,getQuickCamRadius(.3)]){
			rotate([0,180,0]){
				QuickCam();
			}	
		}
	}
}

module endcap(){
	cylinder(h=10,r=getThickness()/2,center=false);
}

module cameraHolder(){
	cameraInterface();
	translate([(getRadius()-10),0,0]){
		rotate([0,90,0]){
			#endcap();
		}
	}
	translate([-(getRadius()-10),0,0]){
		rotate([0,-90,0]){
			endcap();
		}
	}
}
cameraHolder();