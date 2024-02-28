package org.uv.dapp01practica01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {
    private static ConexionDB cx = null;
    private Connection con = null;
    
    public static ConexionDB getInstance() {
        if (cx == null)
            cx = new ConexionDB();
        return cx;//no retornar
    }
    
    private ConexionDB() {
        try {
            String url = "jdbc:postgresql://172.17.0.2:5432/ejemplo";
            String pdw = "password";
            String usr = "postgres";
            con = DriverManager.getConnection(url, usr, pdw); 
            Logger.getLogger(ConexionDB.class.getName()).log(Level.INFO, "se conecto");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean execute(String sql) {
        Statement st = null;  //no statement, debe ser preparedStatement
        try {
            st = con.createStatement();
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
   public boolean execute(TransactionDB tra){
   return tra.execute(con);
   }
    
   
public List select(SelectionDB sel){// regresar un selectiondb
return sel.select(con);
}
   
   
    public ResultSet select(String sql) {
        Statement st = null;
        try {
            st = con.createStatement();
            ResultSet reg = st.executeQuery(sql);
            return reg;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    } 
    



}
