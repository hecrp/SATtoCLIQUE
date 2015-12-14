import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class InstanciaSAT {
	
	private FileReader fReader;
	private BufferedReader bReader;
	
	private ArrayList<Clausula> clausulas;
	
	private ArrayList<String> elementos;
	private Integer elementosCounter;
	
	public InstanciaSAT(String filename) throws IOException{
		setfReader(new FileReader(filename));
		setbReader(new BufferedReader(fReader));
		setClausulas(new ArrayList<Clausula>());
		setElementos(new ArrayList<String>());
		setElementosCounter(new Integer(0));
		this.parse();
	}
	
	private void parse() throws IOException{
		String stringElementos = getbReader().readLine();
		StringTokenizer st = new StringTokenizer(stringElementos);
		
	    while (st.hasMoreTokens()) {
	    	 setElementosCounter(getElementosCounter() + 1);
	    	 getElementos().add(st.nextToken());    
	    }
	    
	    String lineaClausula = getbReader().readLine();
	    
	    while(lineaClausula != null) {
	    	st = new StringTokenizer(lineaClausula);
	    	Clausula aux = new Clausula();
	    	while (st.hasMoreTokens()) {
		    	 aux.add(st.nextToken());
		    	 getClausulas().add(aux);
		    }
	    	lineaClausula = getbReader().readLine();
	    }
	    
	    getbReader().close();
	}

	public FileReader getfReader() {
		return fReader;
	}

	public void setfReader(FileReader fReader) {
		this.fReader = fReader;
	}

	public BufferedReader getbReader() {
		return bReader;
	}

	public void setbReader(BufferedReader bReader) {
		this.bReader = bReader;
	}

	public ArrayList<Clausula> getClausulas() {
		return clausulas;
	}

	public void setClausulas(ArrayList<Clausula> clausulas) {
		this.clausulas = clausulas;
	}

	public ArrayList<String> getElementos() {
		return elementos;
	}

	public void setElementos(ArrayList<String> elementos) {
		this.elementos = elementos;
	}

	public Integer getElementosCounter() {
		return elementosCounter;
	}

	public void setElementosCounter(Integer elementosCounter) {
		this.elementosCounter = elementosCounter;
	}

	
}
