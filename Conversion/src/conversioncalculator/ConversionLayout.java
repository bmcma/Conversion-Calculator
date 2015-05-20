package conversioncalculator;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * @author Brian McMahon Conversion Layout class to develop the Swing components
 *         and implement Event Listeners
 */

/*
 * TODO finish error handling TODO TextField updates on typing?  TODO Add weight and volume radio buttons and
 * switch JComboBoxes - Add relevant classes
 */

public class ConversionLayout {
	NumberFormat df = new DecimalFormat("#.#####");
	JComboBox<?> fromSelection;
	JComboBox<?> toSelection;
	JTextField userInput1;
	JTextField userInput2;
	JLabel topLabel;
	JLabel equals;
	JPanel topPanel;
	JPanel calcInput;
	String[] fromUnits;
	String unit1;
	String unit2;
	String result;
	double amountValue;
	Conversion ml = new ConvertFromMillilitre();
	Conversion cup = new ConvertFromCup();
	Conversion gallon = new ConvertFromGallon();
	Conversion litre = new ConvertFromLitre();
	Conversion oz = new ConvertFromOz();
	Conversion pint = new ConvertFromPint();
	Conversion quart = new ConvertFromQuart();
	Conversion tbsp = new ConvertFromTbsp();
	Conversion tsp = new ConvertFromTsp();

	public ConversionLayout() {
		equals = new JLabel("=");
		equals.setHorizontalAlignment(SwingConstants.CENTER);
		userInput1 = new JTextField();
		userInput2 = new JTextField();

		fromUnits = new String[] { "ml", "litre", "oz", "cup", "pint", "tbsp",
				"tsp", "gallon", "quart" };
		fromSelection = new JComboBox<String>(fromUnits);

		toSelection = new JComboBox<String>(fromUnits);

		calcInput = new JPanel(new GridLayout(1, 5));

		calcInput.add(fromSelection);
		calcInput.add(userInput1);
		calcInput.add(equals);
		calcInput.add(toSelection);
		calcInput.add(userInput2);

		topLabel = new JLabel("Please enter your selections below:");
		topPanel = new JPanel();
		topPanel.add(topLabel);

		addFromSelection();
		addToSelection();

		UserEntries entry = new UserEntries();
		userInput1.addActionListener(entry);
		userInput2.addActionListener(entry);

	}// end layout constructor

	// ActionListener to set the value of the userInput1 field based on user
	// selection
	public void addFromSelection() {
		fromSelection.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String selection = (String) fromSelection.getSelectedItem();
				// check the unit user selects from JComboBox and set the value
				// to unit1
				switch (selection) {
				case "litre":
					unit1 = "litre";
					break;
				case "oz":
					unit1 = "oz";
					break;
				case "cup":
					unit1 = "cup";
					break;
				case "pint":
					unit1 = "pint";
					break;
				case "ml":
					unit1 = "ml";
					break;
				case "tbsp":
					unit1 = "tbsp";
					break;
				case "tsp":
					unit1 = "tsp";
					break;
				case "gallon":
					unit1 = "gallon";
					break;
				case "quart":
					unit1 = "quart";
					break;
				}
				// System.out.println(unit1);

			}
		});
	}

	// ActionListener to set the value of the userInput2 field based on user
	// selection
	public void addToSelection() {
		toSelection.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String selection = (String) toSelection.getSelectedItem();
				// check the unit user selects from JComboBox and set the value
				// to unit2
				switch (selection) {
				case "litre":
					unit2 = "litre";
					break;
				case "oz":
					unit2 = "oz";
					break;
				case "cup":
					unit2 = "cup";
					break;
				case "pint":
					unit2 = "pint";
					break;
				case "ml":
					unit2 = "ml";
					break;
				case "tbsp":
					unit2 = "tbsp";
					break;
				case "tsp":
					unit2 = "tsp";
					break;
				case "gallon":
					unit2 = "gallon";
					break;
				case "quart":
					unit2 = "quart";
					break;
				}

				// System.out.println(unit2);
			}

		});
	}

	// sets the values for userInput to each conversion unit
	public void setValues(double userInput) {

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
	}

	// class for setting user input values on either JTextField
	private class UserEntries implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
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
				try {
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
					}
					// catches exception is user does not select conversion
					// units
				} catch (NullPointerException ex) {
					fromSelection.setSelectedItem("ml");
					JOptionPane.showMessageDialog(topPanel,
							"Please make unit selections.");
				}
				// if userInput2 triggers ActionEvent we check for unit2 value
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
				try {
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
					}
					// catches exception is user does not select conversion
					// units
				} catch (NullPointerException ex) {
					JOptionPane.showMessageDialog(topPanel,
							"Please make unit selections.");
				}
			}
		}
	}// end UserEntries

}// end ConversionLayout
