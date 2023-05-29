/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOINTERFACE.IDAOUser;
import HELPER.KONEKSIDB;
import MODEL.Mahasiswa;
import MODEL.User;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class DAOUser implements IDAOUser {

    public DAOUser()
    {
        con =  KONEKSIDB.getConnection();
    }        
    
    @Override
    public List<User> getAll() {
       List<User> lstUser = null;
        try
        {
            lstUser = new ArrayList<>();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(strRead);
            while(rs.next())
            {
                User User = new User();
                User.setId(rs.getInt("id"));
                User.setNama(rs.getString("nama"));
                User.setTelpon(rs.getString("telepon"));
                User.setEmail(rs.getString("email"));
            lstUser.add(User);
            }
        }  
        catch(SQLException e)
        {
            System.out.println("error: "+e);
        }  
        return lstUser;
    }
    
    @Override
    public void insert(User b) {
        PreparedStatement statement = null;
        try
        {
           statement = (PreparedStatement) con.prepareStatement(strInsert);
           statement.setInt(1, b.getId());
           statement.setString(2, b.getNama());
           statement.setString(3, b.getTelpon());
           statement.setString(4, b.getEmail());
           statement.execute();
        } catch(SQLException e)   
        {
           System.out.println("gagal input" + e);
        }  
        finally
        {
             try {
                statement.close();
            } catch (SQLException ex) {
                 System.out.println("gagal input" + ex);
            }
        }    
    }

    @Override
    public void update(User b) {
        PreparedStatement statement = null;
        try
        {
           statement = (PreparedStatement) con.prepareStatement(strUpdate);
           statement.setString(1, b.getNama());
           statement.setString(2, b.getTelpon());
           statement.setString(3, b.getEmail());
           statement.setInt(5, b.getId());
           statement.execute();
        } catch(SQLException e)   
        {
           System.out.println("gagal update");
        }  
        finally
        {
             try {
                statement.close();
            } catch (SQLException ex) {
                 System.out.println("gagal update");
            }
        } 
    }
    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try
        {
           statement = (PreparedStatement) con.prepareStatement(strDelete);
           statement.setInt(1, id);
           statement.execute();
        } catch(SQLException e)   
        {
           System.out.println("gagal delete");
        }  
        finally
        {
             try {
                statement.close();
            } catch (SQLException ex) {
                 System.out.println("gagal delete");
            }
        }
    }
    @Override
    public List<User> getAllByName(String nama) {
         List<User> lstUser = null;
        try
        {
            lstUser = new ArrayList<>();
            PreparedStatement st = (PreparedStatement) con.prepareStatement(strSearch);
            st.setString(1, "%"+nama+"%");
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                User user = new User();
                user.setId(rs.getInt("Id"));
                user.setNama(rs.getString("Nama"));
                user.setTelpon(rs.getString("Telpon"));
                user.setEmail(rs.getString("Email"));
            lstUser.add(user);
            }
        }  
        catch(SQLException e)
        {
            System.out.println("error: "+e);
        }  
        return lstUser;
    }
    Connection con;
    //SQL Query
     final String strRead="select * from pengguna;";
    String strInsert = "insert into pengguna (id,nama,telepon,email) values (?,?,?,?);" ;
    String strUpdate = "update pengguna set nama=?, telepon=?, email=? where id=?" ;
    String strDelete = " delete from pengguna where id=?";
    String strSearch = " select * from pengguna where nama like ?;";
}
