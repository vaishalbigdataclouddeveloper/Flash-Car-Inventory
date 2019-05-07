package custom_car_sales;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SearchByPriceandKilometer extends JPanel implements ActionListener  {
	
	private JLabel headingLabel = new JLabel("Search By Price & Kilometers");
	private JLabel carPrice = new JLabel("Price Between");
	private JTextArea lowerPrice = new JTextArea();
	private JTextArea upperPrice = new JTextArea();
	private JLabel carKilometers = new JLabel("Kilometers Between");
	private JTextArea lowerKM =new JTextArea();
	private JTextArea upperKM = new JTextArea();
	private JButton searchButton = new JButton("Search");
	private JButton resetButton = new JButton("Reset");
	private JPanel topPanel = new JPanel();
	private JPanel pricePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel kilometersPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel searchButtonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	public ArrayList<String> carInfo = new ArrayList<String>();
	
	
	public SearchByPriceandKilometer()
	{
		//setResizable(false);
		setSize(new Dimension(450,450));
		setLayout(new BorderLayout());
		this.setLocation(250, 200);
		topPanel.setLayout(new GridLayout(4,0,20,20));
		pricePanel.setLayout(new GridLayout(0,3,20,20));
		kilometersPanel.setLayout(new GridLayout(0,3,20,20));
		searchButtonsPanel.setLayout(new GridLayout(0,2,20,20));
		pricePanel.add(carPrice);
		pricePanel.add(lowerPrice);
		pricePanel.add(upperPrice);
		kilometersPanel.add(carKilometers);
		kilometersPanel.add(lowerKM);
		kilometersPanel.add(upperKM);
		searchButtonsPanel.add(searchButton);
		searchButtonsPanel.add(resetButton);
		topPanel.add(headingLabel);
		topPanel.add(pricePanel);
		topPanel.add(kilometersPanel);
		topPanel.add(searchButtonsPanel);
		add(topPanel, "North");
		
		
		
		resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				carInfo.removeAll(carInfo);
			    lowerPrice.setText(null);
			    upperPrice.setText(null);
			    lowerKM.setText(null);
			    upperKM.setText(null);
			}
		});
		
		searchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) throws NumberFormatException {
				// TODO Auto-generated method stub
				try {
				
				
				
				 int lwPrice = (lowerPrice.getText() !=  null) ? Integer.parseInt(lowerPrice.getText()):0;
				 int upPrice = (upperPrice.getText() !=  null) ? Integer.parseInt(upperPrice.getText()):0;
				 int lwKMs = (lowerKM.getText() !=  null) ? Integer.parseInt(lowerKM.getText()):0;
				 int upKMs = (upperKM.getText() !=  null) ? Integer.parseInt(upperKM.getText()):0;
				 
				 
				 
				 
				 
				 Car[] carlist = new Car[new Manufacturer().car.size()];
				 
				 carlist = new Manufacturer().getAllCarInformation();
				  
				 /**Car[] carlist = new Car[2];
				  carlist[0] = new Car("Hundai","2013","Good One","4566","46666");
				  carlist[1] = new Car("Maruti","2016","Good One","4566","46666");*/
			     
			     for (int i = 0; i < carlist.length ; i++)
			     {
			    	 
			        if((carlist[i].getPrice() <= upPrice && carlist[i].getPrice() >= lwPrice) && (carlist[i].getKilometers()<= upKMs && carlist[i].getKilometers() >= lwKMs))
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
				catch(NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(topPanel,"Enter proper values in all 4 fields");
				}
			}
		});
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	/**public static void main(String[] args) {
        
        
	     
        new SearchByPriceandKilometer().setVisible(true);

}*/
}