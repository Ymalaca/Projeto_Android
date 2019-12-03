package com.ifal.wendell.bookingnow.Modelos;

public class Restaurante {
    private String NomeRestaurante;
    private int codigo;
    private int TelefoneRestaurante;
    private int CNPJRestaurante;
    private Endereco endereco;

    public Restaurante(String nomeRestaurante, int codigo, int telefoneRestaurante, int CNPJRestaurante, Endereco endereco) {
        NomeRestaurante = nomeRestaurante;
        this.codigo = codigo;
        TelefoneRestaurante = telefoneRestaurante;
        this.CNPJRestaurante = CNPJRestaurante;
        this.endereco = endereco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeRestaurante() {
        return NomeRestaurante;
    }

    public void setNomeRestaurante(String NomeRestaurante) {
        this.NomeRestaurante = NomeRestaurante;
    }

    public int getTelefoneRestaurante() {
        return TelefoneRestaurante;
    }

    public void setTelefoneRestaurante(int TelefoneRestaurante) {
        this.TelefoneRestaurante = TelefoneRestaurante;
    }

    public int getCNPJRestaurante() {
        return CNPJRestaurante;
    }

    public void setCNPJRestaurante(int CNPJRestaurante) {
        this.CNPJRestaurante = CNPJRestaurante;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
}