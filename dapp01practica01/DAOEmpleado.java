/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.dapp01practica01;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author francisco
 */
public class DAOEmpleado implements IDAOgeneral<PojoEmpleado> {//pojoempleado, Integer

    @Override
    public boolean Save(PojoEmpleado p) {
         ConexionDB con = ConexionDB.getInstance();
     
         TransactionDB tra = new TransactionDB(p) {
             @Override
             public boolean execute(Connection con) {
                 try {
                     String sql = "INSERT INTO empleadotemporal (nombre, direccion, telefono) VALUES (?,?,?)";
                     PreparedStatement pstm = con.prepareStatement(sql);
                     pstm.setString(1, p.getNombre());
                     pstm.setString(2, p.getDireccion());
                     pstm.setString(3, p.getTelefono());
                     pstm.executeUpdate();
                     return true;
                 } catch (SQLException ex) {
                     Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                 return false;
                 }
          
             }
             
         };
        return con.execute(tra);
                 }
        
   
    @Override
    public boolean Edit(PojoEmpleado p) {
         ConexionDB con = ConexionDB.getInstance();
         TransactionDB tra = new TransactionDB(p) {
             @Override
             public boolean execute(Connection con) {
                 try {
                     String sql = "update empleadotemporal set nombre=?, direccion=?, telefono=? WHERE id=?";
                     
                     PreparedStatement pstm = con.prepareStatement(sql);
                     pstm.setInt(4, p.getId());
                     pstm.setString(1, p.getNombre());
                     pstm.setString(2, p.getDireccion());
                     pstm.setString(3, p.getTelefono());
                     pstm.executeUpdate();
                     return true;
                 } catch (SQLException ex) {
                     Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                 return false;
                 }
             }
         };
         return con.execute(tra);
    }

    @Override
    public boolean Delete(int id) {
    ConexionDB con = ConexionDB.getInstance();
    TransactionDB tra = new TransactionDB(id) {
        @Override
        public boolean execute(Connection con) {
              try {
           String sql = "DELETE FROM empleadotemporal WHERE id=?"; 
             PreparedStatement pstm = con.prepareStatement(sql);
                     pstm.setInt(1, id);
                     pstm.executeUpdate();
                     return true;
                             } catch (SQLException ex) {
                     Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                 return false;
                 }
        }
        
    };
    return con.execute(tra);
    }

    @Override
    public List<PojoEmpleado> Findbyid(int id) {
     SelectionDB select = new SelectionDB(null) {
         @Override
         public List select(Connection con) {
           List<PojoEmpleado> stempleado = new ArrayList<>();
           try {
        List<PojoEmpleado> stEmpleado = new ArrayList<>();
        String sql= "SELECT * FROM empleadotemporal WHERE id = "+id;
        Statement st = null;
        ResultSet reg = null;
        st = con.createStatement();
        reg = st.executeQuery(sql);
        
        while(reg.next()){
        PojoEmpleado emp = new PojoEmpleado();
        emp.setId(reg.getInt(1));
        emp.setNombre(reg.getString(2));
        emp.setDireccion(reg.getString(3));
        emp.setTelefono(reg.getString(4));
        stEmpleado.add(emp);
        
        } 
             return stEmpleado;
             } catch (SQLException ex) {
              System.out.print("error"+ ex.getMessage());
        return null;
             
             }
         }
             };   
     ConexionDB con = ConexionDB.getInstance();
        return con.select(select);
         }
     
        
        


    @Override
    public List<PojoEmpleado> FindAll() {
                 List<PojoEmpleado> stempleado = new ArrayList<>();
    try {
        ConexionDB con = ConexionDB.getInstance();
        String sql = "SELECT * FROM empleadotemporal; ";
        ResultSet reg = con.select(sql);
        
        while (reg.next()) {
            PojoEmpleado empleado= new PojoEmpleado();
            empleado.setId(reg.getInt("id"));
            empleado.setNombre(reg.getString("nombre"));
            empleado.setDireccion(reg.getString ("direccion"));
            empleado.setTelefono(reg.getString("telefono"));
             stempleado.add(empleado);
        }
    } catch (SQLException ex) {
        Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
    }
    return stempleado;
    }
    }

  

    


    

