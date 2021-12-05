/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Khuyenmai;

/**
 *
 * @author PhucNguyen
 */
public interface KhuyenmaiDAO {
    // lấy giá trị khuyến mại theo mã
    public Khuyenmai getGiatriKhuyenmai(int makm);
    
    //lấy toàn bộ các mã km
    public List<Khuyenmai> getALL();
}
