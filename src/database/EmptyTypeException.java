package database;

@SuppressWarnings("serial")
public class EmptyTypeException extends Exception {
	EmptyTypeException(){
		super("Risultato della query risulta essere vuoto");
	}
}
