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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PhucNguyen
 */
@Entity
@Table(name = "quangcao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quangcao.findAll", query = "SELECT q FROM Quangcao q"),
    @NamedQuery(name = "Quangcao.findByMaQC", query = "SELECT q FROM Quangcao q WHERE q.maQC = :maQC"),
    @NamedQuery(name = "Quangcao.findByTenQC", query = "SELECT q FROM Quangcao q WHERE q.tenQC = :tenQC"),
    @NamedQuery(name = "Quangcao.findByAnh", query = "SELECT q FROM Quangcao q WHERE q.anh = :anh"),
    @NamedQuery(name = "Quangcao.findByGia", query = "SELECT q FROM Quangcao q WHERE q.gia = :gia"),
    @NamedQuery(name = "Quangcao.findByNhaSanXuat", query = "SELECT q FROM Quangcao q WHERE q.nhaSanXuat = :nhaSanXuat"),
    @NamedQuery(name = "Quangcao.findByMoTa", query = "SELECT q FROM Quangcao q WHERE q.moTa = :moTa"),
    @NamedQuery(name = "Quangcao.findByTrangThai", query = "SELECT q FROM Quangcao q WHERE q.trangThai = :trangThai")})
public class Quangcao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaQC")
    private Integer maQC;
    @Size(max = 500)
    @Column(name = "TenQC")
    private String tenQC;
    @Size(max = 500)
    @Column(name = "Anh")
    private String anh;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Gia")
    private Float gia;
    @Size(max = 500)
    @Column(name = "NhaSanXuat")
    private String nhaSanXuat;
    @Size(max = 500)
    @Column(name = "MoTa")
    private String moTa;
    @Column(name = "TrangThai")
    private Boolean trangThai;

    public Quangcao() {
    }

    public Quangcao(Integer maQC) {
        this.maQC = maQC;
    }

    public Integer getMaQC() {
        return maQC;
    }

    public void setMaQC(Integer maQC) {
        this.maQC = maQC;
    }

    public String getTenQC() {
        return tenQC;
    }

    public void setTenQC(String tenQC) {
        this.tenQC = tenQC;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public Float getGia() {
        return gia;
    }

    public void setGia(Float gia) {
        this.gia = gia;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maQC != null ? maQC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quangcao)) {
            return false;
        }
        Quangcao other = (Quangcao) object;
        if ((this.maQC == null && other.maQC != null) || (this.maQC != null && !this.maQC.equals(other.maQC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Quangcao[ maQC=" + maQC + " ]";
    }
    
}
