/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOINTERFACE;

import MODEL.User;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IDAOUser {
    public List<User> getAll();
    // insert data
    public void insert(User b);
    public void update (User b);
    public void delete (int id);
    public List<User> getAllByName(String nama);
    
}
    

