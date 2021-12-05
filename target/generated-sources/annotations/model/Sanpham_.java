package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cart;
import model.Cauhinh;
import model.Chitietdonhang;
import model.Danhgia;
import model.Nhacungcap;
import model.Nhomsanpham;
import model.Uathich;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-05T23:58:25")
@StaticMetamodel(Sanpham.class)
public class Sanpham_ { 

    public static volatile SingularAttribute<Sanpham, Integer> maSP;
    public static volatile CollectionAttribute<Sanpham, Uathich> uathichCollection;
    public static volatile CollectionAttribute<Sanpham, Danhgia> danhgiaCollection;
    public static volatile SingularAttribute<Sanpham, String> tenSP;
    public static volatile CollectionAttribute<Sanpham, Cauhinh> cauhinhCollection;
    public static volatile SingularAttribute<Sanpham, String> thuongHieu;
    public static volatile SingularAttribute<Sanpham, Nhomsanpham> maNhomSP;
    public static volatile SingularAttribute<Sanpham, Cart> cart;
    public static volatile SingularAttribute<Sanpham, Boolean> trangThai;
    public static volatile CollectionAttribute<Sanpham, Chitietdonhang> chitietdonhangCollection;
    public static volatile SingularAttribute<Sanpham, Nhacungcap> maNCC;
    public static volatile SingularAttribute<Sanpham, String> anh;
    public static volatile SingularAttribute<Sanpham, String> moTa;
    public static volatile SingularAttribute<Sanpham, Double> gia;
    public static volatile SingularAttribute<Sanpham, Integer> soLuong;

}