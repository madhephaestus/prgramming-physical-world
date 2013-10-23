

use <CameraMount.scad>
use <TiltRingHolder.scad>
use <PanRingHolder.scad>
difference(){
	union(){
		panRingHolder();
		rotate([0,0,22])
			tiltRing();
		translate([getPanRingRadius()+5,0,0])
			rotate([0,0,90])
				cameraTiltBar();
	}
	translate([-100,-100,-5]){
		cube([200,200,5]);
	}
}


rotate([0,0,-10]){
translate([0,90,-25]){
import("/Users/aob/Downloads/Ender_Dragon/EnderDragon.stl");

	}
}

translate([15,0,-25]){
import("/Users/aob/Downloads/Minecraft_Chess_Set/Creeper.stl");
}


translate([20,70,-25]){
import("/Users/aob/Downloads/Minecraft_Chess_Set/Slime.stl");
}
translate([-50,90,-25]){
import("/Users/aob/Downloads/Nano_Egg/nano_egg.stl");
}
translate([-75,85,-25]){
import("/Users/aob/Downloads/Nano_Egg/nano_egg.stl");
}

translate([60,80,-25]){
import("/Users/aob/Downloads/White_Mana_Seal_Ring 2/White_Ring_stl.STL");}

translate([-85,-85,-25]){
#cube(200,200,200) center(true);
}