package data;

class ContinuousAttribute extends Attribute {
	private double max;
	private double min;

	public ContinuousAttribute(String name, int index, double min, double max) {
		super(name, index);
		this.max = max;
		this.min = min;
	}

	public double getScaledValue(double v) {
		double v1 = (v - min) / (max - min);
		return v1;
	}

}