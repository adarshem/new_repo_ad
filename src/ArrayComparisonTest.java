import java.util.ArrayList;

public class ArrayComparisonTest {

	public static void main(String[] args) {
		try {
			ArrayList<String> scripts = new ArrayList<String>();
			scripts.add("ad");
			scripts.add("bc");
			scripts.add("cd");
			System.out.println(scripts);
			// String[] ar1 = { "ad", "bc", "cd" };
			String[] ar2 = { "ad", "bc" };
			for (int i = 0; i < scripts.size(); i++) {
				int found = 0;
				for (int j = 0; j < ar2.length; j++) {
					if ((scripts.get(i).equals(ar2[j]))) {
						System.out.println("Action");
						found++;
					} else {
						System.out.println("Action cannot be set");
					}
				}
				System.out.println(found);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
