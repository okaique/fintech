package transaction;

import java.sql.Date;

public class Receita {
    private int cdReceita;
    private double valor;
    private String descricao;
    private int cdConta;
    private Date data;
    private String hora;
    private String nomeReceita; // Novo campo para o nome da receita

    public Receita(int cdReceita, double valor, String descricao, int cdConta, Date data, String hora, String nomeReceita) {
        this.cdReceita = cdReceita;
        this.valor = valor;
        this.descricao = descricao;
        this.cdConta = cdConta;
        this.data = data;
        this.hora = hora;
        this.nomeReceita = nomeReceita;
    }

    public String getNomeReceita() {
        return nomeReceita;
    }

    public void setNomeReceita(String nomeReceita) {
        this.nomeReceita = nomeReceita;
    }

    public int getCdReceita() {
        return cdReceita;
    }

    public void setCdReceita(int cdReceita) {
        this.cdReceita = cdReceita;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCdConta() {
        return cdConta;
    }

    public void setCdConta(int cdConta) {
        this.cdConta = cdConta;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Receita{" +
                "cdReceita=" + cdReceita +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                ", cdConta=" + cdConta +
                ", data=" + data +
                ", hora='" + hora + '\'' +
                '}';
    }
}
