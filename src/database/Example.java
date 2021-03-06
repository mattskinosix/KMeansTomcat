package database;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe che rappresenta un esempio nella tabella
 * 
 * @author Matteo.
 *
 */
public class Example implements Comparable<Example> {
	/**
	 * Lista di oggetti di tipo Object.
	 */
	private List<Object> example = new ArrayList<Object>();

	/**
	 * Aggiunge l'oggetto "o" alla lista di esempi.
	 * 
	 * @param o
	 *            Oggetto da aggiungere alla lista.
	 */
	 void add(Object o) {
		example.add(o);
	}

	/**
	 * Ritorna l'oggetto o in i-esima posizione.
	 * 
	 * @param i
	 *            Posizione dell'oggetto da returnare.
	 * @return Oggetto desiderato.
	 */
	public Object get(int i) {
		return example.get(i);
	}

	/**
	 * Compara se i due esempi, ovvero il parametro e this, sono uguali in modo da
	 * non inserire esempi uguali.
	 * 
	 * @param Esempio
	 *            da confrontare con this.
	 * @return Restituisce 0 se sono uguali 1 se sono diversi piu grande -1 se piu
	 *         piccolo.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int compareTo(Example ex) {

		int i = 0;
		for (Object o : ex.example) {
			if (!o.equals(this.example.get(i)))
				return ((Comparable) o).compareTo(example.get(i));
			i++;
		}
		return 0;
	}

	/**
	 * Sovrascrive metodo ereditato dalla superclasse e restituisce la stringa
	 * rappresentante lo stato dell'oggetto.
	 */
	public String toString() {
		String str = "";
		for (Object o : example)
			str += o.toString() + " ";
		return str;
	}

}