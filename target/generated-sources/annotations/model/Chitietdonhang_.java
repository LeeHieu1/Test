package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Donhang;
import model.Sanpham;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-05T23:58:25")
@StaticMetamodel(Chitietdonhang.class)
public class Chitietdonhang_ { 

    public static volatile SingularAttribute<Chitietdonhang, Float> giaTien;
    public static volatile SingularAttribute<Chitietdonhang, Sanpham> maSP;
    public static volatile SingularAttribute<Chitietdonhang, Boolean> trangThai;
    public static volatile SingularAttribute<Chitietdonhang, Donhang> maDH;
    public static volatile SingularAttribute<Chitietdonhang, Integer> maCTDH;
    public static volatile SingularAttribute<Chitietdonhang, Integer> soLuong;

}