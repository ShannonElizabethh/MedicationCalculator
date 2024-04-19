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
 * This will check the math of a CRI that has already been created. 
 * There is no walk-through for this math.
 * Will work for mg/kg/hr or mg/kg/day.
 * 
 */

public class CheckCRI {

	public static void medCalc () {
		
		// create the frame and panels
		JFrame oneFrame = new JFrame("Check CRI Calculation");
		JPanel onePanel = new JPanel();
		JPanel twoPanel = new JPanel();
		JPanel threePanel = new JPanel();
		JLabel oneLabel = new JLabel("", JLabel.LEFT);
		
		// create the text fields for gathering information
		JTextField weightField = new JTextField(30);
		JTextField conField = new JTextField(30);
		JTextField volField = new JTextField(30);
		JTextField totVolField = new JTextField(30);
		JTextField rateField = new JTextField(30);
		
		// create the labels for the text fields
		JLabel weightLabel = new JLabel("Enter the pt weight in kg.");
		JLabel conLabel = new JLabel("Enter the concentration of the medication in mg/ml.");
		JLabel volLabel = new JLabel("Enter the Volume of the medication in mls.");
		JLabel totVolLabel = new JLabel("Enter total volume in ml's (volume of medication + diluent).");
		JLabel rateLabel = new JLabel("Enter the rate in ml/hr.");
		
		//adjust font for labels
		Font f1 = new Font("Times New Roman", Font.BOLD, 15);
		Font f2 = new Font("Times New Roman", Font.BOLD, 20);
		Font f3 = new Font("Times New Roman", Font.PLAIN, 15);
		weightLabel.setFont(f1);
		conLabel.setFont(f1);
		volLabel.setFont(f1);
		totVolLabel.setFont(f1);
		rateLabel.setFont(f1);
		oneLabel.setFont(f2);
		
		// set layout of frame (add panels and label)
		oneLabel.setText("You clicked 2: For checking calculation of CRI.");
		oneFrame.getContentPane().add(BorderLayout.NORTH, oneLabel);
		oneFrame.getContentPane().add(BorderLayout.CENTER, onePanel);
		oneFrame.getContentPane().add(BorderLayout.SOUTH, twoPanel);

		oneFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		oneFrame.setSize(800, 300);
		oneFrame.setVisible(true);
		
		// grid for text fields & labels
		GridLayout oneLayout = new GridLayout(5,2);
		oneLayout.setHgap(10);
		oneLayout.setVgap(10);
		
		// grid for panel two
		GridLayout twoLayout = new GridLayout(3,0);
		oneLayout.setHgap(10);
		oneLayout.setVgap(10);
		
		// grid for buttons
		GridLayout buttonLayout = new GridLayout(0,2);
		oneLayout.setHgap(10);
		oneLayout.setVgap(10);		
		
		// set panels with the grids
		onePanel.setLayout(oneLayout);
		twoPanel.setLayout(twoLayout);
		threePanel.setLayout(buttonLayout);
		
		// Weight of pt		
		onePanel.add(weightLabel);
		onePanel.add(weightField);
		
		// Concentration of drug	
		onePanel.add(conLabel);
		onePanel.add(conField);
	
		// Volume of the drug		
		onePanel.add(volLabel);
		onePanel.add(volField);
		
		// Desired total volume of drug		
		onePanel.add(totVolLabel);
		onePanel.add(totVolField);
		
		// Rate of the CRI
		onePanel.add(rateLabel);
		onePanel.add(rateField);
		
		JLabel vl = new JLabel();

		JLabel vl5 = new JLabel("Is CRI in mg/kg/day or mg/kg/hr?");
		
		// crates the buttons for calculating mg/kg/day or mg/kg/hr
		JButton dayButton = new JButton("mg/kg/day");
		JButton hrButton = new JButton("mg/kg/hr");
		
		// add buttons to panel
		threePanel.add(dayButton); 
		threePanel.add(hrButton);
	
		//add labels and button panel to panel two
		twoPanel.add(vl5);
		twoPanel.add(threePanel);
		twoPanel.add(vl);
		
		// adjust label fonts
		vl.setFont(f3);
		vl5.setFont(f1);
		


	// calculation for mg/kg/day	
		dayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// gather and convert information to double
				String wtText = weightField.getText();
				double wt = Double.valueOf(wtText);
				
				String conText = conField.getText();
				double con = Double.valueOf(conText);
				
				String volText = volField.getText();
				double vol = Double.valueOf(volText);
				
				String totVolText = totVolField.getText();
				double totVol = Double.valueOf(totVolText);
				
				String rateText = rateField.getText();
				double rate = Double.valueOf(rateText);
				
				// calculation for the CRI
				double tempNum;
				
				tempNum = (con * vol) / totVol;
				tempNum = (tempNum / wt) * rate;
				
				double criCompleate = tempNum * 24;
				
				//set label for correct calculation of the CRI
				vl.setText(rate + " ml/hr = " + criCompleate + " mg/kg/day");
				

			}
		});
		
	//calculation for mg/kg/hr	
		hrButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// gather and convert information to double
				String wtText = weightField.getText();
				double wt = Double.valueOf(wtText);
				
				String conText = conField.getText();
				double con = Double.valueOf(conText);
				
				String volText = volField.getText();
				double vol = Double.valueOf(volText);
				
				String totVolText = totVolField.getText();
				double totVol = Double.valueOf(totVolText);
				
				String rateText = rateField.getText();
				double rate = Double.valueOf(rateText);
				
				// calculation for the CRI
				double tempNum;
				
				tempNum = (con * vol) / totVol;
				double criCompleate = (tempNum / wt) * rate;
				
				//set label for correct calculation of the CRI
				vl.setText(rate + " ml/hr = " + criCompleate + " mg/kg/hr");
				
			}
		});
		
	} // ends medCalc
	
} // ends Check CRI
