package Run;

import java.util.Arrays;

import PipeLine.EX_MEM;
import PipeLine.ID_EX;
import PipeLine.IF_ID;
import PipeLine.MEM_WB;
import Units.ALU;
import Units.Instruction;
import Units.InstructionMemory;
import Units.Memory;
import Units.RegisterFile;
import Units.Utility;

public class Functions {
	
	public static void fetch(int i) {
		// Fetch
		System.out.println("\n");
		System.out.println("\nStage : FETCH");
		try{
			Stages.Fetch.fetch(i);
			Instruction tempI = InstructionMemory.instructionFile.get(i);
			ALU.findOutTheOperation(tempI);
			System.out.print("Fetched Instruction is : " + tempI.getOperation() + "\n");
			System.out.print("IF/ID PC Amount : " + IF_ID.pc + "\n");
		}
		catch(Exception e) {
			System.out.println("########## No Instruction to fetch ##########");
		}

	}
	
	public static int decode() {
		//Decode
		System.out.println("\n");
		System.out.println("Stage : DECODE ");
		try {
			int returnAmount =  Stages.Decode.decode();
			System.out.println("The return amount is  :  " + returnAmount);
			return returnAmount ;
		}
		
		catch(Exception e) {
			System.out.println("########## The Operation Cant be done due to null pointer Exception ##########");
			return -1 ;
		}
		

	}

	public static void execute() {
		
		//Execute :
		System.out.println("\n");
		System.out.println("Stage : EXECUTE ");

		try {
			Stages.Execute.execute();
		}
		
		catch(Exception e) {
			System.out.println("########## The Operation Cant be done due to null pointer Exception ##########");
		}

		
	}
	
	public static void memoryStage() {
		//Memory Stage :
		System.out.println("\n");
		System.out.println("Stage : MEMORY ");
		try {
			Stages.MemoryStage.MemoryStageRun();
		}
		
		catch(Exception e) {
			System.out.println("########## The Operation Cant be done due to null pointer Exception ##########");
		}
		
	}
	
	public static void writeBack() {
		
		//WriteBack Stage
		System.out.println("\n");
		System.out.println("Stage : WRITE_BACK");
		try {
			Stages.WriteBack.writeBack();
		}
		
		catch(Exception e) {
			System.out.println("########## The Operation Cant be done due to null pointer Exception ##########");
		}
		
	}
	
	public static void print() {
		System.out.print("\n\n\nReg :");
		Utility.printArray(RegisterFile.registerFile);
		System.out.print("\nRAM : ");
		//System.out.println(Arrays.toString(Memory.memory));
		Utility.printArray(Memory.memory);
	}
	
	public static void initialize() {
		
		Units.ALU.input1 = Units.ALU.input2 = "0";
		IF_ID.pc = 0 ;
		ID_EX.pc = 0;ID_EX.RdAmount="0" ;ID_EX.RsAmount="0";ID_EX.RtAmount="0";ID_EX.Const="0" ;
		EX_MEM.pc = 0;EX_MEM.DestinationRegister = EX_MEM.ALU_Result  = EX_MEM.WriteData = "0" ; 
		MEM_WB.memoryReadData = MEM_WB.destinationRegister = MEM_WB.ALUResult = MEM_WB.writeBackData = "0";
		
	}
}
