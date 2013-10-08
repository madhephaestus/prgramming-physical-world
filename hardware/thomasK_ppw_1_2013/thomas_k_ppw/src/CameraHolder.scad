use<../../../Vitamins/Actuators/StandardServo/StandardServo_Vitamin.scad>

use<../../../Vitamins/Structural/SealedBearings/SealedBearing608_Vitamin.scad>

use<../../../Vitamins/Sensors/Camera/QuickCam_STX.scad>

function getCameraBarThickness() = 10;
function getCameraBarWidth()	 = 20;

function  getRadius() = getQuickCamRadius(.3) + 
						getCameraBarThickness();

module bearingInterface(){

	cylinder(	h=608BallBearingHeight(),
			r=608BallBearingInnerDiam()/2,
			center=false);
}

module cameraHolder(){
	//QuickCam();
	//StandardServoMotor();
	//608BallBearing();
	intersection(){
	
	sphere( getRadius() );
	
	translate([-getRadius(),
	           -getCameraBarWidth()/2,
	           0]){
	cube([ getRadius()*2,
			getCameraBarWidth(),
			getRadius()  ]);

		}
	//finished the intersection
	}
}


cameraHolder();