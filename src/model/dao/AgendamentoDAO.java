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
import model.bean.Agendamento;
import model.bean.Espaco;
import model.bean.Horario;
import model.bean.Status;
import model.bean.Turno;
import model.bean.Usuario;

/**
 *
 * @author rodrigo
 */
public class AgendamentoDAO {

    private Connection con = null;

    public AgendamentoDAO() {
        con = ConnectionFactory.getConnection();
    }

    public Vector<Status> listarStatus() {
        String sql = "SELECT * FROM tbl_status";
        Vector<Status> status = new Vector<>();

        PreparedStatement stmt;
        try {
            stmt = getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Status obj = new Status();
                obj.setCodStatus(rs.getInt("cod_status"));
                obj.setDesStatus(rs.getString("des_status"));
                status.add(obj);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
        return status;
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

    public Vector<Usuario> listarUsuarios() throws Exception {

        String sql = "SELECT * FROM tbl_usuario";
        Vector<Usuario> usuarios = new Vector<Usuario>();

        PreparedStatement stmt = getConnection().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Usuario obj = new Usuario();
            obj.setCodUsuario(rs.getInt("cod_usuario"));
            obj.setNomUsuario(rs.getString("nom_usuario"));
            obj.setDesLogin(rs.getString("des_login"));
            usuarios.add(obj);
        }
        return usuarios;
    }

    public boolean salvarAgendamento(Agendamento objAgendamento) throws Exception {

        //objAgendamento = new Agendamento();
        String sql = "INSERT INTO tbl_agendamento (dta_agendamento, des_observacao, cod_usuario, cod_espaco, cod_horario, cod_turno, cod_status)VALUES (?,?,?,?,?,?,?)";
        PreparedStatement stmt = getConnection().prepareStatement(sql);

        stmt.setString(1, objAgendamento.getDataAgendamento());
        stmt.setString(2, objAgendamento.getDesObservacao());
        stmt.setInt(3, objAgendamento.getUsuario().getCodUsuario());
        stmt.setInt(4, objAgendamento.getEspaco().getCodEspaco());
        stmt.setInt(5, objAgendamento.getHorario().getCodHorario());
        stmt.setInt(6, objAgendamento.getTurno().getCodTurno());
        stmt.setInt(7, objAgendamento.getStatus().getCodStatus());

        if (stmt.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<Agendamento> pesquisarAgendamento(String data) {

        ConnectionFactory.getConnection();
        List<Agendamento> agendamentos = new ArrayList<>();
        String sql = "select ta.cod_agendamento as 'Código Agendamento',\n"
                + "ta.dta_agendamento as 'Data Agendamento',\n"
                + "ts.des_status as 'Status',\n"
                + "tu.nom_usuario as 'Usuário',\n"
                + "tt.des_turno as 'Turno',\n"
                + "th.des_horario as 'Horário',\n"
                + "te.des_espaco as 'Espaço',\n"
                + "ta.des_observacao as 'Observações'\n"
                + "from tbl_agendamento ta inner join tbl_status ts\n"
                + "on(ta.cod_status=ts.cod_status) inner join tbl_usuario tu\n"
                + "on(ta.cod_usuario=tu.cod_usuario) inner join tbl_turno tt\n"
                + "on(ta.cod_turno=tt.cod_turno) inner join tbl_horario th\n"
                + "on(ta.cod_horario=th.cod_horario) inner join tbl_espaco te\n"
                + "on(ta.cod_espaco=te.cod_espaco)\n"
                + "where ta.dta_agendamento like ?";
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, "%" + data + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Agendamento agendamento = new Agendamento();
                agendamento.setCodAgendamento(rs.getInt("Código Agendamento"));
                agendamento.setDataAgendamento(rs.getString("Data Agendamento"));

                Status status = new Status();
                status.setDesStatus(rs.getString("Status"));
                agendamento.setStatus(status);

                Usuario usuario = new Usuario();
                usuario.setNomUsuario(rs.getString("Usuário"));
                agendamento.setUsuario(usuario);

                Turno turno = new Turno();
                turno.setDesTurno(rs.getString("Turno"));
                agendamento.setTurno(turno);

                Horario horario = new Horario();
                horario.setDesHorario(rs.getString("Horário"));
                agendamento.setHorario(horario);

                Espaco espaco = new Espaco();
                espaco.setDesEspaco(rs.getString("Espaço"));
                agendamento.setEspaco(espaco);

                agendamento.setDesObservacao(rs.getString("Observações"));

                agendamentos.add(agendamento);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con);
        }

        return agendamentos;
    }

    public boolean atualizarAgendamento(Agendamento agendamento) {
        ConnectionFactory.getConnection();

        try {
            String sql = "UPDATE `agendamento_sala`.`tbl_agendamento` SET `dta_agendamento`= ?, `des_observacao`=?, `cod_usuario`=?, `cod_espaco`=?, `cod_horario`=?, `cod_turno`=?, `cod_status`= ? WHERE `cod_agendamento`=?";
            PreparedStatement stmt = getConnection().prepareStatement(sql);

            stmt.setString(1, agendamento.getDataAgendamento());
            stmt.setString(2, agendamento.getDesObservacao());
            stmt.setInt(3, agendamento.getUsuario().getCodUsuario());
            stmt.setInt(4, agendamento.getEspaco().getCodEspaco());
            stmt.setInt(5, agendamento.getHorario().getCodHorario());
            stmt.setInt(6, agendamento.getTurno().getCodTurno());
            stmt.setInt(7, agendamento.getStatus().getCodStatus());
            stmt.setInt(8, agendamento.getCodAgendamento());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            return false;
        }

    }
}
