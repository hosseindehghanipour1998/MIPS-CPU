package Stages;

import java.util.ResourceBundle.Control;

import PipeLine.ID_EX;
import PipeLine.IF_ID;
import Units.RegisterFile;

public class Decode {
	
	public static void decode() {
		
		Units.ControlUnit.setControls();	
		
		// write RS RT RD
		ID_EX.instruction = IF_ID.instruction ;
		RegisterFile.Rs = IF_ID.instruction.getInstructionRegister().substring(6, 11);
		RegisterFile.Rt = IF_ID.instruction.getInstructionRegister().substring(11, 16);
		RegisterFile.Rd = IF_ID.instruction.getInstructionRegister().substring(16, 21);
		
		
		RegisterFile.Rs = Integer.toString(Integer.parseInt(RegisterFile.Rs,2));
		RegisterFile.Rt = Integer.toString(Integer.parseInt(RegisterFile.Rt,2));
		RegisterFile.Rd = Integer.toString(Integer.parseInt(RegisterFile.Rd,2));
		
		
		System.out.println("The Instruction : " + ID_EX.instruction.getInstructionRegister());
		System.out.print("The RegisterFile RS : " + RegisterFile.Rs  + "\n");
		System.out.print("The RegisterFile RT : " + RegisterFile.Rt  + "\n");
		System.out.print("The RegisterFile RD : " + RegisterFile.Rd  + "\n");
		
		//if it didn't want to write the data
		if(RegisterFile.writeControl == 0) {
			
			int RsIndex = Integer.parseInt(RegisterFile.Rs );
			int RtIndex = Integer.parseInt(RegisterFile.Rt );
			int RdIndex = Integer.parseInt(RegisterFile.Rd );
			
			ID_EX.RsAmount = RegisterFile.registerFile[RsIndex] ;
			ID_EX.RtAmount = RegisterFile.registerFile[RtIndex] ;
			ID_EX.RdAmount = RegisterFile.registerFile[RdIndex] ;
			
			
			
			System.out.println("The ID_EX RS  Amount : " + ID_EX.RsAmount );
			System.out.println("The ID_EX Rt  Amount : " + ID_EX.RtAmount );
			System.out.println("The ID_EX Rd  Amount : " + ID_EX.RdAmount );
			
			ID_EX.Const = RegisterFile.Rd = IF_ID.instruction.getInstructionRegister().substring( 16 , 32);
			ID_EX.Const = Integer.toString(Integer.parseInt(ID_EX.Const ,2 )) ;
		}
		
		System.out.println("The Constant : " + ID_EX.Const);
//		else if(RegisterFile.writeControl == 1) {
//			
//			int RdIndex = Integer.parseInt(RegisterFile.Rd , 2);
//			RegisterFile.registerFile[RdIndex] = RegisterFile.data ; 
//		}
	}

	

}
