package conversioncalculator;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 * @author Brian McMahon Conversion Layout class to develop the Swing components
 *         and implement Event Listeners
 */

/*
 * TODO TextField updates on typing? TODO Conversion updates when new unit is
 * selected. ie don't have to hit enter again
 * TODO add weight values to switch statement and move to another method and call from here passing in parameters.
 */

public class ConversionLayout {
	NumberFormat df = new DecimalFormat("#.#####");
	private JRadioButton volume = new JRadioButton("volume");
	private JRadioButton weight = new JRadioButton("weight");
	private JComboBox<String> selection1 = new JComboBox<String>();
	private JComboBox<String> selection2 = new JComboBox<String>();
	private DefaultComboBoxModel<String> unitSet1 = new DefaultComboBoxModel<String>();
	private DefaultComboBoxModel<String> unitSet2 = new DefaultComboBoxModel<String>();
	private JTextField userInput1;
	private JTextField userInput2;
	private JLabel topLabel;
	private JLabel equals;
	private JPanel topPanel;
	private JPanel calcInput;
	private JPanel radioPanel;
	private String[] units = { "ml", "litre", "oz", "cup", "pint", "tbsp",
			"tsp", "gallon", "quart" };
	private String[] units1 = { "g", "kg", "oz", "lb" };
	private String unit1;
	private String unit2;
	private String result;
	private double amountValue;
	private Conversion ml = new ConvertFromMillilitre();
	private Conversion cup = new ConvertFromCup();
	private Conversion gallon = new ConvertFromGallon();
	private Conversion litre = new ConvertFromLitre();
	private Conversion oz = new ConvertFromOz();
	private Conversion pint = new ConvertFromPint();
	private Conversion quart = new ConvertFromQuart();
	private Conversion tbsp = new ConvertFromTbsp();
	private Conversion tsp = new ConvertFromTsp();
	private Conversion g = new ConvertFromGram();
	private Conversion kg = new ConvertFromKilogram();
	private Conversion ozWeight = new ConvertFromOzWeight();
	private Conversion lb = new ConvertFromPound();

	public ConversionLayout() {
		equals = new JLabel("=");
		equals.setHorizontalAlignment(SwingConstants.CENTER);
		userInput1 = new JTextField();
		userInput2 = new JTextField();

		for (int i = 0; i < units.length; i++) {
			unitSet1.addElement(units[i]);
			unitSet2.addElement(units[i]);
		}

		selection1.setModel(unitSet1);
		selection2.setModel(unitSet2);
		ButtonGroup group = new ButtonGroup();
		group.add(volume);
		group.add(weight);
		volume.setSelected(true);
		radioPanel = new JPanel(new GridLayout(0, 2));
		radioPanel.add(volume);
		radioPanel.add(weight);

		volume.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				unitSet1.removeAllElements();
				unitSet2.removeAllElements();
				for (int i = 0; i < units.length; i++) {
					unitSet1.addElement(units[i]);
					unitSet2.addElement(units[i]);
				}
			}

		});

		weight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				unitSet1.removeAllElements();
				unitSet2.removeAllElements();
				for (int i = 0; i < units1.length; i++) {
					unitSet1.addElement(units1[i]);
					unitSet2.addElement(units1[i]);
				}
			}

		});

		setDefaultValues("ml", "ml");

		calcInput = new JPanel(new GridLayout(1, 5));

		calcInput.add(selection1);
		calcInput.add(userInput1);
		calcInput.add(equals);
		calcInput.add(selection2);
		calcInput.add(userInput2);

		topLabel = new JLabel("Please enter your selections below:");
		topPanel = new JPanel();
		topPanel.add(topLabel);

		unitSelections();

		UserEntries entry = new UserEntries();
		userInput1.addActionListener(entry);
		userInput2.addActionListener(entry);

	}// end layout constructor

	private void setDefaultValues(String val1, String val2) {
		if (unit1 == null) {
			this.unit1 = val1;
			this.unit2 = val2;
		}
	}

	// ItemListener to set the value of the unit1 and unit2 fields based on user
	// selections
	private void unitSelections() {
		selection1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String selection = selection1.getSelectedItem().toString();
					unit1 = selection;
				}
			}
		});

		selection2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String selection = selection2.getSelectedItem().toString();
					unit2 = selection;
				}
			}
		});
	}

	// sets the values for userInput to each conversion unit
	private void setValues(double userInput) {
		ml.setValue(userInput);
		ml.getValue();

		cup.setValue(userInput);
		cup.getValue();

		gallon.setValue(userInput);
		gallon.getValue();

		litre.setValue(userInput);
		litre.getValue();

		oz.setValue(userInput);
		oz.getValue();

		pint.setValue(userInput);
		pint.getValue();

		quart.setValue(userInput);
		quart.getValue();

		tbsp.setValue(userInput);
		tbsp.getValue();

		tsp.setValue(userInput);
		tsp.getValue();

		tsp.setValue(userInput);
		tsp.getValue();

		g.setValue(userInput);
		g.getValue();

		kg.setValue(userInput);
		kg.getValue();

		ozWeight.setValue(userInput);
		ozWeight.getValue();

		lb.setValue(userInput);
		lb.getValue();
	}
	

	// class for setting user input values on either JTextField
	private class UserEntries implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//if the volume JRadioButton is selected we will run the switch on volume units.
			if (volume.isSelected()) {
				// if userInput1 triggers ActionEvent we check for unit1 value and
				// convert to unit2 value
				if (e.getSource() == userInput1) {
					String value = userInput1.getText();
					// ensure entry is a numerical value
					try {
						amountValue = Double.parseDouble(value);
						if (amountValue < 0) {
							throw new NumberFormatException();
						}
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(userInput1,
								"Please enter a numeric value to convert.");
					}
					// sets the userInput value to the unit1
					setValues(amountValue);
					switch (unit1) {
					case "ml":
						result = String.valueOf(ml.convertTo(unit2));
						userInput2
								.setText(df.format(Double.parseDouble(result)));
						break;
					case "cup":
						result = String.valueOf(cup.convertTo(unit2));
						userInput2
								.setText(df.format(Double.parseDouble(result)));
						break;
					case "gallon":
						result = String.valueOf(gallon.convertTo(unit2));
						userInput2
								.setText(df.format(Double.parseDouble(result)));
						break;
					case "litre":
						result = String.valueOf(litre.convertTo(unit2));
						userInput2
								.setText(df.format(Double.parseDouble(result)));
						break;
					case "oz":
						result = String.valueOf(oz.convertTo(unit2));
						userInput2
								.setText(df.format(Double.parseDouble(result)));
						break;
					case "pint":
						result = String.valueOf(pint.convertTo(unit2));
						userInput2
								.setText(df.format(Double.parseDouble(result)));
						break;
					case "quart":
						result = String.valueOf(quart.convertTo(unit2));
						userInput2
								.setText(df.format(Double.parseDouble(result)));
						break;
					case "tbsp":
						result = String.valueOf(tbsp.convertTo(unit2));
						userInput2
								.setText(df.format(Double.parseDouble(result)));
						break;
					case "tsp":
						result = String.valueOf(tsp.convertTo(unit2));
						userInput2
								.setText(df.format(Double.parseDouble(result)));
						break;

					}//end switch

					// if userInput2 triggers ActionEvent we check for unit2
					// value
					// and convert to unit1 value
				} else if (e.getSource() == userInput2) {
					String value = userInput2.getText();
					try {
						amountValue = Double.parseDouble(value);
						if (amountValue < 0) {
							throw new NumberFormatException();
						}
					} catch (NumberFormatException ex) {
						JOptionPane
								.showMessageDialog(userInput2,
										"Please enter a positive numeric value to convert.");
					}
					// sets the userInput value to the units
					setValues(amountValue);
					switch (unit2) {
					case "ml":
						result = String.valueOf(ml.convertTo(unit1));
						userInput1
								.setText(df.format(Double.parseDouble(result)));
						break;
					case "cup":
						result = String.valueOf(cup.convertTo(unit1));
						userInput1
								.setText(df.format(Double.parseDouble(result)));
						break;
					case "gallon":
						result = String.valueOf(gallon.convertTo(unit1));
						userInput1
								.setText(df.format(Double.parseDouble(result)));
						break;
					case "litre":
						result = String.valueOf(litre.convertTo(unit1));
						userInput1
								.setText(df.format(Double.parseDouble(result)));
						break;
					case "oz":
						result = String.valueOf(oz.convertTo(unit1));
						userInput1
								.setText(df.format(Double.parseDouble(result)));
						break;
					case "pint":
						result = String.valueOf(pint.convertTo(unit1));
						userInput1
								.setText(df.format(Double.parseDouble(result)));
						break;
					case "quart":
						result = String.valueOf(quart.convertTo(unit1));
						userInput1
								.setText(df.format(Double.parseDouble(result)));
						break;
					case "tbsp":
						result = String.valueOf(tbsp.convertTo(unit1));
						userInput1
								.setText(df.format(Double.parseDouble(result)));
						break;
					case "tsp":
						result = String.valueOf(tsp.convertTo(unit1));
						userInput1
								.setText(df.format(Double.parseDouble(result)));
						break;
					}//end switch
				}//end inner if/else
			//if the weight JRadioButton is selected we will run the switch on weight units.	
			} else if (weight.isSelected()) {
				// if userInput1 triggers ActionEvent we check for unit1
				// value and convert to unit2 value
				if (e.getSource() == userInput1) {
					String value = userInput1.getText();
					// ensure entry is a numerical value
					try {
						amountValue = Double.parseDouble(value);
						if (amountValue < 0) {
							throw new NumberFormatException();
						}
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(userInput1,
								"Please enter a numeric value to convert.");
					}
					// sets the userInput value to the unit1
					setValues(amountValue);
					switch (unit1) {
					case "g":
						result = String.valueOf(g.convertTo(unit2));
						userInput2
								.setText(df.format(Double.parseDouble(result)));
						break;
					case "kg":
						result = String.valueOf(kg.convertTo(unit2));
						userInput2
								.setText(df.format(Double.parseDouble(result)));
						break;
					case "oz":
						result = String.valueOf(ozWeight.convertTo(unit2));
						userInput2
								.setText(df.format(Double.parseDouble(result)));
						break;
					case "lb":
						result = String.valueOf(lb.convertTo(unit2));
						userInput2
								.setText(df.format(Double.parseDouble(result)));
						break;
					}//end switch
					// if userInput2 triggers ActionEvent we check for unit2
					// value and convert to unit1 value
				} else if (e.getSource() == userInput2) {
					String value = userInput2.getText();
					try {
						amountValue = Double.parseDouble(value);
						if (amountValue < 0) {
							throw new NumberFormatException();
						}
					} catch (NumberFormatException ex) {
						JOptionPane
								.showMessageDialog(userInput2,
										"Please enter a positive numeric value to convert.");
					}
					// sets the userInput value to the units
					setValues(amountValue);
					switch (unit2) {
					case "g":
						result = String.valueOf(g.convertTo(unit1));
						userInput1
								.setText(df.format(Double.parseDouble(result)));
						break;
					case "kg":
						result = String.valueOf(kg.convertTo(unit1));
						userInput1
								.setText(df.format(Double.parseDouble(result)));
						break;
					case "oz":
						result = String.valueOf(ozWeight.convertTo(unit1));
						userInput1
								.setText(df.format(Double.parseDouble(result)));
						break;
					case "lb":
						result = String.valueOf(lb.convertTo(unit1));
						userInput1
								.setText(df.format(Double.parseDouble(result)));
						break;
					}//end switch
				}//end inner if/else
			}//end outer if/else for JRadioButton selections
		}//end ActionPerformed
	}// end UserEntries

	private void buildGui() {
		JFrame frame = new JFrame("Conversion Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(4, 1, 0, 5));
		frame.getContentPane().add(topPanel);
		frame.getContentPane().add(radioPanel);
		frame.getContentPane().add(calcInput);
		frame.setSize(400, 150);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				ConversionLayout run = new ConversionLayout();
				run.buildGui();
			}
		});
	}//end main

}// end ConversionLayout
