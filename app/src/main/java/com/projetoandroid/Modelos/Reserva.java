package com.projetoandroid.Modelos;

import java.io.Serializable;

public class Reserva implements Serializable {
    private int codigo;
    private String NomeReservante;
    private int TelefoneReservante;
    private int CpfReservante;

    public Reserva(String NomeReservante, int TelefoneReservante, int CpfReservante) {
        this.codigo = codigo;
        this.NomeReservante = NomeReservante;
        this.TelefoneReservante = TelefoneReservante;
        this.CpfReservante = CpfReservante;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeReservante() {
        return NomeReservante;
    }

    public void setNomeReservante(String NomeReservante) {
        this.NomeReservante = NomeReservante;
    }

    public int getTelefoneReservante() {
        return TelefoneReservante;
    }

    public void setTelefoneReservante(int TelefoneReservante) {
        this.TelefoneReservante = TelefoneReservante;
    }

    public int getCpfReservante() {
        return CpfReservante;
    }

    public void setCpfReservante(int CpfReservante) {
        this.CpfReservante = CpfReservante;
    }
    
    
}