package epam.test.Assignment.PrimeNumber;

import java.util.Scanner;

import org.apache.log4j.Logger;

import epam.test.Assignment.CustomiseException.CustomiseException;

public class PrimeNumber {

	static final Logger log = Logger.getLogger(PrimeNumber.class);

	public static void main(String[] args) {
		int intNumber = 0 ;
		Scanner sc = new Scanner(System.in);
		PrimeNumber obj = new PrimeNumber();

		try
		{
			log.info("Enter valid Integer : ");
			intNumber = sc.nextInt();
		} catch (Exception e) {
			log.error("Enter valid Number");
			throw new CustomiseException("Enter valid number");
		}
		finally {
			sc.close();
		}

		obj.isPrimeNumber(intNumber);
		obj.additionOfFirstNPrimeNumber(intNumber);
	}

	public void isPrimeNumber(int intNumber) {
		for(int i=2;i<intNumber;i++) {
			if(intNumber%i==0) {
				log.info("Number " + intNumber + " is not prime number");
				break;
			}else if(i== intNumber-1) {
				log.info("Number " + intNumber + " is prime number");
			}
		}
	}

	public void additionOfFirstNPrimeNumber(int intNumber) {
		int intCounter = 0;
		int[] intArray = new int[100] ;
		int intSum = 0;

		try {
			for(int i=3;i<1000;i++) {
				for(int j=2;j<i;j++) {
					if(i%j==0) {
						break;
					}else if(j== i-1) {
						intArray[intCounter] = i;
						intCounter++;
					}
				}
				if(intCounter>=intNumber) {
					break;
				}
			}
			for(int i=0;i<intArray.length;i++) {
				intSum  = intSum + intArray[i];
			}
		}catch(CustomiseException e) {
			log.error((e.getMessage()));
			throw new CustomiseException(e.getMessage());
		}

		log.info("Sum of first " + intNumber + " is " + intSum);

	}
}

