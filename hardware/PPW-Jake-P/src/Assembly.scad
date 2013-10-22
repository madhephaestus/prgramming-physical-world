use <../../../Education/Programming the Physical World/PanTiltMechanism/CameraMount.scad>
use <../../../Education/Programming the Physical World/PanTiltMechanism/TiltRingHolder.scad>
use <../../../Education/Programming the Physical World/PanTiltMechanism/PanRingHolder.scad>
use <MyBase.scad>

panRingHolder();
rotate([0,0,22])
	tiltRing();
translate([getPanRingRadius()+5,0,0])
	rotate([0,0,90])
		cameraTiltBar();

translate([0,110,50]){
	myBaseWithHole();
}

translate([20,0,7]){
import("prgramming-physical-world/Working Directory/hardware/PPw-Jake-P/src/Lego_8Block.stl");
}