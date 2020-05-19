/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Cargo;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rodrigo
 */
public class CargoDAO {

    private Connection con = null;

    public CargoDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean salvar(Cargo cargo) {
        String sql = "INSERT INTO tbl_cargo (des_cargo) VALUES (?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);

            stmt.setString(1, cargo.getDesCargo());

            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar novo cargo! " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Cargo> read() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cargo> cargos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbl_cargo");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cargo objCargo = new Cargo();

                objCargo.setCodCargo(rs.getInt("cod_cargo"));
                objCargo.setDesCargo(rs.getString("des_cargo"));
                cargos.add(objCargo);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return cargos;
    }

}
