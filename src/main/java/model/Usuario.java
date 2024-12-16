package model;

public class Usuario {
    private int cdUsuario;
    private String nomeUsuario;
    private String sobrenomeUsuario;
    private String email;
    private String senha;

    public Usuario(int cdUsuario, String nomeUsuario, String sobrenomeUsuario, String email, String senha) {
        this.cdUsuario = cdUsuario;
        this.nomeUsuario = nomeUsuario;
        this.sobrenomeUsuario = sobrenomeUsuario;
        this.email = email;
        this.senha = senha;
    }

    public void setCdUsuario(int cdUsuario) {
        this.cdUsuario = cdUsuario;
    }

    public int getCdUsuario() { return cdUsuario; }
    public String getNome() { return nomeUsuario; }
    public String getSobrenome() { return sobrenomeUsuario; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
}
