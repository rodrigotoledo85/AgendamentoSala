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
public class Turno {

    private int codTurno;
    private String desTurno;

    public int getCodTurno() {
        return codTurno;
    }

    public void setCodTurno(int codTurno) {
        this.codTurno = codTurno;
    }

    public String getDesTurno() {
        return desTurno;
    }

    public void setDesTurno(String desTurno) {
        this.desTurno = desTurno;
    }

    @Override
    public String toString() {
        return getDesTurno(); //To change body of generated methods, choose Tools | Templates.
    }
}
