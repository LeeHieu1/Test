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
@Table(name = "vanchuyen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vanchuyen.findAll", query = "SELECT v FROM Vanchuyen v"),
    @NamedQuery(name = "Vanchuyen.findByMaVC", query = "SELECT v FROM Vanchuyen v WHERE v.maVC = :maVC"),
    @NamedQuery(name = "Vanchuyen.findByTenVC", query = "SELECT v FROM Vanchuyen v WHERE v.tenVC = :tenVC"),
    @NamedQuery(name = "Vanchuyen.findByGia", query = "SELECT v FROM Vanchuyen v WHERE v.gia = :gia"),
    @NamedQuery(name = "Vanchuyen.findByMoTa", query = "SELECT v FROM Vanchuyen v WHERE v.moTa = :moTa"),
    @NamedQuery(name = "Vanchuyen.findByTrangThai", query = "SELECT v FROM Vanchuyen v WHERE v.trangThai = :trangThai")})
public class Vanchuyen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaVC")
    private Integer maVC;
    @Size(max = 500)
    @Column(name = "TenVC")
    private String tenVC;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Gia")
    private Float gia;
    @Size(max = 500)
    @Column(name = "MoTa")
    private String moTa;
    @Column(name = "TrangThai")
    private Boolean trangThai;
    @OneToMany(mappedBy = "maVC")
    private Collection<Donhang> donhangCollection;

    public Vanchuyen() {
    }

    public Vanchuyen(Integer maVC) {
        this.maVC = maVC;
    }

    public Integer getMaVC() {
        return maVC;
    }

    public void setMaVC(Integer maVC) {
        this.maVC = maVC;
    }

    public String getTenVC() {
        return tenVC;
    }

    public void setTenVC(String tenVC) {
        this.tenVC = tenVC;
    }

    public Float getGia() {
        return gia;
    }

    public void setGia(Float gia) {
        this.gia = gia;
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
        hash += (maVC != null ? maVC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vanchuyen)) {
            return false;
        }
        Vanchuyen other = (Vanchuyen) object;
        if ((this.maVC == null && other.maVC != null) || (this.maVC != null && !this.maVC.equals(other.maVC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MaVC" + maVC + "TenVC" + tenVC + "Gia" +gia + "MoTa" + moTa;
    }
    
}
