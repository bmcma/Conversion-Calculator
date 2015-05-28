/**
 * 
 */
package conversioncalculator;

/**
 * @author Brian
 *
 */
public class ConvertFromPound extends Conversion{

	@Override
	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public double getValue() {
		return value;
	}

	@Override
	public double convertTo(String unit) {
		if(unit.equals("lb")){
			result = value;
		}else if(unit.equals("g")){
			result = value / 0.0022046;
		}else if(unit.equals("oz")){
			result = value * 16.000;
		}else if(unit.equals("kg")){
			result = value / 2.2046;
		}
		return result;
	}
}
