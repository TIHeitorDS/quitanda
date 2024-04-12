package entidades;

public class Proprietario extends Pessoa {
    private String email;
    private String senha;

    public Proprietario(String nome, String telefone, String endereco, String email, String senha) {
        super(nome, telefone, endereco);
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'';
    }
}
