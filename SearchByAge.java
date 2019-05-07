package custom_car_sales;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class SearchByAge extends JPanel implements ActionListener {
	    
	  
	private final String[] age = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
			"15", "20", "25", "30"};
		private JLabel headingLabel = new JLabel("Search on age");
		private JLabel ageLabel = new JLabel("Car Age");
		private JButton searchButton = new JButton("Search");
		private JButton resetButton = new JButton("Reset");
		private JComboBox ageCombo = new JComboBox(age);
		private JPanel topPanel = new JPanel();
		private JPanel agePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		private JPanel searchButtonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		public ArrayList<String> carInfo = new ArrayList<String>();

		
		public SearchByAge()
		{
			//setResizable(false);
			setSize(new Dimension(450,450));
			setLayout(new BorderLayout());
			this.setLocation(250, 200);
			topPanel.setLayout(new GridLayout(3,0,20,20));
            agePanel.setLayout(new GridLayout(0,2,20,20));
            searchButtonsPanel.setLayout(new GridLayout(0,2,20,20));
			
			resetButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					carInfo.removeAll(carInfo);
					ageCombo.setSelectedIndex(0);
				}
			});
			
			searchButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					
					 int upperAge = Integer.parseInt(ageCombo.getSelectedItem().toString());
					 
					 Car[] carlist = new Car[new Manufacturer().car.size()];
					 
					 carlist = new Manufacturer().getAllCarInformation();
					  
					 /** Car[] carlist = new Car[2];
					  carlist[0] = new Car("Hundai","2013","Good One","4566","46666");
					  carlist[1] = new Car("Maruti","2016","Good One","4566","46666");*/
				     
				     for (int i = 0; i < carlist.length ; i++)
				     {
				    	 
				        if(carlist[i].getAge() <= upperAge)
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
				     }
				     JScrollPane  info = new JScrollPane(new JTextArea(carInfo.toString()));
				     JOptionPane.showMessageDialog(topPanel,info ); 
				     info.setSize( new Dimension( 500, 500 ) );
				     info.setHorizontalScrollBar(new JScrollBar(JScrollBar.HORIZONTAL));
				     carInfo.removeAll(carInfo);
				     
					 
				}
			});

			agePanel.add(ageLabel);
			agePanel.add(ageCombo);
			searchButtonsPanel.add(searchButton);
			searchButtonsPanel.add(resetButton);
			topPanel.add(headingLabel);
			topPanel.add(agePanel);
			topPanel.add(searchButtonsPanel);
			add(topPanel, "North");
			
		}

		
		public void actionPerformed(ActionEvent ev)
		{
			
				
		}
		
		
		
	/**public static void main(String[] args) {
	        
	         
		     
            new SearchByAge().setVisible(true);

		}*/
		
	}
