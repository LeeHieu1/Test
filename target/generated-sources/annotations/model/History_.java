package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-05T23:58:25")
@StaticMetamodel(History.class)
public class History_ { 

    public static volatile SingularAttribute<History, Integer> maSanPham;
    public static volatile SingularAttribute<History, Integer> idHistory;
    public static volatile SingularAttribute<History, Date> ngayMua;
    public static volatile SingularAttribute<History, Double> thanhTien;
    public static volatile SingularAttribute<History, Integer> userId;
    public static volatile SingularAttribute<History, Integer> soLuong;

}