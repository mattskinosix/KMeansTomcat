package data;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Tuple implements Serializable {
	Item[] tuple;

	Tuple(int size) {
		tuple = new Item[size];
	}

	public int getLength() {
		return tuple.length;
	}

	public Item get(int i) {
		return tuple[i];
	}

	public void add(Item c, int i) {
		tuple[i] = c;
	}

	public double getDistance(Tuple obj) {
		double distance = 0;
		int i = 0;
		while (i < obj.getLength()) {// era this
			distance += obj.get(i).distance(get(i).getValue());// forse errore
			i++;
		}
		return distance;

	}

	public double avgDistance(Data data, Object[] array) {
		double p = 0.0, sumD = 0.0;
		for (int i = 0; i < array.length; i++) {
			double d = getDistance(data.getItemSet((int) array[i]));
			sumD += d;
		}
		p = sumD / array.length;
		return p;
	}

	

}
