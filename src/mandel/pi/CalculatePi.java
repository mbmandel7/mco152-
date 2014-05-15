package mandel.pi;

public class CalculatePi {

	public Double calculatePi() {
		double pi = 0;
		for (int i = 1; i < 1000000000; i++) {
			pi += 4 * (Math.pow((-1), (i + 1)) / (2 * i - 1));
		}
		return pi;
	}
}
