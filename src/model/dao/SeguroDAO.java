/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import br.edu.unijui.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Seguro;

/**
 *
 * @author Rafael
 */
public class SeguroDAO {
    
    
    public List<Seguro> read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Seguro> seguros = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM seguro");
            rs = stmt.executeQuery();
        
            
            while (rs.next()) {

               
                
                Seguro segurodados = new Seguro();

                
                
                segurodados.setId(rs.getInt("id"));
                segurodados.setNome(rs.getString("nome"));
                segurodados.setValor(rs.getInt("valor"));
                
                seguros.add(segurodados);
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(LocadoraDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return seguros;

    }
}
