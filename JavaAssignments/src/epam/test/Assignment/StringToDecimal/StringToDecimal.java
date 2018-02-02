package epam.test.Assignment.StringToDecimal;


import java.util.Scanner;

import org.apache.log4j.Logger;

import epam.test.Assignment.CustomiseException.*;



public class StringToDecimal {

	final Logger log = Logger.getLogger(this.getClass());

	public static void main(String[] args) {
		StringToDecimal obj = new StringToDecimal() ;
		//1obj.stringToDecimalWithLogic();
		obj.stringToDecimalUsingInbuildFunction();
	}

	public void stringToDecimalUsingInbuildFunction() {
		String strString = acceptString();

		//boundary Checks
		if(strString==null) {
			log.error("String is null");
			throw new CustomiseException("String is Null");
		}
		else if(strString.isEmpty()) {
			log.error("String is Empty");
			throw new CustomiseException("String is empty");
		}

		try {
			log.info("Decimal Representation of Binary Number : " + Integer.parseInt(strString, 2));
		}catch(NumberFormatException e) {
			throw new CustomiseException("Enter valid Binary Number : ");
		}
	}

	public void stringToDecimalWithLogic() {

		String sString = acceptString();
		int intDecimalNumber = 0;
		try {
			for(int i=0;i<sString.length();i++ ) {
				intDecimalNumber = intDecimalNumber +  Character.getNumericValue(sString.charAt(sString.length()-1-i)) * (int) Math.pow(2 , i)  ;
			}
		}catch(Exception e) {
			log.error("Enter valid number");
			throw new CustomiseException("Enter valid number");
		}

		log.info("Decimal Representation of " + sString + " : " +intDecimalNumber);
	}

	public String acceptString() {
		String strString = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String : ");
		char[] ch;
		try
		{
			strString = sc.next();
			ch = strString.toCharArray();
			for(int i =0;i<ch.length;i++)
			{
				if(!(ch[i]=='0' || ch[i]=='1'))
				{
					throw new CustomiseException();
				}
			}
		} catch (CustomiseException e) {

			log.error("Enter valid String");
			throw new CustomiseException("Enter valid String");
		}
		finally {
			sc.close();
		}
		return strString;
	}


}
