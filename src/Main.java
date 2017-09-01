import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] args) {
		BufferedReader o = new BufferedReader( new InputStreamReader(System.in));
		
		
		MenuPrincipal();
		
		
		
		String input = "";
		String state = "S1";
		char[] allowedChars = {'0','1'};
		try
		{
			input = o.readLine();
		}
		catch(Exception e)
		{
			System.out.println("Hubo un error en el input.");
		}
		boolean error1 = false;
		for(int i=0; i<input.length() && !error1 ;i++)
		{
			
			error1=false;
			for( char a : allowedChars)
			{
				
				if(a!=input.charAt(i)  )
				{
					
					error1=true;	
				}
				else
				{
					error1=false;
					break;
				}
				System.out.println(a+" "+input.charAt(i)+" "+error1 );
			}
		}
		if(error1)
		{
			System.out.println("La cadena introducida contiene caracteres no validado");
		}
		else
		{
			for(int i=0; i<input.length();i++)
			{
				System.out.println("Estado:" + state);
				char cChar = input.charAt(i);
				switch(cChar)
				{
				case '0':
					if(state.equals("S1"))
					{
						state = "S2";
					}
					else
					{
						state = "S1";
					}
				break;
				
				case '1':
					break;
				}
			}
		}
		
	} 
	
	
	static void MenuPrincipal()
	{
		//numero de nodos, nodo n conexiones, 
		int cnodos= 0;
		int conexionesNodos=0; 
		String cxNodos;
		
		boolean sunnyday=true;
		
		do{		
			sunnyday=true;
			cnodos=0;
			try{
				cnodos=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad de nodos"));
				}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Introduzca un numero.");
				sunnyday=false;
				
			}
		}while(sunnyday==false);
		
		do{
			sunnyday=true;
		for(int a=0;a<cnodos;a++){
			try{
				conexionesNodos=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad de conexiones del nodo "+(a+1)));
				}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Introduzca un numero.");
				sunnyday=false;
			}
		}
		}while(sunnyday==false);
		
		for(int b=0;b<conexionesNodos;b++){
			
			
				
				cxNodos=(JOptionPane.showInputDialog("Conexiones del nodo "+(b+1),"¿Con que nodo se conecta el nodo "+(b+1)+"?"));
				
			}
		}
	}
	

