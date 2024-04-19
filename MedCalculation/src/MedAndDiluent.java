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
 * Calculation of Medication and Diluent with a walk through of how to do the calculations.
 * Will work for both medication's the require dilution and those that do not.
 * 
 */

public class MedAndDiluent {
	
	public static void medCalc () {
		
		// set up the frame and panels, and labels
		JFrame oneFrame = new JFrame("Medication and Diluent Calculation");
		JPanel onePanel = new JPanel();
		JPanel twoPanel = new JPanel();
		JPanel threePanel = new JPanel();
		JLabel oneLabel = new JLabel("", JLabel.LEFT);
		
		// add text field for gathering information
		JTextField weightField = new JTextField(30);
		JTextField conField = new JTextField(30);
		JTextField doseField = new JTextField(30);
		JTextField desConField = new JTextField(30);

		// add labels for the text field
		JLabel weightLabel = new JLabel("Enter the pt weight in kg.");
		JLabel conLabel = new JLabel("Enter the concentration of the medication in mg/ml.");
		JLabel doseLabel = new JLabel("Enter the medication dose in mg/kg.");
		JLabel desConLabel = new JLabel("Enter the desired concentration of the medication in mg/kg.");
		
		//adjust font for labels
		Font f1 = new Font("Times New Roman", Font.BOLD, 15);
		Font f2 = new Font("Times New Roman", Font.BOLD, 20);
		Font f3 = new Font("Times New Roman", Font.PLAIN, 15);
		weightLabel.setFont(f1);
		conLabel.setFont(f1);
		doseLabel.setFont(f1);
		desConLabel.setFont(f1);
		oneLabel.setFont(f2);
						
		// add a label and 2 panels to the frame
		oneLabel.setText("You clicked 1: For calculation of medication and diluent.");
		oneFrame.getContentPane().add(BorderLayout.NORTH, oneLabel);
		oneFrame.getContentPane().add(BorderLayout.CENTER, onePanel);
		oneFrame.getContentPane().add(BorderLayout.SOUTH, twoPanel);

		// set frame to hide on close and set the size
		oneFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		oneFrame.setSize(800,600);
		oneFrame.setVisible(true);
		
		// create a grid for gathering info.
		GridLayout oneLayout = new GridLayout(4,2);
		oneLayout.setHgap(10);
		oneLayout.setVgap(10);
		
		// create a grid for space to explain calculations 
		GridLayout twoLayout = new GridLayout(15,0);
		oneLayout.setHgap(10);
		oneLayout.setVgap(10);
		
		// add a grid for buttons if dilution needed or not
		GridLayout buttonLayout = new GridLayout(0,2);
		oneLayout.setHgap(10);
		oneLayout.setVgap(10);		
		
		// set the panels to the grid layouts
		onePanel.setLayout(oneLayout);
		twoPanel.setLayout(twoLayout);
		threePanel.setLayout(buttonLayout);
		
		// Weight of pt added to panel	
		onePanel.add(weightLabel);
		onePanel.add(weightField);
		
		// Concentration of drug added to panel
		onePanel.add(conLabel);
		onePanel.add(conField);
		
		// Dose of the drug	added to panel
		onePanel.add(doseLabel);
		onePanel.add(doseField);

		// Desired concentration of drug added to panel
		onePanel.add(desConLabel);
		onePanel.add(desConField);
		
		// list of labels for adding text later on (for explaining calculation)
		JLabel vl = new JLabel();
		JLabel vl2 = new JLabel();
		JLabel vl3 = new JLabel();
		JLabel vl4 = new JLabel();
		
		// label to add question
		JLabel vl5 = new JLabel("Do you need to Dilute this medication?");
		vl5.setFont(f1);
		
		// list of labels for adding text later on (for explaining calculation)
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
		vl6.setFont(f3);
		vl7.setFont(f3);
		vl8.setFont(f3);
		vl9.setFont(f3);
		vl10.setFont(f3);
		vl11.setFont(f3);
		vl12.setFont(f3);
		vl13.setFont(f3);
		
		// buttons for dilution. yes or no
		JButton yesButton = new JButton("Yes");
		JButton noButton = new JButton("No");
		
		// add buttons to panel
		threePanel.add(yesButton); 
		threePanel.add(noButton);
	
		// create an enter button 
		JButton enterButton = new JButton("Enter");
		
		//add labels and buttons to the panel 
		twoPanel.add(enterButton);
		twoPanel.add(vl);
		twoPanel.add(vl2);
		twoPanel.add(vl3);
		twoPanel.add(vl4);
		twoPanel.add(vl5);
		
		twoPanel.add(threePanel);
		twoPanel.add(vl6);
		twoPanel.add(vl7);
		twoPanel.add(vl8);
		twoPanel.add(vl9);
		twoPanel.add(vl10);
		twoPanel.add(vl11);
		twoPanel.add(vl12);
		twoPanel.add(vl13);
	
		// action for the yes button
		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// get all required information from text field and convert to a double 
				String wtText = weightField.getText();
				double wt = Double.valueOf(wtText);
				
				String conText = conField.getText();
				double con = Double.valueOf(conText);
				
				String doseText = doseField.getText();
				double dose = Double.valueOf(doseText);
				
				String desConText = desConField.getText();
				double desCon = Double.valueOf(desConText);
				
				// calculation for volume of medication needed
				double medVol = (wt * dose) / con;
				
				// calculation for volume of diluent needed
				double dilVol = ((medVol * con) / desCon) - medVol;
				
				// temp values needed for explanation 
				double exTemp2 = medVol * con;
				double exTemp3 = exTemp2 / desCon;
					
				// set labels to text/values to explain the calculation of med and diluent volume			
				vl6.setText("To get the amount of diluent. First multiply the volume of the medication by the concentration of the medication.");
				vl7.setText(medVol + " ml * " + con + " mg/ml = " + exTemp2 + " mg");
				vl8.setText("Next divide the mg of the medication by the desired concentration.");
				vl9.setText(exTemp2 + " mg / " + desCon + " mg/ml = " + exTemp3 + " ml");
				vl10.setText("Now subtract the total volume by the volume of the medication to get the amount of diluent needed.");
				vl11.setText(exTemp3 + " ml - " + medVol + " ml = " + dilVol + " ml");
				vl12.setText("Amount of the medication to be given is: " + medVol + " mls");
				vl13.setText("Amount of diluent to be used is: " + dilVol + " mls \n");

			}
		});
		
		// action for the no button
		noButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// get all required information from text field and convert to a double
				String wtText = weightField.getText();
				double wt = Double.valueOf(wtText);
				
				String conText = conField.getText();
				double con = Double.valueOf(conText);
				
				String doseText = doseField.getText();
				double dose = Double.valueOf(doseText);
				
				// calculate the volume of medication
				double medVol = (wt * dose) / con;
				
				// set labels
				vl6.setText("If no dilution required then no further  steps needed.");
				vl7.setText("Amount of the medication to be given is: " + medVol + " mls");
				vl8.setText("");
				vl9.setText("");
				vl10.setText("");
				vl11.setText("");
				vl12.setText("");
				vl13.setText("");
			}
		});
		
		// action for the enter button
		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// get all required information from text field and convert to a double
				String wtText = weightField.getText();
				double wt = Double.valueOf(wtText);
				
				String conText = conField.getText();
				double con = Double.valueOf(conText);
				
				String doseText = doseField.getText();
				double dose = Double.valueOf(doseText);

				// calculate the volume of medication needed								
				double medVol = (wt * dose) / con;
				
				// temp value used for explanation
				double exTemp = wt * dose;
				
				//set labels with text/values for explanation of calculation
				vl.setText("First take the pt weight and multiply it by the medication dose.");
				vl2.setText(wt + " kg * " + dose + " mg/kg = " + exTemp + " mg");
				vl3.setText("Next take the mg of medication and divid it by the medications concentration.");
				vl4.setText(exTemp + " mg / " + con + " mg/ml = " + medVol + " ml");

			}
		});
		
	} // end medCalc

} // end MedAndDiluent
