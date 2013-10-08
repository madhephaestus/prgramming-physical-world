use <../../../Education/PanTiltMechanism/CameraMount.scad>
use <../../../Education/PanTiltMechanism/TiltRingHolder.scad>
use <../../../Education/PanTiltMechanism/PanRingHolder.scad>


panRingHolder();
rotate([0,0,22])
	tiltRing();
translate([getPanRingRadius()+5,0,0])
	rotate([0,0,90])
		cameraTiltBar();