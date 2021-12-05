package dao;

import java.util.List;
import model.Nhomsanpham;
import model.Sanpham;

public interface SanphamDAO {

    // hiển thị danh sách sản phẩm theo giá >= 20.000
    public List<Sanpham> getListSPgia();

    // hiển thị danh sách sản phẩm
    public List<Sanpham> getList();
    
    // lấy sản phâm theo id của sản phẩm
    public Sanpham getSanpham(int idsp);
    
    //lấy sản phẩm theo mã nhóm sản phẩm
    public List<Sanpham> getSanphamByIDmaNhomSP(int mnsp);
    
    //search list sản phẩm theo tên
    public List<Sanpham> searchByName(String name);
    
    
    //lấy mã nhóm san pham
    public Sanpham getTennhomSanphamByIDSP (int idsp);

    
    //lấy list sản phẩm theo thương hiệu
    public List<Sanpham> getThuongHieu (String idsp);
    
    
    //lấy sản phẩm có giá trên $30
    public List<Sanpham> getSanphamByPrice();
    
    //lấy những sản phẩm có giá dưới 15
    public List<Sanpham> getSanphamByPrice15();
    

    //lấy sản phẩm theo trang cho shop.jsp
    public List<Sanpham> getSPPhanTrang(int index);
    
    
    //lấy sản phẩm theo trang cho category.jsp
    public List<Sanpham> getSPPhanTrangCategory(int index);
    
    public void updateSP (Sanpham sp);
    
    
}
