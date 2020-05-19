/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Rodrigo de Melo Toledo
 */
public class Horario {

    private int codHorario;
    private String desHorario;

    public int getCodHorario() {
        return codHorario;
    }

    public void setCodHorario(int codHorario) {
        this.codHorario = codHorario;
    }

    public String getDesHorario() {
        return desHorario;
    }

    public void setDesHorario(String desHorario) {
        this.desHorario = desHorario;
    }

    @Override
    public String toString() {
        return getDesHorario(); //To change body of generated methods, choose Tools | Templates.
    }

}
