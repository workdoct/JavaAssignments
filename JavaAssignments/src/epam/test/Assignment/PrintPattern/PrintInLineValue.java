package epam.test.Assignment.PrintPattern;

import java.util.Scanner;

import org.apache.log4j.Logger;

import epam.test.Assignment.CustomiseException.CustomiseException;

public class PrintInLineValue {
	
	static final Logger log = Logger.getLogger(PrintInLineValue.class);
	
	public static void main(String[] args) {
		int intCount = 0;
		PrintInLineValue object = new PrintInLineValue();
		
		Scanner sc = new Scanner(System.in);
		log.info("Enter Integer Number : ");
		try
		{
			intCount = sc.nextInt();
			object.boundaryCheck(intCount);
			for (int i = 1; i <= intCount; i++) {
				for (int j = 1; j <= i; j++) {
					System.out.print(j);
				}
				if (i != intCount) {
					System.out.print(", ");
				}
			}
		} catch (Exception e) {
			log.error("Enter Positive Integer Number");
			throw new CustomiseException("Enter Positive Integer Number");
		}
		finally {
			sc.close();
		}
	}
	
	private void boundaryCheck(int intNumber) {
		
		if(intNumber<=0) {
			throw new CustomiseException();
		}
	}
}

