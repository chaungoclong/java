package file;
import java.io.*;
import basic.Execute;
public class Test  extends Execute{

	public static void main(String[] args) {
		HandleFile f = new HandleFile();
		String content = "absasc";
		try {
			f.Write("/home/long/test.txt", content, true);
		} catch (IOException e) {
			echo(e);
		}
	}

}
