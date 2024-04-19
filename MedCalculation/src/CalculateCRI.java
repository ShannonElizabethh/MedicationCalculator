import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * 
 * This will calculate a CRI for the user and provide a walk-though of the math.
 * Will work for mg/kg/day or mg/kg/hr. 
 * 
 */

public class CalculateCRI {
	
	public static void medCalc () {		
		// create the frame and panels
		JFrame oneFrame = new JFrame("CRI Calculation");
		JPanel onePanel = new JPanel();
		JPanel twoPanel = new JPanel();
		JPanel threePanel = new JPanel();
		JLabel oneLabel = new JLabel("", JLabel.LEFT);
		
		// create the text field for gathering information
		JTextField weightField = new JTextField(30);
		JTextField conField = new JTextField(30);
		JTextField desConField = new JTextField(30);
		JTextField desTime = new JTextField(30);
		JTextField rateField = new JTextField(30);

		// add labels for the text fields
		JLabel weightLabel = new JLabel("Enter the pt weight in kg.");
		JLabel conLabel = new JLabel("Enter the concentration of the medication in mg/ml.");
		JLabel rateLabel = new JLabel("Enter the rate in ml/hr.");
		JLabel desTimeLabel = new JLabel("Enter desired amount of time to run in hours.(Ignore for mg/kg/day)");
		JLabel desConLabel = new JLabel("Enter desired concentration in mg/kg/hr or mg/kg/day");	
			
		// add label and panels to the frame
		oneLabel.setText("You clicked 3: For calculation of CRI.");
		oneFrame.getContentPane().add(BorderLayout.NORTH, oneLabel);
		oneFrame.getContentPane().add(BorderLayout.CENTER, onePanel);
		oneFrame.getContentPane().add(BorderLayout.SOUTH, twoPanel);

		oneFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		oneFrame.setSize(950,600);
		oneFrame.setVisible(true);
		
		//adjust font for labels
		Font f1 = new Font("Times New Roman", Font.BOLD, 15);
		Font f2 = new Font("Times New Roman", Font.BOLD, 20);
		Font f3 = new Font("Times New Roman", Font.PLAIN, 15);
		weightLabel.setFont(f1);
		conLabel.setFont(f1);
		rateLabel.setFont(f1);
		desTimeLabel.setFont(f1);
		desConLabel.setFont(f1);
		oneLabel.setFont(f2);
		
		// create grid for text fields and labels
		GridLayout oneLayout = new GridLayout(5,2);
		oneLayout.setHgap(10);
		oneLayout.setVgap(10);
		
		// create grid for explanation of calculations
		GridLayout twoLayout = new GridLayout(15,2);
		oneLayout.setHgap(10);
		oneLayout.setVgap(10);
		
		// create grid for buttons
		GridLayout buttonLayout = new GridLayout(0,2);
		oneLayout.setHgap(10);
		oneLayout.setVgap(10);		
		
		// add grids to panels
		onePanel.setLayout(oneLayout);
		twoPanel.setLayout(twoLayout);
		threePanel.setLayout(buttonLayout);
		
		// Weight of pt		
		onePanel.add(weightLabel);
		onePanel.add(weightField);
		
		// Concentration of drug	
		onePanel.add(conLabel);
		onePanel.add(conField);
	
		// Rate of the CRI	
		onePanel.add(rateLabel);
		onePanel.add(rateField);

		// Desired number of hours to run CRI	
		onePanel.add(desTimeLabel);
		onePanel.add(desTime);

		// mg/kg/day or mg/kg/hr		
		onePanel.add(desConLabel);
		onePanel.add(desConField);
		
		// labels for explanations to be changed later
		JLabel vl = new JLabel();
		JLabel vl5 = new JLabel("Is CRI in mg/kg/day or mg/kg/hr?");
		JLabel vl2 = new JLabel();
		JLabel vl3 = new JLabel();
		JLabel vl4 = new JLabel();
		JLabel vl6 = new JLabel();
		JLabel vl7 = new JLabel();
		JLabel vl8 = new JLabel();
		JLabel vl9 = new JLabel();
		JLabel vl10 = new JLabel();
		JLabel vl11 = new JLabel();
		JLabel vl12 = new JLabel();
		JLabel vl13 = new JLabel();
		
		//adjust font for labels
		vl.setFont(f3);
		vl2.setFont(f3);
		vl3.setFont(f3);
		vl4.setFont(f3);
		vl5.setFont(f1);
		vl6.setFont(f3);
		vl7.setFont(f3);
		vl8.setFont(f3);
		vl9.setFont(f3);
		vl10.setFont(f3);
		vl11.setFont(f3);
		vl12.setFont(f3);
		vl13.setFont(f3);
		
		// create the buttons 
		JButton dayButton = new JButton("mg/kg/day");
		JButton hrButton = new JButton("mg/kg/hr");
		
		// add buttons to button panel
		threePanel.add(dayButton); 
		threePanel.add(hrButton);
	
		// add labels and buttons to panel two
		twoPanel.add(vl5);
		
		twoPanel.add(threePanel);
		
		twoPanel.add(vl);
		twoPanel.add(vl2);
		twoPanel.add(vl3);
		twoPanel.add(vl4);

		twoPanel.add(vl6);
		twoPanel.add(vl7);
		twoPanel.add(vl8);
		twoPanel.add(vl9);
		twoPanel.add(vl10);
		twoPanel.add(vl11);
		twoPanel.add(vl12);
		twoPanel.add(vl13);

	
		// if mg/kd/day selected 	
		dayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// gather text field information and convert to double
				String wtText = weightField.getText();
				double wt = Double.valueOf(wtText);

				// concentration of drug				
				String conText = conField.getText();
				double con = Double.valueOf(conText);
				
				// not needed for md/kg/day - needed to cal for mg/kg/hr			
//				String desTimeText = desTime.getText();
//				double totVol = Double.valueOf(desTime);
				
				// rate for CRI in ml/hr
				String rateText = rateField.getText();
				double rate = Double.valueOf(rateText);
				
				// Dose for CRI in mg/kg/day
				String orText = desConField.getText();
				double or = Double.valueOf(orText);
				
				// calculates for CRI
				double one = wt * or;				//gets mg/day
				double two = one / con;				//gets drug vol
				double three = (rate * 24) - two;	//gets diluent vol
				
				double four = rate * 24;			//for explanation for calculation
				
				// set labels with the text/value walk though for calculation
				vl.setText("First multiply the pt weight by the medication dose(mg/kg/day)");
				vl2.setText(wt + " kg * " + or + " mg/kg/day = " + one + " mg/day");
				vl3.setText("Next divide the volume of the medication per day by the concentration of the medication.");
				vl4.setText(one + " mg/day / " + con + " mg/ml = " + two + " ml/day of the medication");
				vl6.setText("Now, multiply the rate (ml/hr) and multiply by 24; Since 24 hrs in 1 day");
				vl7.setText(rate + " ml/hr * 24 hr = " + four + " ml/day");
				vl8.setText("Finally, take the ml/day and subtract the volume of the drug");
				vl9.setText(four + " ml - " + two + " ml = " + three + " mls");
				vl10.setText("You will need " + two + " mls of the medication and " + three + " mls of diluent.");
				vl11.setText("");
				vl12.setText("");

			}
		});

//		
		hrButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// gather text field information and convert to double
				String wtText = weightField.getText();
				double wt = Double.valueOf(wtText);
				
				// concentration of the drug	
				String conText = conField.getText();
				double con = Double.valueOf(conText);
				
				// Desired amount of time to run CRI in hrs	
				String desTimeText = desTime.getText();
				double desTime = Double.valueOf(desTimeText);
				
				// Rate of the CRI in ml/hr	
				String rateText = rateField.getText();
				double rate = Double.valueOf(rateText);
				
				// Dose of CRI in mg/kg/hr	
				String orText = desConField.getText();
				double or = Double.valueOf(orText);
				
				// calculation of CRI
				double one = wt * or;			//gets mg/hr
				double two = one / con;			//gets vol of drug per hr
				double three = rate - two;		//gets vol diluant per hr
				double drug = two * desTime;		//gets final drug vol
				double dil = three * desTime;	//gets final diluant vol
				
				// set labels with the text/value walk though for calculation
				vl.setText("First multiply the pt weight by the medication dose(mg/kg/hr)");
				vl2.setText(wt + " kg * " + or + " mg/kg/hr = " + one + " mg/hr");
				vl3.setText("Next divide the volume of the medication per hour by the concentration of the medication.");
				vl4.setText(one + " mg/hr / " + con + " mg/ml = " + two + " ml/hr of the medication");
 				vl6.setText("Now, subtract total volume by the volume of the medication per hour");
				vl7.setText("The total volume for one hour is equal to the rate (ml/hr); Since you would multiple the rate by 1 to get total volume");
				vl8.setText(rate + " ml - " + two + " ml = " + three + "  mls. This is volume of the diluent.");
				vl9.setText("Finally, to get the amount of the medication and diluent for more than one hour multiple by the desired number of hours");
				vl10.setText(two + " ml * " + desTime + " hr = " + drug + " mls ");
				vl11.setText(three + " ml * " + desTime + " hr = " + dil + " mls ");			
				vl12.setText("You will need " + drug + " mls of the medication and " + dil + " mls of diluent.");
				
			}
		});
		
	} // ends medCalc

} //ends Calculate CRI
