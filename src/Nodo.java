/**
 * 
 * La clase Nodo representa un nodo en el grafo final,
 * cada nodo contiene un ID numerico para identificarlo en base a
 * el total de nodos, un grupo(clusters) al que pertenece y el contenido del nodo.
 * 
 */
public class Nodo {
	
	private int id;
	private String cont;
	private int grupo;
	
	public Nodo(int id, String contenido, int grp) {
		setId(id);
		setCont(contenido);
		setGrupo(grp);	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCont() {
		return cont;
	}

	public void setCont(String cont) {
		this.cont = cont;
	}

	public int getGrupo() {
		return grupo;
	}

	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}
	
}
