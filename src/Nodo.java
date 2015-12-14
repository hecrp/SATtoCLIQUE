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
	private boolean estado; //falso = negado, true = no negado
	
	public Nodo(int id, String contenido, int grp) {
		setId(id);
		setGrupo(grp);	
		setCont(contenido);
		
		if(contenido.contains("n")) {
			setEstado(false);
		}
		else {
			setEstado(true);
		}
		
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
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
