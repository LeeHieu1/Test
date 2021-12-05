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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PhucNguyen
 */
@Entity
@Table(name = "khuyenmai")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Khuyenmai.findAll", query = "SELECT k FROM Khuyenmai k"),
    @NamedQuery(name = "Khuyenmai.findByMaKM", query = "SELECT k FROM Khuyenmai k WHERE k.maKM = :maKM"),
    @NamedQuery(name = "Khuyenmai.findByGiaTri", query = "SELECT k FROM Khuyenmai k WHERE k.giaTri = :giaTri")})
public class Khuyenmai implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaKM")
    private Integer maKM;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "GiaTri")
    private Double giaTri;

    public Khuyenmai() {
    }

    public Khuyenmai(Integer maKM) {
        this.maKM = maKM;
    }

    public Integer getMaKM() {
        return maKM;
    }

    public void setMaKM(Integer maKM) {
        this.maKM = maKM;
    }

    public Double getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(Double giaTri) {
        this.giaTri = giaTri;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maKM != null ? maKM.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Khuyenmai)) {
            return false;
        }
        Khuyenmai other = (Khuyenmai) object;
        if ((this.maKM == null && other.maKM != null) || (this.maKM != null && !this.maKM.equals(other.maKM))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MaKM" + maKM + "GiaTri" + giaTri;
    }
    
}
