package dao;

import java.util.List;
import model.Nhacungcap;
import model.Nhomsanpham;


/**
 *
 * @author BaoThanh
 */
public interface NSP_NCC_DAO {

    public List<Nhacungcap> getListNCC();
    
    public List<Nhomsanpham> getListNSP();
     
}
