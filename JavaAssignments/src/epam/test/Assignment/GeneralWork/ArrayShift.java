package epam.test.Assignment.GeneralWork;

import java.util.Arrays;

public class ArrayShift {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] ch  = { 'a','l','i','j' };
		String strString = Arrays.toString(ch);
		System.out.println(strString);
		String reverseString = strString.substring(2) + strString.substring(0, 2);
		System.out.println(reverseString);
	}

}
