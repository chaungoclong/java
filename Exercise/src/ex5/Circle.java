package ex5;

public class Circle extends Shape {

	public Circle() {
		super();
	}

	public Circle(double radius) {
		super(radius, radius);
	}

	public double calculateSurface() {
		return this.PI * Math.pow(this.width, 2);
	}
}
