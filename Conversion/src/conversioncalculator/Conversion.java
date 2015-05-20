package conversioncalculator;
/**
 * @author Brian McMahon
 * Abstract class conversions
 * All conversion factors sourced from http://www.metric-conversions.org/weight/grams-conversion-table.htm
 */

public abstract class Conversion {

	double value;
	double result;


	public Conversion(){}
	
	public abstract void setValue(double value);
	
	public abstract double getValue();

	public abstract double convertTo(String value);
	

}
