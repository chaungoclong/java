package basic;

public class Rectangle extends Shape {
	public float length;
	public float width;
	
	public Rectangle(float length, float width) {
		this.length = length;
		this.width = width;
		if(!check()) {
			System.out.println("khong phai hinh chu nhat");
		}
	}
	
	public boolean check() {
		if(this.length <= 0 || this.width <= 0) {
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
			return this.length * this.width;
		}
		return 0;
	}
}
