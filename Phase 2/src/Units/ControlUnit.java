package Units;

import PipeLine.EX_MEM;
import PipeLine.ID_EX;
import PipeLine.IF_ID;

public class ControlUnit {
	
	public static void setControls() throws NullPointerException{
		try {
			
		
			/****************************
			 * ID_EX  ( EX_Controls )
			 ****************************/
		if( IF_ID.instruction.getType() == InstructionType.R_TYPE) {
//			 Stages.Execute.forwardA = "00"  ;
//			 Stages.Execute.forwardB = "00" ;
			ID_EX.forwardA = "00" ;
			ID_EX.forwardB = "00" ;
		}
		
		else {
//			Stages.Execute.forwardA = "00" ;
//			Stages.Execute.forwardB = "11" ;
			ID_EX.forwardA = "00" ;
			ID_EX.forwardB = "11" ;
		}
		
		 
		if(IF_ID.instruction.getType() == InstructionType.R_TYPE) {ID_EX.mux1Signal = 1 ; }
		else if(IF_ID.instruction.getOperation() == OperationName.LW) { ID_EX.mux1Signal = 0 ;}
		else {
			// don't care 
			ID_EX.mux1Signal = 0 ;
		}
		
		
		
		/*// ************************
		 * Memory Read/Write Signal
		 	***************************/		
		if(IF_ID.instruction.getOperation() == OperationName.SW) {
			ID_EX.writeSignal = 1 ;
			ID_EX.readSignal = 0 ;
		}
		else if(IF_ID.instruction.getOperation() == OperationName.LW) {
			ID_EX.readSignal = 1 ;
			ID_EX.writeSignal = 0 ;
		}
		
		else {
			ID_EX.readSignal = 0 ;
			ID_EX.writeSignal = 0 ;
		}
		
		/*
		 *WB Control Signals 
		 * */
		
		if(IF_ID.instruction.getOperation() == OperationName.LW) {
			ID_EX.muxSignal = 0 ;
		}
		else {
			ID_EX.muxSignal = 1 ;
		}
		
		if(IF_ID.instruction.getOperation() == OperationName.LW || IF_ID.instruction.getType() == InstructionType.R_TYPE) {
			ID_EX.registerWrite = 1 ;
		}
		
		}
		
		
		
		catch(Exception e) {
			
		}
		
	}
	
	
	
	
	

	

}
