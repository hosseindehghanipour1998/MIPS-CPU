package Stages;

import PipeLine.EX_MEM;
import PipeLine.ID_EX;
import PipeLine.MEM_WB;
import Units.ALU;
import Units.HazardDetectionUnit;
import Units.InstructionType;
import Units.OperationName;

public class Execute {
	
	
	public static String forwardA , forwardB ;public static int muxSignal ;
	
	public static void execute( ) {
		
		//Detect Hazard :
		try {
			HazardDetectionUnit.detectHazard();
		}
		catch(Exception e) {
			// what can u do ?
			System.out.println("An Error Occured while detecting Hazard");
		}
		
		
		
		// SET The Control Signals
		Execute.forwardA = ID_EX.forwardA ;
		Execute.forwardB = ID_EX.forwardB ;
		
		Execute.muxSignal = ID_EX.mux1Signal ;
		
		// transfer the control signals to next level
		EX_MEM.readSignal = ID_EX.readSignal ;
		EX_MEM.writeSignal = ID_EX.writeSignal ;
		EX_MEM.muxSignal = ID_EX.muxSignal ;
		EX_MEM.registerWrite = ID_EX.registerWrite ;
		

			
		
		//Units.ControlUnit.setControls();
			
		// ALU 1st Input
		if(Execute.forwardA == "00") {
			ALU.input1 = ID_EX.RsAmount ;
		}
		else if( Execute.forwardA == "01") {
			ALU.input1 = MEM_WB.writeBackData ;
		}
		else if( Execute.forwardA == "10") {
			ALU.input1 = EX_MEM.ALU_Result ;
		}
		
		//ALU 2nd Input
		if( Execute.forwardB == "00") {
			ALU.input2 = ID_EX.RtAmount ;
		}
		else if ( Execute.forwardB == "01") {
			ALU.input2 = MEM_WB.writeBackData ;
		}
		else if( Execute.forwardB == "10") {
			ALU.input2 = EX_MEM.ALU_Result ;
		}
		else if( Execute.forwardB == "11") {
			ALU.input2 = ID_EX.Const;
		}
		
		
				

		
		//set destination register
		if(muxSignal == 1) {
			
			EX_MEM.DestinationRegister = ID_EX.instruction.getInstructionRegister().substring(16, 21);
			
		}
		else if (muxSignal == 0) {
			
			EX_MEM.DestinationRegister = ID_EX.instruction.getInstructionRegister().substring(11,16);
		}
		
		
		//destination register to decimal : 
		EX_MEM.DestinationRegister = Integer.toString(Integer.parseInt(EX_MEM.DestinationRegister,2));
		
		
		//prints
		System.out.println("The ALU Operation is : " + ID_EX.instruction.getOperation());
		System.out.print("ALU Input1 : " + ALU.input1 + "\n");
		System.out.print("ALU Input2 : " + ALU.input2 + "\n");
		
		
		//ALU Operation
		ALU.findOutTheOperation(ID_EX.instruction);
		if	   (ID_EX.instruction.getOperation() == OperationName.ADD || 
				ID_EX.instruction.getOperation() == OperationName.LW ||
				ID_EX.instruction.getOperation() == OperationName.SW) {
			EX_MEM.ALU_Result = ALU.add(ALU.input1, ALU.input2);
		}
		else if(ID_EX.instruction.getOperation() == OperationName.SUB) {
			EX_MEM.ALU_Result = ALU.sub(ALU.input1, ALU.input2);
		}
		else if(ID_EX.instruction.getOperation() == OperationName.OR) {
			EX_MEM.ALU_Result = ALU.or(ALU.input1, ALU.input2);
		}
		else if(ID_EX.instruction.getOperation() == OperationName.NOR) {
			EX_MEM.ALU_Result = ALU.nor(ALU.input1, ALU.input2);
		}
		else if(ID_EX.instruction.getOperation() == OperationName.AND) {
			EX_MEM.ALU_Result = ALU.and(ALU.input1, ALU.input2);
		}
		else if(ID_EX.instruction.getOperation() == OperationName.XOR) {
			EX_MEM.ALU_Result = ALU.xor(ALU.input1, ALU.input2);
		}
		else if(ID_EX.instruction.getOperation() == OperationName.SLT) {
			if(ID_EX.RsAmount .equals(ID_EX.RtAmount)) {
				EX_MEM.ALU_Result = Integer.toString(1) ;
				System.out.println("\n$$$They are equal$$$\n");
			}
			else {
				EX_MEM.ALU_Result = Integer.toString(0) ;
			}
		}
		

		
		// PC Address Calculation for jump operations
		int pcExtra = Integer.parseInt(ID_EX.Const);
		EX_MEM.pc = ID_EX.pc + pcExtra ;
		
		// write Data
		EX_MEM.WriteData = ID_EX.RtAmount ;//decimal		

		// Print : 

		System.out.print("Forward A - B : " + Execute.forwardA + "-" + Execute.forwardB + "\n");
		System.out.print("MUX Signal : " + muxSignal + "\n" );
		System.out.print("EX/MEM destination Register : " + EX_MEM.DestinationRegister + "\n");
		System.out.print("EX/MEM Write Data : " + EX_MEM.WriteData + "\n");
		System.out.print("ALU Result : " + EX_MEM.ALU_Result  + "\n");
		System.out.println("The PC Amount : " + EX_MEM.pc);
		
		
		//Memory Read/Write Signal
//		EX_MEM.writeSignal = ID_EX.writeSignal ;
//		EX_MEM.readSignal = ID_EX.readSignal ;
		EX_MEM.i = ID_EX.instruction ;
		//write Signal :

		}


		
	

}
