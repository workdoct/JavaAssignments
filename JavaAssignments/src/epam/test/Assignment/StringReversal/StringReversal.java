package epam.test.Assignment.StringReversal;

import java.util.Scanner;
import org.apache.log4j.Logger;
import epam.test.Assignment.CustomiseException.CustomiseException;

public class StringReversal {
	
	static final Logger log = Logger.getLogger(StringReversal.class);

	private String reverseString(String sString){
		return new String(new StringBuffer(sString).reverse()); 
	}


	private String reverseStringByIteration(String sString)
	{	
		//Boundary Checks
		
		if(sString.length()<=0) {
			throw new CustomiseException("String is Empty");
		}
		String reverseString = "";
		for (int i = sString.length() - 1; i >= 0; i--) {
			reverseString = reverseString + sString.charAt(i);
		}
		return reverseString;
	}

	public static void main(String[] args)
	{
		StringReversal obj = new StringReversal();
		String strString = "";
		Scanner sc = new Scanner(System.in);
		log.info("Enter String : ");
		
		try
		{
			strString = sc.next();
		} catch (Exception e) {
			log.error("Enter valid String");
			throw new CustomiseException("Enter valid String");
		}
		finally {
			sc.close();
		}

		log.info(obj.reverseStringByIteration(strString));
		
		

	}
}