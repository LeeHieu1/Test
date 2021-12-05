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
@Table(name = "khachhang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Khachhang.findAll", query = "SELECT k FROM Khachhang k"),
    @NamedQuery(name = "Khachhang.findByMaKH", query = "SELECT k FROM Khachhang k WHERE k.maKH = :maKH"),
    @NamedQuery(name = "Khachhang.findByTenKH", query = "SELECT k FROM Khachhang k WHERE k.tenKH = :tenKH"),
    @NamedQuery(name = "Khachhang.findByTenTK", query = "SELECT k FROM Khachhang k WHERE k.tenTK = :tenTK"),
    @NamedQuery(name = "Khachhang.findByMatKhau", query = "SELECT k FROM Khachhang k WHERE k.matKhau = :matKhau"),
    @NamedQuery(name = "Khachhang.findByDiaChi", query = "SELECT k FROM Khachhang k WHERE k.diaChi = :diaChi"),
    @NamedQuery(name = "Khachhang.findBySdt", query = "SELECT k FROM Khachhang k WHERE k.sdt = :sdt"),
    @NamedQuery(name = "Khachhang.findByEmail", query = "SELECT k FROM Khachhang k WHERE k.email = :email"),
    @NamedQuery(name = "Khachhang.findByTrangThai", query = "SELECT k FROM Khachhang k WHERE k.trangThai = :trangThai")})
public class Khachhang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaKH")
    private Integer maKH;
    @Size(max = 500)
    @Column(name = "TenKH")
    private String tenKH;
    @Size(max = 50)
    @Column(name = "TenTK")
    private String tenTK;
    @Size(max = 50)
    @Column(name = "MatKhau")
    private String matKhau;
    @Size(max = 500)
    @Column(name = "DiaChi")
    private String diaChi;
    @Size(max = 20)
    @Column(name = "SDT")
    private String sdt;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 500)
    @Column(name = "Email")
    private String email;
    @Column(name = "TrangThai")
    private Boolean trangThai;
    @OneToMany(mappedBy = "maKH")
    private Collection<Donhang> donhangCollection;
    @OneToMany(mappedBy = "maKH")
    private Collection<Danhgia> danhgiaCollection;
    @OneToMany(mappedBy = "maKH")
    private Collection<Uathich> uathichCollection;

    public Khachhang() {
    }

    public Khachhang(String tenKH, String tenTK, String matKhau,
            String diaChi, String sdt, String email) {
        this.tenKH = tenKH;
        this.tenTK = tenTK;
        this.matKhau = matKhau;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
    }
    public Khachhang(Integer maKH) {
        this.maKH = maKH;
    }

    public Integer getMaKH() {
        return maKH;
    }

    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @XmlTransient
    public Collection<Danhgia> getDanhgiaCollection() {
        return danhgiaCollection;
    }

    public void setDanhgiaCollection(Collection<Danhgia> danhgiaCollection) {
        this.danhgiaCollection = danhgiaCollection;
    }

    @XmlTransient
    public Collection<Uathich> getUathichCollection() {
        return uathichCollection;
    }

    public void setUathichCollection(Collection<Uathich> uathichCollection) {
        this.uathichCollection = uathichCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maKH != null ? maKH.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Khachhang)) {
            return false;
        }
        Khachhang other = (Khachhang) object;
        if ((this.maKH == null && other.maKH != null) || (this.maKH != null && !this.maKH.equals(other.maKH))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Khachhang[ maKH=" + maKH + " ]";
    }
    
}
