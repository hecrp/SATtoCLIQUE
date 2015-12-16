import java.util.ArrayList;

/**
 * Esta clase representa una clausula.
 * Contiene elementos(caracteres) parseados del fichero fuente
 */
public class Clausula {

	private ArrayList<String> Elementos;

	public Clausula() {
		setElementos(new ArrayList<String>());
	}

	public void add(String elemento) {
		getElementos().add(elemento);
	}

	public ArrayList<String> getElementos() {
		return Elementos;
	}

	public void setElementos(ArrayList<String> elementos) {
		Elementos = elementos;
	}

}
