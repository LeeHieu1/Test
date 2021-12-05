/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Khuyenmai;

/**
 *
 * @author PhucNguyen
 */
public class KhuyenmaiDAOImpl implements KhuyenmaiDAO {

    @Override
    public Khuyenmai getGiatriKhuyenmai(int makm) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "Select t from Khuyenmai as t where t.maKM = :id";
        TypedQuery<Khuyenmai> km = em.createQuery(query, Khuyenmai.class);
        km.setParameter("id", makm);
        Khuyenmai sp = km.getSingleResult();
        return sp;
    }

    public static void main(String[] args) {
        KhuyenmaiDAOImpl dao = new KhuyenmaiDAOImpl();
        List<Khuyenmai> sp = dao.getALL();
        System.out.println(sp);
    }

    @Override
    public List<Khuyenmai> getALL() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "Select t from Khuyenmai t";
        TypedQuery<Khuyenmai> km = em.createQuery(query, Khuyenmai.class);
        List<Khuyenmai> sp = km.getResultList();
        return sp;
    }
    
    
    
}
