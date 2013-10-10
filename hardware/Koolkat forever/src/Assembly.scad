use <../../../Education/Programming the Physical World/PanTiltMechanism/CameraMount.scad>
use <../../../Education/Programming the Physical World/PanTiltMechanism/TiltRingHolder.scad>
use <../../../Education/Programming the Physical World/PanTiltMechanism/PanRingHolder.scad>


panRingHolder();
rotate([0,0,22])
	tiltRing();
translate([getPanRingRadius()+5,0,0])
	rotate([0,0,90])
		cameraTiltBar();

import("hexbug_saddle.stl");
