package ex5;

public abstract class Shape {
	protected double width;
	protected double height;
	protected final double PI = 3.14;

	public Shape() {
	}

	public Shape(double width, double height) {
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public abstract double calculateSurface();
}
