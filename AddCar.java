package custom_car_sales;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class AddCar extends JPanel implements ActionListener {

	private JLabel headingLabel = new JLabel("Add New Car");
	private JLabel manufacture = new JLabel("Manufacture Name :");
	private JTextArea man = new JTextArea();
	private JLabel model = new JLabel("Model Year :");
	private JTextArea mod = new JTextArea();
	private JLabel carName = new JLabel("Car Name and Detail Info :");
	private JTextArea carIn = new JTextArea();
	private JLabel price = new JLabel("Price :");
	private JTextArea priceNum = new JTextArea();
	private JLabel kilometers = new JLabel("Kilometers Run :");
	private JTextArea km = new JTextArea();
	private JPanel topPanel = new JPanel();
	private JPanel manPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel modelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel carNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pricePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel kilometersPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel addButtonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JButton add = new JButton("Add Car");
	private JButton reset = new JButton("Reset");
	
	
	public AddCar()
	{
		//setResizable(false);
		setSize(new Dimension(450,450));
		setLayout(new BorderLayout());
		this.setLocation(250, 200);
		topPanel.setLayout(new GridLayout(7,0,20,20));
		manPanel.setLayout(new GridLayout(0,2,20,20));
		modelPanel.setLayout(new GridLayout(0,2,20,20));
		carNamePanel.setLayout(new GridLayout(0,2,20,20));
		pricePanel.setLayout(new GridLayout(0,2,20,20));
		kilometersPanel.setLayout(new GridLayout(0,2,20,20));
		addButtonsPanel.setLayout(new GridLayout(0,2,20,20));
		manPanel.add(manufacture);
		manPanel.add(man);
		modelPanel.add(model);
		modelPanel.add(mod);
		carNamePanel.add(carName);
		carNamePanel.add(carIn);
		pricePanel.add(price);
		pricePanel.add(priceNum);
		kilometersPanel.add(kilometers);
		kilometersPanel.add(km);
		addButtonsPanel.add(add);
		addButtonsPanel.add(reset);
		topPanel.add(headingLabel);
		topPanel.add(manPanel);
		topPanel.add(modelPanel);
		topPanel.add(carNamePanel);
		topPanel.add(pricePanel);
		topPanel.add(kilometersPanel);
		topPanel.add(addButtonsPanel);
		add(topPanel, "North");
		
		reset.addActionListener(new ActionListener()
				{
			        
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						man.setText(null);
						mod.setText(null);
						carIn.setText(null);
						priceNum.setText(null);
						km.setText(null);
						
					}
				});
		
		add.addActionListener(new ActionListener()
		{
	        
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			try {
				
			
				String manufacture = man.getText();
				String model = mod.getText();
				String information = carIn.getText();
				String price = priceNum.getText();
				String kilometers = km.getText();
				
				
				
				Car newCar = new Car(manufacture,model,information,price,kilometers);
				new Manufacturer().addCar(newCar);
				
				JOptionPane.showMessageDialog(topPanel, "Your Car has been succefully added in the system.");
				
				man.setText(null);
				mod.setText(null);
				carIn.setText(null);
				priceNum.setText(null);
				km.setText(null);
			}
			
			catch(NumberFormatException | IOException ex)
			{
				JOptionPane.showMessageDialog(topPanel, "Enter Proper field values");
			}
			}
		});
		
		
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
		/**public static void main(String[] args) {
    
    
    
    new AddCar().setVisible(true);

}*/
	
	
	
}
