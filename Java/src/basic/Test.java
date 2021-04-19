package basic;

public class Test extends Execute{
	public static void main(String[] args) {
		Square a = new Square(-3, 3);
		float b = a.area();
		echo(b);
		echo("\n");
		
		Rectangle x = new Rectangle(-1, 2);
		float y = x.area();
		echo(y);
	}
}
