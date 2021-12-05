package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Sanpham;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-05T23:58:25")
@StaticMetamodel(Nhomsanpham.class)
public class Nhomsanpham_ { 

    public static volatile SingularAttribute<Nhomsanpham, Boolean> trangThai;
    public static volatile CollectionAttribute<Nhomsanpham, Sanpham> sanphamCollection;
    public static volatile SingularAttribute<Nhomsanpham, String> tenNhomSP;
    public static volatile SingularAttribute<Nhomsanpham, Integer> maNhomSP;

}