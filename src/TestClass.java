
public class TestClass {


	public void calculae(int a, int b) {

		if (b == 0) {
			throw new ArithmeticException();
		} else {
			System.out.println(a / b);
		}

	}

	public void printException(String s) throws Exception {

		if (!s.equals("Hello World")) {
			throw new UserDefinedException("Not Matching");
		}

	}
}
