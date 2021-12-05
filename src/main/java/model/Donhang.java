/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PhucNguyen
 */
@Entity
@Table(name = "donhang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donhang.findAll", query = "SELECT d FROM Donhang d"),
    @NamedQuery(name = "Donhang.findByMaDH", query = "SELECT d FROM Donhang d WHERE d.maDH = :maDH"),
    @NamedQuery(name = "Donhang.findByTenKH", query = "SELECT d FROM Donhang d WHERE d.tenKH = :tenKH"),
    @NamedQuery(name = "Donhang.findByEmail", query = "SELECT d FROM Donhang d WHERE d.email = :email"),
    @NamedQuery(name = "Donhang.findByDiaChi", query = "SELECT d FROM Donhang d WHERE d.diaChi = :diaChi"),
    @NamedQuery(name = "Donhang.findBySdt", query = "SELECT d FROM Donhang d WHERE d.sdt = :sdt"),
    @NamedQuery(name = "Donhang.findByTongTien", query = "SELECT d FROM Donhang d WHERE d.tongTien = :tongTien"),
    @NamedQuery(name = "Donhang.findByNgayMua", query = "SELECT d FROM Donhang d WHERE d.ngayMua = :ngayMua"),
    @NamedQuery(name = "Donhang.findByTrangThai", query = "SELECT d FROM Donhang d WHERE d.trangThai = :trangThai")})
public class Donhang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaDH")
    private Integer maDH;
    @Size(max = 500)
    @Column(name = "TenKH")
    private String tenKH;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 500)
    @Column(name = "Email")
    private String email;
    @Size(max = 500)
    @Column(name = "DiaChi")
    private String diaChi;
    @Size(max = 500)
    @Column(name = "SDT")
    private String sdt;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TongTien")
    private Float tongTien;
    @Column(name = "NgayMua")
    @Temporal(TemporalType.DATE)
    private Date ngayMua;
    @Column(name = "TrangThai")
    private Boolean trangThai;
    @JoinColumn(name = "MaKH", referencedColumnName = "MaKH")
    @ManyToOne
    private Khachhang maKH;
    @JoinColumn(name = "MaTT", referencedColumnName = "MaTT")
    @ManyToOne
    private Thanhtoan maTT;
    @JoinColumn(name = "MaVC", referencedColumnName = "MaVC")
    @ManyToOne
    private Vanchuyen maVC;
    @OneToMany(mappedBy = "maDH")
    private Collection<Chitietdonhang> chitietdonhangCollection;

    public Donhang() {
    }

    public Donhang(Integer maDH) {
        this.maDH = maDH;
    }

    public Integer getMaDH() {
        return maDH;
    }

    public void setMaDH(Integer maDH) {
        this.maDH = maDH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Float getTongTien() {
        return tongTien;
    }

    public void setTongTien(Float tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Khachhang getMaKH() {
        return maKH;
    }

    public void setMaKH(Khachhang maKH) {
        this.maKH = maKH;
    }

    public Thanhtoan getMaTT() {
        return maTT;
    }

    public void setMaTT(Thanhtoan maTT) {
        this.maTT = maTT;
    }

    public Vanchuyen getMaVC() {
        return maVC;
    }

    public void setMaVC(Vanchuyen maVC) {
        this.maVC = maVC;
    }

    @XmlTransient
    public Collection<Chitietdonhang> getChitietdonhangCollection() {
        return chitietdonhangCollection;
    }

    public void setChitietdonhangCollection(Collection<Chitietdonhang> chitietdonhangCollection) {
        this.chitietdonhangCollection = chitietdonhangCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maDH != null ? maDH.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donhang)) {
            return false;
        }
        Donhang other = (Donhang) object;
        if ((this.maDH == null && other.maDH != null) || (this.maDH != null && !this.maDH.equals(other.maDH))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Donhang[ maDH=" + maDH + " ]";
    }
    
}
