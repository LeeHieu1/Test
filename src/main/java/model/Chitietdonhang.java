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
@Table(name = "chitietdonhang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chitietdonhang.findAll", query = "SELECT c FROM Chitietdonhang c"),
    @NamedQuery(name = "Chitietdonhang.findByMaCTDH", query = "SELECT c FROM Chitietdonhang c WHERE c.maCTDH = :maCTDH"),
    @NamedQuery(name = "Chitietdonhang.findBySoLuong", query = "SELECT c FROM Chitietdonhang c WHERE c.soLuong = :soLuong"),
    @NamedQuery(name = "Chitietdonhang.findByGiaTien", query = "SELECT c FROM Chitietdonhang c WHERE c.giaTien = :giaTien"),
    @NamedQuery(name = "Chitietdonhang.findByTrangThai", query = "SELECT c FROM Chitietdonhang c WHERE c.trangThai = :trangThai")})
public class Chitietdonhang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaCTDH")
    private Integer maCTDH;
    @Column(name = "SoLuong")
    private Integer soLuong;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "GiaTien")
    private Float giaTien;
    @Column(name = "TrangThai")
    private Boolean trangThai;
    @JoinColumn(name = "MaDH", referencedColumnName = "MaDH")
    @ManyToOne
    private Donhang maDH;
    @JoinColumn(name = "MaSP", referencedColumnName = "MaSP")
    @ManyToOne
    private Sanpham maSP;

    public Chitietdonhang() {
    }

    public Chitietdonhang(Integer maCTDH) {
        this.maCTDH = maCTDH;
    }

    public Integer getMaCTDH() {
        return maCTDH;
    }

    public void setMaCTDH(Integer maCTDH) {
        this.maCTDH = maCTDH;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Float getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Float giaTien) {
        this.giaTien = giaTien;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Donhang getMaDH() {
        return maDH;
    }

    public void setMaDH(Donhang maDH) {
        this.maDH = maDH;
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
        hash += (maCTDH != null ? maCTDH.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chitietdonhang)) {
            return false;
        }
        Chitietdonhang other = (Chitietdonhang) object;
        if ((this.maCTDH == null && other.maCTDH != null) || (this.maCTDH != null && !this.maCTDH.equals(other.maCTDH))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Chitietdonhang[ maCTDH=" + maCTDH + " ]";
    }
    
}
