package ex5;

public class Circle extends Shape {
	private double radius;
	private final double PI = 3.14;

	public Circle() {
		super();
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double calculateSurface() {
		return Math.pow(this.radius, 2) * this.PI;
	}
}
