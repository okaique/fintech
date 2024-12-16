package transaction;

import java.sql.Date;

public class Despesa {
    private int cdDespesa;
    private double valor;
    private String descricao;
    private int cdConta;
    private Date data;
    private String hora;
    private String nomeDespesa; // Novo campo para o nome da despesa

    public Despesa(int cdDespesa, double valor, String descricao, int cdConta, Date data, String hora, String nomeDespesa) {
        this.cdDespesa = cdDespesa;
        this.valor = valor;
        this.descricao = descricao;
        this.cdConta = cdConta;
        this.data = data;
        this.hora = hora;
        this.nomeDespesa = nomeDespesa;
    }

    public String getNomeDespesa() {
        return nomeDespesa;
    }

    public void setNomeDespesa(String nomeDespesa) {
        this.nomeDespesa = nomeDespesa;
    }

    public int getCdDespesa() {
        return cdDespesa;
    }

    public void setCdDespesa(int cdDespesa) {
        this.cdDespesa = cdDespesa;
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
        return "Despesa{" +
                "cdDespesa=" + cdDespesa +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                ", cdConta=" + cdConta +
                ", data=" + data +
                ", hora='" + hora + '\'' +
                '}';
    }
}
