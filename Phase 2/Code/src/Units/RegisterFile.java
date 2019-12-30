package Units;

public class RegisterFile {
	
	public static String[] registerFile = new String[32] ;
	
	public static String Rs ;
	public static String Rt ;
	public static String Rd ;
	public static String data ;
	
	public static int writeControl ;
	
	
	static {
		
		for(int i = 0 ; i < registerFile.length ; i++) {
			registerFile[i] = "0" ;
		}
	}
	

}
