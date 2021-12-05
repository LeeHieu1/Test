/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PhucNguyen
 */
@Entity
@Table(name = "cart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c"),
    @NamedQuery(name = "Cart.findByMaSP", query = "SELECT c FROM Cart c WHERE c.maSP = :maSP"),
    @NamedQuery(name = "Cart.findByQuantity", query = "SELECT c FROM Cart c WHERE c.quantity = :quantity")})
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaSP")
    private Integer maSP;
    @Column(name = "quantity")
    private Integer quantity;
    @JoinColumn(name = "MaSP", referencedColumnName = "MaSP", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Sanpham sanpham;

    public Cart() {
    }

    public Cart(Integer maSP) {
        this.maSP = maSP;
    }

    public Integer getMaSP() {
        return maSP;
    }

    public void setMaSP(Integer maSP) {
        this.maSP = maSP;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Sanpham getSanpham() {
        return sanpham;
    }

    public void setSanpham(Sanpham sanpham) {
        this.sanpham = sanpham;
    }
    
    public double getTotal() {
        double total = quantity * sanpham.getGia();
        return total;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maSP != null ? maSP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cart)) {
            return false;
        }
        Cart other = (Cart) object;
        if ((this.maSP == null && other.maSP != null) || (this.maSP != null && !this.maSP.equals(other.maSP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cart[ maSP=" + maSP + " ]";
    }
    
}
