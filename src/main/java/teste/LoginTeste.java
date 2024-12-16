package teste;

import dao.UsuarioDAO;
import model.Usuario;

import java.util.Scanner;

public class LoginTeste {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o email: ");
        String email = scanner.nextLine();

        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        // Cria uma instância do UsuarioDAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Tenta buscar o usuário no banco com o email e senha fornecidos
        Usuario usuarioLogado = usuarioDAO.getByEmailAndSenha(email, senha);

        // Verifica se o login foi bem-sucedido
        if (usuarioLogado != null) {
            System.out.println("Login bem-sucedido!");
            System.out.println("Bem-vindo, " + usuarioLogado.getNome() + "!");
            System.out.println("Dados do usuário logado:");
            System.out.println("ID: " + usuarioLogado.getCdUsuario());
            System.out.println("Nome: " + usuarioLogado.getNome() + " " + usuarioLogado.getSobrenome());
            System.out.println("Email: " + usuarioLogado.getEmail());
            System.out.println("Senha: " + usuarioLogado.getSenha());
        } else {
            System.out.println("Falha no login: Usuário ou senha incorretos.");
        }

        scanner.close();
    }
}