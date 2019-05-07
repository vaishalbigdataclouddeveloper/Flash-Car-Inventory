package custom_car_sales;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Manufacturer {

	String Manufacture;
	public static ArrayList<Car> car = new ArrayList<Car>();
	 
	
	public Manufacturer() 
	{
		
		
		
	
		
	  
	}
	
	

	public String getManufacture() {
		return Manufacture;
	}

	public void setManufacture(String manufacture) {
		Manufacture = manufacture;
	}
	
	 void addCar(Car c) throws IOException 
	{  
		car.add(c);

		FileOutputStream f = new FileOutputStream(new File("CarsListInventory.ser"),false);
		ObjectOutputStream o = new ObjectOutputStream(f);
		
		for(Car ca:car) {
		
		o.writeObject(ca);
		}
		WelcomeScreen.carsnum.setText("The Total number of Cars available in system are:"+String.valueOf(this.car.size()));
		
	}
	 
	 /**Car[] increaseArray(Car[] c,int addSize) {
		 
		 Car [] newCar = new Car[c.length+addSize];
		 
		 for(int i =0;i < c.length;i++)
		 {
			 newCar[i] = c[i];
		 }
		 return newCar;
	 }*/
	 
	public int carCount()
	 {
		FileInputStream fi;
		ObjectInputStream oi;
		try {
			fi = new FileInputStream(new File("CarsListInventory.ser"));
		
			 oi = new ObjectInputStream(fi);
			 
			 while(true)
			 {
			 car.add((Car)oi.readObject());
			 }
			
			
			
		} catch (IOException | ClassNotFoundException ex) {
			// TODO Auto-generated catch block
		
          
		}  
		 
		
	
		
		
		 return car.size();
	 }
	 
	
	 public Car[]  getAllCarInformation()
	 {
		 Car[] c = new Car[car.size()]; 
		 for (int i = 0; i<car.size() ;i++)
		 {
			 c[i]=car.get(i);
		 }
		 return c;
	 }
	 

	 
	
}
