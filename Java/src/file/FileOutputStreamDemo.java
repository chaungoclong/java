package file;
import java.io.*;
import java.util.*;
import basic.Execute;

public class FileOutputStreamDemo extends Execute{
	public static void main(String[] a) throws Exception{
		Scanner s = new Scanner(System.in);
		
		echo("nhap ten file:\n>");
		String fileName = s.nextLine();
		
		echo("nhap noi dung can ghi vao file\n>");
		String content = s.nextLine();
		
		try {
			BufferedWriter f = new BufferedWriter(new FileWriter(fileName));
			f.write(content);
			f.close();
			echo("thanh cong");
		} catch (IOException e) {
			echo(e);
		} finally {
			echo("end");
			s.close();
		}
		
		try {
			BufferedReader f = new BufferedReader(new FileReader(fileName));
			String line = f.readLine();
			while (line != null) {
				System.out.println(line);
				line = f.readLine();
			}
			f.close();
			echo("thanh cong");
		} catch (IOException e) {
			echo(e);
		} finally {
			echo("end");
			s.close();
		}
	}
}
