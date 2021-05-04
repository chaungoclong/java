package ex5;

public class Main {
	public static void main(String[] args) {
		Shape[] listShape = { new Rectangle(10, 20), new Triangle(4, 3), new Circle(3) };
		double[] result = new double[listShape.length];
		for (int i = 0; i < listShape.length; i++) {
			result[i] = listShape[i].calculateSurface();
			System.out.println(result[i]);
		}
	}
}
