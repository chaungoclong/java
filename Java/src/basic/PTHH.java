package basic;
import java.util.*;

public class PTHH extends Execute {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
//		echo(input);
		String VT, VP;
		String[] VT_VP = input.split("=");
		VT = VT_VP[0].trim();
		VP = VT_VP[1].trim();
		String[] ListVT = VT.split("[+]");
		String[] ListVP = VP.split("[+]");
		for (int i = 0; i < ListVT.length; ++i) {
			ListVT[i] = ListVT[i].trim();
			echo(ListVT[i] + "\n");
		}
		
		for (int i = 0; i < ListVP.length; ++i) {
			ListVP[i] = ListVP[i].trim();
			echo(ListVP[i] + "\n");
		}
	}
}
