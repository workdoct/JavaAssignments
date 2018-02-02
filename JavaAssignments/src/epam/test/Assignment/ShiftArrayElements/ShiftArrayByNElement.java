package epam.test.Assignment.ShiftArrayElements;

import java.util.Scanner;

import org.apache.log4j.Logger;

import epam.test.Assignment.CustomiseException.CustomiseException;

public class ShiftArrayByNElement {

	final Logger log = Logger.getLogger(this.getClass());

	public static void main(String[] args) {

		ShiftArrayByNElement object = new ShiftArrayByNElement();
		object.shiftElementByNValue();
	}

	public void shiftElementByNValue() {

		int[] intArray = new int[20];
		Scanner sc = new Scanner(System.in);
		int intTotalNumber =0;
		int intShift;
		int intCount = 0;

		try
		{
			log.info("Enter Count of array element: ");
			intTotalNumber = sc.nextInt();
			log.info("Enter array element: ");

			for(int i=0;i<intTotalNumber;i++) {
				intArray[i]= sc.nextInt();
			}

			log.info("Enter Number for shifting array : ");
			intShift = sc.nextInt();

		} catch (Exception e) {
			log.error("Enter valid Number");
			throw new CustomiseException("Enter valid number");
		}
		finally {
			sc.close();
		}
		
		if(intTotalNumber<intShift) {
			log.error("Element shifting is not possible total number of array is less than number of shifts");
			throw new CustomiseException("Element shifting is not possible total number of array is less than number of shifts");
		}

		try {
			int[] tempArray = new int[20];
			for(int i= 0; i<intTotalNumber;i++) {
				if(i<intShift) {
					tempArray[i]=intArray[i];
				}

				if(i<intTotalNumber-intShift) {
					intArray[i]=intArray[intShift+i];
				}else{
					intArray[i]=tempArray[intCount];
					intCount++;
				}
			}
			
			for(int i= 0; i<intTotalNumber;i++) {
				log.info(intArray[i]);
			}

		}catch(CustomiseException e) {
			throw new CustomiseException(e.getMessage());
		}
	}



}
