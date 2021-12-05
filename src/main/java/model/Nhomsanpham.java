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
@Table(name = "nhomsanpham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nhomsanpham.findAll", query = "SELECT n FROM Nhomsanpham n"),
    @NamedQuery(name = "Nhomsanpham.findByMaNhomSP", query = "SELECT n FROM Nhomsanpham n WHERE n.maNhomSP = :maNhomSP"),
    @NamedQuery(name = "Nhomsanpham.findByTenNhomSP", query = "SELECT n FROM Nhomsanpham n WHERE n.tenNhomSP = :tenNhomSP"),
    @NamedQuery(name = "Nhomsanpham.findByTrangThai", query = "SELECT n FROM Nhomsanpham n WHERE n.trangThai = :trangThai")})
public class Nhomsanpham implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaNhomSP")
    private Integer maNhomSP;
    @Size(max = 500)
    @Column(name = "TenNhomSP")
    private String tenNhomSP;
    @Column(name = "TrangThai")
    private Boolean trangThai;
    @OneToMany(mappedBy = "maNhomSP")
    private Collection<Sanpham> sanphamCollection;

    public Nhomsanpham() {
    }

    public Nhomsanpham(Integer maNhomSP) {
        this.maNhomSP = maNhomSP;
    }

    public Integer getMaNhomSP() {
        return maNhomSP;
    }

    public void setMaNhomSP(Integer maNhomSP) {
        this.maNhomSP = maNhomSP;
    }

    public String getTenNhomSP() {
        return tenNhomSP;
    }

    public void setTenNhomSP(String tenNhomSP) {
        this.tenNhomSP = tenNhomSP;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    @XmlTransient
    public Collection<Sanpham> getSanphamCollection() {
        return sanphamCollection;
    }

    public void setSanphamCollection(Collection<Sanpham> sanphamCollection) {
        this.sanphamCollection = sanphamCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maNhomSP != null ? maNhomSP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nhomsanpham)) {
            return false;
        }
        Nhomsanpham other = (Nhomsanpham) object;
        if ((this.maNhomSP == null && other.maNhomSP != null) || (this.maNhomSP != null && !this.maNhomSP.equals(other.maNhomSP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Nhomsanpham[ maNhomSP=" + maNhomSP + " ]";
    }
    
}
