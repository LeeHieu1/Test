package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Sanpham;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-05T23:58:25")
@StaticMetamodel(Nhacungcap.class)
public class Nhacungcap_ { 

    public static volatile SingularAttribute<Nhacungcap, String> tenNCC;
    public static volatile SingularAttribute<Nhacungcap, Boolean> trangThai;
    public static volatile SingularAttribute<Nhacungcap, Integer> maNCC;
    public static volatile CollectionAttribute<Nhacungcap, Sanpham> sanphamCollection;
    public static volatile SingularAttribute<Nhacungcap, Integer> maNhomSP;

}