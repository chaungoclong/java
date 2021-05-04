package ex5;

public class Rectangle extends Shape {
	public Rectangle() {
		super();
	}

	public Rectangle(double width, double height) {
		super(width, height);
	}

	public double calculateSurface() {
		return this.height * this.width;
	}
}
