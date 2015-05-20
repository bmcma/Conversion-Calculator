package conversioncalculator;
/**
 * 
 * @author Brian McMahon
 * Class to implement conversions from tablespoons units. Extends Conversion superclass
 *
 */

public class ConvertFromTbsp extends Conversion{
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
		if(unit.equals("tbsp")){
			result = value;
		}else if(unit.equals("ml")){
			result = value / 0.067628;
		}else if(unit.equals("gallon")){
			result = value * 0.0039062;
		}else if (unit.equals("cup")){
			result = value * 0.062500;
		}else if(unit.equals("pint")){
			result = value * 0.031250;
		}else if(unit.equals("oz")){
			result = value * 0.50000;
		}else if (unit.equals("litre")){
			result = value / 67.628;
		}else if(unit.equals("quart")){
			result = value * 0.015625;
		}else if(unit.equals("tsp")){
			result = value * 3.000;
		}
		return result;
	}

}
