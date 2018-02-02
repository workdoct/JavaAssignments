package epam.test.Assignment.GeneralWork;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import epam.test.Assignment.CustomiseException.CustomiseException;
import epam.test.Assignment.PrimeNumber.PrimeNumber;

public class ReflectionImplementationForSystemClass {
	
	static final Logger log = Logger.getLogger(PrimeNumber.class);

	public static void main(String[] args) {

		try {
			Class cls = Class.forName("java.io.PrintStream");
			Method[] mc = cls.getDeclaredMethods();

			for(Method mcs : mc) {
				log.info(mcs.getName());
			}

			Field[] fi = cls.getDeclaredFields();
			for(Field mcs : fi) {
				log.info(mcs.getName());
			}
		} catch (ClassNotFoundException e) {
			log.error("Enter Valid Class Name");
			throw new CustomiseException("Enter Valid Class Name");
		}

	}
}
