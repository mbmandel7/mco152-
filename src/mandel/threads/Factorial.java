package mandel.threads;

import java.math.BigInteger;

public class Factorial extends Thread {

	private long n;

	public Factorial(long num) {
		this.n = num;
	}

	public BigInteger fact(long n) {
		BigInteger total = BigInteger.valueOf(n);
		for (long i = n - 1; i > 0; i--) {
			total = total.multiply(BigInteger.valueOf(i));
		}
		return total;
	}

	@Override
	public void run() {
		System.out.println(fact(n));
	}
}
