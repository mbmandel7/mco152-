package mandel.weather;

public class Conditions {

	Day[] list;

	public int[] getTemps() {
		int[] temperatureList = new int[50];
		for (int i = 0; i < list.length; i++) {
			temperatureList[i] = list[i].getTemp();
		}
		return temperatureList;
	}
}

class Day {
	private Main main;

	public int getTemp() {
		return (int) main.getTempInFar();
	}
}

class Main {
	private double temp;

	public double getTempInFar() {
		return 9 / 5 * (temp - 273) + 32;
	}
}