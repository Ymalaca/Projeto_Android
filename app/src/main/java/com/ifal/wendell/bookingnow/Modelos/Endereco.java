package com.ifal.wendell.bookingnow.Modelos;

public class Endereco {
     private String CepRestaurante;
    private String RuaRestaurante;
    private String BairroRestaurante;
    private String CidadeRestaurante;

    public Endereco(String CepRestaurante, String RuaRestaurante, String BairroRestaurante, String CidadeRestaurante) {
        this.CepRestaurante = CepRestaurante;
        this.RuaRestaurante = RuaRestaurante;
        this.BairroRestaurante = BairroRestaurante;
        this.CidadeRestaurante = CidadeRestaurante;
    }

    public String getCepRestaurante() {
        return CepRestaurante;
    }

    public void setCepRestaurante(String CepRestaurante) {
        this.CepRestaurante = CepRestaurante;
    }

    public String getRuaRestaurante() {
        return RuaRestaurante;
    }

    public void setRuaRestaurante(String RuaRestaurante) {
        this.RuaRestaurante = RuaRestaurante;
    }

    public String getBairroRestaurante() {
        return BairroRestaurante;
    }

    public void setBairroRestaurante(String BairroRestaurante) {
        this.BairroRestaurante = BairroRestaurante;
    }

    public String getCidadeRestaurante() {
        return CidadeRestaurante;
    }

    public void setCidadeRestaurante(String CidadeRestaurante) {
        this.CidadeRestaurante = CidadeRestaurante;
    }
    
    
}
