/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaCode;

/**
 *
 * @author Armando Mavova Bazeydio
 */


public class Retailers {
    
    private int id;
    private int userId;
    
    public Retailers() {
    }

    public Retailers(int id, int userId) {
        this.id = id;
        this.userId = userId;
    }
    
    public int getId() {
            return id;
    }
    public void setId(int id) {
            this.id = id;
    }
    public int getUserId() {
            return userId;
    }
    public void setUserId(int userId) {
            this.userId = userId;
    }
    
}
