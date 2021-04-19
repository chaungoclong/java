package file;
import java.util.*;
import java.io.*;
import basic.Execute;

public class FileInputStreamDemo extends Execute{

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		echo("nhap ten file:\n>");
		String fileName = s.nextLine();
		
		try {
			FileInputStream f = new FileInputStream(fileName);
			
			int data = 0;
			while((data = f.read()) != -1){
				echo((char) data);
//				data = f.read();
			}
			f.close();
		} catch (Exception e) {
			echo(e);
		} finally {
			echo("end");
			s.close();
		}

	}

}
