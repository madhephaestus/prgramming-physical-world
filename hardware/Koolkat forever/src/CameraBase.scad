use <../../Vitamins/Actuators/StandardServo/StandardServo_Vitamin.scad>

module myBase(){
baseWidth=200;
baseHeight=150;
baseDepth=9;

difference(){
		cube([baseWidth,baseHeight,baseDepth]);

translate([baseWidth/2-(StandardServoHeight()/2),baseHeight/2-(StandardServoThickness()/2),40]){
#StandardServoMotor(true, 1, false, .4);
		}
	}
}
myBase();