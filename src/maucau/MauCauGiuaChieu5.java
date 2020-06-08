package maucau;

import stockmarket.BigStock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MauCauGiuaChieu5 implements MauCau {
    private static List<String> dauCauu;
    private BigStock stock;

    public MauCauGiuaChieu5(BigStock stock) {
        this.stock = stock;
        dauCauu = new ArrayList<String>();

        dauCauu.add("Biến động cố phiểu chiều nay, ");
        dauCauu.add("Tới thời điểm này, ");
        dauCauu.add("Khớp lệnh liên tục, ");

    }

    public String sinhCau() {
        String mauCauGiuaChieu = null;
        StringBuffer sb = new StringBuffer();
        String symbol = stock.getSymbol();
        String giuaCau = null;
        String donVi = null;
        double giaMoCuaGiuaChieu = stock.getGiaDauPhienChieu();
        double giaGiuaPhienChieu = stock.getGiaGiuaPhienChieu();
        double chenhLech = giaGiuaPhienChieu - giaMoCuaGiuaChieu;
        float tiLeThayDoi = Math.abs((float) chenhLech) / (float) giaMoCuaGiuaChieu;

        if ((chenhLech >= 0) && (tiLeThayDoi < 1)) {
            giuaCau = " tăng ";
            donVi = "%";
        }
        if ((chenhLech >= 0) && (tiLeThayDoi > 1)) {
            giuaCau = " tăng gấp ";
            donVi = " lần ";
        }
        if ((chenhLech < 0) && (tiLeThayDoi < 1)) {
            giuaCau = " giảm ";
            donVi = "%";
        }
        if ((chenhLech < 0) && (tiLeThayDoi > 1)) {
            giuaCau = " giảm mất ";
            donVi = " lần ";
        }

        sb.append(dauCauu.get(new Random().nextInt(dauCauu.size())));
        sb.append(symbol);
        sb.append(giuaCau);
        sb.append(String.format("%.3g", (tiLeThayDoi * 100)));
        sb.append(donVi);
        sb.append(" đạt ở mức ");
        sb.append(giaGiuaPhienChieu);
        sb.append(" điểm.");

        mauCauGiuaChieu = sb.toString();

        return mauCauGiuaChieu;
    }
}
