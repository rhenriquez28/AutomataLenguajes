import java.util.ArrayList;

public class Qx {

	ArrayList<String> states = new ArrayList<String>();
	public void Q0(char[] cad, int cont){
		if(cont<cad.length){
			System.out.println("Inicio en el Estado Q0");
			if(cad[cont]=='a'){
				cont++;
				System.out.println("Paso al Estado Q1");
				states.add("Q1");
				Q1(cad, cont);
			}
			else{
				cont++;
				System.out.println("Paso al Estado Q4");
				states.add("Q4");
				Q4(cad, cont);
			}
		}
	}
	
	public void Q1(char[] cad, int cont){
		if(cont<cad.length){
			if(cad[cont]=='b'){
				cont++;
				System.out.println("Paso al Estado Q2");
				states.add("Q2");
				Q2(cad, cont);
			}
			else{
				System.out.println("Error: no existe esa opcion en este estado, porfavor trate denuevo.");
			}
		}
	}
	
	public void Q2(char[] cad, int cont){
		if(cont<cad.length){
			if(cad[cont]=='a'){
				cont++;
				System.out.println("Se mantiene en el Estado Q2");
				states.add("Q2");
				Q2(cad, cont);
			}
			else{
				cont++;
				System.out.println("Paso al Estado Q3");
				states.add("Q3");
				Q3(cad, cont);
			}
		}
	}
	
	public void Q3(char[] cad, int cont){
		if(cont<cad.length){
			if(cad[cont]=='a'){
				cont++;
				System.out.println("Se mantiene en el Estado Q3");
				states.add("Q3");
				Q3(cad, cont);
			}
			else{
				System.out.println("Error: no existe esa opcion en este estado, porfavor trate denuevo.");
			}
		}
	}
	
	public void Q4(char[] cad, int cont){
		if(cont<cad.length){
			if(cad[cont]=='a'){
				cont++;
				System.out.println("Se mantiene en el Estado Q4");
				states.add("Q4");
				Q4(cad, cont);
			}
			else{
				cont++;
				System.out.println("Paso al Estado Q5");
				states.add("Q5");
				Q5(cad, cont);
			}
		}
	}
	
	public void Q5(char[] cad, int cont){
		if(cont<cad.length){
			if(cad[cont]=='a'){
				cont++;
				System.out.println("Se mantiene en el Estado Q5");
				states.add("Q5");
				Q5(cad, cont);
			}
			else{
				System.out.println("Error: no existe esa opcion en este estado, porfavor trate denuevo.");
			}
		}
	}
}
