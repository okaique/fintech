package dao;

import model.Usuario;
import database.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // Método de inserção de usuário
    // No método insert em UsuarioDAO
    // No método insert em UsuarioDAO
    // Em UsuarioDAO.java
    public int insert(Usuario usuario) {
        String sql = "INSERT INTO USUARIO (cd_usuario, nome_usuario, sobrenome_usuario, email, senha) VALUES (SEQ_USUARIO.NEXTVAL, ?, ?, ?, ?)";
        int cdUsuario = 0;

        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, new String[]{"cd_usuario"})) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSobrenome());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getSenha());

            stmt.executeUpdate();

            // Obtém o cdUsuario gerado
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                cdUsuario = rs.getInt(1);
                usuario.setCdUsuario(cdUsuario);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir usuário: " + e.getMessage());
        }
        return cdUsuario;
    }



    // Método para recuperar todos os usuários
    public List<Usuario> getAll() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM USUARIO";
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int cdUsuario = rs.getInt("cd_usuario");
                String nomeUsuario = rs.getString("nome_usuario");
                String sobrenomeUsuario = rs.getString("sobrenome_usuario");
                String email = rs.getString("email");
                String senha = rs.getString("senha");

                Usuario usuario = new Usuario(cdUsuario, nomeUsuario, sobrenomeUsuario, email, senha);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar usuários: " + e.getMessage());
        }
        return usuarios;
    }

    // Método para buscar usuário por email e senha
    public Usuario getByEmailAndSenha(String email, String senha) {
        String sql = "SELECT * FROM USUARIO WHERE email = ? AND senha = ?";
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                        rs.getInt("cd_usuario"),
                        rs.getString("nome_usuario"),
                        rs.getString("sobrenome_usuario"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao tentar logar no banco de dados: " + e.getMessage());
        }
        return null;
    }
}