import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * 
 * The main screen for the program with button options for guides to calculate CRI or medication volume and diluent.
 *  
 */

public class mainScreen implements ActionListener {
	JTextArea text;

	public static void main(String[] args) {
		mainScreen gui = new mainScreen();
		gui.setup();
	} // end main
	
	public void setup() {
		//create main frame and a label for selections
		JFrame mFrame = new JFrame("Medical Dose Calculator");
		JLabel selectLabel = new JLabel("", JLabel.LEFT);

		//grid for the buttons 
		GridLayout layout = new GridLayout(0,3);
		layout.setHgap(10);
		layout.setVgap(10);
		
		//panel to put buttons on and one button for each of the selections
		JPanel buttonPanel = new JPanel(); 
		JButton oneButton = new JButton("1");
		JButton twoButton = new JButton("2");
		JButton threeButton = new JButton("3");
		
		//action listeners for each button
		oneButton.addActionListener(this);
		twoButton.addActionListener(this);
		threeButton.addActionListener(this);
		
		oneButton.setActionCommand("1");
		twoButton.setActionCommand("2");
		threeButton.setActionCommand("3");
		
		//add text to the selection label
		selectLabel.setText("<html>Select: <br/> 1: For calculation of medication and diluent.<br/>"
				+ " 2: For checking calculation of a Constant Rate Infusion (CRI).<br/>"
				+ " 3: For calculation of a Constant Rate Infusion (CRI). <html>");
		
		//adjust font for selection label
		Font f1 = new Font("Times New Roman", Font.BOLD, 20);
		selectLabel.setFont(f1);
		
		//place the selection label and button panel on the main frame
		mFrame.getContentPane().add(BorderLayout.NORTH, selectLabel); 
		mFrame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);

		//set the button panel layout to a grid and add buttons to it
		buttonPanel.setLayout(layout);
		buttonPanel.add(oneButton);
		buttonPanel.add(twoButton);
		buttonPanel.add(threeButton);
		
		//set main frame to close on exit and adjust size
		mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mFrame.setSize(550, 200);
		mFrame.setVisible(true);

	} // end setup
		
	public void actionPerformed (ActionEvent event) {
		String command = event.getActionCommand();
		
		//open medication and diluent calculation class
		if (command.equals("1")) {
//			System.out.println("Button 1 Clicked \n");  //test for button 1
			MedAndDiluent.medCalc();
			
		//open Check CRI class	
		}else if (command.equals ("2")) {
//			System.out.println("Button 2 Clicked \n");  //test for button 2
			CheckCRI.medCalc();
			
		//open CRI calculation class
		}else {
//			System.out.println("Button 3 Clicked \n");  //test for button 3
			CalculateCRI.medCalc();
		}
	} // end actionPerformed

} // ends mainScreen 
