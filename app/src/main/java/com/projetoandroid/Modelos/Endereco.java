package com.projetoandroid.Modelos;

public class Endereco {
     private String CepRestaurante;
    private String RuaRestaurante;
    private String BairroRestaurante;
    private String CidadeRestaurante;
    private String UFRestaurante;
    private int codigo;

    public Endereco(int codigo, String CepRestaurante, String RuaRestaurante, String BairroRestaurante, String CidadeRestaurante, String UFRestaurante) {
        this.CepRestaurante = CepRestaurante;
        this.RuaRestaurante = RuaRestaurante;
        this.BairroRestaurante = BairroRestaurante;
        this.CidadeRestaurante = CidadeRestaurante;
        this.UFRestaurante = UFRestaurante;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUFRestaurante() {
        return UFRestaurante;
    }

    public void setUFRestaurante(String UFRestaurante) {
        this.UFRestaurante = UFRestaurante;
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
