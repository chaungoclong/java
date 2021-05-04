package ex5;

public class Triangle extends Shape {

	public Triangle() {
		super();
	}

	public Triangle(double width, double height) {
		super(width, height);
	}

	public double calculateSurface() {
		return (this.height * this.width) / 2;
	}
}
