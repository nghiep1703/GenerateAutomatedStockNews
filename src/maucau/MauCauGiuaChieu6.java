package maucau;

import stockmarket.BigStock;
import stockmarket.Stock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MauCauGiuaChieu6 implements MauCau {
    private BigStock stock;
    private static List<Stock> listStock;

    public MauCauGiuaChieu6(BigStock stock) {
        this.stock = stock;


    }

    public String sinhCau() {
        String mauCau = null;
        StringBuffer sb = new StringBuffer();

        String symbol = stock.getSymbol();
        listStock = new ArrayList<Stock>();
        double maxMoPhienChieu = listStock.get(0).getGiaGiuaPhienChieu();
        double minMoPhienChieu = listStock.get(0).getGiaDauPhienChieu();
        Date dateMax = null;
        Date dateMin = null;

        for (int i = 0; i < 7; i++) {
            listStock.add(stock.history(-i));
        }
        for (int i = 1; i < listStock.size(); i++) {
            if (listStock.get(i).getGiaGiuaPhienChieu() > maxMoPhienChieu) {
                maxMoPhienChieu = listStock.get(i).getGiaGiuaPhienChieu();
                dateMax = listStock.get(i).getDate();
            }
            if (listStock.get(i).getGiaGiuaPhienChieu() < minMoPhienChieu) {
                minMoPhienChieu = listStock.get(i).getGiaGiuaPhienChieu();
                dateMin = listStock.get(i).getDate();
            }
        }

        sb.append("Một tuần vừa qua, cùng thời điểm phiên giữa chiều, cổ phiếu ");
        sb.append(symbol);
        sb.append(" mở phiên giữa chiều với điểm cao nhất là: ");
        sb.append(maxMoPhienChieu);
        sb.append(" đạt được vào ngày: ");
        sb.append(dateMax);
        sb.append(" và mở phiên chiều với điểm thấp nhất là: ");
        sb.append(minMoPhienChieu);
        sb.append(" đạt được vào ngày: ");
        sb.append(dateMin);

        mauCau = sb.toString();

        return mauCau;
    }
}
