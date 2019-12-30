package PipeLine;

import Units.Instruction;

public class MEM_WB {
	
	public static String memoryReadData ;
	public static String ALUResult ;
	public static String destinationRegister ;
	public static String writeBackData ;
	
	
	//Control Signals :
	//wb
	public static int muxSignal ;
	
	//extra
	public static Instruction i ;
}
