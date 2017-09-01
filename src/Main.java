import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] args) {
		BufferedReader o = new BufferedReader( new InputStreamReader(System.in));
		
				
		
		
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
	
	
	}
	

