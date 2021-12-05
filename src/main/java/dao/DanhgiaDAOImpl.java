package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Donhang;
import model.Khachhang;

public class DanhgiaDAOImpl implements DanhgiaDAO {

    @Override
    public List<Khachhang> getList() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT s FROM Khachhang k, Danhgia d"
                + " WHERE k.maKH = d.maKH";

        TypedQuery<Khachhang> q = em.createQuery(qString, Khachhang.class);

        List<Khachhang> dg = q.getResultList();

        return dg;
    }
    
    public static void main(String[] args) {
        DanhgiaDAOImpl dao =  new DanhgiaDAOImpl();
        List<Khachhang> sp =  dao.getList();
        
        System.out.println(sp);
    }
}
