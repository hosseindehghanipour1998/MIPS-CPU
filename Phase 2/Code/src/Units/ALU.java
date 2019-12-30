package Units;

public class ALU {
	
	public static String input1 ;
	public static String input2 ;
	
	
	public static String add(String input1 , String input2) {
		int Input1 = Integer.parseInt(input1 )  ;
		int Input2 = Integer.parseInt(input2 )  ;
		int result = Input1 + Input2 ;
		return Integer.toString(result);
	}
	
	public static String sub(String input1 , String input2) {
		int Input1 = Integer.parseInt(input1  )  ;
		int Input2 = Integer.parseInt(input2  )  ;
		int result = Input1 - Input2 ;
		return Integer.toString(result);
	}
	
	public static String and(String input1 , String input2) {
		int Input1 = Integer.parseInt(input1  )  ;
		int Input2 = Integer.parseInt(input2  )  ;
		int result = Input1 & Input2 ;
		return Integer.toString(result);
	}
	
	public static String or(String input1 , String input2) {
		int Input1 = Integer.parseInt(input1  )  ;
		int Input2 = Integer.parseInt(input2  )  ;
		int result = Input1 | Input2 ;
		return Integer.toString(result);
	}
	
	public static String xor(String input1 , String input2) {
		int Input1 = Integer.parseInt(input1 )  ;
		int Input2 = Integer.parseInt(input2 )  ;
		int result = Input1 ^ Input2 ;
		return Integer.toString(result);
	}
	public static String nor(String input1 , String input2) {
		int Input1 = Integer.parseInt(input1  )  ;
		int Input2 = Integer.parseInt(input2  )  ;
		int result = ~(Input1 | Input2) ;
		return Integer.toString(result);
	}
	
	public static void findOutTheOperation(Instruction i) {
		setTheType(i);
		if(i.getType().equals(InstructionType.R_TYPE)) {
			System.out.println("The Instruction is R_Type");
			String instructionRegister = i.getInstructionRegister() ;
			String funct = instructionRegister.substring(26 , 32) ;
			Integer functAmount  = Integer.parseInt(funct,2);
			switch(functAmount) {
			
				case 32 :
					System.out.println("The operation is : ADD");
					i.setOperation(OperationName.ADD);
					break ;

				case 34 :
					System.out.println("The operation is : SUB");
					i.setOperation(OperationName.SUB);
					break ;
				
				case 37:
					System.out.println("The operation is : OR");
					i.setOperation(OperationName.OR);
					break ;
				
				case 39:
					System.out.println("The operation is : NOR");
					i.setOperation(OperationName.NOR);
					break ;
				
				case 42 :
					System.out.println("The operation is : SLT ");
					i.setOperation(OperationName.SLT);
					break ;
					
				default :
					System.out.println("The Funct Field is not set correctly...");
					break ;
			}
			
		}//end of R_Type
		
		else if(i.getType().equals(InstructionType.I_TYPE)) {
			System.out.println("The Instruction is I_Type");
			String instructionString = i.getInstructionRegister() ;
			String opCode = instructionString.substring(0, 6);
			Integer opCodeAmount  = Integer.parseInt(opCode,2);
			switch(opCodeAmount) {
			
				case 35 :
					System.out.println("The operation is : LW");
					i.setOperation(OperationName.LW);
					break ;
					
				case 43 :
					System.out.println("The operation is : SW");
					i.setOperation(OperationName.SW);
					break ;
				case 4 : 
					// beq
					System.out.println("The operation is : Beq");
					i.setOperation(OperationName.BEQ);
					break ;
				
				case 5:
					System.out.println("The operation is : Bneq");
					i.setOperation(OperationName.BNEQ);
					break ;
					
				default:
					System.out.println("Error in I_Type SwitchCase...");
					break;
			}
		}// End OF I_Type
		else if(i.getType().equals(InstructionType.J_TYPE)) {
			System.out.println("The Instruction is J_Type");
			String instructionString = i.getInstructionRegister() ;
			String opCode = instructionString.substring(0, 6);
			Integer opCodeAmount  = Integer.parseInt(opCode,2);
			switch(opCodeAmount) {
				case 2 :
					System.out.println("the Operation is Jump.");
					i.setOperation(OperationName.JUMP);
					break ;
					
				default :
					System.out.println("Error in J_Type Switch Case");
					break ;
			}
		}// End of J_Type
		
		else {
			i.setOperation(OperationName.NOP);
		}
		
	}
	public static void setTheType(Instruction instruction) {
		
		String instructionString = instruction.getInstructionRegister() ;
		
		String opCode = instructionString.substring(0, 6);
		
		int intOpCode = -1 ;
		try {
			 intOpCode = Integer.parseInt(opCode) ;
		}
		catch(Exception e){
			System.out.println("Unsupported Input");
			instruction.setType(InstructionType.NOP);
		}
		
		for(Instruction i : Instruction.allPredefinedInstructions) {
			if(opCode.equals(i.getOpCode())) {
				instruction.setType(i.getType());
			}
		}
	}
	
	

}
