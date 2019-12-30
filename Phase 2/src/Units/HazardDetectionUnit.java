package Units;

import PipeLine.EX_MEM;
import PipeLine.ID_EX;
import PipeLine.MEM_WB;
import Stages.MemoryStage;

public class HazardDetectionUnit {
	
	public static boolean isHazardDetected = false ;
	public static void detectHazard() {
		System.out.println("@Cehcking for hazards ....");
		String ID_EXRegisterRs = RegisterFile.Rs ;
		String ID_EXRegisterRt = RegisterFile.Rt ;
		// this function should be called in execution stage.
		
		
//		if(MEM_WB.i.getType() == InstructionType.R_TYPE || MEM_WB.i.getOperation() == OperationName.LW) {
//			registersWriteControl = 1 ;
//		}
		
		//EX hazard
		int registersWriteControl = EX_MEM.registerWrite ;
		if( registersWriteControl == 1 && !EX_MEM.DestinationRegister.equals("0")  && EX_MEM.DestinationRegister.equals(ID_EXRegisterRs) ) {
			throwHazard("Data Hazard.");
			ID_EX.forwardA = "10" ;	
		}
		
		 if( registersWriteControl == 1 && !EX_MEM.DestinationRegister.equals("0")  && EX_MEM.DestinationRegister.equals(ID_EXRegisterRt) ) {
			throwHazard("Data Hazard.");
			ID_EX.forwardB = "10" ;	
		}
		
		 registersWriteControl = MEM_WB.registerWrite; 
		//MEM hazard
		if(registersWriteControl == 1 && !MemoryStage.forwardingInput.equals("0") && MemoryStage.forwardingInput.equals(ID_EXRegisterRs)) {
			throwHazard("MEM Hazard");
			ID_EX.forwardA = "01" ;	
		}
		 if( registersWriteControl == 1 && !MemoryStage.forwardingInput.equals("0")  && MemoryStage.forwardingInput.equals(ID_EXRegisterRt) ) {
			throwHazard("MEM Hazard");
			ID_EX.forwardB = "01" ;	
		}
		
		
		System.out.println("@Hazard Detection is done...");
	}
	
	public static void throwHazard(String hazardType) {
		HazardDetectionUnit.isHazardDetected = true ;
		System.out.println("Warning Hazard Detected ... :" + hazardType);
		HazardDetectionUnit.isHazardDetected = false ;
	}

}
