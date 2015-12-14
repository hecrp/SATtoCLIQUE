import java.util.ArrayList;


public class ProblemaCLIQUE {
	private InstanciaCLIQUE instancia;
	private ArrayList<Boolean> asignacion;
	
	public ProblemaCLIQUE(InstanciaCLIQUE instancia){
		setInstancia(instancia);
	}
	
	public void resolver(){
		boolean fin = false;
		int i = 0;
		while(!fin || i < Math.pow(2, getInstancia().getElementos())){
			generarAsignacion(i);
			if(formaClique())
				fin = true;
			i++;
		}
		if(fin)
			System.out.println("Hay solucion" + asignacion);
		else
			System.out.println("No hay solucion");
	}
	
	private boolean formaClique(){
		int grupoCounter = 0;
		int j = 0;
		int h = 0;
		while(j < getInstancia().getNodos().size() && grupoCounter < getInstancia().getK()){
			System.out.println("asignacion " + asignacion + " mirando nodo " + j);
			if(getInstancia().getNodos().get(j).getGrupo() == grupoCounter){
				if(getInstancia().getNodos().get(j).getCont().equals(getInstancia().getCaracteres().get(h))){
					if((getInstancia().getNodos().get(j).isEstado() == asignacion.get(h))){
						grupoCounter++;
						h++;
					}	
				}
			}
			j++;
		}
		if(grupoCounter == getInstancia().getK())
			break;
		j = 0;
		if(grupoCounter == getInstancia().getK())
			return true;
		else 
			return false;
	}
	
	
	private void generarAsignacion(Integer num){
		String binario = Integer.toBinaryString(num);
		asignacion = new ArrayList<Boolean>();
		
		for(int i = 0; i < binario.length(); i++){
			boolean aux = false;
			if(binario.charAt(i) == '1')
				aux = true;
			asignacion.add(aux);
		}
		
		while(asignacion.size() < getInstancia().getElementos())
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
