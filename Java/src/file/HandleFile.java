package file;

import java.io.*;

public class HandleFile implements MethodHandleFile{
	public boolean Write(String fileName, String content, boolean mode) throws IOException{
		FileOutputStream write = null;
		byte[] byteContent = content.getBytes();
		boolean check = false;
		
		try {
			write = new FileOutputStream(fileName, mode);
			write.write(byteContent);
			write.close();
			check = true;
		} catch(IOException e) {
			check = false;
			throw new IOException();
		}
		
		return check;
	}
	
	public String Read(String fileName) {
		return "";
	}
}
