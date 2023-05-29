/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import DAO.DAOMahasiswa;
import DAOINTERFACE.IDAOUser;
import MODEL.User;
import DAO.DAOUser;
import DAOINTERFACE.IDAOMahasiswa;
import MODEL.Mahasiswa;
import MODEL.TabelModelUser;
import MODEL.TableModelUser;
import MODEL.User;
import VIEW.FormMahasiswa;
import VIEW.FormUser;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class ControllerUser {
    
    
    public ControllerUser(FormUser frmUser){
        this.frmUser = frmUser;
        iUser = new DAOUser();
        
    }
    public void isiTable(){
        lstUser = iUser.getAll();
        TableModelUser tableUser = new TableModelUser ( lstUser);
        frmUser.getTableData().setModel(tableUser);
    }
    
    public void insert()
    {
        User b = new User();
        b.setId(Integer.parseInt(frmUser.gettxtID().getText()));
        b.setNama(frmUser.gettxtNama().getText());
        b.setTelpon(frmUser.gettxtTelpon().getText());
        b.setEmail(frmUser.getEmail().toString());
        iUser.insert(b);
        JOptionPane.showMessageDialog(null, "Input berhasil");
    }      
    
    public void reset()
    {
        if(!frmUser.gettxtID().isEnabled())
            frmUser.gettxtID().setEnabled(true);
         frmUser.gettxtID().setText("");
         frmUser.gettxtNama().setText("");
         frmUser.gettxtTelpon().setText("");
        frmUser.getEmail().setText("");
    }        
    public void isiField(int row)
    {
         frmUser.gettxtID().setEnabled(false);
         frmUser.gettxtID().setText(lstUser.get(row).getId().toString());
         frmUser.gettxtNama().setText(lstUser.get(row).getNama());
         frmUser.gettxtTelpon().setText(lstUser.get(row).getTelpon());
         frmUser.getEmail().setText(lstUser.get(row).getEmail());
    
    }
    public void update()
    {
        User b = new User();
        b.setNama(frmUser.gettxtNama().getText());
        b.setTelpon(frmUser.gettxtTelpon().getText());
        b.setEmail(frmUser.getEmail().getText().toString());
        b.setId(Integer.parseInt(frmUser.gettxtID().getText()));
        iUser.update(b);
        JOptionPane.showMessageDialog(null, "Update berhasil");
    }      
    public void delete()
    {
        
        iUser.delete(Integer.parseInt(frmUser.gettxtID().getText()));
        JOptionPane.showMessageDialog(null, "Delete berhasil");
    }     
    
    public void  cari()
    {
       lstUser = iUser.getAllByName(frmUser.gettxtCariNama().getText());
        TableModelUser tableuser= new TableModelUser( lstUser);
        frmUser.getTableData().setModel(tableuser);
    }        
    FormUser frmUser;
    IDAOUser iUser;
    List<User> lstUser;
}
