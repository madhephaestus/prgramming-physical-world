
use <../../../Vitamins/Actuators/StandardServo/StandardServo_Vitamin.scad>

module centeredHole(	centerDistance=1,
						angleFromStart=0,
						holeDepth=5,
						holeWidth=5){
	rotate([0,0,angleFromStart]){
	translate([centerDistance,0,0]){
	cylinder(	h=holeDepth,
				r=holeWidth/2,
				center=true);
	}
	}
}

module tester(input=2) {
	StandardServoMotor();
	difference(){
		translate([-25,-25,0]){
			
			  cube([50,50,1]);
		}
		
		centeredHole();
		
		for (i = [0:10:360]) {
			echo(i);
			centeredHole(	centerDistance=10,
							angleFromStart=i,
							holeDepth=5,
							holeWidth=5);
			
		}
		
	}
	
}

tester();

