/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HP
 */
public class TableModelUser extends AbstractTableModel {
    
     public TableModelUser(List<User> lstUser){
        this.lstUser = lstUser;
    }        
    @Override
    public int getRowCount() {
      return this.lstUser.size();
    }
    
    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int column)
    {
        switch(column)
        {
            case 0:
                return "ID";
            case 1:
                return "Nama";
            case 2:
                return "Telpon";
            case 3:
                return "Email";
            default:
                return null;
        }    
    }       
            
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
          switch(columnIndex)
        {
            case 0:
                return lstUser.get(rowIndex).getId();
            case 1:
                return lstUser.get(rowIndex).getNama();
            case 2:
                return lstUser.get(rowIndex).getTelpon();
            case 3:
                return lstUser.get(rowIndex).getEmail();
            default:
                return null;
        }  
    }
    
    List<User> lstUser;
    
}
