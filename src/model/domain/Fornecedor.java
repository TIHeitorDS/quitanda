package model.domain;

public class Fornecedor extends Pessoa {
    private int id;
    private String cnpj;

    public Fornecedor(String nome, String telefone, String endereco, String cnpj) {
        super(nome, telefone, endereco);
        this.cnpj = cnpj;
    }

    public Fornecedor(int id, String nome, String telefone, String endereco, String cnpj) {
        super(nome, telefone, endereco);
        this.id = id;
        this.cnpj = cnpj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return super.toString() + ", cnpj='" + cnpj + '\'';
    }
}
