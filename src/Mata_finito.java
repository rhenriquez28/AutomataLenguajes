import java.io.*;

public class Mata_finito {

	public static void main(String[] args) throws IOException {
		int cont=0;
		char [] cad = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
		System.out.println("Ingrese la cadena:");
		String x=br.readLine();
		cad=x.toCharArray();
		}
		catch(NumberFormatException e){
			System.out.println("Ingrese una cadena de a's o b's porfavor");
		}
		
		Qx Automata = new Qx();
		Automata.Q0(cad, cont);

	}

}
