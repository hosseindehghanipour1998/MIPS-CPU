package Stages;
import PipeLine.IF_ID;
import Units.* ;
public class Fetch {
	
	public static void fetch(int instructionIndex) {
		
		Instruction newInstruction = InstructionMemory.instructionFile.get(instructionIndex) ;
		IF_ID.instruction = newInstruction ;
		IF_ID.pc = instructionIndex + 1;
	}

}
