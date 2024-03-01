/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.dapp01practica01;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author francisco
 */
@Entity
@Table(name = "Detalleventa")
public class Detalleventa implements Serializable {
    @Id
     @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator =  "detalleventa_idventa_seq")
    @SequenceGenerator(name = "detalleventa_idventa_seq", sequenceName = "detalleventa_idventa_seq", allocationSize = 1)
    @Column(name = "idLinea")
    private long idLinea;
    @Column
    private int cantidad;
    @Column
    private double precio;
    @Column
    private String producto;
   
 
    @ManyToOne
    @JoinColumn(name = "idventa")
    private Venta venta;
            
    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public long getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(long idLinea) {
        this.idLinea = idLinea;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public long getIdventa() {
        return idventa;
    }

    public void setIdventa(long idventa) {
        this.idventa = idventa;
    }
}
