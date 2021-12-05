/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PhucNguyen
 */
@Entity
@Table(name = "thanhtoan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Thanhtoan.findAll", query = "SELECT t FROM Thanhtoan t"),
    @NamedQuery(name = "Thanhtoan.findByMaTT", query = "SELECT t FROM Thanhtoan t WHERE t.maTT = :maTT"),
    @NamedQuery(name = "Thanhtoan.findByTenTT", query = "SELECT t FROM Thanhtoan t WHERE t.tenTT = :tenTT"),
    @NamedQuery(name = "Thanhtoan.findByMoTa", query = "SELECT t FROM Thanhtoan t WHERE t.moTa = :moTa"),
    @NamedQuery(name = "Thanhtoan.findByTrangThai", query = "SELECT t FROM Thanhtoan t WHERE t.trangThai = :trangThai")})
public class Thanhtoan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaTT")
    private Integer maTT;
    @Size(max = 500)
    @Column(name = "TenTT")
    private String tenTT;
    @Size(max = 500)
    @Column(name = "MoTa")
    private String moTa;
    @Column(name = "TrangThai")
    private Boolean trangThai;
    @OneToMany(mappedBy = "maTT")
    private Collection<Donhang> donhangCollection;

    public Thanhtoan() {
    }

    public Thanhtoan(Integer maTT) {
        this.maTT = maTT;
    }

    public Integer getMaTT() {
        return maTT;
    }

    public void setMaTT(Integer maTT) {
        this.maTT = maTT;
    }

    public String getTenTT() {
        return tenTT;
    }

    public void setTenTT(String tenTT) {
        this.tenTT = tenTT;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    @XmlTransient
    public Collection<Donhang> getDonhangCollection() {
        return donhangCollection;
    }

    public void setDonhangCollection(Collection<Donhang> donhangCollection) {
        this.donhangCollection = donhangCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maTT != null ? maTT.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thanhtoan)) {
            return false;
        }
        Thanhtoan other = (Thanhtoan) object;
        if ((this.maTT == null && other.maTT != null) || (this.maTT != null && !this.maTT.equals(other.maTT))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MaTT " + maTT + "TenTT" + tenTT + "MoTa " + moTa;
    }
    
}
