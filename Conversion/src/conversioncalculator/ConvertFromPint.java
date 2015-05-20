package conversioncalculator;
/**
 * 
 * @author Brian McMahon
 * Class to implement conversions from pints units. Extends Conversion superclass
 *
 */

public class ConvertFromPint extends Conversion{

	//setters and getters for user input values
	@Override
	public void setValue(double value) {
		this.value=value;
	}

	@Override
	public double getValue() {
		return value;
	}
	//method to convert from pints to other units
	@Override
	public double convertTo(String unit) {
		if(unit.equals("pint")){
			result = value;
		}else if(unit.equals("ml")){
			result = value / 0.0021134;
		}else if(unit.equals("gallon")){
			result = value * 0.12500;
		}else if (unit.equals("cup")){
			result = value * 2.0000;
		}else if(unit.equals("oz")){
			result = value * 16.000;
		}else if(unit.equals("litre")){
			result = value / 2.1134;
		}else if (unit.equals("quart")){
			result = value * 0.50000;
		}else if(unit.equals("tbsp")){
			result = value * 32.000;
		}else if(unit.equals("tsp")){
			result = value * 96.000;
		}
		return result;
	}

}
