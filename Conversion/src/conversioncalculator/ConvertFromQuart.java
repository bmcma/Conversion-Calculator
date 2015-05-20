package conversioncalculator;
/**
 * 
 * @author Brian McMahon
 * Class to implement conversions from quarts units. Extends Conversion superclass
 *
 */

public class ConvertFromQuart extends Conversion{
	//setters and getters for user input values
	@Override
	public void setValue(double value) {
		this.value=value;
	}

	@Override
	public double getValue() {
		return value;
	}
	//method to convert from quarts to other units
	@Override
	public double convertTo(String unit) {
		if(unit.equals("quart")){
			result = value;
		}else if(unit.equals("ml")){
			result = value / 0.0010567;
		}else if(unit.equals("gallon")){
			result = value * 0.25000;
		}else if (unit.equals("cup")){
			result = value * 4.0000;
		}else if(unit.equals("pint")){
			result = value * 2.0000;
		}else if(unit.equals("oz")){
			result = value * 32.000;
		}else if (unit.equals("litre")){
			result = value / 1.0567;
		}else if(unit.equals("tbsp")){
			result = value * 64.000;
		}else if(unit.equals("tsp")){
			result = value * 192.00;
		}
		return result;
	}


}
