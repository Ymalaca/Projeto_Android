public class Restaurante {
    private String NomeRestaurante;
    private int TelefoneRestaurante;
    private int CNPJRestaurante;
    private Endereco endereco;

    public Restaurante(String NomeRestaurante, int TelefoneRestaurante, int CNPJRestaurante, Endereco endereco) {
        this.NomeRestaurante = NomeRestaurante;
        this.TelefoneRestaurante = TelefoneRestaurante;
        this.CNPJRestaurante = CNPJRestaurante;
        this.endereco = endereco;
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