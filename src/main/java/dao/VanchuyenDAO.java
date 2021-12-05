package dao;

import java.util.List;
import model.Vanchuyen;

public interface VanchuyenDAO {

    public List<Vanchuyen> getList();
    
    public Vanchuyen getVanchuyen(int id);

}
