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
		byte[] byteContent = content.getBytes();	
		
		try {
			FileOutputStream f = new FileOutputStream(fileName, true);
			f.write(byteContent);
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
