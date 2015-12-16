import java.util.ArrayList;

/**
 * Esta clase resuelve el problema clique generando asignaciones
 * y comprobando si son correctas para el grafo obtenido en la instancia
 *
 */
public class ProblemaCLIQUE {
	private InstanciaCLIQUE instancia;
	private ArrayList<Boolean> asignacion;

	public ProblemaCLIQUE(InstanciaCLIQUE instancia) {
		setInstancia(instancia);
	}

	public void resolver() {
		boolean fin = false;
		int i = 0;
		while (!fin) {
			generarAsignacion(i);
			if (formaClique()) {
				fin = true;
			}
			i++;

		}
		if (!fin)
			System.out.println("No hay solucion");
		;
	}

	/**
	 * Hacemos para cada asignacion obtenida, una comparacion de cada nodo con cada elemento
	 * de la asignacion, y si es correcto devuelve true.
	 * Se detiene con la primera solución encontrada
	 * @return
	 */
	private boolean formaClique() {
		int grupoCounter = 0;
		int j = 0;
		while (j < getInstancia().getNodos().size()) {
			for (int i = 0; i < asignacion.size(); i++) {
				if (getInstancia().getNodos().get(j).getGrupo() == grupoCounter) {
					if (getInstancia().getNodos().get(j).getCont().equals(getInstancia().getCaracteres().get(i))) {
						if ((getInstancia().getNodos().get(j).isEstado() == asignacion.get(i))) {
							grupoCounter++;
							if (grupoCounter == getInstancia().getK()) {
								System.out.println("Hay solucion" + asignacion);
								return true;
							}
						}
					}
				}
			}
			j++;
		}
		return false;
	}

	/**
	 * Genera asignaciones binarias segun el numero elementos
	 * de la instancia SAT
	 * @param num
	 */
	private void generarAsignacion(Integer num) {
		String binario = Integer.toBinaryString(num+3);
		asignacion = new ArrayList<Boolean>();

		for (int i = 0; i < binario.length(); i++) {
			boolean aux = false;
			if (binario.charAt(i) == '1')
				aux = true;
			asignacion.add(aux);
		}

		while (asignacion.size() < getInstancia().getElementos())
			asignacion.add(0, false);
	}

	public InstanciaCLIQUE getInstancia() {
		return instancia;
	}

	public void setInstancia(InstanciaCLIQUE instancia) {
		this.instancia = instancia;
	}

	public ArrayList<Boolean> getAsignacion() {
		return asignacion;
	}

	public void setAsignacion(ArrayList<Boolean> asignacion) {
		this.asignacion = asignacion;
	}

}
