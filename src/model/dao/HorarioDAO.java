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
import java.util.Vector;
import model.bean.Horario;

/**
 *
 * @author rodrigo
 */
public class HorarioDAO {

    private Connection con = null;

    public HorarioDAO() {
        con = ConnectionFactory.getConnection();
    }

    public Vector<Horario> listarHorarios() throws Exception {

        String sql = "SELECT * FROM tbl_horario";
        Vector<Horario> horarios = new Vector<Horario>();

        PreparedStatement stmt = getConnection().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Horario obj = new Horario();
            obj.setCodHorario(rs.getInt("cod_horario"));
            obj.setDesHorario(rs.getString("des_horario"));
            horarios.add(obj);
        }
        return horarios;
    }

}
