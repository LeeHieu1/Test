/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import model.Cauhinh;

/**
 *
 * @author PhucNguyen
 */
public class CauhinhDAOImpl implements CauhinhDAO{

    @Override
    public Cauhinh getCauhinh(int masp) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        Cauhinh entity = em.find(Cauhinh.class, masp);
        return entity;
    }
    
    public static void main(String[] args) {
        CauhinhDAOImpl dao = new CauhinhDAOImpl();
        Cauhinh ch = dao.getCauhinh(1);
        System.out.println(ch);
    }
    
}
