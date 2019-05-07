package custom_car_sales;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;



public class WelcomeScreen extends JPanel implements ActionListener  {

	private JLabel heading = new JLabel("Car Sales System", JLabel.CENTER);
	public static JLabel carsnum = new JLabel();
	private JPanel statstics = new JPanel();
	private JPanel main = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
	public JPanel panel1 = new JPanel();
	public JButton allCars = new JButton();
	public ArrayList<String> carInfo = new ArrayList<String>();

	public WelcomeScreen()
	{
		//setResizable(false);
		setSize(new Dimension(450,450));
		setLayout(new BorderLayout());
		this.setLocation(250, 200);
		panel1.setLocation(250,200);
		

		statstics.setLayout(new GridLayout(2, 0, 30, 30));
		main.add(statstics);
		//heading.setBorder (new TitledBorder(null, getTitle(), getDefaultCloseOperation(), getDefaultCloseOperation(), getFont() ));

		statstics.add(carsnum);
		statstics.add(allCars);
		allCars.setText("Show All Cars");
		
		allCars.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
			     Car[] carlist = new Car[new Manufacturer().car.size()];
			     
			     carlist = new Manufacturer().getAllCarInformation();
				  
				  /**Car[] carlist = new Car[2];
				  carlist[0] = new Car("Hundai","2015","Good One","4566","46666");
				  carlist[1] = new Car("Maruti","2016","Good One","4566","46666");*/
			     
			     for (int i = 0; i < carlist.length; i++)
			     {
			        String manufacture = carlist[i].getManufacture();
			        String model = carlist[i].getModel();
			        int year = carlist[i].getYear();
			        int km = (int)carlist[i].getKilometers();
			        String Information = carlist[i].getInformation();
			        int price = carlist[i].getPrice();
			        int age = carlist[i].getAge();
			        
			        carInfo.add(String.format("\n \n No. %d car has \n Manfacture Name: %s \n Model : %s \n  Age : %d \n"
			        		+ "Information : %s \n Year :%d \n Price: %d \n Kilometers: %d \n \n",i+1,manufacture,model,age
			        		,Information,year,price,km));
			     }
			     
			     JScrollPane  info = new JScrollPane(new JTextArea(carInfo.toString()));
			     JOptionPane.showMessageDialog(panel1,info ); 
			     info.setSize( new Dimension( 500, 500 ) );
			     info.setHorizontalScrollBar(new JScrollBar(JScrollBar.HORIZONTAL));
			     carInfo.removeAll(carInfo);
			
			  }
			});
		carsnum.setText("The Total number of Cars available in system are:"+String.valueOf(new Manufacturer().carCount()));
		add(heading, "North");
		add(main, "Center");
	}
	
	
	  public static void main(String[] args) {
	        
	         
	     
	                new WelcomeScreen().setVisible(true);
	          
	        
	        

	
	

	  }


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



}