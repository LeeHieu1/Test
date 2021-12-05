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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PhucNguyen
 */
@Entity
@Table(name = "cauhinh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cauhinh.findAll", query = "SELECT c FROM Cauhinh c"),
    @NamedQuery(name = "Cauhinh.findByMaCauHinh", query = "SELECT c FROM Cauhinh c WHERE c.maCauHinh = :maCauHinh"),
    @NamedQuery(name = "Cauhinh.findByManHinh", query = "SELECT c FROM Cauhinh c WHERE c.manHinh = :manHinh"),
    @NamedQuery(name = "Cauhinh.findByHeDieuHanh", query = "SELECT c FROM Cauhinh c WHERE c.heDieuHanh = :heDieuHanh"),
    @NamedQuery(name = "Cauhinh.findByCameraSau", query = "SELECT c FROM Cauhinh c WHERE c.cameraSau = :cameraSau"),
    @NamedQuery(name = "Cauhinh.findByCameraTruoc", query = "SELECT c FROM Cauhinh c WHERE c.cameraTruoc = :cameraTruoc"),
    @NamedQuery(name = "Cauhinh.findByCpu", query = "SELECT c FROM Cauhinh c WHERE c.cpu = :cpu"),
    @NamedQuery(name = "Cauhinh.findByRam", query = "SELECT c FROM Cauhinh c WHERE c.ram = :ram"),
    @NamedQuery(name = "Cauhinh.findByRom", query = "SELECT c FROM Cauhinh c WHERE c.rom = :rom"),
    @NamedQuery(name = "Cauhinh.findByTheSim", query = "SELECT c FROM Cauhinh c WHERE c.theSim = :theSim"),
    @NamedQuery(name = "Cauhinh.findByDungLuongPin", query = "SELECT c FROM Cauhinh c WHERE c.dungLuongPin = :dungLuongPin")})
public class Cauhinh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaCauHinh")
    private Integer maCauHinh;
    @Size(max = 500)
    @Column(name = "ManHinh")
    private String manHinh;
    @Size(max = 500)
    @Column(name = "HeDieuHanh")
    private String heDieuHanh;
    @Size(max = 500)
    @Column(name = "CameraSau")
    private String cameraSau;
    @Size(max = 500)
    @Column(name = "CameraTruoc")
    private String cameraTruoc;
    @Size(max = 500)
    @Column(name = "CPU")
    private String cpu;
    @Size(max = 500)
    @Column(name = "Ram")
    private String ram;
    @Size(max = 500)
    @Column(name = "Rom")
    private String rom;
    @Size(max = 500)
    @Column(name = "TheSim")
    private String theSim;
    @Size(max = 500)
    @Column(name = "DungLuongPin")
    private String dungLuongPin;
    @JoinColumn(name = "MaSP", referencedColumnName = "MaSP")
    @ManyToOne
    private Sanpham maSP;

    public Cauhinh() {
    }

    public Cauhinh(Integer maCauHinh) {
        this.maCauHinh = maCauHinh;
    }

    public Integer getMaCauHinh() {
        return maCauHinh;
    }

    public void setMaCauHinh(Integer maCauHinh) {
        this.maCauHinh = maCauHinh;
    }

    public String getManHinh() {
        return manHinh;
    }

    public void setManHinh(String manHinh) {
        this.manHinh = manHinh;
    }

    public String getHeDieuHanh() {
        return heDieuHanh;
    }

    public void setHeDieuHanh(String heDieuHanh) {
        this.heDieuHanh = heDieuHanh;
    }

    public String getCameraSau() {
        return cameraSau;
    }

    public void setCameraSau(String cameraSau) {
        this.cameraSau = cameraSau;
    }

    public String getCameraTruoc() {
        return cameraTruoc;
    }

    public void setCameraTruoc(String cameraTruoc) {
        this.cameraTruoc = cameraTruoc;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getTheSim() {
        return theSim;
    }

    public void setTheSim(String theSim) {
        this.theSim = theSim;
    }

    public String getDungLuongPin() {
        return dungLuongPin;
    }

    public void setDungLuongPin(String dungLuongPin) {
        this.dungLuongPin = dungLuongPin;
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
        hash += (maCauHinh != null ? maCauHinh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cauhinh)) {
            return false;
        }
        Cauhinh other = (Cauhinh) object;
        if ((this.maCauHinh == null && other.maCauHinh != null) || (this.maCauHinh != null && !this.maCauHinh.equals(other.maCauHinh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cauhinh[ maCauHinh=" + maCauHinh + " ]";
    }
    
}
