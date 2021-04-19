package basic;
import java.util.*;
import java.io.*;

public class Execute {
//	echo
	public static void echo(String message) {
		System.out.print(message);
	}
	
	public static void echo(byte message) {
		System.out.print(message);
	}
	
	public static void echo(short message) {
		System.out.print(message);
	}
	
	public static void echo(int message) {
		System.out.print(message);
	}
	
	public static void echo(long message) {
		System.out.print(message);
	}
	
	public static void echo(float message) {
		System.out.print(message);
	}
	
	public static void echo(double message) {
		System.out.print(message);
	}
	
	public static void echo(char message) {
		System.out.print(message);
	}
	
	public static void echo(boolean message) {
		System.out.print(message);
	}
	
	public static void echo(Exception message) {
		System.out.print(message);
	}
	
	public static int input() {
		Scanner in = new Scanner(System.in);
		int result = in.nextInt();
		in.nextLine();
		return result;
	}
	
	public static void clrscr(){
		try {  
			final String os = System.getProperty("os.name");  
			if (os.contains("Windows")) {  
				Runtime.getRuntime().exec("cls");  
			}  
			else {  
				Runtime.getRuntime().exec("clear");  
			}  
		}  
		catch (final Exception e) {  
			e.printStackTrace();  
		}  
	}
}
