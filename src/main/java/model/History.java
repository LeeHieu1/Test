/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PhucNguyen
 */
@Entity
@Table(name = "history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "History.findAll", query = "SELECT h FROM History h"),
    @NamedQuery(name = "History.findByIdHistory", query = "SELECT h FROM History h WHERE h.idHistory = :idHistory"),
    @NamedQuery(name = "History.findByMaSanPham", query = "SELECT h FROM History h WHERE h.maSanPham = :maSanPham"),
    @NamedQuery(name = "History.findByNgayMua", query = "SELECT h FROM History h WHERE h.ngayMua = :ngayMua"),
    @NamedQuery(name = "History.findBySoLuong", query = "SELECT h FROM History h WHERE h.soLuong = :soLuong"),
    @NamedQuery(name = "History.findByThanhTien", query = "SELECT h FROM History h WHERE h.thanhTien = :thanhTien"),
    @NamedQuery(name = "History.findByUserId", query = "SELECT h FROM History h WHERE h.userId = :userId")})
public class History implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_history")
    private Integer idHistory;
    @Column(name = "ma_san_pham")
    private Integer maSanPham;
    @Column(name = "ngay_mua")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayMua;
    @Column(name = "so_luong")
    private Integer soLuong;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "thanh_tien")
    private Double thanhTien;
    @Column(name = "user_id")
    private Integer userId;

    public History() {
    }

    public History(Integer idHistory) {
        this.idHistory = idHistory;
    }

    public Integer getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(Integer idHistory) {
        this.idHistory = idHistory;
    }

    public Integer getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(Integer maSanPham) {
        this.maSanPham = maSanPham;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistory != null ? idHistory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof History)) {
            return false;
        }
        History other = (History) object;
        if ((this.idHistory == null && other.idHistory != null) || (this.idHistory != null && !this.idHistory.equals(other.idHistory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.History[ idHistory=" + idHistory + " ]";
    }
    
}
