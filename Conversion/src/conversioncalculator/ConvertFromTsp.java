package conversioncalculator;
/**
 * 
 * @author Brian McMahon
 * Class to implement conversions from teaspoons units. Extends Conversion superclass
 *
 */

public class ConvertFromTsp extends Conversion{
	//setters and getters for user input values
	@Override
	public void setValue(double value) {
		this.value=value;
	}

	@Override
	public double getValue() {
		return value;
	}
	//method to convert from teaspoons to other units.
	@Override
	public double convertTo(String unit) {
		if(unit.equals("tsp")){
			result = value;
		}else if(unit.equals("ml")){
			result = value / 0.20288;
		}else if(unit.equals("gallon")){
			result = value * 0.0013021;
		}else if (unit.equals("cup")){
			result = value * 0.020833;
		}else if(unit.equals("pint")){
			result = value * 0.010417;
		}else if(unit.equals("oz")){
			result = value * 0.16667;
		}else if (unit.equals("litre")){
			result = value / 202.88;
		}else if(unit.equals("quart")){
			result = value * 0.0052083;
		}else if(unit.equals("tbsp")){
			result = value * 0.33333;
		}
		return result;
	}

}
