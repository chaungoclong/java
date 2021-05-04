package ex5;

public class ShapeFactory {
	public Shape getShape(String type) {
		if(type == null) {
			return null;
		}
		
		if(type.equalsIgnoreCase("rectangle")) {
			return new Rectangle();
		}
		
		if(type.equalsIgnoreCase("triangle")) {
			return new Triangle();
		}
		
		if(type.equalsIgnoreCase("circle")) {
			return new Circle();
		}
		
		return null;
	}
}
