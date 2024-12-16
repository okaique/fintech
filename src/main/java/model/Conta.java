package model;

public class Conta {
    private int cdConta;
    private String tipoConta;
    private double saldo;
    private int cdUsuario;
    private String nomeBanco;

    public Conta(int cdConta, String tipoConta, double saldo, int cdUsuario, String nomeBanco) {
        this.cdConta = cdConta;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.cdUsuario = cdUsuario;
        this.nomeBanco = nomeBanco;
    }

    public int getCdConta() { return cdConta; }
    public void setCdConta(int cdConta) { this.cdConta = cdConta; }

    public String getTipoConta() { return tipoConta; }
    public void setTipoConta(String tipoConta) { this.tipoConta = tipoConta; }

    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }

    public int getCdUsuario() { return cdUsuario; }
    public void setCdUsuario(int cdUsuario) { this.cdUsuario = cdUsuario; }

    public String getNomeBanco() { return nomeBanco; }
    public void setNomeBanco(String nomeBanco) { this.nomeBanco = nomeBanco; }

    @Override
    public String toString() {
        return "Conta{" +
                "cdConta=" + cdConta +
                ", tipoConta='" + tipoConta + '\'' +
                ", saldo=" + saldo +
                ", cdUsuario=" + cdUsuario +
                ", nomeBanco='" + nomeBanco + '\'' +
                '}';
    }
}
