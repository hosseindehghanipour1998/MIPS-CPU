package PipeLine;

import Units.Instruction;

public class EX_MEM {
	
	public static String ALU_Result ;
	public static String WriteData ;
	public static String DestinationRegister ;
	public static int pc ;

	
	
	
	// control signals :
	
	
	//mem
	public static int writeSignal ;
	public static int readSignal ;
	
	//WB
	public static int muxSignal ;
	public static int registerWrite ;
	//extra 
	public static Instruction i ;
}
