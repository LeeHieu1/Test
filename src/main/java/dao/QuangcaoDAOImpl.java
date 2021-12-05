package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Quangcao;

public class QuangcaoDAOImpl implements QuangcaoDAO {

    @Override
    public List<Quangcao> getList() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT s FROM Quangcao s";

        TypedQuery<Quangcao> q = em.createQuery(qString, Quangcao.class);

        List<Quangcao> qc = null;
        try {
            qc = q.getResultList();

            if (qc == null) {
                qc = null;
            }
        } catch (NoResultException e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return qc;
    }
    
    public static void main(String[] args) {
        QuangcaoDAOImpl dao =  new QuangcaoDAOImpl();
        List<Quangcao> sp =  dao.getList();
        
        System.out.println(sp);
    }
}
