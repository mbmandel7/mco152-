package mandel.clock;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JComponent;

public class ClockComponent extends JComponent {

	private static final long serialVersionUID = -1582942101838834157L;

	@Override
	public void paintComponent(Graphics g) {
		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;
		int radiusLength = Math.min(getHeight(), getWidth());

		g.setColor(Color.CYAN);
		g.fillOval(0, 0, getWidth(), getHeight());

		g.setColor(Color.DARK_GRAY);
		g.drawString("12", xCenter, 20);
		g.drawString("3", getWidth() - 20, yCenter);
		g.drawString("6", xCenter, getHeight() - 20);
		g.drawString("9", 20, yCenter);

		GregorianCalendar time = new GregorianCalendar();
		drawHour(xCenter, yCenter, radiusLength, time.get(Calendar.HOUR), g);
		drawMinute(xCenter, yCenter, radiusLength, time.get(Calendar.MINUTE), g);
		drawSecond(xCenter, yCenter, radiusLength, time.get(Calendar.SECOND), g);

	}

	public void drawHour(int xCenter, int yCenter, int radiusLength, int hour,
			Graphics g) {
		g.setColor(Color.WHITE);
		double hourAngle = 2 * Math.PI * hour / 12;
		hourAngle -= (Math.PI / 2);
		double hourX = Math.cos(hourAngle);
		hourX = xCenter + hourX * radiusLength * .25;
		double hourY = Math.sin(hourAngle);
		hourY = yCenter + hourY * radiusLength * .25;
		g.drawLine(xCenter, yCenter, (int) hourX, (int) hourY);
	}

	public void drawMinute(int xCenter, int yCenter, int radiusLength,
			int minute, Graphics g) {
		g.setColor(Color.DARK_GRAY);
		double minuteAngle = 2 * Math.PI * minute / 60;
		minuteAngle -= (Math.PI / 2);
		double minuteX = Math.cos(minuteAngle);
		minuteX = xCenter + minuteX * radiusLength * .4;
		double minuteY = Math.sin(minuteAngle);
		minuteY = yCenter + minuteY * radiusLength * .4;
		g.drawLine(xCenter, yCenter, (int) minuteX, (int) minuteY);
	}

	public void drawSecond(int xCenter, int yCenter, int radiusLength,
			int second, Graphics g) {
		g.setColor(Color.RED);
		double secondAngle = 2 * Math.PI * second / 60;
		secondAngle -= (Math.PI / 2);
		double secondX = Math.cos(secondAngle);
		secondX = xCenter + secondX * radiusLength * .5;
		double secondY = Math.sin(secondAngle);
		secondY = yCenter + secondY * radiusLength * .5;
		g.drawLine(xCenter, yCenter, (int) secondX, (int) secondY);
	}

}