package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.Nhomsanpham;
import model.Sanpham;

public class SanphamDAOImpl implements SanphamDAO {

    @Override
    public List<Sanpham> getListSPgia() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT s FROM Sanpham s WHERE s.gia >= 20000";

        TypedQuery<Sanpham> q = em.createQuery(qString, Sanpham.class);

        List<Sanpham> sp = null;
        try {
            sp = q.getResultList();

            if (sp == null) {
                sp = null;
            }
        } catch (NoResultException e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return sp;
    }

    @Override
    public List<Sanpham> getList() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT s FROM Sanpham s";

        TypedQuery<Sanpham> q = em.createQuery(qString, Sanpham.class);

        List<Sanpham> sp = q.getResultList();

        return sp;
    }

    @Override
    public Sanpham getSanpham(int idsp) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        Sanpham entity = em.find(Sanpham.class, idsp);
        return entity;
    }

    @Override
    public List<Sanpham> getSanphamByIDmaNhomSP(int mnsp) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "SELECT s FROM Sanpham s where s.maNhomSP = d";
        TypedQuery<Sanpham> list = em.createQuery(query, Sanpham.class);

        List<Sanpham> sp = null;

        try {
            sp = list.getResultList();

            if (sp == null) {
                sp = null;
            }
        } catch (NoResultException e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return sp;
    }

    @Override
    public List<Sanpham> searchByName(String name) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "SELECT s FROM Sanpham s WHERE s.tenSP LIKE :name ";
        TypedQuery<Sanpham> list = em.createQuery(query, Sanpham.class);
        list.setParameter("name", "%" + name + "%");
        List<Sanpham> listsp = list.getResultList();
        return listsp;
    }

    @Override
    public Sanpham getTennhomSanphamByIDSP(int idsp) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "Select t.tenSP from Sanpham as t where t.maSP = :id";
        TypedQuery<Sanpham> list = em.createQuery(query, Sanpham.class);
        list.setParameter("id", idsp);
        Sanpham sp = list.getSingleResult();
        return sp;
    }

    @Override
    public List<Sanpham> getThuongHieu(String th) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "Select t from Sanpham as t where t.thuongHieu = :th";
        TypedQuery<Sanpham> list = em.createQuery(query, Sanpham.class);
        list.setParameter("th", th);
        List<Sanpham> sp = list.getResultList();
        return sp;
    }

    @Override
    public List<Sanpham> getSanphamByPrice() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "Select t from Sanpham as t where t.gia >= 30";
        TypedQuery<Sanpham> list = em.createQuery(query, Sanpham.class);
        List<Sanpham> sp = list.getResultList();
        return sp;
    }

    @Override
    public void updateSP(Sanpham sp) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(sp);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Sanpham> getSanphamByPrice15() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "Select t from Sanpham as t where t.gia >= 16.9 and t.gia <=18";
        TypedQuery<Sanpham> list = em.createQuery(query, Sanpham.class);
        List<Sanpham> sp = list.getResultList();
        return sp;
    }

    @Override
    public List<Sanpham> getSPPhanTrang(int index) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "Select t from Sanpham t where t.maSP > :id ";
        TypedQuery<Sanpham> list = em.createQuery(query, Sanpham.class);
        int t = (index-1)*8;
        list.setParameter("id", t);
        List<Sanpham> sp = list.setMaxResults(8).getResultList();
        return sp;
    }

    public static void main(String[] args) {

        SanphamDAOImpl sp = new SanphamDAOImpl();
        List<Sanpham> ls = sp.getSPPhanTrang(2);
        System.out.println(ls);

    }

    @Override
    public List<Sanpham> getSPPhanTrangCategory(int index) {
         EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "Select t from Sanpham t where t.maSP > :id ";
        TypedQuery<Sanpham> list = em.createQuery(query, Sanpham.class);
        int t = (index-1)*4;
        list.setParameter("id", t);
        List<Sanpham> sp = list.setMaxResults(4).getResultList();
        return sp;
    }

}
