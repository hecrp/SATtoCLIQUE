import java.util.ArrayList;

/**
 * Esta clase representa una instancia clique con un conjuto de clausulas K
 * Se crea una lista de Nodos que contienen su id, elemento, y grupo; y se
 * unen a traves de una matriz de binaria de aristas que contiene 1 en 
 * los nodos conectados.
 */
public class InstanciaCLIQUE {

	private ArrayList<Nodo> nodos;
	private boolean[][] aristas;

	private Integer k;
	private Integer elementos;
	private ArrayList<String> caracteres;

	public InstanciaCLIQUE(InstanciaSAT problemaSAT) {
		setK(problemaSAT.getClausulas().size());
		setElementos(problemaSAT.getElementosCounter());
		setNodos(new ArrayList<Nodo>());
		setCaracteres(problemaSAT.getElementos());
		int id = 0;
		for (int i = 0; i < problemaSAT.getClausulas().size(); i++) {
			for (int j = 0; j < problemaSAT.getClausulas().get(i).getElementos().size(); j++) {
				getNodos().add(new Nodo(id, problemaSAT.getClausulas().get(i).getElementos().get(j), i));
			}
		}
		aristas = new boolean[getNodos().size()][getNodos().size()];
		rellenarAristas();

	}

	/**
	 * Asignacion de valores a la matriz aristas con el criterio de 
	 * que sea 1 en los nodos que pertenecen a distinto grupo y no son
	 * opuestos entre si.
	 */
	public void rellenarAristas() {
		for (int i = 0; i < getNodos().size(); i++)
			aristas[i][i] = false;

		for (int i = 0; i < getNodos().size(); i++) {
			for (int j = 0; j < getNodos().size(); j++) {
				if (getNodos().get(i).getGrupo() != getNodos().get(j).getGrupo()) {
					if (!getNodos().get(i).getCont().equals(getNodos().get(j).getCont())) {
						aristas[i][j] = true;
					} else {
						if (getNodos().get(i).isEstado() == getNodos().get(j).isEstado())
							aristas[i][j] = true;
					}
				}
			}
		}
	}

	public ArrayList<Nodo> getNodos() {
		return nodos;
	}

	public void setNodos(ArrayList<Nodo> nodos) {
		this.nodos = nodos;
	}

	public boolean[][] getAristas() {
		return aristas;
	}

	public void setAristas(boolean[][] aristas) {
		this.aristas = aristas;
	}

	public Integer getK() {
		return k;
	}

	public void setK(Integer k) {
		this.k = k;
	}

	public Integer getElementos() {
		return elementos;
	}

	public void setElementos(Integer elementos) {
		this.elementos = elementos;
	}

	public ArrayList<String> getCaracteres() {
		return caracteres;
	}

	public void setCaracteres(ArrayList<String> caracteres) {
		this.caracteres = caracteres;
	}

}
