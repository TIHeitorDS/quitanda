package src.model.domain;

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

    public CarrinhoDeCompras getCarrinhoDeCompras() {
        return carrinhoDeCompras;
    }

    public void setCarrinhoDeCompras(CarrinhoDeCompras carrinhoDeCompras) {
        this.carrinhoDeCompras = carrinhoDeCompras;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", cpf: '" + cpf + '\'';
    }
}
