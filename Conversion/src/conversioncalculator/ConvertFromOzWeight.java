/**
 * 
 */
package conversioncalculator;

/**
 * @author Brian
 *
 */
public class ConvertFromOzWeight extends Conversion{

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
		if(unit.equals("oz")){
			result = value;
		}else if(unit.equals("kg")){
			result = value / 35.274;
		}else if(unit.equals("g")){
			result = value / 0.035274;
		}else if(unit.equals("lb")){
			result = value * 0.062500;
		}
		return result;
	}

}
