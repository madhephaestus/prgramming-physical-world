use<../../../Vitamins/Actuators/StandardServo/StandardServo_Vitamin.scad>

module centeredHole(	centerDistance=1,
						angleFromStart=0,
						holeDepth=5,
						holeWidth=1){
	
	rotate([0,0,angleFromStart]){
	translate([centerDistance,0,0]){
		//the hole itself
		cylinder(	h=holeDepth,//how deep the hole goes
					r=holeWidth/2,//setting the size of the hole
					center=true);//half depth
		}
	}
}

module tester(input=2){
	
	StandardServoMotor();
	
	
	difference(){
		translate([-25,-25,0]){
			//the flat surface
			cube([50,50,1]);
		}
		
		centeredHole();
		
		for (i = [0:10:360]) {
			
			echo(i);
			centeredHole(	centerDistance=10,
							angleFromStart=i,
							holeDepth=5,
							holeWidth=1);
		}
		
		
	}
	
}

//calling the module to start the whole display
tester();
