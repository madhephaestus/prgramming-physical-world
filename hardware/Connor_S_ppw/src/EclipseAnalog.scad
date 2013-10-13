//File Name: Xbox360AnalogStick.scad

//Module=customStick


customStick();
/*[Top of Stick]*/
stickHeight=25;
stickDiameterBottom=8;
stickDiameterTop=10;
/*[Measurement from Controller]*/
//If remove the stick from the controller, there is a hemisphere, if you set
//this hemisphere flat on a piece of paper this is the radius of the circle
//touching the paper
radiusOfCapCrossection=10;
//This is the height of the hemisphere above the paper
heightOfCap=8.5;
wallThickness=1;
pegMinorAxis=3;
pegMajorAxis=4;
pegDepth=4.75;







/*[calculation Block]*/
radiusOfSphereForStick=(radiusOfCapCrossection*radiusOfCapCrossection+heightOfCap*heightOfCap)/heightOfCap;

module customStick(){
union(){
difference(){
translate([0,0,heightOfCap-radiusOfSphereForStick])sphere(radiusOfSphereForStick);
translate([-2*radiusOfSphereForStick,-2*radiusOfSphereForStick,-2*radiusOfSphereForStick])cube([4*radiusOfSphereForStick,4*radiusOfSphereForStick,2*radiusOfSphereForStick]);
translate([0,0,heightOfCap-wallThickness-radiusOfSphereForStick])sphere(radiusOfSphereForStick-wallThickness);
}
difference(){
translate([0,0,heightOfCap-2*wallThickness-pegDepth])cylinder(r=pegMajorAxis/2+wallThickness,h=pegDepth);
difference(){
cylinder(r=pegMajorAxis/2,h=heightOfCap-wallThickness);
translate([pegMinorAxis/2,-pegMajorAxis/2,0])cube([pegMinorAxis,pegMajorAxis,heightOfCap]);
rotate([0,0,180])translate([pegMinorAxis/2,-pegMajorAxis/2,0])cube([pegMinorAxis,pegMajorAxis,heightOfCap]);

}
}



//Analogstick; Neck
translate([0,0,7]){
	cylinder(r=4.75,h=6,$fn=50);
}



//Analog Stick Grip
difference(){
	translate([0,0,15]){
		resize([18,18,4])
			#sphere(10,$fn=50);
	}


		translate([0,0,18.5]){
			resize([20,20,5])
				sphere(10,$fn=25);
		}


}




//Details
translate([0,5,16]){
	sphere(r=1);
}

		translate([0,-5,16]){
			sphere(r=1);
		}

			translate([5,0,16]){
				sphere(r=1);
			}

				translate([-5,0,16]){
					sphere(r=1);
				}




difference(){
intersection(){
translate([0,0,heightOfCap-wallThickness-radiusOfSphereForStick])sphere(radiusOfSphereForStick-.5*wallThickness);
translate([0,0,heightOfCap-2*wallThickness-pegDepth+radiusOfSphereForStick])sphere(radiusOfSphereForStick-.5*wallThickness);
}
cylinder(r=pegMajorAxis/2,h=heightOfCap-wallThickness);
translate([wallThickness,wallThickness,0])cube(radiusOfSphereForStick);
rotate([0,0,90])translate([wallThickness,wallThickness,0])cube(radiusOfSphereForStick);
rotate([0,0,180])translate([wallThickness,wallThickness,0])cube(radiusOfSphereForStick);
rotate([0,0,270])translate([wallThickness,wallThickness,0])cube(radiusOfSphereForStick);
}
}
}

translate([35,0,0]){

customStick();
}






