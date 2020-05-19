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
import model.bean.Turno;

/**
 *
 * @author rodrigo
 */
public class TurnoDAO {

    private Connection con = null;

    public TurnoDAO() {
        con = ConnectionFactory.getConnection();
    }

    public Vector<Turno> listarTurnos() throws Exception {

        String sql = "SELECT * FROM tbl_turno";
        Vector<Turno> turnos = new Vector<Turno>();

        PreparedStatement stmt = getConnection().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Turno obj = new Turno();
            obj.setCodTurno(rs.getInt("cod_turno"));
            obj.setDesTurno(rs.getString("des_turno"));
            turnos.add(obj);
        }
        return turnos;
    }
}
