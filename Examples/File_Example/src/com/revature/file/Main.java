package com.revature.file;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		
		int val;
		
		try {
				
			FileReader fr = new FileReader("C:\\Users\\micha\\Documents\\Git\\batch-source\\Examples\\File_Example\\src\\com\\revature\\file\\count.txt");
			BufferedReader br = new BufferedReader(fr);
			
			try {
				val = Integer.parseInt(br.readLine()) + 1;
			}
			
			catch (NumberFormatException e) {
				
				val = 0;
			}
			
			br.close();
			
			FileWriter fw = new FileWriter("C:\\Users\\micha\\Documents\\Git\\batch-source\\Examples\\File_Example\\src\\com\\revature\\file\\count.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(new Integer(val).toString());

			bw.close();
		}
		
		catch(IOException e) {
			
			System.out.println("IOException: Fix it");
		}
	}
}
