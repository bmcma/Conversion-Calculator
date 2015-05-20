package conversioncalculator;

/**
 * 
 * @author Brian McMahon
 * Class to implement conversions from gallon units. Extends Conversion superclass
 *
 */

public class ConvertFromGallon extends Conversion{

	//setters and getters for user input values
	@Override
	public void setValue(double value) {
		this.value=value;
	}

	@Override
	public double getValue() {
		return value;
	}
	
	//method to convert from gallons to other units
	@Override
	public double convertTo(String unit) {
		if(unit.equals("gallon")){
			result = value;
		}else if(unit.equals("ml")){
			result = value/0.00026417;
		}else if(unit.equals("litre")){
			result = value/0.26417;
		}else if (unit.equals("cup")){
			result = value * 16.000;
		}else if(unit.equals("pint")){
			result = value * 8.0000;
		}else if(unit.equals("oz")){
			result = value * 128.00;
		}else if (unit.equals("quart")){
			result = value * 4.000;
		}else if(unit.equals("tbsp")){
			result = value * 256.00;
		}else if(unit.equals("tsp")){
			result = value * 768.00;
		}
		return result;
	}

}
