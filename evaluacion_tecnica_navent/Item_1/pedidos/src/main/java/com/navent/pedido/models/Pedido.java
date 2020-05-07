package com.navent.pedido.models;

public class Pedido {
    private int id;
    private String nombre;
    private int monto;
    private int descuento;

    public Pedido() {
    }

    public Pedido(int id) {
        this.id = id;
    }

    public Pedido(int id, String nombre, int monto, int descuento) {
        this.id = id;
        this.nombre = nombre;
        this.monto = monto;
        this.descuento = descuento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
}
