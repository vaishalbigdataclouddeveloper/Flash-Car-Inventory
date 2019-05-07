package custom_car_sales;

import java.util.GregorianCalendar;

public class Car implements java.io.Serializable {

  String model;
  String manufacture;
  String information;
  int year;
  int price;
  double kilometers;
  
  public Car()
  {
	  
  }
  
  public Car(String manufacture, String model, String information,String price,String kilometers)
  {
	  this.manufacture = manufacture;
	  this.model = model;
	  this.information = information;
	  this.year = Integer.parseInt(model);
	  this.price = Integer.parseInt(price);
	  this.kilometers =Double.parseDouble(kilometers);
	  
  }
  
 
  
  public int getAge()
  {
	GregorianCalendar cal = new GregorianCalendar();
	return (cal.get(cal.YEAR)-this.year);
  }
  
  protected String getModel() {
	return model;
}
  protected void setModel(String model) {
	this.model = model;
}
  protected String getManufacture() {
	return manufacture;
}
  protected void setManufacture(String manufacture) {
	this.manufacture = manufacture;
}
  protected String getInformation() {
	return information;
}
  protected void setInformation(String information) {
	this.information = information;
}
  protected int getYear() {
	return year;
}
  protected void setYear(int year) {
	this.year = year;
}
  protected int getPrice() {
	return price;
}
  protected void setPrice(int price) {
	this.price = price;
}
  protected double getKilometers() {
	return kilometers;
}
  protected void setKilometers(double kilometers) {
	this.kilometers = kilometers;
}

}
