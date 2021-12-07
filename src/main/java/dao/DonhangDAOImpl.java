package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Donhang;

public class DonhangDAOImpl implements DonhangDAO {

    @Override
    public List<Donhang> getList() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT s FROM Donhang s";

        TypedQuery<Donhang> q = em.createQuery(qString, Donhang.class);

        List<Donhang> dh = q.getResultList();

        return dh;
    }

    @Override
    public List<Donhang> insertDH(String tenKH, String Email, String DiaChi, String SDT) {
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "INSERT INTO DonHang(TenKH, Email, DiaChi, SDT) VALUES(?,?,?,?)";

        TypedQuery<Donhang> q = em.createQuery(qString, Donhang.class);

        List<Donhang> dh1 = q.getResultList();

        return dh1;
    }

}
