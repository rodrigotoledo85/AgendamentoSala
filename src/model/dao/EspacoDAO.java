/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import static connection.ConnectionFactory.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import model.bean.Espaco;

/**
 *
 * @author rodrigo
 */
public class EspacoDAO {

    private Connection con = null;

    public EspacoDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean salvar(Espaco espaco) {
        String sql = "INSERT INTO tbl_espaco (des_espaco) VALUES (?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);

            stmt.setString(1, espaco.getDesEspaco());

            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar novo espaco! " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public Vector<Espaco> listarEspacos() throws Exception {

        String sql = "SELECT * FROM tbl_espaco";
        Vector<Espaco> espacos = new Vector<Espaco>();

        PreparedStatement stmt = getConnection().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Espaco obj = new Espaco();
            obj.setCodEspaco(rs.getInt("cod_espaco"));
            obj.setDesEspaco(rs.getString("des_espaco"));
            espacos.add(obj);
        }
        return espacos;
    }
}
