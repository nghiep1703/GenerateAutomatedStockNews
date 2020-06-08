package maucau;

import stockmarket.BigStock;
import stockmarket.Stock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MauCauGiuaChieu7 implements MauCau {
    private BigStock stock;
    private static List<Stock> listStock;

    public MauCauGiuaChieu7(BigStock stock) {
        this.stock = stock;


    }

    public String sinhCau() {
        String mauCau = null;
        StringBuffer sb = new StringBuffer();

        String symbol = stock.getSymbol();
        listStock = new ArrayList<Stock>();
        int count = 0;
        String Change = null;
        double giaPhienChieuTuanTruoc = stock.history(-7).getGiaGiuaPhienChieu();
        Date oneWeekLater = stock.history(-7).getDate();

        for (int i = 0; i < 7; i++) {
            listStock.add(stock.history(-i));
        }
        for (int i = 0; i < listStock.size(); i++) {
            if (listStock.get(i).getGiaGiuaPhienChieu() < listStock.get(i + 1).getGiaGiuaPhienChieu()) {
                count++;
            }
        }
        if (count == 6) {
            Change = "liên tục tăng từ ";
        }
        if (count == 4 || count == 3 || count == 2){
            Change = " Biến động thất thường từ ";
        }
        if (count == 0){
            Change = " Tụt dốc liên tục từ ";
        }
        sb.append("Trong các buổi chiều 1 tuần vừa qua, ");
        sb.append(symbol);
        sb.append(Change);
        sb.append(giaPhienChieuTuanTruoc);
        sb.append(" điểm ở ngày ");
        sb.append(oneWeekLater);
        sb.append(" đến ");
        sb.append(stock.getGiaGiuaPhienChieu());
        sb.append(" điểm, ở hiện tại là ngày ");
        sb.append(stock.getDate());


        mauCau = sb.toString();

        return mauCau;
    }
}
