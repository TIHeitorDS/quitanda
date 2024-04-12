package entidades;

import fornecimento.Fruta;
import fornecimento.Fornecimento;

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

    public Fruta fornecerFruta(String nome, double preco, int quantidade) {
        Fruta fruta = new Fruta(nome, preco, quantidade);

        this.fornecimento.setFruta(fruta);
        this.fornecimento.historicoDeFornecimento(this);

        return fruta;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "cnpj='" + cnpj + '\'' +
                "} " + super.toString();
    }
}
