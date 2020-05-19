/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author rodrigo
 */
public class Agendamento {

    private int codAgendamento;
    private String dataAgendamento;
    private String desObservacao;
    private Usuario usuario;
    private Espaco espaco;
    private Horario horario;
    private Turno turno;
    private Status status;

    public Agendamento() {
    }

    public Agendamento(int codAgendamento, String dataAgendamento, String desObservacao, Usuario usuario, Espaco espaco, Horario horario, Turno turno, Status status) {
        this.codAgendamento = codAgendamento;
        this.dataAgendamento = dataAgendamento;
        this.desObservacao = desObservacao;
        this.usuario = usuario;
        this.espaco = espaco;
        this.horario = horario;
        this.turno = turno;
        this.status = status;
    }

    public int getCodAgendamento() {
        return codAgendamento;
    }

    public void setCodAgendamento(int codAgendamento) {
        this.codAgendamento = codAgendamento;
    }

    public String getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(String dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getDesObservacao() {
        return desObservacao;
    }

    public void setDesObservacao(String desObservacao) {
        this.desObservacao = desObservacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Espaco getEspaco() {
        return espaco;
    }

    public void setEspaco(Espaco espaco) {
        this.espaco = espaco;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
