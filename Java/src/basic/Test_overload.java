package basic;

class Super{
	public void Hello(int a) {
		System.out.println("hello");
	}
}

public class Test_overload extends Super{
	public void Hello(int a) {
		super.Hello(1);
		System.out.println("kkk");
	}
	public static void main(String[] args) {
		Test_overload a = new Test_overload();
		a.Hello(1);
	}
}
