package epam.test.Assignment.ReverseArray;

import java.util.Scanner;

import org.apache.log4j.Logger;

import epam.test.Assignment.CustomiseException.CustomiseException;

public class ReverseArray {

	final Logger log = Logger.getLogger(this.getClass());
	
	public static void main(String[] args) {
		ReverseArray obj = new ReverseArray();
		obj.reverseArrayAndStore();
	}

	void reverseArrayAndStore() {
		int[] intArray = new int[20];
		Scanner sc = new Scanner(System.in);
		int intKey = 0;
		int intTotalNumber =0;

		try
		{
			log.info("Enter Count of array element: ");
			intTotalNumber = sc.nextInt();
			log.info("Enter array element: ");
			for(int i=0;i<intTotalNumber;i++) {
				intArray[i]= sc.nextInt();
			}
			
			//Swap Logic
			for(int i=0;i<intTotalNumber/2;i++) {
				intKey = intArray[intTotalNumber-1-i];
				intArray[intTotalNumber-1-i] = intArray[i];;
				intArray[i] = intKey;
			}

			//Print Logic
			for(int i=0;i<intTotalNumber;i++) {
				log.info(intArray[i] + " ");
			}
			
		} catch (Exception e) {
			log.error("Enter valid number");
			throw new CustomiseException("Enter valid number");
		}
		finally {
			sc.close();
		}

		
	}




}
