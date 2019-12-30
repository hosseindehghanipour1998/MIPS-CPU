package Units;

public class Memory {
	public static String[] memory = new String[128] ; 
	public static int writeSignal ;
	public static String address ;
	public static String data ;
	
	public Memory() {
		for(int i = 0 ; i < memory.length ; i++) {
			memory[i] = "0" ;
		}
	}
	
	static {
		
		for(int i = 0 ; i < memory.length ; i++) {
			memory[i] = "0" ;
		}
	}
}
