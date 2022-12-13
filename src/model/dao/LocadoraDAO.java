/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javax.swing.JOptionPane;
import model.bean.Locadora;

/**
 *
 * @author Rafael
 */
public class LocadoraDAO {

    

    public List<Locadora> read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Locadora> locadoras = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM locadora");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Locadora locadoradados = new Locadora();

                locadoradados.setId(rs.getInt("id"));
                locadoradados.setCidade(rs.getString("cidade"));
                locadoradados.setEndereco(rs.getString("endereco"));
                locadoras.add(locadoradados);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LocadoraDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return locadoras;

    }

}
