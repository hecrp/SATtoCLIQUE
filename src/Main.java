import java.io.IOException;


public class Main {
	public static void main(String[] args) throws IOException{
		InstanciaSAT instancia = new InstanciaSAT("./res/ejemplo.txt");
		InstanciaCLIQUE instanciaC = new InstanciaCLIQUE(instancia);
		ProblemaCLIQUE problema = new ProblemaCLIQUE(instanciaC);
		problema.resolver();
	}
}
