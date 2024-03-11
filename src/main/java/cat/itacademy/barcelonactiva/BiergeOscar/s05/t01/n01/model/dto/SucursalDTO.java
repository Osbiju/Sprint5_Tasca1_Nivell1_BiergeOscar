package cat.itacademy.barcelonactiva.BiergeOscar.s05.t01.n01.model.dto;

import java.util.Arrays;
import java.util.List;

public class SucursalDTO {
    private int pk_SucursalID;
    private String nomSucursal;
    private String paisSucursal;
    private String tipusSucursal;

    public int getPk_SucursalID() {
        return pk_SucursalID;
    }

    public void setPk_SucursalID(int pk_SucursalID) {
        this.pk_SucursalID = pk_SucursalID;
    }

    public String getNomSucursal() {
        return nomSucursal;
    }

    public void setNomSucursal(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }

    public String getPaisSucursal() {
        return paisSucursal;
    }

    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }

    public String getTipusSucursal() {
        return tipusSucursal;
    }

    public void setTipusSucursal(String tipusSucursal) {
        this.tipusSucursal = tipusSucursal;
    }

//    //metodo propio para saber tipo sucursal
//    public String tipusSucursal(String paisSucursal){
//        return (PAISOS_UE.contains(paisSucursal))?"UE" : "Fora UE";
//    }
}
