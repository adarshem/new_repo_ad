
public class TestExceptionExample {

	public static void main(String[] args) {

		TestClass tc = new TestClass();
		try {
			tc.calculae(1, 01);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		try {
			tc.printException("test");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
	
}
