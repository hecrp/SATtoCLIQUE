import java.util.ArrayList;


public class Clausula {
	
	private ArrayList<String> Elementos;

	public Clausula() {
		setElementos(new ArrayList<String>());
	}
	
	public void add(String elemento){
		getElementos().add(elemento);
	}

	public ArrayList<String> getElementos() {
		return Elementos;
	}

	public void setElementos(ArrayList<String> elementos) {
		Elementos = elementos;
	}

	
}
