package dao;

import transaction.Receita;
import database.ConexaoBanco;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReceitaDAO {

    // Método para inserir uma nova receita no banco de dados
    public void insert(Receita receita) {
        String sql = "INSERT INTO receita (cd_receita, valor, descricao, cd_conta, data, hora, nome_receita) VALUES (seq_cd_receita.NEXTVAL, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, receita.getValor());
            stmt.setString(2, receita.getDescricao());
            stmt.setInt(3, receita.getCdConta());
            stmt.setDate(4, receita.getData());
            stmt.setString(5, receita.getHora());
            stmt.setString(6, receita.getNomeReceita());
            stmt.executeUpdate();
            System.out.println("Receita inserida com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir receita: " + e.getMessage());
        }
    }

    // Método para listar todas as receitas do banco de dados
    public List<Receita> getAll() {
        List<Receita> receitas = new ArrayList<>();
        String sql = "SELECT * FROM RECEITA";
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Receita receita = new Receita(
                        rs.getInt("cd_receita"),
                        rs.getDouble("valor"),
                        rs.getString("descricao"),
                        rs.getInt("cd_conta"),
                        rs.getDate("data"),
                        rs.getString("hora"),
                        rs.getString("nome_receita")
                );
                receitas.add(receita);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao consultar receitas: " + e.getMessage());
        }
        return receitas;
    }

    // Método para listar receitas de uma conta específica
    public List<Receita> getReceitasPorConta(int cdConta) {
        List<Receita> receitas = new ArrayList<>();
        String sql = "SELECT * FROM RECEITA WHERE cd_conta = ?";
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cdConta);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Receita receita = new Receita(
                        rs.getInt("cd_receita"),
                        rs.getDouble("valor"),
                        rs.getString("descricao"),
                        rs.getInt("cd_conta"),
                        rs.getDate("data"),
                        rs.getString("hora"),
                        rs.getString("nome_receita")
                );
                receitas.add(receita);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao consultar receitas por conta: " + e.getMessage());
        }
        return receitas;
    }

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

    public Map<String, Double> getReceitasMensais() {
        String sql = "SELECT TO_CHAR(data, 'MM-YYYY') AS mes, SUM(valor) AS total " +
                "FROM receita GROUP BY TO_CHAR(data, 'MM-YYYY') ORDER BY mes";
        Map<String, Double> receitasMensais = new HashMap<>();
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                receitasMensais.put(rs.getString("mes"), rs.getDouble("total"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return receitasMensais;
    }

}
