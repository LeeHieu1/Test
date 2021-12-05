package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.Vanchuyen;

public class VanchuyenDAOImpl implements VanchuyenDAO {

    @Override
    public List<Vanchuyen> getList() {

        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT s FROM Vanchuyen s";

        TypedQuery<Vanchuyen> q = em.createQuery(qString, Vanchuyen.class);

        List<Vanchuyen> vch = null;
        try {
            vch = q.getResultList();

            if (vch == null) {
                vch = null;
            }
        } catch (NoResultException e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return vch;

    }

    

    @Override
    public Vanchuyen getVanchuyen(int id) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT s FROM Vanchuyen s where s.maVC = :id";
        TypedQuery<Vanchuyen> q = em.createQuery(qString, Vanchuyen.class);
        q.setParameter("id", id);
        Vanchuyen sp = q.getSingleResult();
        return sp;
    }
    
    public static void main(String[] args) {
        VanchuyenDAOImpl dAO = new VanchuyenDAOImpl();
        Vanchuyen sp = dAO.getVanchuyen(1);

        System.out.println(sp);
    }
}
