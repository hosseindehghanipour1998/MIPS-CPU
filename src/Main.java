import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException{
		// Initialize Some Instructions : 
		
		 
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

		// IO
		Utility.readFile("TestCase",inputStringStreamInstructions);
		Utility.readFile("dataFile", inputStringStreamDataFile);
		Utility.readFile("registerFile", inputStringStreamRegFile);
		
		
		for(String s : inputStringStreamInstructions) {
			Instruction i = new Instruction() ;
			i.setInstructionRegister(s);
			Storages.instructionFile.add(i);
		}
		
		for(int i = 1 ; i <  Storages.dataFile.length && i <inputStringStreamDataFile.size()  ; i++) {
			Storages.dataFile[i] = Integer.parseInt(inputStringStreamDataFile.get(i-1)) ;
			
		}
		
		for(int i = 1 ; i <  Storages.registerFile.length  && i <inputStringStreamRegFile.size(); i++) {
			Storages.registerFile[i] = Integer.parseInt(inputStringStreamRegFile.get(i-1)) ;
			// for register file we start at index 1 due to Register $Zero
		}
		
		
		
		
		
		//Test : 
		/*
		Utility.printArrayList(inputStringStreamInstructions);
		
		System.out.println("--------------");
		Utility.printArrayList(inputStringStreamDataFile);
		System.out.println("--------------");
		Utility.printArrayList(inputStringStreamRegFile);
		System.out.println("--------------");
		Utility.printArray(Storages.dataFile);
		System.out.println("--------------");
		Utility.printArray(Storages.registerFile);
		System.out.println("--------------");
		Utility.printArrayList(Storages.instructionFile);
		System.out.println("--------------");

		
		*/
		// Process
		
		// 1 - set the Types : 
		for(Instruction i : Storages.instructionFile) {
			Utility.setTheType(i);
		}
		
		// 2 - Determine the Process :
		for(int counter = 0 ; counter < Storages.instructionFile.size() ; counter++ ) {
			Instruction i = Storages.instructionFile.get(counter) ;
			System.out.print("Reg :");
			Utility.printArray(Storages.registerFile);
			System.out.print("\nRAM : ");
			Utility.printArray(Storages.dataFile);
			if(i.getType().equals(InstructionType.R_TYPE)) {
				System.out.println("The Instruction is R_Type");
				String instructionRegister = i.getInstructionRegister() ;
				String funct = instructionRegister.substring(26 , 32) ;
				Integer functAmount  = Integer.parseInt(funct,2);
				switch(functAmount) {
				
					case 32 :
						FunctionsAndMethods.add(i);
						System.out.println("The operation is : ADD");
						break ;

					case 34 :
						FunctionsAndMethods.sub(i);
						System.out.println("The operation is : SUB");
						break ;
					
					case 37:
						FunctionsAndMethods.or(i);
						System.out.println("The operation is : OR");
						break ;
					
					case 39:
						FunctionsAndMethods.nor(i);
						System.out.println("The operation is : NOR");
						break ;
					
					case 42 :
						FunctionsAndMethods.slt(i);
						System.out.println("The operation is : SLT ");
						break ;
						
					default :
						System.out.println("The Funct Field is not set correctly...");
						break ;
				}
			}// End of R_Type Condition
			
			else if(i.getType().equals(InstructionType.I_TYPE)) {
				System.out.println("The Instruction is I_Type");
				String instructionString = i.getInstructionRegister() ;
				String opCode = instructionString.substring(0, 6);
				Integer opCodeAmount  = Integer.parseInt(opCode,2);
				switch(opCodeAmount) {
				
					case 35 :
						FunctionsAndMethods.lw(i);
						System.out.println("The operation is : LW");
						break ;
						
					case 43 :
						FunctionsAndMethods.sw(i);
						System.out.println("The operation is : SW");
						break ;
					case 4 : 
						// beq
						counter = FunctionsAndMethods.beq(i , counter) ;
						break ;
					
					case 5:
						//bne
						counter = FunctionsAndMethods.bne(i , counter) ;
						break ;
						
					default:
						System.out.println("Error in I_Type SwitchCase...");
						break;
				}
			}// End of I_Type Condition
			
			else if(i.getType().equals(InstructionType.J_TYPE)) {
				System.out.println("The Instruction is J_Type");
				String instructionString = i.getInstructionRegister() ;
				String opCode = instructionString.substring(0, 6);
				Integer opCodeAmount  = Integer.parseInt(opCode,2);
				switch(opCodeAmount) {
					case 2 :
						counter = FunctionsAndMethods.j(i);
						System.out.println("the Operation is Jump.");
						counter -- ;
						break ;
						
					default :
						System.out.println("Error in J_Type Switch Case");
						break ;
				}
			}
			System.out.println("****************");
			
			
		}// END OF FIRST LOOP
		System.out.println("########### The Final ##########");
		System.out.print("Reg :");
		Utility.printArray(Storages.registerFile);
		System.out.print("\nRAM : ");
		Utility.printArray(Storages.dataFile);
		
		Utility.writeFile(Storages.registerFile, "Storages.registerFileResult.txt");
		Utility.writeFile(Storages.dataFile, "Storages.DataStorageResult.txt");



	}

}
