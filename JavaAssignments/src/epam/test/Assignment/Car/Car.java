package epam.test.Assignment.Car;

import org.apache.log4j.Logger;

public class Car {
	
	final Logger log = Logger.getLogger(this.getClass());
	
	int speed ;
	String color ;
	String model ;
	String type;
	
// Overloading
	public Car() {
		
	}
	
	Car(int speed, String color, String model) {
		this.speed = speed;
		this.color = color;
		this.model = model;
	}
	
	Car(int speed, String color, String model, String type) {
		this.speed = speed;
		this.color = color;
		this.model = model;
		this.type = type;
	}
	
	void displayCarInfo() {
		log.info(this.speed + " " + this.color +  " " + this.model);
	} 
	
	public static void main(String[] args) {
		
		Car car1 = new Car(100, "Red", "Audi");
		Car car2 = new Car(180, "Black", "Nissan", "Luxary");
		
		car1.displayCarInfo();
		car2.displayCarInfo();
		
		
		Honda car3 = new Honda(150, "Blue");
		car3.displayCarInfo();
	}
}

class Honda extends Car{   //inheritance
	
	Honda(int speed, String color) {
		this.speed = speed;
		this.color = color;
	}

	private static String model = "Honda" ;  //Encapsulation 
	
	//Overriding
	void displayCarInfo() {
		log.info(this.speed + " " + this.color +  " " + model );
	}
	
}
