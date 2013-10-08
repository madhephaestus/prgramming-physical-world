use <../../Vitamins/Actuators/StandardServo/StandardServo_Vitamin.scad>

baseWidth=200;
baseHeight=150;
baseDepth=9;


		cube([baseWidth,baseHeight,baseDepth]);

translate([baseWidth/2-(StandardServoHeight()/2),baseHeight/2-(StandardServoThickness()/2),40]){
#StandardServoMotor(true, 1, false, .4);
}