package basic;

import java.util.Scanner;
public class Tests {
    
    public static void main(String[] abc) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
       	System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
      	if(b == 0) {
              System.out.println("INF");
		} else {
              System.out.printf("%.2f", (float) a / b);
		}
	}
}