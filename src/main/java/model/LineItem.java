package model;

import dao.SanphamDAOImpl;
import java.io.Serializable;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import static org.eclipse.persistence.jpa.jpql.utility.CollectionTools.list;

public class LineItem implements Serializable {

    private ArrayList<Cart> items;

    public LineItem() {
        items = new ArrayList<Cart>();
    }

    public ArrayList<Cart> getItems() {
        return items;
    }

    
    public int getCount() {
        return items.size();
    }

    public void addItem(Cart item) {
        int code = item.getSanpham().getMaSP();
        for (int i = 0; i < items.size(); i++) {
            Cart lineItem = items.get(i);
            if (lineItem.getSanpham().getMaSP().equals(code)) {
                return;
            }
        }
        items.add(item);
    }

    public double TotalItem(Cart item) {
        double total = item.getTotal();
        return total;
    }

    public void removeItem(Cart item) {
        int id = item.getSanpham().getMaSP();

        for (int i = 0; i < items.size(); i++) {
            Cart lineItem = items.get(i);
            if (lineItem.getSanpham().getMaSP().equals(id)) {
                items.remove(i);
                return;
            }
        }
    }
    
    public void setCart(Cart item, int s) {
        int code = item.getSanpham().getMaSP();
        
        for (int i = 0; i < items.size(); i++) {
            Cart lineItem = items.get(i);
            if (lineItem.getSanpham().getMaSP().equals(code)) {
                lineItem.setQuantity(s);
            }
        }
        items.add(item);
    }

    
}
