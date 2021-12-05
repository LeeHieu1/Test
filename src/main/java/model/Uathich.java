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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PhucNguyen
 */
@Entity
@Table(name = "uathich")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uathich.findAll", query = "SELECT u FROM Uathich u"),
    @NamedQuery(name = "Uathich.findByMaUT", query = "SELECT u FROM Uathich u WHERE u.maUT = :maUT")})
public class Uathich implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaUT")
    private Integer maUT;
    @JoinColumn(name = "MaKH", referencedColumnName = "MaKH")
    @ManyToOne
    private Khachhang maKH;
    @JoinColumn(name = "MaSP", referencedColumnName = "MaSP")
    @ManyToOne
    private Sanpham maSP;

    public Uathich() {
    }

    public Uathich(Integer maUT) {
        this.maUT = maUT;
    }

    public Integer getMaUT() {
        return maUT;
    }

    public void setMaUT(Integer maUT) {
        this.maUT = maUT;
    }

    public Khachhang getMaKH() {
        return maKH;
    }

    public void setMaKH(Khachhang maKH) {
        this.maKH = maKH;
    }

    public Sanpham getMaSP() {
        return maSP;
    }

    public void setMaSP(Sanpham maSP) {
        this.maSP = maSP;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maUT != null ? maUT.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uathich)) {
            return false;
        }
        Uathich other = (Uathich) object;
        if ((this.maUT == null && other.maUT != null) || (this.maUT != null && !this.maUT.equals(other.maUT))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Uathich[ maUT=" + maUT + " ]";
    }
    
}
