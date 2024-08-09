/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaCode;

import java.util.List;

/**
 *
 * @author UsEr
 */


public interface RetailersDAO {
    
    void createRetailer(Retailers retailer);
    Retailers getRetailerById(int id);
    List<Retailers> getAllRetailers();
    void updateRetailer(Retailers retailer);
    void deleteRetailer(int id);
    
}
