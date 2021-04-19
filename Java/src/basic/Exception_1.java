package basic;
import java.util.*;
import java.io.*;

class AgeException extends Exception{
	public AgeException(String message) {
		super(message);
	}
}

class LengthStringException extends Exception {
	public LengthStringException(String message) {
		super(message);
	}
}



class YoungException extends AgeException{
	public YoungException(String message) {
		super(message);
	}
}

class OldException extends AgeException{
	public OldException(String message) {
		super(message);
	}
}

class ValidateException extends Exception{
	public ValidateException(Exception e) {
		super(e);
	}
}
public class Exception_1 {
	public static void hello(String message) throws LengthStringException{
		if(message.length() < 2) {
			throw new LengthStringException("khong chinh xac");
			}
		System.out.println(message);
		
	}

	public static void main(String[] args) {
		
		try {
			hello("h");
		} catch (LengthStringException e) {
			System.out.println(e);
		}
//		
		try {
			int[] arr = {1, 2, 3};
			//System.out.println(arr[3]);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("phan tu khong ton tai");
		} finally {
			System.out.println("end.");
		}
		
//		catch exception age
		Scanner s = new Scanner(System.in);
		try {
			System.out.println("nhap tuoi cua ban vao");
			int Age = s.nextInt();
			if(Age < 10) {
				throw new YoungException("tuoi khong du");
			}
			if(Age > 20) {
				throw new OldException("qua gioi han tuoi");
			}
		} catch(AgeException e) {
			System.out.println(e);
		} finally {
			s.close();
		}
		
	}
}
