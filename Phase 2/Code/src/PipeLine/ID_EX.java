package PipeLine;
import Units.*;
public class ID_EX {
	
	public static int pc ;
	public static String RsAmount; 
	public static String RtAmount ;
	public static String RdAmount ;
	public static String Const ;
	public static Instruction instruction ;
	
	//signal Controls : 
	
	//MEM
	public static int readSignal , writeSignal ; 
	
	//EX
	public static String forwardA , forwardB ;
	public static int mux1Signal ;
	
	
	// WB
	public static int muxSignal ;
	public static int registerWrite ;
}
