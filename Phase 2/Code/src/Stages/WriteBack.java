package Stages;

import PipeLine.MEM_WB;
import Units.OperationName;
import Units.RegisterFile;

public class WriteBack {
	
	public static void writeBack() {
		//String muxSignal  = (PipeLine.MEM_WB.i.getOperation() == OperationName.LW ? "0" : "1" );
		
		int muxSignal = MEM_WB.muxSignal ;
		PipeLine.MEM_WB.writeBackData  = ( muxSignal == 0  ? PipeLine.MEM_WB.memoryReadData : PipeLine.MEM_WB.ALUResult);
	
		//Write The register propeerties
		RegisterFile.data = PipeLine.MEM_WB.writeBackData ;
		RegisterFile.Rd =  PipeLine.MEM_WB.destinationRegister ;
		
		int data = Integer.parseInt(RegisterFile.data) ;
		RegisterFile.data = Integer.toString(data);
		
		RegisterFile.registerFile[Integer.parseInt(RegisterFile.Rd)]  = RegisterFile.data ;
		
		System.out.println("The Write Back Result : " + PipeLine.MEM_WB.writeBackData);
		System.out.println("Mux Signal : " + muxSignal);
		System.out.println("So the Value Of Register " + PipeLine.MEM_WB.destinationRegister + " is  " + PipeLine.MEM_WB.writeBackData);
	}
}
