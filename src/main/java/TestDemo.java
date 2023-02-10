import java.util.Random;


public class TestDemo {
	private int testDemo;

	public int addPositive(int a, int b) {
		if (a > 0 && b > 0) {
			return a + b;
		} else {
			throw new IllegalArgumentException("Both parameter must be positive!");
		}
		
		
	}
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
	int randomNumberSquared() {
		int z = getRandomInt();
		int p = (z * z);
		return p;
	}
	
}
