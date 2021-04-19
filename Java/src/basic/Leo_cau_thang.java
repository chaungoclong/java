package basic;
import java.util.*;

public class Leo_cau_thang  extends Execute{
	public static int fibo(int n) {
		if(n == 0 || n == 1) {
			return n;
		}
		return fibo(n - 1) + fibo(n - 2);
	}
	
	public static int countWay(int n) {
		return fibo(n + 1);
	}

	public static void main(String[] args) {
		char k;
		do {
			int n = input();
			echo(countWay(n));
			echo("\n");
			Scanner s = new Scanner(System.in);
			echo("x: exit\n");
			k = s.next().charAt(0);
		} while (k != 'x');
	}

}
