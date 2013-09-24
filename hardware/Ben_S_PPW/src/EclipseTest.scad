use <../../Vitamins/Actuators/StandardServo/StandardServo_Vitamin.scad>

module testModule(){
	
	difference(){
	
		translate([
		           -(StandardServoThickness()/2),
		           0,
		           0
		           ]){
			
			cube([StandardServoThickness()*2,150,5]);
			
		}
		
		#StandardServoMotor(true, 1, false, .4);
		
		translate([
		           (StandardServoThickness()/2),
		           150-StandardServoCylinderDist(),
		           0
		           ]){
			
			#StandardServoMotor(true, 1, true, .4);
		
		}
		
	}
	
}

testModule();