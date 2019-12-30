package Units;

public class HazardDetectionUnit {
	
	public static boolean isHazardDetected = false ;
	public void detectHazard() {
		
		
		
		
	}
	
	public static void throwHazard() {
		HazardDetectionUnit.isHazardDetected = true ;
		System.out.println("Warning Hazard Detected ... ");
		HazardDetectionUnit.isHazardDetected = false ;
	}

}
