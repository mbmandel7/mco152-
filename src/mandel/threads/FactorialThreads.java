package mandel.threads;

public class FactorialThreads {

	public static void main(String args[]) {
		Thread t1 = new Factorial(100);
		Thread t2 = new Factorial(200);

		t1.start();
		t2.start();
	}
}
