package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Donhang;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-05T23:58:25")
@StaticMetamodel(Thanhtoan.class)
public class Thanhtoan_ { 

    public static volatile CollectionAttribute<Thanhtoan, Donhang> donhangCollection;
    public static volatile SingularAttribute<Thanhtoan, Boolean> trangThai;
    public static volatile SingularAttribute<Thanhtoan, Integer> maTT;
    public static volatile SingularAttribute<Thanhtoan, String> moTa;
    public static volatile SingularAttribute<Thanhtoan, String> tenTT;

}