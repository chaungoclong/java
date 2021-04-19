package basic;
import java.lang.*;

public class Square extends Rectangle {
	public Square(float length, float width) {
		super(length, width);
		if(!check()) {
			System.out.println("khong phai hinh vuong");
		}
	}
	
	public boolean check() {
		if(this.length != this.width || this.length <= 0 || this.width <= 0) {
			return false;
		}
		return true;
	}
	

	public float perimeter() {
		if(check()) {
			return (this.length + this.width) * 2;
		}
		return 0;
	}
	

	public float area() {
		if(check()) {
			return (float) Math.pow(this.length, 2);
		}
		return 0;
	}
}
