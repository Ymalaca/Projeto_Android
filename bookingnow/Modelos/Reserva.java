public class Reserva {
    private String NomeReservante;
    private int TelefoneReservante;
    private int CpfReservante;

    public Reserva(String NomeReservante, int TelefoneReservante, int CpfReservante) {
        this.NomeReservante = NomeReservante;
        this.TelefoneReservante = TelefoneReservante;
        this.CpfReservante = CpfReservante;
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