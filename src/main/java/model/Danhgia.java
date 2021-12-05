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
@Table(name = "danhgia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Danhgia.findAll", query = "SELECT d FROM Danhgia d"),
    @NamedQuery(name = "Danhgia.findByMaDG", query = "SELECT d FROM Danhgia d WHERE d.maDG = :maDG"),
    @NamedQuery(name = "Danhgia.findByNoidung", query = "SELECT d FROM Danhgia d WHERE d.noidung = :noidung")})
public class Danhgia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaDG")
    private Integer maDG;
    @Column(name = "Noidung")
    private Integer noidung;
    @JoinColumn(name = "MaKH", referencedColumnName = "MaKH")
    @ManyToOne
    private Khachhang maKH;
    @JoinColumn(name = "MaSP", referencedColumnName = "MaSP")
    @ManyToOne
    private Sanpham maSP;

    public Danhgia() {
    }

    public Danhgia(Integer maDG) {
        this.maDG = maDG;
    }

    public Integer getMaDG() {
        return maDG;
    }

    public void setMaDG(Integer maDG) {
        this.maDG = maDG;
    }

    public Integer getNoidung() {
        return noidung;
    }

    public void setNoidung(Integer noidung) {
        this.noidung = noidung;
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
        hash += (maDG != null ? maDG.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Danhgia)) {
            return false;
        }
        Danhgia other = (Danhgia) object;
        if ((this.maDG == null && other.maDG != null) || (this.maDG != null && !this.maDG.equals(other.maDG))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Danhgia[ maDG=" + maDG + " ]";
    }
    
}
