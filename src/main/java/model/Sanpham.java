/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PhucNguyen
 */
@Entity
@Table(name = "sanpham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sanpham.findAll", query = "SELECT s FROM Sanpham s"),
    @NamedQuery(name = "Sanpham.findByMaSP", query = "SELECT s FROM Sanpham s WHERE s.maSP = :maSP"),
    @NamedQuery(name = "Sanpham.findByTenSP", query = "SELECT s FROM Sanpham s WHERE s.tenSP = :tenSP"),
    @NamedQuery(name = "Sanpham.findByAnh", query = "SELECT s FROM Sanpham s WHERE s.anh = :anh"),
    @NamedQuery(name = "Sanpham.findByGia", query = "SELECT s FROM Sanpham s WHERE s.gia = :gia"),
    @NamedQuery(name = "Sanpham.findByMoTa", query = "SELECT s FROM Sanpham s WHERE s.moTa = :moTa"),
    @NamedQuery(name = "Sanpham.findByTrangThai", query = "SELECT s FROM Sanpham s WHERE s.trangThai = :trangThai"),
    @NamedQuery(name = "Sanpham.findByThuongHieu", query = "SELECT s FROM Sanpham s WHERE s.thuongHieu = :thuongHieu"),
    @NamedQuery(name = "Sanpham.findBySoLuong", query = "SELECT s FROM Sanpham s WHERE s.soLuong = :soLuong")})
public class Sanpham implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaSP")
    private Integer maSP;
    @Size(max = 500)
    @Column(name = "TenSP")
    private String tenSP;
    @Size(max = 500)
    @Column(name = "Anh")
    private String anh;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Gia")
    private Double gia;
    @Size(max = 500)
    @Column(name = "MoTa")
    private String moTa;
    @Column(name = "TrangThai")
    private Boolean trangThai;
    @Size(max = 500)
    @Column(name = "ThuongHieu")
    private String thuongHieu;
    @Column(name = "SoLuong")
    private Integer soLuong;
    @OneToMany(mappedBy = "maSP")
    private Collection<Cauhinh> cauhinhCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "sanpham")
    private Cart cart;
    @OneToMany(mappedBy = "maSP")
    private Collection<Chitietdonhang> chitietdonhangCollection;
    @JoinColumn(name = "MaNCC", referencedColumnName = "MaNCC")
    @ManyToOne
    private Nhacungcap maNCC;
    @JoinColumn(name = "MaNhomSP", referencedColumnName = "MaNhomSP")
    @ManyToOne
    private Nhomsanpham maNhomSP;
    @OneToMany(mappedBy = "maSP")
    private Collection<Danhgia> danhgiaCollection;
    @OneToMany(mappedBy = "maSP")
    private Collection<Uathich> uathichCollection;

    public Sanpham() {
    }

    public Sanpham(int maSP, String tenSP, String anh, double gia,
            String moTa, String thuongHieu) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.anh = anh;
        this.gia = gia;
        this.moTa = moTa;
        this.thuongHieu = thuongHieu;
    }
    public Sanpham(Integer maSP) {
        this.maSP = maSP;
    }

    public Integer getMaSP() {
        return maSP;
    }

    public void setMaSP(Integer maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
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

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    @XmlTransient
    public Collection<Cauhinh> getCauhinhCollection() {
        return cauhinhCollection;
    }

    public void setCauhinhCollection(Collection<Cauhinh> cauhinhCollection) {
        this.cauhinhCollection = cauhinhCollection;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @XmlTransient
    public Collection<Chitietdonhang> getChitietdonhangCollection() {
        return chitietdonhangCollection;
    }

    public void setChitietdonhangCollection(Collection<Chitietdonhang> chitietdonhangCollection) {
        this.chitietdonhangCollection = chitietdonhangCollection;
    }

    public Nhacungcap getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(Nhacungcap maNCC) {
        this.maNCC = maNCC;
    }

    public Nhomsanpham getMaNhomSP() {
        return maNhomSP;
    }

    public void setMaNhomSP(Nhomsanpham maNhomSP) {
        this.maNhomSP = maNhomSP;
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
        hash += (maSP != null ? maSP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sanpham)) {
            return false;
        }
        Sanpham other = (Sanpham) object;
        if ((this.maSP == null && other.maSP != null) || (this.maSP != null && !this.maSP.equals(other.maSP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sanpham{" + "maSP=" + maSP + ", tenSP=" + tenSP + ", anh=" + anh + ", gia=" + gia + ", mota=" + moTa + ", trangthai=" + trangThai
                +"MaNhomSP" +maNhomSP +"ThuongHieu" + thuongHieu;
    }
    
}
