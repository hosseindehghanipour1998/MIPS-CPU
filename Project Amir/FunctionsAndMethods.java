
public class FunctionsAndMethods {
	
	// The R_Types :
	
	public static void add(Instruction instruction) {
		
		String instructionRegister = instruction.getInstructionRegister() ;
		
		String rs , rt , rd , shamt , funct;
		
		rs = instructionRegister.substring(6 , 11) ;
		rt = instructionRegister.substring(11 , 16) ;
		rd = instructionRegister.substring(16 , 21) ;
		shamt = instructionRegister.substring(21 , 26) ;
		funct = instructionRegister.substring(26 , 32) ;
		
		Integer RsAddress  = Integer.parseInt(rs,2); 
		Integer RtAddress  = Integer.parseInt(rt,2); 
		Integer RdAddress  = Integer.parseInt(rd,2); 
		Integer ShamtAmoiunt  = Integer.parseInt(shamt,2); 
		Integer FunctAmount  = Integer.parseInt(funct,2); 
		
		int summation = Storages.registerFile[RsAddress] + Storages.registerFile[RtAddress] ;
		Storages.registerFile[RdAddress] = summation  ;

		//Test Part : 
		/*
		System.out.println("rs : " + rs);
		System.out.println("rt : " + rt);
		System.out.println("rd : " + rd);
		System.out.println("shamt : " + shamt);
		System.out.println("func : " + funct);
		System.out.println("Summation : " + summation);
		for(Integer i : Storages.registerFile) {
			System.out.print("|" + i + "|");
		}
		*/
	}
	
	
	public static void sub(Instruction instruction) {
		String instructionRegister = instruction.getInstructionRegister() ;
		
		String rs , rt , rd , shamt , funct;
		
		rs = instructionRegister.substring(6 , 11) ;
		rt = instructionRegister.substring(11 , 16) ;
		rd = instructionRegister.substring(16 , 21) ;
		shamt = instructionRegister.substring(21 , 26) ;
		funct = instructionRegister.substring(26 , 32) ;
		
		Integer RsAddress  = Integer.parseInt(rs,2); 
		Integer RtAddress  = Integer.parseInt(rt,2); 
		Integer RdAddress  = Integer.parseInt(rd,2); 
		Integer ShamtAddress  = Integer.parseInt(shamt,2); 
		Integer FunctAddress  = Integer.parseInt(funct,2); 
		
		int subtraction = Storages.registerFile[RsAddress] - Storages.registerFile[RtAddress] ;
		Storages.registerFile[RdAddress] = subtraction  ;

		//Test Part : 
		/*
		System.out.println("rs : " + rs);
		System.out.println("rt : " + rt);
		System.out.println("rd : " + rd);
		System.out.println("shamt : " + shamt);
		System.out.println("func : " + funct);
		System.out.println("subtraction : " + summation);
		for(Integer i : Storages.registerFile) {
			System.out.print("|" + i + "|");
		}
		*/
	}
	
	
	public static void or(Instruction instruction) {
		
		String instructionRegister = instruction.getInstructionRegister() ;
		
		String rs , rt , rd , shamt , funct;
		
		rs = instructionRegister.substring(6 , 11) ;
		rt = instructionRegister.substring(11 , 16) ;
		rd = instructionRegister.substring(16 , 21) ;
		shamt = instructionRegister.substring(21 , 26) ;
		funct = instructionRegister.substring(26 , 32) ;
		
		Integer RsAddress  = Integer.parseInt(rs,2); 
		Integer RtAddress  = Integer.parseInt(rt,2); 
		Integer RdAddress  = Integer.parseInt(rd,2); 
		Integer ShamtAddress  = Integer.parseInt(shamt,2); 
		Integer FunctAddress  = Integer.parseInt(funct,2); 

		int rtInt = Storages.registerFile[RtAddress] ;
		int rsInt = Storages.registerFile[RsAddress] ;
		int rdInt = rsInt | rtInt ;
		
		Storages.registerFile[RdAddress] = rdInt ;
	}

	public static void xor(Instruction instruction) {
		String instructionRegister = instruction.getInstructionRegister() ;
		
		String rs , rt , rd , shamt , funct;
		
		rs = instructionRegister.substring(6 , 11) ;
		rt = instructionRegister.substring(11 , 16) ;
		rd = instructionRegister.substring(16 , 21) ;
		shamt = instructionRegister.substring(21 , 26) ;
		funct = instructionRegister.substring(26 , 32) ;
		
		Integer RsAddress  = Integer.parseInt(rs,2); 
		Integer RtAddress  = Integer.parseInt(rt,2); 
		Integer RdAddress  = Integer.parseInt(rd,2); 
		Integer ShamtAddress  = Integer.parseInt(shamt,2); 
		Integer FunctAddress  = Integer.parseInt(funct,2); 

		int rtInt = Storages.registerFile[RtAddress] ;
		int rsInt = Storages.registerFile[RsAddress] ;
		int rdInt = rsInt ^ rtInt ;
		
		Storages.registerFile[RdAddress] = rdInt ;
	}
	
	public static void nor(Instruction instruction) {

		String instructionRegister = instruction.getInstructionRegister() ;
		
		String rs , rt , rd , shamt , funct;
		
		rs = instructionRegister.substring(6 , 11) ;
		rt = instructionRegister.substring(11 , 16) ;
		rd = instructionRegister.substring(16 , 21) ;
		shamt = instructionRegister.substring(21 , 26) ;
		funct = instructionRegister.substring(26 , 32) ;
		
		Integer RsAddress  = Integer.parseInt(rs,2); 
		Integer RtAddress  = Integer.parseInt(rt,2); 
		Integer RdAddress  = Integer.parseInt(rd,2); 
		Integer ShamtAddress  = Integer.parseInt(shamt,2); 
		Integer FunctAddress  = Integer.parseInt(funct,2); 

		int rtInt = Storages.registerFile[RtAddress] ;
		int rsInt = Storages.registerFile[RsAddress] ;
		int rdInt = ~( rsInt | rtInt );
		
		Storages.registerFile[RdAddress] = rdInt ;
	}

	
	public static void slt(Instruction instruction) {

		String instructionRegister = instruction.getInstructionRegister() ;
		
		String rs , rt , rd , shamt , funct;
		
		rs = instructionRegister.substring(6 , 11) ;
		rt = instructionRegister.substring(11 , 16) ;
		rd = instructionRegister.substring(16 , 21) ;
		shamt = instructionRegister.substring(21 , 26) ;
		funct = instructionRegister.substring(26 , 32) ;
		
		Integer RsAddress  = Integer.parseInt(rs,2); 
		Integer RtAddress  = Integer.parseInt(rt,2); 
		Integer RdAddress  = Integer.parseInt(rd,2); 
		Integer ShamtAddress  = Integer.parseInt(shamt,2); 
		Integer FunctAddress  = Integer.parseInt(funct,2); 

		int rtInt = Storages.registerFile[RtAddress] ;
		int rsInt = Storages.registerFile[RsAddress] ;
		int rdInt = 0 ;
		
		if(rsInt < rtInt) {
			rdInt = 1 ;
		}
		
		Storages.registerFile[RdAddress] = rdInt ;
		
	}


	// The I_types :
	
	public static int beq(Instruction instruction , int currentInstructionIndex) {
		String instructionRegister = instruction.getInstructionRegister() ;
		
		String rs , rt  , constantOrAddress;
		
		rs = instructionRegister.substring(6 , 11) ;
		rt = instructionRegister.substring(11 , 16) ;
		constantOrAddress = instructionRegister.substring(16 , 32) ;
		
		int rsAddress , rtAddress , constantAmount ;
		
		rsAddress = Integer.parseInt(rs, 2) ;
		rtAddress = Integer.parseInt(rt, 2) ;
		constantAmount = Integer.parseInt(constantOrAddress, 2) ;
		
		
		if(Storages.dataFile[rsAddress] == Storages.dataFile[rtAddress] ) {
			return constantAmount ;
		}
		return currentInstructionIndex ;
		
		
	}
	
	public static int bne(Instruction instruction , int currentInstructionIndex) {
		String instructionRegister = instruction.getInstructionRegister() ;
		
		String rs , rt  , constantOrAddress;
		
		rs = instructionRegister.substring(6 , 11) ;
		rt = instructionRegister.substring(11 , 16) ;
		constantOrAddress = instructionRegister.substring(16 , 32) ;
		
		int rsAddress , rtAddress , constantAmount ;
		
		rsAddress = Integer.parseInt(rs, 2) ;
		rtAddress = Integer.parseInt(rt, 2) ;
		constantAmount = Integer.parseInt(constantOrAddress, 2) ;
		
		
		if(Storages.dataFile[rsAddress] != Storages.dataFile[rtAddress] ) {
			return constantAmount ;
		}
		return currentInstructionIndex ;
		
		
	}
	
	
	public static void sw(Instruction instruction) {
		

		String instructionRegister = instruction.getInstructionRegister() ;
		
		String rs , rt  , constantOrAddress;
		
		rs = instructionRegister.substring(6 , 11) ;
		rt = instructionRegister.substring(11 , 16) ;
		constantOrAddress = instructionRegister.substring(16 , 32) ;
		
		int rsAddress , rtAddress , constantAmount ;
		
		rsAddress = Integer.parseInt(rs, 2) ;
		rtAddress = Integer.parseInt(rt, 2) ;
		constantAmount = Integer.parseInt(constantOrAddress, 2) ;
		int offset = constantAmount/4 ;
		
		int storeAmount = Storages.registerFile[rtAddress] ;
		int RAMIndex = Storages.registerFile[rsAddress] + offset ;
		System.out.println("Offset : " + offset +   " Store Amount : " + storeAmount + " Ram INDEX : " + RAMIndex);
		Storages.dataFile[RAMIndex] = storeAmount ;
		
		
	}
	
	public static void lw(Instruction instruction) {
		
		String instructionRegister = instruction.getInstructionRegister() ;
		
		String rs , rt  , constantOrAddress;
		
		rs = instructionRegister.substring(6 , 11) ;
		rt = instructionRegister.substring(11 , 16) ;
		constantOrAddress = instructionRegister.substring(16 , 32) ;
		
		int rsAddress , rtAddress , constantAmount ;
		
		rsAddress = Integer.parseInt(rs, 2) ;
		rtAddress = Integer.parseInt(rt, 2) ;
		constantAmount = Integer.parseInt(constantOrAddress, 2) ;
		int offset = constantAmount/4 ;
		int RAMIndex = Storages.registerFile[rsAddress] + offset ;
		int storeAmount = Storages.dataFile[RAMIndex] ;
		Storages.registerFile[rtAddress] = storeAmount ;
		
	}

	
	// The J_Types :
	public static int j(Instruction instruction ) {
		String instructionRegister = instruction.getInstructionRegister() ;
		String opCode = instructionRegister.substring(0 , 6) ;
		String addressOrConstant = instructionRegister.substring(6 , 31) ;
		int jumpIndex = Integer.parseInt(addressOrConstant , 2 );
		return ( jumpIndex );
		
	}
	

	
	
}
