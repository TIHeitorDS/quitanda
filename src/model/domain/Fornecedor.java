package src.model.domain;

public class Fornecedor extends Pessoa {
    private String cnpj;
    private Fornecimento fornecimento;

    public Fornecedor(String nome, String telefone, String endereco, String cnpj) {
        super(nome, telefone, endereco);
        this.cnpj = cnpj;

        fornecimento = new Fornecimento();
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public Fornecimento getFornecimento() {
        return fornecimento;
    }

    public void setFornecimento(Fornecimento fornecimento) {
        this.fornecimento = fornecimento;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "cnpj='" + cnpj + '\'' +
                "} " + super.toString();
    }
}
