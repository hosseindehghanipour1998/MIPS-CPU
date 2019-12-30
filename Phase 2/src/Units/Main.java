package Units;
import Units.Utility;

import java.io.IOException;
import java.util.ArrayList;

import PipeLine.IF_ID;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		// Initialize the Instructions Available
		Instruction   sll  = Instruction.preDefinedInstructions(InstructionType.R_TYPE , "000000") ;
		Instruction   add  = Instruction.preDefinedInstructions(InstructionType.R_TYPE , "000000") ;
		Instruction   addu = Instruction.preDefinedInstructions(InstructionType.R_TYPE , "000000") ;
		Instruction   sub  = Instruction.preDefinedInstructions(InstructionType.R_TYPE , "000000") ;
		Instruction   subu = Instruction.preDefinedInstructions(InstructionType.R_TYPE , "000000") ;
		Instruction   and  = Instruction.preDefinedInstructions(InstructionType.R_TYPE , "000000") ;
		Instruction   or   = Instruction.preDefinedInstructions(InstructionType.R_TYPE , "000000") ;
		Instruction   nor  = Instruction.preDefinedInstructions(InstructionType.R_TYPE , "000000") ;
		Instruction   slt  = Instruction.preDefinedInstructions(InstructionType.R_TYPE , "000000") ;
		Instruction   sltu = Instruction.preDefinedInstructions(InstructionType.R_TYPE , "000000") ;
		              
		              
		Instruction  j    =  Instruction.preDefinedInstructions(InstructionType.J_TYPE, "000010");
		Instruction  jal  =  Instruction.preDefinedInstructions(InstructionType.J_TYPE, "000011");
		
		
		Instruction  beq   = Instruction.preDefinedInstructions(InstructionType.I_TYPE, "000100");
		Instruction  bne   = Instruction.preDefinedInstructions(InstructionType.I_TYPE, "000101");
		Instruction  addi  = Instruction.preDefinedInstructions(InstructionType.I_TYPE, "001000");
		Instruction  addiu = Instruction.preDefinedInstructions(InstructionType.I_TYPE, "001001");
		Instruction  andi  = Instruction.preDefinedInstructions(InstructionType.I_TYPE, "001100");
		Instruction  ori   = Instruction.preDefinedInstructions(InstructionType.I_TYPE, "001101");
		Instruction  lui   = Instruction.preDefinedInstructions(InstructionType.I_TYPE, "001111");
		Instruction  lw    = Instruction.preDefinedInstructions(InstructionType.I_TYPE, "100011");
		Instruction  sw    = Instruction.preDefinedInstructions(InstructionType.I_TYPE, "101011");
		
	
		ArrayList <String> inputStringStreamInstructions = new  ArrayList<>();
		ArrayList <String> inputStringStreamDataFile = new  ArrayList<>();
		ArrayList <String> inputStringStreamRegFile = new  ArrayList<>();
		
		
		
		System.out.println("Reading the files...");
		
		// IO
		String instructionsAddress = "H:\\Codes\\New Java Codes 15June\\MIPS PipeLine Project\\testCase3.txt" ;
		String dataAddress = "H:\\Codes\\New Java Codes 15June\\MIPS PipeLine Project\\dataFile3.txt" ;
		String registerFileAddress = "H:\\Codes\\New Java Codes 15June\\MIPS PipeLine Project\\registerFile3.txt" ;
		Utility.readFile(instructionsAddress,inputStringStreamInstructions);
		Utility.readFile(dataAddress, inputStringStreamDataFile);
		Utility.readFile(registerFileAddress, inputStringStreamRegFile);
		System.out.println("File Reading is Completed ...");
		
		// fill the instruction register
		for(String s : inputStringStreamInstructions) {
			Instruction i = new  Instruction() ;
			i.setInstructionRegister(s);
			InstructionMemory.instructionFile.add(i);
		}
		for(Instruction i : InstructionMemory.instructionFile)
		System.out.println("All Instructions are  : " + i.getInstructionRegister() );
		
		// fill the Memory
		for(int i = 1 ; i <  Memory.memory.length && i <inputStringStreamDataFile.size()  ; i++) {
			Memory.memory[i] = inputStringStreamDataFile.get(i-1) ;
			
		}
		
		//fill the register file
		for(int i = 1 ; i <  RegisterFile.registerFile.length  && i <inputStringStreamRegFile.size(); i++) {
			RegisterFile.registerFile[i] = inputStringStreamRegFile.get(i-1) ;
			// for register file we start at index 1 due to Register $Zero
		}
		
		System.out.print("Reg :");
		Utility.printArray(RegisterFile.registerFile);
		System.out.print("\nRAM : ");
		Utility.printArray(Memory.memory);
		int pc = 0 ;
		// Run
		//Run.Functions.initialize();
		int clockNumber = InstructionMemory.instructionFile.size() + 4 ;
		for(int i = 0 ; i < clockNumber  ; i++ , pc++) {
			
			System.out.print("\nInstruction :  ("  + (i+1) + ")\n");
			
//			// Fetch
//			System.out.println("\n");
//			System.out.println("\nStage : FETCH");
//			Stages.Fetch.fetch(i);
//			Instruction tempI = InstructionMemory.instructionFile.get(i);
//			ALU.findOutTheOperation(tempI);
//			System.out.print("Fetched Instruction is : " + tempI.getOperation() + "\n");
//			System.out.print("IF/ID PC Amount : " + IF_ID.pc + "\n");
			
			
//			//Decode
//			System.out.println("\n");
//			System.out.println("Stage : DECODE ");
//			Stages.Decode.decode();
			
			
//			
//			//Execute :
//			System.out.println("\n");
//			System.out.println("Stage : EXECUTE ");
//			Stages.Execute.execute();
//			
//			//Memory Stage :
//			System.out.println("\n");
//			System.out.println("Stage : MEMORY ");
//			Stages.MemoryStage.MemoryStageRun();
			
//			
//			//WriteBack Stage
//			System.out.println("\n");
//			System.out.println("Stage : WRITE_BACK");
//			Stages.WriteBack.writeBack();
			
//			System.out.print("\n\n\nReg :");
//			Utility.printArray(RegisterFile.registerFile);
//			System.out.print("\nRAM : ");
//			Utility.printArray(Memory.memory);
			
			
		
	Run.Functions.writeBack();
	Run.Functions.memoryStage();
	Run.Functions.execute();
	Run.Functions.decode();
	//if(pc < Units.InstructionMemory.instructionFile.size())
		Run.Functions.fetch(pc);
	Run.Functions.print();
	
			

			
			
			System.out.println("\n**********************************************************************");
		}
	
	}
}
