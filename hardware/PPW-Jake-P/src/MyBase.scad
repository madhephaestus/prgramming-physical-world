use <../../Vitamins/Actuators/StandardServo/StandardServo_Vitamin.scad>

module myPart(){
	hull(){
		cube([StandardServoThickness()*3,StandardServoLength()+20,1]);
		translate([15.75,10,StandardServoHeight()]){
			cube([StandardServoThickness()*1.5,StandardServoLength(),1]);
		}
	}
}

module myBase(){
	difference(){
		translate([-31.5,-StandardServoLength()+7.5,-StandardServoHeight()-10]){
			myPart();
		}

		StandardServoMotor(true, 1, true, .4);
	}
}

myBase();