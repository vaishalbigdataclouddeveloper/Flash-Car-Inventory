package custom_car_sales;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.sun.javafx.stage.WindowCloseRequestHandler;


public class CarSalesMainScreen extends JFrame implements ActionListener,ChangeListener {
	
	private JPanel topPanel = new JPanel(new BorderLayout());
	private JPanel title = new JPanel(new GridLayout(2, 1));
	private JLabel status = new JLabel();
	private JLabel picture = new JLabel();
	private JLabel carCompany = new JLabel("Flash Car Inventory ", JLabel.CENTER);
	private JLabel prjctLabel = new JLabel("Car Sales & Inventory System", JLabel.CENTER);
	private JTabbedPane Tab1 = new JTabbedPane(JTabbedPane.LEFT);
	private JMenuBar menu = new JMenuBar();
	private JMenuItem exit = new JMenuItem("Exit");
	//private Container con = new Container();
	
	

	public CarSalesMainScreen()
	{
		
        
        setResizable(true);
        setSize(700,700);
        setLocation(50,50);
		

        

		String carFont = carCompany.getFont().getName();
		carCompany.setFont(new Font(carFont, Font.BOLD, 25));
		prjctLabel.setFont(new Font(carFont, Font.PLAIN, 18));

		

		
		status.setBorder(new javax.swing.border.EtchedBorder());

		
		picture.setIcon(new ImageIcon("index1.jpg"));
		title.add(carCompany);
		title.add(prjctLabel);
		topPanel.add(picture, "East");
		topPanel.add(title, "Center");
		
		

		WelcomeScreen welcomeScreen = new WelcomeScreen();
		AddCar addCar = new AddCar();
		SearchByAge searchByAge = new SearchByAge();
		SearchByPriceandKilometer searchByPK = new SearchByPriceandKilometer();

		Tab1.add("Welcome", welcomeScreen);
		Tab1.add("Add a Car", addCar);
		Tab1.add("Search on Price and Kilometers run", searchByPK);
		Tab1.add("Search By Age ", searchByAge);

		/** Tab1.addChangeListener(new ChangeListener() {
		        public void stateChanged(ChangeEvent e) {
		           
		        	 
		        }
		        });*/
	

		Tab1.setSelectedIndex(0);
  
		setLayout(new BorderLayout());
		add(topPanel, "North");
		add(Tab1, "Center");
		add(status, "South");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new CarSalesMainScreen().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

}
