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
public class Cargo {

    private int codCargo;
    private String desCargo;

    public Cargo() {

    }

    public Cargo(int codCargo, String desCargo) {
        this.codCargo = codCargo;
        this.desCargo = desCargo;
    }

    public int getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(int codCargo) {
        this.codCargo = codCargo;
    }

    public String getDesCargo() {
        return desCargo;
    }

    public void setDesCargo(String desCargo) {
        this.desCargo = desCargo;
    }

    @Override
    public String toString() {
        return getDesCargo(); //To change body of generated methods, choose Tools | Templates.
    }
}
