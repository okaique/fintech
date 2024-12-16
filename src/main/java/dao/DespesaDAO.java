package dao;

import transaction.Despesa;
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

public class DespesaDAO {

    // Método para inserir uma nova despesa no banco de dados
    public void insert(Despesa despesa) {
        String sql = "INSERT INTO despesa (cd_despesa, valor, descricao, cd_conta, data, hora, nome_despesa) VALUES (seq_cd_despesa.NEXTVAL, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, despesa.getValor());
            stmt.setString(2, despesa.getDescricao());
            stmt.setInt(3, despesa.getCdConta());
            stmt.setDate(4, despesa.getData());
            stmt.setString(5, despesa.getHora());
            stmt.setString(6, despesa.getNomeDespesa());
            stmt.executeUpdate();
            System.out.println("Despesa inserida com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir despesa: " + e.getMessage());
        }
    }

    // Método para listar todas as despesas do banco de dados
    public List<Despesa> getAll() {
        List<Despesa> despesas = new ArrayList<>();
        String sql = "SELECT * FROM DESPESA";
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Despesa despesa = new Despesa(
                        rs.getInt("cd_despesa"),
                        rs.getDouble("valor"),
                        rs.getString("descricao"),
                        rs.getInt("cd_conta"),
                        rs.getDate("data"),
                        rs.getString("hora"),
                        rs.getString("nome_despesa")
                );
                despesas.add(despesa);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao consultar despesas: " + e.getMessage());
        }
        return despesas;
    }

    // Método para listar despesas de uma conta específica
    public List<Despesa> getDespesasPorConta(int cdConta) {
        List<Despesa> despesas = new ArrayList<>();
        String sql = "SELECT * FROM DESPESA WHERE cd_conta = ?";
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cdConta);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Despesa despesa = new Despesa(
                        rs.getInt("cd_despesa"),
                        rs.getDouble("valor"),
                        rs.getString("descricao"),
                        rs.getInt("cd_conta"),
                        rs.getDate("data"),
                        rs.getString("hora"),
                        rs.getString("nome_despesa")
                );
                despesas.add(despesa);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao consultar despesas por conta: " + e.getMessage());
        }
        return despesas;
    }

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

    public Map<String, Double> getDespesasMensais() {
        String sql = "SELECT TO_CHAR(data, 'MM-YYYY') AS mes, SUM(valor) AS total " +
                "FROM despesa GROUP BY TO_CHAR(data, 'MM-YYYY') ORDER BY mes";
        Map<String, Double> despesasMensais = new HashMap<>();
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                despesasMensais.put(rs.getString("mes"), rs.getDouble("total"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return despesasMensais;
    }

}
