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
@Table(name = "quantri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quantri.findAll", query = "SELECT q FROM Quantri q"),
    @NamedQuery(name = "Quantri.findByMaQT", query = "SELECT q FROM Quantri q WHERE q.maQT = :maQT"),
    @NamedQuery(name = "Quantri.findByTenQT", query = "SELECT q FROM Quantri q WHERE q.tenQT = :tenQT"),
    @NamedQuery(name = "Quantri.findByTaiKhoan", query = "SELECT q FROM Quantri q WHERE q.taiKhoan = :taiKhoan"),
    @NamedQuery(name = "Quantri.findByMatKhau", query = "SELECT q FROM Quantri q WHERE q.matKhau = :matKhau"),
    @NamedQuery(name = "Quantri.findByTrangThai", query = "SELECT q FROM Quantri q WHERE q.trangThai = :trangThai")})
public class Quantri implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaQT")
    private Integer maQT;
    @Size(max = 500)
    @Column(name = "TenQT")
    private String tenQT;
    @Size(max = 500)
    @Column(name = "TaiKhoan")
    private String taiKhoan;
    @Size(max = 500)
    @Column(name = "MatKhau")
    private String matKhau;
    @Column(name = "TrangThai")
    private Boolean trangThai;

    public Quantri() {
    }

    public Quantri(Integer maQT) {
        this.maQT = maQT;
    }

    public Integer getMaQT() {
        return maQT;
    }

    public void setMaQT(Integer maQT) {
        this.maQT = maQT;
    }

    public String getTenQT() {
        return tenQT;
    }

    public void setTenQT(String tenQT) {
        this.tenQT = tenQT;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
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
        hash += (maQT != null ? maQT.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quantri)) {
            return false;
        }
        Quantri other = (Quantri) object;
        if ((this.maQT == null && other.maQT != null) || (this.maQT != null && !this.maQT.equals(other.maQT))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Quantri[ maQT=" + maQT + " ]";
    }
    
}
