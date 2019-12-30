import java.util.ArrayList;

public class Instruction {
	public static ArrayList<Instruction> allPredefinedInstructions = new ArrayList<>() ;
	private String instructionRegister = "" ;
	private InstructionType type ;
	private String opCode = "" ;
	
	public String getInstructionRegister() {
		return instructionRegister;
	}
	public void setInstructionRegister(String instructionRegister) {
		this.instructionRegister = instructionRegister;
	}
	public InstructionType getType() {
		return type;
	}
	public void setType(InstructionType type) {
		this.type = type;
	}
	
	
	public static ArrayList<Instruction> getAllPredefinedInstructions() {
		return allPredefinedInstructions;
	}
	public static void setAllPredefinedInstructions(ArrayList<Instruction> allPredefinedInstructions) {
		Instruction.allPredefinedInstructions = allPredefinedInstructions;
	}
	public String getOpCode() {
		return opCode;
	}
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}
	public static Instruction preDefinedInstructions(InstructionType type , String OpCode) {
		Instruction temp = new Instruction() ;
		allPredefinedInstructions.add(temp);
		temp.setType(type);
		temp.opCode = OpCode ;
		
		return temp ;
	}

	
	
}
