
public class Circle extends Shape {
	private double radius;
	private final double PI = 3.14;

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

	public double getArea() {
		return this.radius * this.radius * this.PI;
	}
}
