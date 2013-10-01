use<../../../Vitamins/Actuators/StandardServo/StandardServo_Vitamin.scad>

module centeredHole(	centerDistance=0,
						angleFromstart=0,
						holeDepth=5,
						holeWidth=1){
	rotate([0,0,angleFromstart]){
	translate([centerDistance,0,0]){
	cylinder(h=holeDepth,
			r=holeWidth,
			center=true);
		}
	}
}

module tester(input=2){

	StandardServoMotor();
	
	difference(){
		translate([-25,-25,0]){
			cube([50,50,1]);
		}
		centeredHole();
		for (i = [0:120:360]) {
			
			echo(i);
			centeredHole(	centerDistance=10,
							angleFromstart=i,
							holeDepth=5,
							holeWidth=1);
		}
		
	}

}

tester();