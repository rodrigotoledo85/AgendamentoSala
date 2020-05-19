/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rodrigo
 */
public class LoginDAO {

    public boolean checkLogin(String des_login, String des_senha) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;

        try {
            stmt = con.prepareStatement("Select * from tbl_usuario WHERE des_login = ? and des_senha = ?");
            stmt.setString(1, des_login);
            stmt.setString(2, des_senha);

            rs = stmt.executeQuery();

            if (rs.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }
        return check;
    }
}
