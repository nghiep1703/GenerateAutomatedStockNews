package maucau;

import stockmarket.BigStock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MauCauGiuaChieu3 implements MauCau {
    private static List<String> dauCauChieuTang;
    private static List<String> dauCauChieuGiam;
    private static List<String> giuaCauChieuTang;
    private static List<String> giuaCauChieuGiam;


    private BigStock stock;

    public MauCauGiuaChieu3(BigStock stock) {
        this.stock = stock;
        dauCauChieuTang = new ArrayList<String>();
        dauCauChieuGiam = new ArrayList<String>();
        giuaCauChieuTang = new ArrayList<String>();
        giuaCauChieuGiam = new ArrayList<String>();


        dauCauChieuTang.add("Tiếp tục tín hiệu từ đầu buổi chiều hôm nay, ");
        dauCauChieuTang.add("Mở của phiên giữa chiều, ");
        dauCauChieuTang.add("Với sự khởi sắc trong buổi chiề, ");

        dauCauChieuTang.add("Mở cửa phiên giữa chiều, ");
        dauCauChieuGiam.add("Tín hiệu không tốt cho buổi chiều, ");

        giuaCauChieuTang.add(" tăng thêm");
        giuaCauChieuTang.add(" tiếp tục tín hiệu tốt khi nhích thêm");
        giuaCauChieuTang.add(" nhích thêm ");
        giuaCauChieuTang.add(" cộng thêm");

        giuaCauChieuGiam.add(" có sự thay đổi và giảm ");
        giuaCauChieuGiam.add(" giảm đi ");
        giuaCauChieuGiam.add(" có tín hiệu xấu khi giảm đi ");
    }

    public String sinhCau() {
        String mauCauGiuaChieu = null;
        StringBuffer sb = new StringBuffer();
        String dauCau;
        String giuaCau;
        String symbol = stock.getSymbol();

        double giaMoCuaGiuaChieu = stock.getGiaDauPhienChieu();
        double giaGiuaPhienChieu = stock.getGiaGiuaPhienChieu();
        float chenhLech = (float) (giaGiuaPhienChieu - giaMoCuaGiuaChieu);

        if (chenhLech >= 0) {
            dauCau = dauCauChieuTang.get(new Random().nextInt(dauCauChieuTang.size()));
            giuaCau = giuaCauChieuTang.get(new Random().nextInt(giuaCauChieuTang.size()));
        } else {
            dauCau = dauCauChieuGiam.get(new Random().nextInt(dauCauChieuGiam.size()));
            giuaCau = giuaCauChieuGiam.get(new Random().nextInt(giuaCauChieuGiam.size()));
        }
        sb.append(dauCau);
        sb.append(symbol);
        sb.append(giuaCau);
        sb.append(Math.abs(chenhLech));
        sb.append(" điểm, hiện đang ở mức ");
        sb.append(giaGiuaPhienChieu);
        sb.append(" điểm.");

        mauCauGiuaChieu = sb.toString();

        return mauCauGiuaChieu;
    }
}
