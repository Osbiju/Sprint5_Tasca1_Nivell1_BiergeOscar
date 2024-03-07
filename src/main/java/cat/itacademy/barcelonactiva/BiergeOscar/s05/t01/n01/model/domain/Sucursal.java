package cat.itacademy.barcelonactiva.BiergeOscar.s05.t01.n01.model.domain;

import jakarta.persistence.*;

@Entity
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pk_SucursalID;
    @Column(name = "Nom")
    private String nomSucursal;
    @Column(name = "Pais")
    private String paisSucursal;

    public int getPk_SucursalID() {
        return pk_SucursalID;
    }
    public Sucursal() {

    }

    public Sucursal(String nomSucursal, String paisSucursal) {
        this.nomSucursal = nomSucursal;
        this.paisSucursal = paisSucursal;
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
}
