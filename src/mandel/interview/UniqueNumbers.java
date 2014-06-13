package mandel.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UniqueNumbers {

	public static void main(String args[]) {

		Scanner keyboard = new Scanner(System.in);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < 10; i++) {
			System.out.println("ENTER A NUMBER");
			Integer number = keyboard.nextInt();
			Integer count = map.get(number);
			if (null == count) {
				count = 0;
			}
			map.put(number, count + 1);
		}

		System.out.println(map);
		keyboard.close();
	}
}
