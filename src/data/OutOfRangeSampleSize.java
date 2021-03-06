package data;

/**
 * Classe per eccezioni sollevate in caso di una richiesta di cluster troppo
 * elevata rispetto alla tabella data
 * 
 */
@SuppressWarnings("serial")
public class OutOfRangeSampleSize extends Exception {
	/**
	 * Costruttore che permette di richiamare il costruttore della superclasse
	 * passandoli una stringa.
	 */
	public OutOfRangeSampleSize() {
		super("Numero di cluter troppo elevato.");
	}
}