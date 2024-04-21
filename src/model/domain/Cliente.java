package model.domain;

public class Cliente extends Pessoa {
    private int id;
    private String cpf;
    private CarrinhoDeCompras carrinhoDeCompras;

    public Cliente(String nome, String telefone, String endereco, String cpf) {
        super(nome, telefone, endereco);
        this.cpf = cpf;

        carrinhoDeCompras = new CarrinhoDeCompras(0, 0);
    }

    public Cliente(int id, String nome, String telefone, String endereco, String cpf) {
        super(nome, telefone, endereco);
        this.id = id;
        this.cpf = cpf;

        carrinhoDeCompras = new CarrinhoDeCompras(0, 0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Nome: " + super.getNome() + " | Telefone: " + super.getTelefone() + 
        " | Endereço: " + super.getEndereco() + " | CPF: " + cpf; 
    }
}
