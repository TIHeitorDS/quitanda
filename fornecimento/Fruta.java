package fornecimento;

public class Fruta {
    private String nome;
    private double preco;
    private int quantidadeFornecida;

    public Fruta(String nome, double preco, int quantidadeFornecida) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeFornecida = quantidadeFornecida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeFornecida() {
        return quantidadeFornecida;
    }

    public void setQuantidadeFornecida(int quantidadeFornecida) {
        this.quantidadeFornecida = quantidadeFornecida;
    }

    @Override
    public String toString() {
        return "Fruta{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidadeFornecida=" + quantidadeFornecida +
                '}';
    }
}