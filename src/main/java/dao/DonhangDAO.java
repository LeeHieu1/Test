package dao;

import java.util.List;
import model.Donhang;

public interface DonhangDAO {
    
     public List<Donhang> getList();
     public List<Donhang> insertDH(String tenKH, String Email, String DiaChi, String SDT);
    
}
