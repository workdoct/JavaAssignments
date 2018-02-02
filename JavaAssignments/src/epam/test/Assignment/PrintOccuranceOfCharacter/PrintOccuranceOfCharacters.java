package epam.test.Assignment.PrintOccuranceOfCharacter;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

import org.apache.log4j.Logger;

import epam.test.Assignment.CustomiseException.CustomiseException;

public class PrintOccuranceOfCharacters
{
	static final Logger log = Logger.getLogger(PrintOccuranceOfCharacters.class);

	public static void main(String[] args) {

		PrintOccuranceOfCharacters obj = new PrintOccuranceOfCharacters();
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
		obj.charcterCountOfArray(strString);

	}

	public void charcterCountOfArray(String sString){
		char[] array = sString.toCharArray();
		Arrays.sort(array);
		int intCount = 1;
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				log.info(array[i] + " " + intCount);
			}
			else if (array[i] == array[(i + 1)]) {
				intCount++;
			}
			else {
				log.info(array[i] + " " + intCount);
				intCount = 1;
			}
		}
	}

	public void charcterCountUsingHashmap(String sString) {
		char[] array = sString.toCharArray();
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();

		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				map.put(array[i], map.get(array[i]) + 1);
			} else {
				map.put(array[i], 1);
			}
		}

		for (Character ch : map.keySet()) {
			log.info(ch + " : " + map.get(ch));
		}
	}
}