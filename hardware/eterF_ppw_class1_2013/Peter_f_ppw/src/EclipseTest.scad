use <../../Vitamins/Actuators/StandardServo/StandardServo_Vitamins
module centeredHole(	centerDistance=1,
						anglefromstart=0,
						holeDepth=5,
						holeWidth=1){
	
	
	rotate([0,0,anglefromstart]){
		translate([centerDistance,0,0]){
			//the hole itself					
			cylinder(	h=holeDepth,
				r=holeWidth/2,
				center=true);
		}
	}
	
}
	
module tester(input=2){
	
	
	//call the box
	difference(){
		translate([-25,-25,0]){
			//the flat surface
			cube([50,50,1]);
		}
		centeredHole() ;
		
		for (i = [0:90:360]) { 
			
			echo(i );
			centeredHole(					centerDistance=10,  
											anglefromstart=i,
											holeDepth=5,
											holeWidth=1);
			}
		}

	}

//calling the module 
tester() ;

