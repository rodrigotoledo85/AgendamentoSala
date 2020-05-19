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
public class Espaco {

    private int codEspaco;
    private String desEspaco;

    public Espaco() {

    }

    public Espaco(int codEspaco, String desEspaco) {
        this.codEspaco = codEspaco;
        this.desEspaco = desEspaco;
    }

    public int getCodEspaco() {
        return codEspaco;
    }

    public void setCodEspaco(int codEspaco) {
        this.codEspaco = codEspaco;
    }

    public String getDesEspaco() {
        return desEspaco;
    }

    public void setDesEspaco(String desEspaco) {
        this.desEspaco = desEspaco;
    }

    @Override
    public String toString() {
        return getDesEspaco(); //To change body of generated methods, choose Tools | Templates.
    }
}
