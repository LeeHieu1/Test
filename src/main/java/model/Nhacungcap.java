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
@Table(name = "nhacungcap")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nhacungcap.findAll", query = "SELECT n FROM Nhacungcap n"),
    @NamedQuery(name = "Nhacungcap.findByMaNCC", query = "SELECT n FROM Nhacungcap n WHERE n.maNCC = :maNCC"),
    @NamedQuery(name = "Nhacungcap.findByTenNCC", query = "SELECT n FROM Nhacungcap n WHERE n.tenNCC = :tenNCC"),
    @NamedQuery(name = "Nhacungcap.findByTrangThai", query = "SELECT n FROM Nhacungcap n WHERE n.trangThai = :trangThai"),
    @NamedQuery(name = "Nhacungcap.findByMaNhomSP", query = "SELECT n FROM Nhacungcap n WHERE n.maNhomSP = :maNhomSP")})
public class Nhacungcap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaNCC")
    private Integer maNCC;
    @Size(max = 500)
    @Column(name = "TenNCC")
    private String tenNCC;
    @Column(name = "TrangThai")
    private Boolean trangThai;
    @Column(name = "MaNhomSP")
    private Integer maNhomSP;
    @OneToMany(mappedBy = "maNCC")
    private Collection<Sanpham> sanphamCollection;

    public Nhacungcap() {
    }

    public Nhacungcap(Integer maNCC) {
        this.maNCC = maNCC;
    }

    public Integer getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(Integer maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Integer getMaNhomSP() {
        return maNhomSP;
    }

    public void setMaNhomSP(Integer maNhomSP) {
        this.maNhomSP = maNhomSP;
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
        hash += (maNCC != null ? maNCC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nhacungcap)) {
            return false;
        }
        Nhacungcap other = (Nhacungcap) object;
        if ((this.maNCC == null && other.maNCC != null) || (this.maNCC != null && !this.maNCC.equals(other.maNCC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Nhacungcap[ maNCC=" + maNCC + " ]";
    }
    
}
