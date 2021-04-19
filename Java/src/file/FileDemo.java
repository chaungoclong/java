package file;
import basic.Execute;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

public class FileDemo extends Execute{
  public static void main(String[] args) {
    try {
      File myObj = new File("filename.txt");
      File xyz = new File("xyz.txt");
      xyz.createNewFile();
      xyz.delete();
      if (myObj.createNewFile()) {
        echo("File created: " + myObj.getName()); 
      } else {
    	  throw new IOException("error");
      }
    } catch (IOException e) {
      System.out.println(e);
      e.printStackTrace();
    }
  }
}
