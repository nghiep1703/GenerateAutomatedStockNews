package stockmarket;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import readfile.ReadFiles;

public class StockExchange {
	
	private String nameStockExchange;
	private String symbolStockExchange;
	private Map<String, Stock> stockMap;
	private ReadFiles f;
	
	public StockExchange(ReadFiles f, String nameStockExchange, String symbolStockExchange) {
		stockMap = new LinkedHashMap<String, Stock>();
		this.f = f;
		this.nameStockExchange = nameStockExchange;
		this.symbolStockExchange = symbolStockExchange;
		createStockMap(this.f.getArray());
		
	}
	
	public void createStockMap(String[][] s) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		for (int i = 0; i < s.length; i++) {
			String symbol = s[i][0];
			Date date = null;
			try {
				date = (Date) dateFormat.parse(s[i][1]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			double giaMoCua = Double.parseDouble(s[i][2]);
			double giaGiuaPhienSang = Double.parseDouble(s[i][3]);
			double giaChotPhienSang = Double.parseDouble(s[i][4]);
			double giaDauPhienChieu = Double.parseDouble(s[i][5]);
			double giaGiuaPhienChieu = Double.parseDouble(s[i][6]);
			double giaDongCua = Double.parseDouble(s[i][7]);
			double giaThapNhat = Double.parseDouble(s[i][8]);
			double giaCaoNhat = Double.parseDouble(s[i][9]);
			double volume = Double.parseDouble(s[i][10]);
			Stock stock = new Stock(symbol, date, giaMoCua, giaGiuaPhienSang, giaChotPhienSang, giaDauPhienChieu, giaGiuaPhienChieu, giaDongCua, giaThapNhat, giaCaoNhat, volume);
			stockMap.put(symbol, stock);
		}
		
	}
	public void printStockMap() {
		System.out.println("Tên sàn chứng khoán: " + nameStockExchange + " - " + symbolStockExchange);
		for (Stock stock: stockMap.values()) {
	        stock.printStock();
	    }
	}
}

