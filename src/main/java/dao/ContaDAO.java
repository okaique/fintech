package dao;

import model.Conta;
import database.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO {

    // Método para inserir conta
    public void insert(Conta conta) {
        String sql = "INSERT INTO conta (cd_conta, tipo_conta, saldo, cd_usuario, nome_banco) " +
                "VALUES (SEQ_CONTA.NEXTVAL, ?, ?, ?, ?)";
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, conta.getTipoConta());
            stmt.setDouble(2, conta.getSaldo());
            stmt.setInt(3, conta.getCdUsuario());
            stmt.setString(4, conta.getNomeBanco());

            stmt.executeUpdate();
            System.out.println("Conta inserida com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir conta: " + e.getMessage());
        }
    }

    // Método para atualizar saldo de uma conta
    public void atualizarSaldo(int cdConta, double valor) {
        String sql = "UPDATE conta SET saldo = saldo + ? WHERE cd_conta = ?";
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, valor);
            stmt.setInt(2, cdConta);
            stmt.executeUpdate();
            System.out.println("Saldo atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar saldo: " + e.getMessage());
        }
    }

    // Método para buscar todas as contas
    public List<Conta> getAll() {
        List<Conta> contas = new ArrayList<>();
        String sql = "SELECT * FROM conta";
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Conta conta = new Conta(
                        rs.getInt("cd_conta"),
                        rs.getString("tipo_conta"),
                        rs.getDouble("saldo"),
                        rs.getInt("cd_usuario"),
                        rs.getString("nome_banco")
                );
                contas.add(conta);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao consultar contas: " + e.getMessage());
        }
        return contas;
    }

    // Método para pegar as contas de um usuário específico
    public List<Conta> getContasPorUsuario(int cdUsuario) {
        List<Conta> contas = new ArrayList<>();
        String sql = "SELECT * FROM conta WHERE cd_usuario = ?";
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cdUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Conta conta = new Conta(
                        rs.getInt("cd_conta"),
                        rs.getString("tipo_conta"),
                        rs.getDouble("saldo"),
                        rs.getInt("cd_usuario"),
                        rs.getString("nome_banco")
                );
                contas.add(conta);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao consultar as contas: " + e.getMessage());
        }
        return contas;
    }

    // Método para obter o total de receitas de uma conta
    public double getTotalReceitas(int cdConta) {
        String sql = "SELECT SUM(valor) AS total_receitas FROM RECEITA WHERE cd_conta = ?";
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cdConta);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getDouble("total_receitas");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao consultar total de receitas: " + e.getMessage());
        }
        return 0.0;
    }

    // Método para obter o total de despesas de uma conta
    public double getTotalDespesas(int cdConta) {
        String sql = "SELECT SUM(valor) AS total_despesas FROM DESPESA WHERE cd_conta = ?";
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cdConta);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getDouble("total_despesas");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao consultar total de despesas: " + e.getMessage());
        }
        return 0.0;
    }
}
