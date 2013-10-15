use <../../../Education/Programming the Physical World/PanTiltMechanism/CameraMount.scad>
use <../../../Education/Programming the Physical World/PanTiltMechanism/TiltRingHolder.scad>
use <../../../Education/Programming the Physical World/PanTiltMechanism/PanRingHolder.scad>
use <EclipseAnalog.scad>

panRingHolder();
rotate([0,0,22])
	tiltRing();
translate([getPanRingRadius()+5,0,0])
	rotate([0,0,90])
		cameraTiltBar();


translate([0,20,0]){
	customStick();
}	

translate([0,-20,0]){
	customStick();
}	


translate([0,80,0]){
	customStick();
}	


translate([0,-80,0]){
	customStick();
}	





#cube([200,200,200],center=true);