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
	VolumeConversionFactory volumeFactory = new VolumeConversionFactory();
	Conversion volumeUnits;
	WeightConversionFactory weightFactory = new WeightConversionFactory();
	Conversion weightUnits;

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
		volume.setSelected(true);// sets default selection to volume
		radioPanel = new JPanel(new GridLayout(0, 2));
		radioPanel.add(volume);
		radioPanel.add(weight);

		// adds the units for volume calculations when the volume JRadioButton
		// is selected
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

		// adds the units for weight calculations when the weight JRadioButton
		// is selected
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

	// sets the default selection on startup
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

	// calls the relevant calculation based on unit selection and user input
	// values
	public void calculate(String result, Conversion converter, String unit,
			JTextField field) {
		result = String.valueOf(converter.convertTo(unit));// calls calculation
		field.setText(df.format(Double.parseDouble(result)));// sets the result
																// in JTextField
	}

	// class for setting user input values on either JTextField
	private class UserEntries implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// if the volume JRadioButton is selected we will run the switch on
			// volume units.
			if (volume.isSelected()) {

				// if userInput1 triggers ActionEvent we check for unit1 value
				// and
				// convert to unit2 value
				if (e.getSource() == userInput1) {
					volumeUnits = volumeFactory.getVolumeConversion(unit1);
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
					// sets the userInput value to the relevant volume unit for
					// unit1
					volumeUnits.setValue(amountValue);
					volumeUnits.getValue();
					// checks for selected unit value and calls the calculate
					// method on the relevant unit
					switch (unit1) {
					case "ml":
						calculate(result, volumeUnits, unit2, userInput2);
						break;
					case "cup":
						calculate(result, volumeUnits, unit2, userInput2);
						break;
					case "gallon":
						calculate(result, volumeUnits, unit2, userInput2);
						break;
					case "litre":
						calculate(result, volumeUnits, unit2, userInput2);
						break;
					case "oz":
						calculate(result, volumeUnits, unit2, userInput2);
						break;
					case "pint":
						calculate(result, volumeUnits, unit2, userInput2);
						break;
					case "quart":
						calculate(result, volumeUnits, unit2, userInput2);
						break;
					case "tbsp":
						calculate(result, volumeUnits, unit2, userInput2);
						break;
					case "tsp":
						calculate(result, volumeUnits, unit2, userInput2);
						break;

					}// end switch

					// if userInput2 triggers ActionEvent we check for unit2
					// value
					// and convert to unit1 value
				} else if (e.getSource() == userInput2) {
					volumeUnits = volumeFactory.getVolumeConversion(unit2);
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
					// sets the userInput value to the relevant volume unit for
					// unit2
					volumeUnits.setValue(amountValue);
					volumeUnits.getValue();
					// checks for selected unit value and calls the calculate
					// method on the relevant unit
					switch (unit2) {
					case "ml":
						calculate(result, volumeUnits, unit1, userInput1);
						break;
					case "cup":
						calculate(result, volumeUnits, unit1, userInput1);
						break;
					case "gallon":
						calculate(result, volumeUnits, unit1, userInput1);
						break;
					case "litre":
						calculate(result, volumeUnits, unit1, userInput1);
						break;
					case "oz":
						calculate(result, volumeUnits, unit1, userInput1);
						break;
					case "pint":
						calculate(result, volumeUnits, unit1, userInput1);
						break;
					case "quart":
						calculate(result, volumeUnits, unit1, userInput1);
						break;
					case "tbsp":
						calculate(result, volumeUnits, unit1, userInput1);
						break;
					case "tsp":
						calculate(result, volumeUnits, unit1, userInput1);
						break;
					}// end switch
				}// end inner if/else
				// if the weight JRadioButton is selected we will run the switch
				// on weight units.
			} else if (weight.isSelected()) {
				// if userInput1 triggers ActionEvent we check for unit1
				// value and convert to unit2 value
				if (e.getSource() == userInput1) {
					weightUnits = weightFactory.getWeightConversion(unit1);
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
					// sets the userInput value to the relevant weight unit for
					// unit1
					weightUnits.setValue(amountValue);
					weightUnits.getValue();
					// checks for selected unit value and calls the calculate
					// method on the relevant unit
					switch (unit1) {
					case "g":
						calculate(result, weightUnits, unit2, userInput2);
						break;
					case "kg":
						calculate(result, weightUnits, unit2, userInput2);
						break;
					case "oz":
						calculate(result, weightUnits, unit2, userInput2);
						break;
					case "lb":
						calculate(result, weightUnits, unit2, userInput2);
						break;
					}// end switch
						// if userInput2 triggers ActionEvent we check for unit2
						// value and convert to unit1 value
				} else if (e.getSource() == userInput2) {
					weightUnits = weightFactory.getWeightConversion(unit2);
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
					// sets the userInput value to the relevant weight unit for
					// unit2
					weightUnits.setValue(amountValue);
					weightUnits.getValue();
					// checks for selected unit value and calls the calculate
					// method on the relevant unit
					switch (unit2) {
					case "g":
						calculate(result, weightUnits, unit1, userInput1);
						break;
					case "kg":
						calculate(result, weightUnits, unit1, userInput1);
						break;
					case "oz":
						calculate(result, weightUnits, unit1, userInput1);
						break;
					case "lb":
						calculate(result, weightUnits, unit1, userInput1);
						break;
					}// end switch
				}// end inner if/else
			}// end outer if/else for JRadioButton selections
		}// end ActionPerformed
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
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ConversionLayout run = new ConversionLayout();
				run.buildGui();
			}
		});
	}// end main

}// end ConversionLayout
