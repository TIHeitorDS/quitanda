package entidades;

public class Fornecedor extends Pessoa {
    private String cnpj;

    public Fornecedor(String nome, String telefone, String endereco, String cnpj) {
        super(nome, telefone, endereco);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return super.toString() + " Fornecedor{" +
                "cnpj='" + cnpj + '\'' +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                "} ";
    }
}
