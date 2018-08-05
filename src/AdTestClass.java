import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class AdTestClass implements AdTest {

	@Override
	public int findDivisor(int n) {

		int divisorSum = 1;
		for (int i = 2; i <= n; i++) {
			int resultt = n % i;
			if (resultt == 0) {
				System.out.println("Divisor is " + i);
				divisorSum = divisorSum + i;
			}
		}
		return divisorSum;
	}

	public static int at() {
		try {
			return 1/0;
		} catch (Exception e) {
			return 1;
		} finally {
			System.out.println("ada");
			return 1;
		}
	}
	
	public static void main(String[] args) {
		at();
	}

}
