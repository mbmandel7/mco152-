package mandel.weather;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SelectCityPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = -2264115585939555582L;
	private JLabel enterCityLabel;
	private JTextField enterCity;
	private JButton select;

	private GraphComponent graph;

	public SelectCityPanel(GraphComponent graph) {

		enterCityLabel = new JLabel(
				"Enter the name of a city and state/country");
		add(enterCityLabel);

		enterCity = new JTextField(20);
		add(enterCity);

		select = new JButton("Select");
		add(select);

		this.graph = graph;

		select.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String location = enterCity.getText();
		if (location != null) {
			try {
				WeatherConditions wc = new WeatherConditions(location, graph);
				wc.start();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}