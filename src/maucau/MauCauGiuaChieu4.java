package maucau;

import stockmarket.BigStock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MauCauGiuaChieu4 implements MauCau {
    private static List<String> dauCauTang;
    private static List<String> giuaCauChieu;
    private static List<String> dauCauGiam;
    private BigStock stock;

    public MauCauGiuaChieu4(BigStock stock) {
        this.stock = stock;
        dauCauTang = new ArrayList<String>();
        giuaCauChieu = new ArrayList<String>();
        dauCauGiam = new ArrayList<String>();

        dauCauTang.add("Chiều nay, ");
        dauCauTang.add("Phủ sắc xanh từ đầu buổi chiều, ");
        dauCauTang.add("Lội ngược dòng buổi sáng, ");

        giuaCauChieu.add(" mua bán ");
        giuaCauChieu.add(" chuyển nhượng ");
        giuaCauChieu.add(" sang tay ");
        giuaCauChieu.add(" giao dịch ");

        dauCauGiam.add("Chiều nay, ");
        dauCauGiam.add("Tiếp tục là màu đỏ, ");
        dauCauGiam.add("Tiếp đà buổi sáng, ");
    }

    public String sinhCau() {
        String mauCauGiuaChieu = null;
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        String dauCau;
        String thayDoi;
        String giuaCau = giuaCauChieu.get(random.nextInt(giuaCauChieu.size()));
        String symbol = stock.getSymbol();
        double khoiLuong = stock.getVolume();
        double giaMoCuaGiuaChieu = stock.getGiaDauPhienChieu();
        double giaGiuaPhienChieu = stock.getGiaGiuaPhienChieu();
        float chenhLech = (float) (giaGiuaPhienChieu - giaMoCuaGiuaChieu);

        if (chenhLech >= 0) {
            dauCau = dauCauTang.get(random.nextInt(dauCauTang.size()));
            thayDoi = " tăng thêm ";
        } else {
            dauCau = dauCauGiam.get(random.nextInt(dauCauGiam.size()));
            thayDoi = " giảm đi ";
        }
        sb.append(dauCau);
        sb.append(symbol);
        sb.append(thayDoi);
        sb.append(" điểm, hiện đạt ");
        sb.append(giaGiuaPhienChieu);
        sb.append(" điểm, ");
        sb.append(giuaCau);
        sb.append(khoiLuong);
        sb.append(" cổ phiếu");

        mauCauGiuaChieu = sb.toString();

        return mauCauGiuaChieu;
    }
}
