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
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import model.bean.Cargo;
import model.bean.Usuario;

/**
 *
 * @author rodrigo
 */
public class UsuarioDAO {

    Cargo objCargo = new Cargo();

    private Connection con = null;

    public UsuarioDAO() {
        con = ConnectionFactory.getConnection();
    }

    public Vector<Cargo> listarCargos() throws Exception {

        String sql = "SELECT * FROM tbl_cargo";
        Vector<Cargo> cargos = new Vector<Cargo>();

        PreparedStatement stmt = getConnection().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Cargo obj = new Cargo();
            obj.setCodCargo(rs.getInt("cod_cargo"));
            obj.setDesCargo(rs.getString("des_cargo"));
            cargos.add(obj);
        }
        return cargos;
    }

    public boolean salvarUsuario(Usuario objUsuario) throws Exception {

        String sql = "INSERT INTO tbl_usuario (nom_usuario, des_email, des_login, des_senha, cod_cargo)VALUES (?,?,?,?,?)";
        PreparedStatement stmt = getConnection().prepareStatement(sql);

        stmt.setString(1, objUsuario.getNomUsuario());
        stmt.setString(2, objUsuario.getDesEmail());
        stmt.setString(3, objUsuario.getDesLogin());
        stmt.setString(4, objUsuario.getDesSenha());
        stmt.setInt(5, objUsuario.getCargo().getCodCargo());

        if (stmt.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean editarUsuario(Usuario objUsuario) throws Exception {
        ConnectionFactory.getConnection();
        String sql = "UPDATE tbl_usuario SET nom_usuario = ?, des_email = ?, des_login = ?, des_senha = ?, cod_cargo = ? WHERE cod_usuario = ?";
        PreparedStatement ps = getConnection().prepareStatement(sql);

        ps.setString(1, objUsuario.getNomUsuario());
        ps.setString(2, objUsuario.getDesEmail());
        ps.setString(3, objUsuario.getDesLogin());
        ps.setString(4, objUsuario.getDesSenha());
        ps.setInt(5, objUsuario.getCargo().getCodCargo());
        ps.setInt(6, objUsuario.getCodUsuario());

        if (ps.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Usuario pesquisar(String desLogin) throws SQLException {
        Usuario obj = new Usuario();
        ConnectionFactory.getConnection();
        String sql = "SELECT * FROM agendamento_sala.tbl_usuario WHERE des_login LIKE ?";
        PreparedStatement ps = getConnection().prepareStatement(sql);
        ps.setString(1, "%" + desLogin + "%");

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            obj.setCodUsuario(rs.getInt("cod_usuario"));
            obj.setNomUsuario(rs.getString("nom_usuario"));
            obj.setDesEmail(rs.getString("des_email"));
            obj.setDesLogin(rs.getString("des_login"));
            obj.setDesSenha(rs.getString("des_senha"));
        }
        ConnectionFactory.closeConnection(con, ps, rs);
        return obj;
    }

    //Usar este metodo para implementar o envio de email com login e senha
    public List<Usuario> consultaUsuario(String desLogin) throws Exception {
        ConnectionFactory.getConnection();
        String sql = "select * from tbl_usuario where des_email = ?";

        PreparedStatement pstmt = getConnection().prepareStatement(sql);
        pstmt.setString(1, desLogin);
        ResultSet rs = pstmt.executeQuery();

        Usuario usuarios = new Usuario();
        List<Usuario> listaUsuarios = new ArrayList<>();
        while (rs.next()) {
            usuarios.setCodUsuario(rs.getInt("cod_usuario"));
            usuarios.setDesEmail(rs.getString("des_email"));
            usuarios.setNomUsuario(rs.getString("nom_usuario"));
            usuarios.setDesLogin(rs.getString("des_login"));
            usuarios.setDesSenha(rs.getString("des_senha"));
            Cargo cargo = new Cargo();
            cargo.setCodCargo(rs.getInt("cod_cargo"));
            usuarios.setCargo(cargo);

            listaUsuarios.add(usuarios);
        }
        return listaUsuarios;
    }
}
