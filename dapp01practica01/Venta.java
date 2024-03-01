/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.dapp01practica01;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author francisco
 */
@Entity
@Table(name = "venta")
public class Venta implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator =  "venta_idventa_seq")
    @SequenceGenerator(name = "venta_idventa_seq", sequenceName = "venta_idventa_seq", allocationSize = 1)
    @Column(name = "idventa")
    private long id;
    
    @Column
    private Date fecha;
    @Column
    private String cliente;
    @Column
    private double total;
    @OneToMany(mappedBy = "venta", fetch = FetchType.LAZY)
    private List<Detalleventa> detalleVenta;
    
    public Venta(){
    detalleVenta=new ArrayList<>();
    }

    public List<Detalleventa> getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(List<Detalleventa> detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
