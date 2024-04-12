package entidades;

import fornecimento.Fruta;

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

    public void fornecerFruta(String nome, double preco, int quantidade) {
        Fruta fruta = new Fruta(nome, preco, quantidade);
    }

    @Override
    public String toString() {
        return super.toString() + ", cnpj='" + cnpj + '\'';
    }
}
