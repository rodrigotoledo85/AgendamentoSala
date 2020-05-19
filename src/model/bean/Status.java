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
public class Status {

    private int codStatus;
    private String desStatus;

    public Status() {
    }

    public Status(int codStatus, String desStatus) {
        this.codStatus = codStatus;
        this.desStatus = desStatus;
    }

    public int getCodStatus() {
        return codStatus;
    }

    public void setCodStatus(int codStatus) {
        this.codStatus = codStatus;
    }

    public String getDesStatus() {
        return desStatus;
    }

    public void setDesStatus(String desStatus) {
        this.desStatus = desStatus;
    }

    @Override
    public String toString() {
        return getDesStatus(); //To change body of generated methods, choose Tools | Templates.
    }
}
