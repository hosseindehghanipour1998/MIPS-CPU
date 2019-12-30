package Stages;

import PipeLine.EX_MEM;
import PipeLine.ID_EX;
import PipeLine.MEM_WB;
import Units.Memory;

public class MemoryStage {
	

	public static String forwardingInput;
	public static void MemoryStageRun() {
	
			
		
		int memoryWriteSignal  = 0;
		int memoryReadSignal = 0 ;
		
		//set write signal
//		if(PipeLine.EX_MEM.writeSignal == 1) {
//			memoryWriteSignal  = "1";
//		}
//		if(PipeLine.EX_MEM.readSignal == 1) {
//			memoryReadSignal = "1";
//		}
		
		//set memory read/write signals
		memoryWriteSignal = EX_MEM.writeSignal ;
		memoryReadSignal = EX_MEM.readSignal ;
		
		// transfer control signals to next level
		MEM_WB.muxSignal = EX_MEM.muxSignal ;
		MEM_WB.registerWrite = EX_MEM.registerWrite ;
		//Memory Inputs
		Units.Memory.address = PipeLine.EX_MEM.ALU_Result ;
		Units.Memory.data = PipeLine.EX_MEM.WriteData ;
		
		//MEM_WB ALU result
		PipeLine.MEM_WB.ALUResult = PipeLine.EX_MEM.ALU_Result ;
		
		// Read from Memory Or Write To It ??
		if(memoryWriteSignal == 1) {
			// write to memory
			if(Integer.parseInt(Memory.address) < Units.Memory.memory.length) {
				Units.Memory.memory[Integer.parseInt(PipeLine.EX_MEM.ALU_Result)] = PipeLine.EX_MEM.WriteData ;
				PipeLine.MEM_WB.memoryReadData = "0" ;
			}
			else {
				System.out.println("Memory Index Out Of range ...");
			}
		}
		else if(memoryWriteSignal == 0 && memoryReadSignal==1) {
			// read from memory or Do nothing
			if(Integer.parseInt(PipeLine.EX_MEM.ALU_Result) < Units.Memory.memory.length) {
				PipeLine.MEM_WB.memoryReadData = Units.Memory.memory[Integer.parseInt(Units.Memory.address)] ;
			}
		}
		
		//register destination
		forwardingInput = PipeLine.MEM_WB.destinationRegister; 
		PipeLine.MEM_WB.destinationRegister = PipeLine.EX_MEM.DestinationRegister ;
		
		
		//Print : 
		System.out.println("The Memory Address : " + Memory.address);
		System.out.println("Write Signal : " + memoryWriteSignal);
		System.out.println("The Operation : " + EX_MEM.i.getOperation());
		System.out.println("Read Signal : " + memoryReadSignal);
		System.out.println("Memory Read Data : " +PipeLine.MEM_WB.memoryReadData );
		System.out.println("MEM_WB Destination Register : " + PipeLine.MEM_WB.destinationRegister );
		System.out.println("MEM_WB ALU Result : " + PipeLine.MEM_WB.ALUResult );
		System.out.println("Memory Input Data : " + Memory.data );
		
		MEM_WB.i = EX_MEM.i ;
		
		}

		

	
	
	

}
