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
import model.bean.Carro;

/**
 *
 * @author Rafael
 */
public class CarroDAO {

    public void create(Carro c) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO carro (modelo,ano,reservado,locadoraID)VALUES(?,?,?,?)");
            stmt.setString(1, c.getModelo());
            stmt.setInt(2, c.getAno());
            stmt.setString(3, "Não");
            stmt.setInt(4, c.getLocadoraID());
//          stmt.setInt(5, p.getPessoaID());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Carro Cadastrado");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Carro> read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Carro> carros = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM carro");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Carro carrodados = new Carro();

                carrodados.setId(rs.getInt("id"));
                carrodados.setModelo(rs.getString("modelo"));
                carrodados.setAno(rs.getInt("ano"));
                carrodados.setReservado(rs.getString("reservado"));
                carrodados.setLocadoraID(rs.getInt("locadoraID"));
                carrodados.setPessoaID(rs.getInt("pessoaID"));
                carros.add(carrodados);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return carros;

    }
    public List<Carro> readForDesc(String desc) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Carro> carros = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM carro WHERE modelo LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Carro carrodados = new Carro();
                
                carrodados.setId(rs.getInt("id"));
                carrodados.setModelo(rs.getString("modelo"));
                carrodados.setAno(rs.getInt("ano"));
                carrodados.setReservado(rs.getString("reservado"));
                carrodados.setLocadoraID(rs.getInt("locadoraID"));
                carrodados.setPessoaID(rs.getInt("pessoaID"));
                carros.add(carrodados);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return carros;

    }

    public void update(Carro c) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE carro SET modelo = ? ,ano = ?,reservado = ?, locadoraID = ? WHERE id = ?");
//            stmt.setString(1, p.getModelo());
//            stmt.setInt(2, p.getAno());
//            stmt.setString(3, p.getReservado());
//            stmt.setInt(4, p.getId());
            
            stmt.setString(1, c.getModelo());
            stmt.setInt(2, c.getAno());
            stmt.setString(3, c.getReservado());
            stmt.setInt(4, c.getLocadoraID());
            stmt.setInt(5, c.getId());
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alterações salvas");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public void delete(Carro c) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM carro WHERE id = ?");
            stmt.setInt(1, c.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Carro Removido");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar deletar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

}
