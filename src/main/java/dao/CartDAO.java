/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import static java.util.Collections.list;
import model.Sanpham;

/**
 *
 * @author PhucNguyen
 */
public class CartDAO {
    
    private ArrayList list = new ArrayList();
    private double total;

    public ArrayList getList() {
        return list;
    }

    public void setList(ArrayList list) {
        this.list = list;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getLineItemCount() {
        return list.size();
    }
    
    public void addCart( String moTa, String price, String quantity) {
        double iPrice = Double.parseDouble(price);
        int iQuantity = Integer.parseInt(quantity);
        Sanpham cartItem = new Sanpham();
        try {
            if (iQuantity > 0) {
                
                cartItem.setMoTa(moTa);
                cartItem.setGia(iPrice);
                cartItem.setSoLuong(iQuantity);
                list.add(cartItem);
            }

        } catch (NumberFormatException nfe) {
            System.out.println("Error while parsing from String to primitive types: " + nfe.getMessage());
            nfe.printStackTrace();
        }
    }
}
