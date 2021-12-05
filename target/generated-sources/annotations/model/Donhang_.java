package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Chitietdonhang;
import model.Khachhang;
import model.Thanhtoan;
import model.Vanchuyen;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-05T23:58:25")
@StaticMetamodel(Donhang.class)
public class Donhang_ { 

    public static volatile SingularAttribute<Donhang, String> diaChi;
    public static volatile SingularAttribute<Donhang, String> sdt;
    public static volatile SingularAttribute<Donhang, Khachhang> maKH;
    public static volatile SingularAttribute<Donhang, Vanchuyen> maVC;
    public static volatile SingularAttribute<Donhang, Boolean> trangThai;
    public static volatile CollectionAttribute<Donhang, Chitietdonhang> chitietdonhangCollection;
    public static volatile SingularAttribute<Donhang, Float> tongTien;
    public static volatile SingularAttribute<Donhang, Thanhtoan> maTT;
    public static volatile SingularAttribute<Donhang, Date> ngayMua;
    public static volatile SingularAttribute<Donhang, String> tenKH;
    public static volatile SingularAttribute<Donhang, Integer> maDH;
    public static volatile SingularAttribute<Donhang, String> email;

}