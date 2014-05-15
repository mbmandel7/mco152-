package mandel.stocks;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class AmexData {

	private List<DailyPrice> allDailyPricesList;
	private HashMap<String, List<DailyPrice>> stockData;

	public AmexData() throws IOException {

		allDailyPricesList = new ArrayList<DailyPrice>();

		ArrayList<FileReader> files = new ArrayList<FileReader>();
		files.add(new FileReader("./resources/amex/AMEX_daily_prices_A.csv"));
		files.add(new FileReader("./resources/amex/AMEX_daily_prices_B.csv"));
		files.add(new FileReader("./resources/amex/AMEX_daily_prices_C.csv"));
		files.add(new FileReader("./resources/amex/AMEX_daily_prices_D.csv"));

		for (FileReader f : files) {
			@SuppressWarnings("resource")
			CSVReader reader = new CSVReader(f, ',', '\"', 2);
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				String exchange = nextLine[0];
				String symbol = nextLine[1];
				String dateString = nextLine[2];
				int year = Integer.parseInt(dateString.substring(0, 4));
				int month = Integer.parseInt(dateString.substring(5, 7));
				int day = Integer.parseInt(dateString.substring(8, 10));
				@SuppressWarnings("deprecation")
				Date date = new Date(year, month - 1, day);
				double openPrice = Double.parseDouble(nextLine[3]);
				double highPrice = Double.parseDouble(nextLine[4]);
				double lowPrice = Double.parseDouble(nextLine[5]);
				double closePrice = Double.parseDouble(nextLine[6]);
				int volume = Integer.parseInt(nextLine[7]);
				double adjustedClosePrice = Double.parseDouble(nextLine[8]);

				DailyPrice dailyPrice = new DailyPrice(symbol, exchange, date,
						openPrice, highPrice, lowPrice, closePrice, volume,
						adjustedClosePrice);

				allDailyPricesList.add(dailyPrice);
			}
		}

		stockData = new HashMap<String, List<DailyPrice>>();

		for (DailyPrice dp : allDailyPricesList) {
			String symbol = dp.getSymbol();
			List<DailyPrice> dailyPrices;
			if (stockData.containsKey(symbol)) {
				dailyPrices = stockData.get(symbol);
				dailyPrices.add(dp);
			} else {
				dailyPrices = new ArrayList<DailyPrice>();
				dailyPrices.add(dp);
				stockData.put(symbol, dailyPrices);
			}
		}
	}

	public boolean contains(String symbol) {
		return stockData.containsKey(symbol);
		// for (DailyPrice dt : stockData) {
		// if (symbol.equals(dt.getSymbol())) {
		// return true;
		// }
		// }
		// return false;
	}

	public List<DailyPrice> getPrices(String symbol) {
		return stockData.get(symbol);

		// List<DailyPrice> stockDataList = new ArrayList<DailyPrice>();
		// for (DailyPrice dt : stockData) {
		// if (symbol.equals(dt.getSymbol())) {
		// stockDataList.add(dt);
		// }
		// }
		// if (!stockDataList.isEmpty()) {
		// Collections.sort(stockData, new DateComparator());
		// }
		// return stockDataList;
	}

	public List<DailyPrice> getPrices(String symbol, Date startDate,
			Date endDate) {

		List<DailyPrice> prices = getPrices(symbol);
		List<DailyPrice> newList = new ArrayList<DailyPrice>();

		for (DailyPrice dp : prices) {
			Date date = dp.getDate();
			if (!startDate.after(date) && !endDate.before(date)) {
				newList.add(dp);
			}
		}
		Collections.sort(newList, new DateComparator());
		return newList;

		// List<DailyPrice> stockDataList = getPrices(symbol);
		// for (DailyPrice dp : stockDataList) {
		// Date date = dp.getDate();
		// if (startDate.after(date) || endDate.before(date)) {
		// stockDataList.remove(dp);
		// }
		// }
		//
		// List<DailyPrice> stockDataList = new ArrayList<DailyPrice>();
		// for (DailyPrice dt : stockData) {
		// Date date = dt.getDate();
		// if (symbol.equals(dt.getSymbol()) && !startDate.after(date)
		// && !endDate.before(date)) {
		// stockDataList.add(dt);
		// }
		// }
		// if (!stockDataList.isEmpty()) {
		// Collections.sort(stockDataList, new DateComparator());
		// }
		// return stockDataList;
	}

	class DateComparator implements Comparator<DailyPrice> {
		@Override
		public int compare(DailyPrice dp1, DailyPrice dp2) {
			return dp1.getDate().compareTo(dp2.getDate());
		}
	}
}
