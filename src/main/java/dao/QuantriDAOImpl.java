package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.Quantri;


public class QuantriDAOImpl implements QuantriDAO {

    @Override
    public Quantri login(String username, String password) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT q FROM Quantri q WHERE q.taiKhoan = :username "
                + "AND q.matKhau = :password";

        TypedQuery<Quantri> q = em.createQuery(qString, Quantri.class);
        
        q.setParameter("username", username);
        q.setParameter("password", password);

        Quantri qtr = null;
        
        try {
            qtr = q.getSingleResult();
            if (qtr == null) {
                qtr = null;
            }
        } catch (NoResultException e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return qtr;
    }
    
     public static void main(String[] args) {
        QuantriDAOImpl sp = new QuantriDAOImpl();
        Quantri ls = new Quantri();
        ls = sp.login("admin", "admin");
        System.out.println(ls);
    }
}
