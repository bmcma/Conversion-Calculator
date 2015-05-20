package conversioncalculator;

/**
 * @Author Brian McMahon
 * Launcher class to run the Calculator Application
 */

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CalculatorLauncher extends JFrame{
	
	public static void main (String[] args){
		
		ConversionLayout l = new ConversionLayout();
		
		JFrame frame = new JFrame("Conversion Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setLayout(new GridLayout (3, 1, 0, 5));
		frame.getContentPane().add(l.topPanel);
		frame.getContentPane().add(l.calcInput);
				
		frame.pack();
		frame.setVisible(true);
				
	}

}
