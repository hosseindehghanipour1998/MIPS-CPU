import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Utility {
	
	public static void setTheType(Instruction instruction) {
		
		String instructionString = instruction.getInstructionRegister() ;
		
		String opCode = instructionString.substring(0, 6);
		
		int intOpCode = -1 ;
		try {
			 intOpCode = Integer.parseInt(opCode) ;
		}
		catch(Exception e){
			System.out.println("Unsupported Input");
		}
		
		for(Instruction i : Instruction.allPredefinedInstructions) {
			if(opCode.equals(i.getOpCode())) {
				instruction.setType(i.getType());
			}
		}
	}
	
	
	public static Instruction getInput() {
		Scanner io = new Scanner(System.in);
		System.out.println("Enter Your Input : ");
		String input = io.nextLine() ;
		Instruction temp = new Instruction() ;
		temp.setInstructionRegister(input);
		return temp ;
		
	}

	
	public static void readFile(String fileName  , ArrayList<String> savedStreams) {
		try {
			FileInputStream fstream = new FileInputStream("H:\\GIT\\Computer Architecture Project\\src\\" + fileName + ".txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			while ((strLine = br.readLine()) != null)   {
				  // Print the content on the console
				//Instruction tempInstruction = new Instruction() ;
				//tempInstruction.setInstructionRegister(strLine.replaceAll(" ", ""));
				savedStreams.add(strLine.replaceAll(" ", ""));
				}
			br.close();
		}
		//
		
		catch(Exception e) {
			System.out.println("No such file Found");
		}
		
	}
	
	public static<T> void printArrayList(ArrayList<T> al ) {
		if(al.size() == 0) {
			System.out.println("ArrayList Stack is Empty");
			return ;
		}
		for(int i = 0 ; i < al.size() ; i++ ) {
			System.out.println(al.get(i));
		}
	}
	
	public static <T> void printArray(int[] dataFile) {
		if(dataFile.length == 0 ) {
			System.out.println("Array Stack  is empty");
			return ;
		}
		for(int i = 0 ; i < dataFile.length ; i++) {
			System.out.print("[" + i + "-|" + dataFile[i] + "]");
		}
	}
	
	/*
	public static void writeFile(int[] Array , String fileName ) throws IOException {
		String path = "H:\\GIT\\Computer Architecture Project\\src\\" + fileName + ".txt";
		FileWriter writer = new FileWriter(path ,false);
		PrintWriter printLine = new PrintWriter(writer) ;
		for(int i = 0 ; i < Array.length ; i++) {
			printLine.printf("%d \n", Array[i]);
		}
		printLine.close();
		
	}
	*/
	
	public static void writeFile(int[] Array , String fileName )throws IOException{
		try {
		    File newTextFile = new File("H:\\GIT\\Computer Architecture Project\\" + fileName + ".txt");
		    FileWriter fw = new FileWriter(newTextFile);
		    
			for(int i : Array) {
				fw.write(Integer.toString(i) + "\n");
			}
			fw.close();
			System.out.println("\nFile Writting Completed Successfully.");
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}
	
}
