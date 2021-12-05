package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.Nhacungcap;
import model.Nhomsanpham;
import model.Sanpham;

/**
 *
 * @author BaoThanh
 */
public class NSP_NCC_DAOImpl implements NSP_NCC_DAO {

    @Override
    public List<Nhacungcap> getListNCC() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT s FROM Nhacungcap s";

        TypedQuery<Nhacungcap> q = em.createQuery(qString, Nhacungcap.class);

        List<Nhacungcap> ncc = null;
        try {
            ncc = q.getResultList();

            if (ncc == null) {
                ncc = null;
            }
        } catch (NoResultException e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return ncc;
    }

    @Override
    public List<Nhomsanpham> getListNSP() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT s FROM Nhomsanpham s";

        TypedQuery<Nhomsanpham> q = em.createQuery(qString, Nhomsanpham.class);

        List<Nhomsanpham> nsp = null;
        try {
            nsp = q.getResultList();

            if (nsp == null) {
                nsp = null;
            }
        } catch (NoResultException e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return nsp;
    }

}
