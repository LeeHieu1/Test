package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.Khachhang;

public class KhachhangDAOImpl implements KhachhangDAO {

    @Override
    public void addKH(Khachhang u) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(u);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public boolean checkKH(String username) {
        return false;
    }

    @Override
    public Khachhang login(String username, String password) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT k FROM Khachhang k WHERE k.tenTK = :username "
                + "AND k.matKhau = :password";

        TypedQuery<Khachhang> q = em.createQuery(qString, Khachhang.class);
        q.setParameter("username", username);
        q.setParameter("password", password);

        Khachhang kh = null;
        try {
            kh = q.getSingleResult();
            if (kh == null) {
                kh = null;
            }
        } catch (NoResultException e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return kh;
    }

    @Override
    public void updateKH(Khachhang u) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(u);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public Khachhang getKH(String username) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT k FROM Khachhang k WHERE k.tenKH = :username";

        TypedQuery<Khachhang> q = em.createQuery(qString, Khachhang.class);

        q.setParameter("username", username);

        Khachhang kh = null;
        try {
            kh = q.getSingleResult();
            if (kh == null) {
                kh = null;
            }
        } catch (NoResultException e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return kh;
    }

    @Override
    public List<Khachhang> getList() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT s FROM Khachhang s";

        TypedQuery<Khachhang> q = em.createQuery(qString, Khachhang.class);

        List<Khachhang> kh = q.getResultList();

        return kh;
    }

    
    public static void main(String[] args) {
        KhachhangDAOImpl dao = new KhachhangDAOImpl();
        List<Khachhang> sp = dao.getList();
        System.out.println(sp);
    }
}
