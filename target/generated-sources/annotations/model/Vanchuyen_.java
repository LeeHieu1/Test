package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Donhang;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-05T23:58:25")
@StaticMetamodel(Vanchuyen.class)
public class Vanchuyen_ { 

    public static volatile SingularAttribute<Vanchuyen, Integer> maVC;
    public static volatile CollectionAttribute<Vanchuyen, Donhang> donhangCollection;
    public static volatile SingularAttribute<Vanchuyen, Boolean> trangThai;
    public static volatile SingularAttribute<Vanchuyen, String> tenVC;
    public static volatile SingularAttribute<Vanchuyen, String> moTa;
    public static volatile SingularAttribute<Vanchuyen, Float> gia;

}