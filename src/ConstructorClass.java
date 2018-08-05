
public class ConstructorClass {
	
	String name="ad";

	public ConstructorClass(String s) {
		System.out.println(s);
		name=s;
	}

	public ConstructorClass(String s, String r) {
		System.out.println(s+r);
	}

	public static void main(String[] args) {
		ConstructorClass cs = new ConstructorClass("a", "b");
		ConstructorClass cs1= new ConstructorClass("adarsh adarsh");
		System.out.println(cs1.name);
	}
}
