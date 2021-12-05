package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Danhgia;
import model.Donhang;
import model.Uathich;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-05T23:58:25")
@StaticMetamodel(Khachhang.class)
public class Khachhang_ { 

    public static volatile SingularAttribute<Khachhang, String> diaChi;
    public static volatile SingularAttribute<Khachhang, Integer> maKH;
    public static volatile SingularAttribute<Khachhang, String> matKhau;
    public static volatile SingularAttribute<Khachhang, String> sdt;
    public static volatile CollectionAttribute<Khachhang, Donhang> donhangCollection;
    public static volatile CollectionAttribute<Khachhang, Uathich> uathichCollection;
    public static volatile CollectionAttribute<Khachhang, Danhgia> danhgiaCollection;
    public static volatile SingularAttribute<Khachhang, Boolean> trangThai;
    public static volatile SingularAttribute<Khachhang, String> tenTK;
    public static volatile SingularAttribute<Khachhang, String> tenKH;
    public static volatile SingularAttribute<Khachhang, String> email;

}