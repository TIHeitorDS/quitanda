package entidades;

import fornecimento.CarrinhoDeCompras;

public class Cliente extends Pessoa {
    private String cpf;
    private CarrinhoDeCompras carrinhoDeCompras;

    public Cliente(String nome, String telefone, String endereco, String cpf) {
        super(nome, telefone, endereco);
        this.cpf = cpf;

        carrinhoDeCompras = new CarrinhoDeCompras(0, 0);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", cpf: '" + cpf + '\'';
    }
}
