package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Uathich;

public class UathichDAOImpl implements UathichDAO {

    @Override
    public List<Uathich> getList() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT s FROM Uathich s";

        TypedQuery<Uathich> q = em.createQuery(qString, Uathich.class);

        List<Uathich> ut = q.getResultList();

        return ut;
    }

}
